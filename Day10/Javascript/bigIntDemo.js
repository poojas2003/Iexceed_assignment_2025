let a=0.1;
let b=0.2;
let sum=a+b;
console.log(sum);
console.log(sum===(0.1+0.2));
 
 
let x=123456789012345678901n;
console.log(x);
let y=BigInt(123456789012345678901);
console.log(y);
 
let balance=1000n;// 10.00
let deposit=25n;
balance+=deposit;
console.log(Number(balance)/100);


let p=123456789012345678901n;
console.log(p);


let l=123456789012345678901234567890n;
let m=BigInt("123456789012345678901234567890");

console.log(l);
console.log(m);

let c = 9007199254740991n;  // largest safe integer
let d = 2n;

console.log(c + d); // 9007199254740993n
console.log(c * d); // 18014398509481982n
console.log(c ** d); // 81129638414606663681390495662081n
console.log(c / d);  // 4503599627370495n (notice: division result is truncated, no decimals)



let s=10n
let t=12n
let u=s+t;
console.log(u)