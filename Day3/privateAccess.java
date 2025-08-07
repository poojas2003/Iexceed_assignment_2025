
import java.lang.reflect.Method;

class studentClass{
    private String str="Hello World";
    private void display(){
        System.out.println(str);
    }
}

public class privateAccess {
    public static void main(String[] args) 
        throws Exception {
        Class<?> c=Class.forName("studentClass");
        Object o=c.getDeclaredConstructor().newInstance();
        Method m=c.getDeclaredMethod("display");
        m.setAccessible(true);
        m.invoke(o);
        
    }
}
