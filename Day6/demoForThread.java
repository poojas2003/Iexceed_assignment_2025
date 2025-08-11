class customer
{
     int amount=10000;
 
     synchronized public void withdraw(int amount)
	{
	   System.out.println("Going to withdraw");
	   if(this.amount<amount)
		{
		  System.out.println("Less balance wait for deposit");
		 try{ wait();}catch(Exception  d){}
		}
		this.amount-=amount;
	   System.out.println("Completed withdraw");

 
	}
 
 
	synchronized public void deposit(int amount)
	{
	   System.out.println("Going to deposit");	   
	   this.amount+=amount;
	   System.out.println("Deposit done");
	   notify();
	}
 
}
 
class demoForThread
{
    public static void main(String asd[])
	{
	   customer c1=new customer();
	   new Thread(){
		 public void run()
		  {
			 c1.withdraw(12000);
	          }
		}.start();
 
	    new Thread(){
		    public void run()
			{
   			  c1.deposit(10000);
			}
		}.start();
	}
}	