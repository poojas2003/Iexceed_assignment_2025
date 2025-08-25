let assign={a:1};
let target={b:2,c:3};
let result=Object.assign(target,assign);
console.log(result);


let person={greet() {console.log("hello everyone")}};
let emp=Object.create(person);
emp.greet();

// let object={car};
// Object.defineProperty(object,'name',{value:'pooja',writable:true,configurable:false,enumerable:true},'age',{value:22,writable:true,configurable:true,enumerable:true});
// console.log(object.name,object.age);

let object1={name:'pooja','age':22};
console.log(Object.entries(object1));//object to array of arrays\
let arr=[['name','pooja'],['age',22]];
console.log(Object.fromEntries(arr))//arr to object 

//freeze it make it immutable 
let obj={name:'Khushi',age:21};
console.log(Object.freeze(obj));
obj.name="Pooja";
console.log(obj.name);


let obj1 = { a: 1 };
console.log(Object.getOwnPropertyDescriptor(obj1, 'a'));
/* 
{
  value: 1,
  writable: true,
  enumerable: true,
  configurable: true
}
*/

let obj3 = { a: 1, b: 2 };
console.log(Object.getOwnPropertyDescriptors(obj3));

let obj4 = { a: 1 };
Object.defineProperty(obj4, 'hidden', { value: 42, enumerable: false });
console.log(Object.getOwnPropertyNames(obj4)); // ['a', 'hidden']

let obj = { a: 1 };
console.log(Object.hasOwn(obj, 'a')); // true
console.log(Object.hasOwn(obj, 'b')); // false

console.log(Object.is(5, 5)); // true
console.log(Object.is(NaN, NaN)); // true (=== gives false)
console.log(Object.is(-0, +0)); // false (=== gives true)

let obj5 = {};
console.log(Object.isExtensible(obj5)); // true
Object.preventExtensions(obj5);
console.log(Object.isExtensible(obj5)); // false

