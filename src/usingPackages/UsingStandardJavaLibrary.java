package usingPackages;
import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Calendar;

public class UsingStandardJavaLibrary {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		
		String fileName = "c:\\test.txt";		
		File fd = new File(fileName);
		System.out.println(fd.toString());
//		FileWriter file = new FileWriter(testFile);
//		file.close();
		
		simpleClass x = new simpleClass(1);
		try {
			simpleClass y = (simpleClass) x.clone();
			System.out.println(x.toString());
			System.out.println(y.toString());
			System.out.println(x.equals(y));
			System.out.println(x == y);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		Integer value = new Integer(1024);
		System.out.println(value.toString());
		System.out.println(value.doubleValue());
		System.out.println("0x" + Integer.toHexString(value));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.E);
		System.out.println(Math.PI);
		
		System.out.println(Math.pow(2, 8));
		System.out.println(Math.sqrt(81));
		for (int i = 0; i < 10; i++) {
			System.out.print(Math.round(5*Math.random()) + 1 + " ");
		}
		
		usingFiles();
	}
	
	public static void usingFiles() {
		System.out.println(System.getProperties());
		
		File pwd=new File(System.getProperty("user.dir"));
		System.out.println(pwd);
        if (pwd.isDirectory()){
             File [] bar=pwd.listFiles();
             for (int i = 0; i < bar.length; i++){
                 System.out.println (bar[i].getName());
             }
        }else{
            System.out.println ("Error. The argument is not a directory");
        }
	}

}
class simpleClass implements Cloneable{
	private int x = 0;
	
	simpleClass(int x){
		this.setX(x);
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	public Object clone() throws CloneNotSupportedException{
        return (simpleClass)super.clone();  
    }
}