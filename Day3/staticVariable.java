public class staticVariable {
     int x=0;
    staticVariable()
    {
        x++;
        System.out.println("static variable is x ="+x);
    }
    public static void main(String[] args){
        staticVariable obj1=new staticVariable();
        staticVariable obj2=new staticVariable();
        staticVariable obj3=new staticVariable();
    }
}
