function removeDuplicates(arr){
   let uniqueElements = new Set(arr);
   let result = [...uniqueElements];
    console.log(result);
}


let arr = [1, 2, 3, 4, 5, 1, 2, 3];
removeDuplicates(arr) ;