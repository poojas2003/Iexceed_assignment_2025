import java.io.DataInputStream;
 
class sample
  {
     DataInputStream din=new DataInputStream(System.in);
 
     sample()
	{	
	  try{
	       int str1=Integer.parseInt(din.readLine());
	       int str2=Integer.parseInt(din.readLine());
	       System.out.println(str1+str2);
 
	}catch(Exception  d){}
	}
}
 
 
class demoInput
{
    public static void main(String asd[])
	{
	    new sample();
	}
}