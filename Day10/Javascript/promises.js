function walkDog(callback){
    setTimeout(()=>{
        console.log("Dog walked");
        callback();
    },2000)
}

function cleanKitchen(callback){
    setTimeout(()=>{
        console.log("Kitchen cleaned");
        callback();
    },1000)}


walkDog(()=>{
    cleanKitchen(()=>{
        console.log("All chores done");
    })
} )   


function display(){
    let states=["Maharashtra","Gujarat","Rajasthan","Punjab"];
    for(i in states){
        console.log(states[i]);
    }
}

setTimeout(display,3000);

let user={
    name:"pooja",
    age:22,
    course:["mongodb","express","react","nodejs"],
}

console.log(user.name);
let jsonData=JSON.stringify(user)
console.log(jsonData);
console.log(typeof jsonData);
let obj=JSON.parse(jsonData);
console.log(obj);