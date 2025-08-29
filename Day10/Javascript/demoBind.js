let trainee={name:"pooja"}

let trainer={
    name:"khushi",
    displayName:function(){
        return this.name;
    },
    calculateMyAge:function(dob){
       this.dob=dob;
       let year=new Date().getFullYear()-this.dob;
        return year;
    }

}

console.log(trainer.displayName());
console.log(trainer.calculateMyAge(2002));
console.log(trainer.displayName.bind(trainee)());
console.log(trainer.calculateMyAge.bind(trainee,2003)());