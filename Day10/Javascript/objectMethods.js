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


console.log(Object.is(5, 5)); // true
console.log(Object.is(NaN, NaN)); // true (=== gives false)
console.log(Object.is(-0, +0)); // false (=== gives true)

// let obj5 = {};
// console.log(Object.isExtensible(obj5)); // true
// Object.preventExtensions(obj5);
// console.log(Object.isExtensible(obj5)); // false

let obj = { a: 1 };
Object.seal(obj);
console.log(Object.isSealed(obj)); // true
obj.a = 2; // allowed
delete obj.a; // not allowed
console.log(obj); // { a: 2 }

//assign

console.log("\n--- Object.assign ---");
const targets = { a: 1 };
const source = { b: 2, c: 3 };
console.log(Object.assign(targets, source)); // { a:1, b:2, c:3 }

//create
console.log("\n--- Object.create ---");
const proto = { greet() { console.log("Hello!"); } };
const student = Object.create(proto, { name: { value: "Pooja" } });
console.log(student.name); // Pooja
student.greet(); // Hello!

//defineProperty
console.log("\n--- Object.defineProperty ---");
const obj12 = {};
Object.defineProperty(obj12, "name", { value: "Pooja", writable: false });
console.log(obj1.name); // Pooja

//define Properties
console.log("\n--- Object.defineProperties ---");
const obj2 = {};
Object.defineProperties(obj2, {
  age: { value: 21, writable: true },
  city: { value: "Bangalore", writable: false }
});
console.log(obj2.age, obj2.city); // 21 Bangalore


console.log("\n--- Object.entries ---");
console.log(Object.entries({ a: 1, b: 2 })); // [ ["a",1], ["b",2] ]

console.log("\n--- Object.fromEntries ---");
console.log(Object.fromEntries([["a", 1], ["b", 2]])); // { a:1, b:2 }

console.log("\n--- Object.freeze ---");
const frozen = { lang: "JS" };
Object.freeze(frozen);
frozen.lang = "Python";
console.log(frozen.lang); // JS

console.log("\n--- Object.getOwnPropertyDescriptor ---");
console.log(Object.getOwnPropertyDescriptor({ a: 1 }, "a"));

console.log("\n--- Object.getOwnPropertyDescriptors ---");
console.log(Object.getOwnPropertyDescriptors({ a: 1, b: 2 }));

console.log("\n--- Object.getOwnPropertyNames ---");
const obj = Object.create({}, { hidden: { value: 42, enumerable: false } });
console.log(Object.getOwnPropertyNames(obj)); // ["hidden"]

console.log("\n--- Object.getOwnPropertySymbols ---");
const sym = Symbol("id");
const obj4 = { [sym]: 123 };
console.log(Object.getOwnPropertySymbols(obj4)); // [Symbol(id)]

console.log("\n--- Object.getPrototypeOf ---");
console.log(Object.getPrototypeOf([]) === Array.prototype); // true

console.log("\n--- Object.hasOwn ---");
console.log(Object.hasOwn({ a: 1 }, "a")); // true

console.log("\n--- Object.is ---");
console.log(Object.is(NaN, NaN)); // true
console.log(Object.is(+0, -0)); // false

console.log("\n--- Object.isExtensible ---");
const extObj = {};
console.log(Object.isExtensible(extObj)); // true
Object.preventExtensions(extObj);
console.log(Object.isExtensible(extObj)); // false

console.log("\n--- Object.isFrozen ---");
console.log(Object.isFrozen({})); // false
console.log(Object.isFrozen(Object.freeze({}))); // true

console.log("\n--- Object.isSealed ---");
console.log(Object.isSealed({})); // false
console.log(Object.isSealed(Object.seal({}))); // true

console.log("\n--- Object.keys ---");
console.log(Object.keys({ a: 1, b: 2 })); // ["a","b"]

console.log("\n--- Object.preventExtensions ---");
const obj5 = { a: 1 };
Object.preventExtensions(obj5);
obj5.b = 2;
console.log(obj5); // {a:1}

console.log("\n--- Object.seal ---");
const obj6 = { a: 1 };
Object.seal(obj6);
obj6.a = 10;
delete obj6.a;
console.log(obj6); // {a:10}

console.log("\n--- Object.setPrototypeOf ---");
const animal = { eat() { console.log("eating"); } };
const dog = {};
Object.setPrototypeOf(dog, animal);
dog.eat(); // eating

console.log("\n--- Object.values ---");
console.log(Object.values({ a: 1, b: 2 })); // [1,2]


console.log("\n--- Object.prototype.constructor ---");
const obj7 = {};
console.log(obj7.constructor === Object); // true

console.log("\n--- Object.prototype.hasOwnProperty ---");
console.log(({ a: 1 }).hasOwnProperty("a")); // true

console.log("\n--- Object.prototype.isPrototypeOf ---");
function Person() {}
const p = new Person();
console.log(Person.prototype.isPrototypeOf(p)); // true

console.log("\n--- Object.prototype.propertyIsEnumerable ---");
console.log(({ a: 1 }).propertyIsEnumerable("a")); // true

console.log("\n--- Object.prototype.toLocaleString ---");
console.log(new Date().toLocaleString());

console.log("\n--- Object.prototype.toString ---");
console.log(Object.prototype.toString.call([])); // [object Array]

console.log("\n--- Object.prototype.valueOf ---");
const numObj = new Number(5);
console.log(numObj.valueOf()); // 5
