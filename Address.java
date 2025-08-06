class Address{
 int pin,plotno;
 String st,city;
 Address(String st,String city,int pin,int plotno){
    this.st=st;
    this.city=city;
    this.pin=pin;
    this.plotno=plotno;
 }
 
 public void displayInfo(){
  System.out.print("plot"+plotno);
  System.out.print("city"+city);
  System.out.print("pin"+pin);
  System.out.print("st"+st);
 }
}
