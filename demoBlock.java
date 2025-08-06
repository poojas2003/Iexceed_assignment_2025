class demoBlock
 {
 
    {
        System.out.println("Instance block is called");
    }
    static{
        System.out.println("inside static block");
    }
 
    demoBlock() // constructor
    {
        System.out.println("Inside constructor");
    }
 
     public static void main(String[] args) {
       // new demoBlock();
        System.out.println("Inside main mathod");
     }
 }