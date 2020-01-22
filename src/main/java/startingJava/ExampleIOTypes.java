package startingJava;

import java.util.Scanner;

public class ExampleIOTypes {

	public ExampleIOTypes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Proporciona el nombre: "); 
		String nombre = s.nextLine();
		
		System.out.println("Proporciona el id: ");
		int id = Integer.parseInt(s.nextLine());
		
		System.out.println("Proporciona el precio: ");
		float precio = Float.parseFloat(s.nextLine()); 
		
		System.out.println("Proporciona el simbolo: ");
		char moneda = s.nextLine().charAt(0);
			
		System.out.println("Proporciona el envio gratuito:" );
		boolean envio = s.nextBoolean();
		
		String result = nombre + " #" + id + '\n' + "Precio: " + moneda + precio + '\n' + "Envio Gratuito: " + envio;
		System.out.println(result);
		System.out.println("Resta: " + (precio - id));
		System.out.flush();
		s.close();
	}

}
