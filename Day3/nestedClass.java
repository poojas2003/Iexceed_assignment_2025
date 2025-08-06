class nestedClass{
    private String cm,capital;
    private double area;
    class mysuru{
        String collecter_Name;
        int area_dist;
        mysuru(String cm,int area_dist){
            this.collecter_Name=cm;
            this.area_dist=area_dist;
        }
        void display(){
            System.out.println("Collecter Name: " + collecter_Name);
            System.out.println("Area of District: " + area_dist);
            System.out.println("Capital: " + capital);
            System.out.println("cm: " + cm);
        }
    }
    public static void main(String[] args){
       // nestedClass obj=new nestedClass();
       new nestedClass().new mysuru("John", 100).display();    }
}