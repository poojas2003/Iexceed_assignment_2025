class student 
  {
     private String name,dept;
     private int roll;
 
      student(String name,int roll,String dept)
	{
	   this.name=name;
	   this.roll=roll;
	   this.dept=dept;
	}
      public int getroll()
	{
	  return roll;
	}
    public String getname(){
        return name;

    }
 
   
      public String getdept()
	{
	  return dept;
	}
 
     /* public void setRoll(int roll)
	{
	  this.roll=roll;
	}*/
      public void setName(String name)
	{
	  this.name=name;
	}
      public void setDept(String dept)
	{
	  this.dept=dept;
	}
   }
 
class Encapsulation 
{
    public static void main(String asdd[])
	{
	   student s1=new student("Ram",1,"CSE");
	   System.out.println(s1.getname());
	   System.out.println(s1.getroll());
	   System.out.println(s1.getdept());

 
	}
}
 