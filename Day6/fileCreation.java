import java.io.File;

public class fileCreation {
    public static void main(String[] args)throws Exception {
        File f =new File("C:\\Users\\pooja.lnu\\Documents\\sample.txt");
        f.createNewFile();
        System.out.print(f.isAbsolute());
        System.out.print(f.getAbsolutePath());
        boolean ex=f.exists();
	System.out.println(ex);
       
        if(ex){
        System.out.print("can raed"+f.canRead());
        System.out.print("can write"+f.canWrite());
        }
          f.delete();
	  System.out.println("is file is available?\t"+f.exists());
}
}