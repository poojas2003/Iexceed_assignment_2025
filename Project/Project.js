process.env.NODE_TLS_REJECT_UNAUTHORIZED = "0";

const readline = require('readline');
const mysql = require('mysql2');
const API_KEY = '0cf44d8fa6901f6eb0f686d6'; // Replace with your API key

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});


const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',     
  password: 'root', 
  database: 'currency_db'
});

db.connect(err => {
  if (err) {
    console.error("❌ Database connection failed:", err);
    process.exit(1);
  }
  console.log("✅ Connected to MySQL Database");
});

function ask(question) {
  return new Promise(resolve => rl.question(question, answer => resolve(answer)));
}

// Core function with callback
async function convertIncomes(incomes, targetCurrency, callback) {
  const url = `https://v6.exchangerate-api.com/v6/${API_KEY}/latest/${targetCurrency}`;
  try {
    const res = await fetch(url);
    const parsed = await res.json();
    if (parsed.result !== 'success') {
      return callback(new Error(parsed['error-type'] || 'API error'));
    }

    const rates = parsed.conversion_rates;
    let total = 0;

    for (const { amount, currency } of incomes) {
      if (currency === targetCurrency) {
        total += amount;
      } else if (rates[currency]) {
        total += amount / rates[currency];
      } else {
        return callback(new Error(`No exchange rate for ${currency}`));
      }
    }

    callback(null, total.toFixed(2));
  } catch (err) {
    callback(err);
  }
}

async function run() {
  const incomes = [];

  console.log("Enter your income entries (amount and currency). Type 'done' to finish.");

  while (true) {
    const input = await ask("Enter income (e.g. 100 USD): ");
    if (input.toLowerCase() === 'done') break;

    const [amountStr, currency] = input.trim().split(' ');
    const amount = parseFloat(amountStr);

    if (isNaN(amount) || !currency) {
      console.log("Invalid input. Format should be: amount currency (e.g., 100 USD)");
      continue;
    }

    incomes.push({ amount, currency: currency.toUpperCase() });
  }

  const targetCurrency = (await ask("Enter target currency (e.g., USD): ")).toUpperCase();

  convertIncomes(incomes, targetCurrency, (err, total) => {
    if (err) {
      console.error("❌ Error:", err.message);
    } else {
      console.log(`\n💰 Total in ${targetCurrency}: ${total}`);

      // ✅ Save results to MySQL instead of JSON
      const timestamp = new Date();
      incomes.forEach(income => {
        db.query(
          'INSERT INTO incomes (amount, currency, target_currency, total, timestamp) VALUES (?, ?, ?, ?, ?)',
          [income.amount, income.currency, targetCurrency, total, timestamp],
          (err) => {
            if (err) console.error("❌ Error inserting into DB:", err);
          }
        );
      });

      console.log("📂 Results stored in MySQL Database.");
    }
    rl.close();
    db.end();
  });
}

run();
