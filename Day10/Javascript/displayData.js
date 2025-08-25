function displayData(name,age,city,...args)
{
 console.log(name);
 console.log(age);
 console.log(city);
 
 console.log(args.sort());
 
}
displayData("Pooja",21,"Kalburagi","Karnataka","India","Asia");
 
 function displayData2(name,age,...args){
    console.log(typeof arguments);
 }

 displayData2("Pooja",21,"Kalburagi","Karnataka","India","Asia");