function outer(){
    let count = 0;
    function inner(){
        count++;
        console.log(count);
    }
    return inner();
}
//  console.log(inner());//ReferenceError: inner is not defined
console.log(outer());//1