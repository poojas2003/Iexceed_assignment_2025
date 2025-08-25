const arrowFunction=(n)=>{
    // String result="     Pooja";
    console.log(n.trimStart());
    console.log(n.toUpperCase());
}

arrowFunction("       Pooja");

let arrowFunction2=(n)=>n.trimStart().toUpperCase();
console.log(arrowFunction2("       Pooja"));