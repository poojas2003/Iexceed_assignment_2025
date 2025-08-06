public class sample {
    int x=10;
    static int y=20;
    public void display(){
        System.out.print("x: " + x);
        System.out.print("y: " + y);
    }
    public static void display1(){
        System.out.print("x: " + new sample().x);
        System.out.print("y: " + y);
    }

}
class staticMethod{
    public static void main(String[] args){
        sample obj=new sample();
        obj.display();
        sample.display1();
    }
}

