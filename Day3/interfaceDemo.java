interface sampleOne{
    public void dispayOne();
}
interface sampleTwo extends sampleOne{
    public void displayTwo();
}

class  sample implements sampleTwo
{
   sample()
   {

   }
   @Override
   public void dispayOne(){
    System.out.println("DisplayInfo");
   }
   @Override
   public void displayTwo(){
    System.out.println("DisplayDetails");
   }
}

public class  interfaceDemo{
    public static void main(String[] args){
       sample obj=new sample();
       obj.dispayOne();
       obj.displayTwo();
    }
}
