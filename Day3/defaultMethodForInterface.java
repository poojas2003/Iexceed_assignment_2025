public class defaultMethodForInterface {
    public static void main(String[] args) {
        sample obj = new sample();
        obj.defaultMethod1();
    }
}

interface MyInterface {
    public void display();
    default void defaultMethod1() {
        System.out.println("This is a default method.");
    }
}
interface MyInterface2{
   default void defaultMethod1(){
    System.out.print("This is second default meathod.");
   }
}

class sample implements MyInterface,MyInterface2{
    @Override
    public void display(){
        System.out.print("Display here");
    }
    @Override
    public void defaultMethod1(){
        System.out.print("inside default method");
        MyInterface.super.defaultMethod1();
        MyInterface2.super.defaultMethod1();
    }
}
