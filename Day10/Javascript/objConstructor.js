class bankaccount{
    constructor(balance){
        this.balance=balance;
    }
    deposit=function(amt){
        this.balance+=amt;
    }
    withdraw=function(amt){
        this.balance-=amt;
    }
    getBalance=function(){
        return this.balance;
    }
}

let bank=new bankaccount(1000);
bank.deposit(2000);
console.log(bank.getBalance());

let businessbankaccount=Object.create(bankaccount,{accno:{value:"bba01",configurable:true,writable:true,enumerable:true},holder:{value:"astosh",writable:false,configurable:true,enumerable:true},balance:{value:1,writable:true}});
businessbankaccount.holder="abcd";
console.log(businessbankaccount.holder);
console.log(businessbankaccount.balance);
businessbankaccount.deposit(200000);
console.log(businessbankaccount.balance);
businessbankaccount.withdraw(50001);
console.log(businessbankaccount.balance);
