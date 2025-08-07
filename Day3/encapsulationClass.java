class encapsulationClass{
    private int roll;
    private String name;
    private String dept;

    public void setName(String name){
        this.name=name;
    }
    public void setRoll(int roll){
        this.roll=roll;
    }

    public void setDept(String dept){
        this.dept=dept;
    }

    public String getname(){
        return name;
    }
    public int getRoll() {
        return roll;
    }
    public String getdept() {
        return dept;
    }
    public static void main(String[] args) {
        encapsulationClass obj = new encapsulationClass();
        obj.setRoll(101);
        obj.setName("John Doe");
        obj.setDept("Computer Science");

        System.out.println("Roll Number: " + obj.getRoll());
        System.out.println("Name: " + obj.getname());
        System.out.println("Department: " + obj.getdept());
    }
}