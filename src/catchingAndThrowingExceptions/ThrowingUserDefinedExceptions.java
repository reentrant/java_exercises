package catchingAndThrowingExceptions;

public class ThrowingUserDefinedExceptions {
	public static void main(String args[]) {
		  try{
		       throw new CustomException(1000);
		  }
		  catch(CustomException e){
		    System.out.println(e) ;
		    System.out.println(e.getStackTrace());
		  }//catch
	}//main
}//class

class CustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int a;
	   CustomException(int a) {
	     this.a = a;
	   }

	   public String toString(){
	     return ("Exception Number =  " + a) ;
	   }
}
