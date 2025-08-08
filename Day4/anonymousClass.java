abstract class student_s {
    abstract public void display();
}


public class anonymousClass {
    public static void main(String[] args){
        new student_s(){
            public void display(){
                System.out.println("Anonymous class display method");
            }
        }.display();
    }
}
