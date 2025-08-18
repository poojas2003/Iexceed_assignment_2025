function display()
{
     var x=10;
    if(true)
    {
       console.log(x);
    }
   
}
display();


function display()
{
    var x=10;
    function display1()
        {
            var y=20;
            console.log(x);
            console.log(y);
        }
        // console.log(y);
    display1();
}
display();

console.log(a);
var a=10;
console.log(a);


function deleteme(){
  var x=10;
  delete x;
  console.log(x);
}

deleteme();

function iterateme()
 {
    for(let i=0;i<5;i++)
    {
        console.log(i);
    }
    // console.log(i);
 }
 iterateme();