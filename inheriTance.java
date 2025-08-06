class car{
  String nameofCompany;
  boolean isAvailability;
    car(String nameofCompany,boolean isAvailability){
      this.nameofCompany=nameofCompany;
      this.isAvailability=isAvailability;
    }
    public void getCarDetails(){
      System.out.println("Company: " + nameofCompany);
      System.out.println("Available: "+isAvailability);
    }
}
class Scorpio extends car{
     String carName,modelName,color;
       Scorpio(String carName,String modelName,String color){
       super("Mahindra", true);
       this.carName=carName;
       this.modelName=modelName;
       this.color=color;
       }
       public void getCarModel() {
    System.out.println("Car Name: " + carName);
    System.out.println("Model Name: " + modelName);
    System.out.println("Color: " + color);
}

}
class inheriTance{
public static void main(String[] args){
Scorpio sc=new Scorpio("Scorpio","VLX","red");
sc.getCarDetails();
sc.getCarModel();
 }
}
