
class Student{
String name,dept;
int roll;
Address adr;
 Student(String name,int roll,String dept,Address adr){
  this.name=name;
  this.roll=roll;
  this.dept=dept;
  this.adr=adr;
} 
  public void displayStudent(){
  System.out.print("Name of the student"+name);
  System.out.print("Roll"+roll);
  System.out.print("Department"+dept);
  adr.displayInfo();
  }
}
class demoStudent{
public static void main(String[] args){
  Address a1=new Address("Koramangala A blk","Bangalore",2,4324324);
  Student st=new Student("Pooja",12,"CSE",a1);
  st.displayStudent();
 }
}

