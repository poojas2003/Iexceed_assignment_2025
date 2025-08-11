class call{
    public void callme(String msg)
	{
      System.out.print("[");
	  System.out.print(msg);
	  System.out.print("]");
      display();
	}
    public void display()
   {
    for(int i=0;i<5;i++)
	{
	   System.out.print(i);
	}
  
   }}
class caller extends Thread{
    call obj;
    String str;
    Thread t=new Thread(this);

    caller(call obj,String str)
   {
       this.obj=obj;
       this.str=str;
       t.start();
   }

   public void run()
   {
       obj.callme(str);
   }
}



public class demoSynchronise
{
   public static void main(String asd[])throws InterruptedException
	{
	     call obj=new call();
    	   caller c1=new caller(obj,"one");
	   c1.join();
	   caller c2=new caller(obj,"two");
	   c2.join();
	   caller c3=new caller(obj,"three");
	}
}