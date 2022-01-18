
package demo;

public class ExceptionHandlingDemo {
	public  static void main(String[] args) {
		try {
		System.out.println("Hello world ..");
		int i = 1/0;
		System.out.println("Completed");	
		}
		catch(Exception exp) {
			System.out.println("inside catch");	
			System.out.println(exp.getMessage());	
			System.out.println(exp.getCause());	
			exp.printStackTrace();

		}
		

	}
}
