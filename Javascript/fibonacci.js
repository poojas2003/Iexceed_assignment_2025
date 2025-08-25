const fibonacci=(n)=>{

    if(n==0){
        return 0;
    }
    if(n==1){
        return 1;
    }
    return fibonacci(n-1)+ fibonacci(n-2);
}

console.log(fibonacci(5)); // Output: 8
console.log(fibonacci(6)); // Output: 55