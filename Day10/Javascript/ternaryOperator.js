let age=20;
let isEligileToVote= age>=18?"Eligible to vote":"Not eligible to vote";
console.log(isEligileToVote);

function validateMe(marks)
{
  let res=marks<40 ? "re-appear" : marks>40&& marks<60 ? "Pass" : marks>60 && marks<80 ? "A grade" :marks>80 && marks<=100?"A++ grade":"Enter proper marks";
  return res;
}
 
console.log(validateMe(34));


function functionname(parameters)
 {
    //body of the function
 }
 
 let username="Rakesh";
 
 function displayMe()
  {
    let username="sivam"; // local variable
    console.log("welcome\t"+username);
  }
 
  console.log(username);
  displayMe();
 
  function addition(x,y,z)
  {
    return x+y+z;
  }
  console.log(addition(1,2,3));
 
  function displayData(name,age,city="Bangalore")
  {
    console.log(name);
    console.log(age);
    console.log(city);
  }
 
  displayData("Rakesh",21,"Mysuru");