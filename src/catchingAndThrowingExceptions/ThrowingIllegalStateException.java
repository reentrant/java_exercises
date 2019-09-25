package catchingAndThrowingExceptions;

public class ThrowingIllegalStateException {
	
	public static void main(String[] args){
		char[] name = { 'J', 'a', 'v', 'a' };
		char[] example = null;
		displayArray(name);
		displayArray(example);
	}

	static void displayArray(char[] name)
	{
		if (name == null){
			throw new IllegalStateException("argument is null");
		}
		else{
			System.out.println(name);	
		}
	}
}
