
// prototype object
const bankaccount={
    balance:1000,
    deposit:function(amt)
            {
                this.balance+=amt;
            },
    withdraw:function(amt)
    {
        this.balance-=amt;
    },
    getBalance:function(amt)
    {
        return this.balance;
    }
 
}
 
let savingaccount=Object.create(bankaccount);
savingaccount.accno="sb001";
savingaccount.accholder="Pooja";
savingaccount.bank="hdfc";
savingaccount.branch="bangalore BTM";
 
let currentaccount=Object.create(bankaccount);
currentaccount.accno="cb001";
currentaccount.accholder="Rakesh";
currentaccount.bank="hdfc";
currentaccount.branch="bangalore BTM";
 
console.log(savingaccount.accholder)
savingaccount.deposit(120000);
savingaccount.withdraw(21000);
console.log(savingaccount.getBalance());
 

let businessbankaccount=Object.create(bankaccount,{accno:{value:"bba01",configurable:false,writable:false,enumerable:true},holder:{value:"astosh",writable:false,configurable:true,enumerable:true},balance:{value:1,writable:true}});
businessbankaccount.holder="pooja";
console.log(businessbankaccount.accno);
console.log(businessbankaccount.holder);
console.log(businessbankaccount.balance);
businessbankaccount.deposit(200000);
console.log(businessbankaccount.balance);
businessbankaccount.withdraw(50001);
console.log(businessbankaccount.balance);