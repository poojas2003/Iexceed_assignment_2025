public class staticMethodForInterface {
    public static void main(String[] args){
        sample obj = new sample();
        obj.displayInfo();
        MyInterface.display();
    }
}


interface MyInterface{
    public void displayInfo();
    static void display(){
        System.out.println("static method in interface");
    }
}
 class sample implements MyInterface{
    @Override
    public void displayInfo(){
        System.out.println("displayInfo method in sample class");
    }

    sample(){
        System.out.println("Constructor of sample class");
    }
 }