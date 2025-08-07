abstract class student
{
   abstract public void displayStudent(String name,int age,String city);
}
 
 
class demoAno{
    public static void main(String asd[])
	{
	    student d= new student(){
		public void displayStudent(String name,int age,String city)
			{
				System.out.println("Name"+name);
	 			System.out.println("Age"+age);
	  			System.out.println("City"+city);
			}	
		};
	  d.displayStudent("X",4,"blore");
	}
}