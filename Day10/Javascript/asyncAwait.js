function walkDog(){
    return new Promise((resolve,reject)=>{
      setTimeout(()=>{
        const success = true;
        if(success){
        resolve("Dog walked");
        }
        else{
        reject("Dog not walked");
        }
      },200)
    })
}

function cleanKitchen(){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            const cleanTime=true;
            if(cleanTime){
                resolve("gaytri");
            }
            else{
                reject("pooja");
            }
        })
    })
}

async function dialyChores(){
    const walkDogResult=await walkDog();
    console.log(walkDogResult);
    const cleanKitchenResult=await cleanKitchen();
    console.log(cleanKitchenResult);
}

console.log(dialyChores());