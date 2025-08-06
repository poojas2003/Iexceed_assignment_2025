class company
{
    String nameofcom;
    String city;
 
    company(String nameofcom,String city)
	{
	  this.nameofcom=nameofcom;
	  this.city=city;
	}
   public void displayInfo()
   {
     System.out.println(nameofcom);
     System.out.println(city);
   }
  }
 
class HR extends company
{
    HR(String nameofcom,String city)
	{
         super(nameofcom,city);
          displayInfo();
	}
}
 
 
class Finance extends company
{
    Finance(String nameofcom,String city)
	{
         super(nameofcom,city);
         displayInfo();

	}
}

class demo{
public static void main(String[] args){
Finance c=new Finance("iexceed","banglore");
HR h=new HR("SFS","US");

}
}