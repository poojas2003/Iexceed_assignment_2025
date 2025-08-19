let str = "pooja";
let str2 = "khushi";
let arr = ["apple", "banana", "cherry"];

console.log("Length:", str.length);

// --- Character Access ---
console.log("1. charAt(1):", str.charAt(1));
console.log("2. charCodeAt(1):", str.charCodeAt(1)); // Unicode
console.log("3. codePointAt(1):", str.codePointAt(1));
console.log("4. at(1):", str.at(1));

// --- Case Conversion ---
console.log("5. toUpperCase():", str.toUpperCase());
console.log("6. toLowerCase():", str.toLowerCase());
// console.log(" toLocaleUpperCase():", "i".toLocaleUpperCase("tr")); // Turkish
// console.log(" toLocaleLowerCase():", "İ".toLocaleLowerCase("tr"));

// --- Concatenation ---
console.log(" 7. concat():", str.concat(" ", str2));

// --- Search Methods ---
console.log(" 8. indexOf('oo'):", str.indexOf("oo"));
console.log(" 9. lastIndexOf('o'):", str.lastIndexOf("o"));
console.log("10.includes('oo'):", str.includes("oo"));
console.log("11.startsWith('po'):", str.startsWith("po"));
console.log("12.endsWith('ja'):", str.endsWith("ja"));

// --- Extracting ---
console.log("16.slice(1,3):", str.slice(1,3));
console.log("17.substring(1,3):", str.substring(1,3));
console.log("18.substr(1,3):", str.substr(1,3)); // deprecated

// --- Trimming ---
let spaced = "   hello world   ";
console.log("19.trim():", spaced.trim());
console.log("20.trimStart():", spaced.trimStart());
console.log("21.trimEnd():", spaced.trimEnd());

// --- Replace ---
console.log("22.replace('oo','aa'):", str.replace("oo","aa"));
console.log("23.replaceAll('o','x'):", str.replaceAll("o","x"));

// --- Split ---
console.log("24.split(','):", "apple,banana,cherry".split(","));

// --- Padding & Repeat ---
console.log("25.padStart(10,'*'):", str.padStart(10,"*"));
console.log("26.padEnd(10,'*'):", str.padEnd(10,"*"));
console.log("27.repeat(2):", str.repeat(2));

// --- Comparison ---
console.log("28.localeCompare:", "apple".localeCompare("banana"));

// --- Regex ---
console.log("29.match(/o/g):", str.match(/o/g));
console.log("30.matchAll(/o/g):", [...str.matchAll(/o/g)]);
console.log("31.search(/ja/):", str.search(/ja/));

// --- Unicode ---
console.log("32.normalize():", "\u00F1".normalize("NFD")); // ñ → n + ~
console.log("33.isWellFormed():", str.isWellFormed());
console.log("34.toWellFormed():", str.toWellFormed());

// --- Conversion ---
let objStr = new String("hi");
console.log("35.valueOf():", objStr.valueOf());
console.log("36.toString():", objStr.toString());
