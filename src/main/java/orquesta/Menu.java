package orquesta;

import java.util.Scanner;

public class Menu {

    public void mostrar() {
        System.out.println("1. Mostrar orquesta");
        System.out.println("2. Mostrar orquesta sonando");
        System.out.println("3. Hacer sonar");
        System.out.println("4. Dejar de sonar");
        System.out.println("5. Hacer cantar");
        System.out.println("6. Dejar de cantar");
        System.out.println("0. FIN");
    }

    public int leerMenuPrincipal() {
    	int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 6);
        return opcion;
    }
    
    public int escoger(String texto) {
    	Scanner sc = new Scanner(System.in);
    	int opcion = -1;
		do {
			System.out.print(texto);
        	try {
            	if (sc.hasNextLine()) {
            		String string = sc.nextLine();
            		opcion = Integer.parseInt(string);
            	}
    		}
        	catch (Exception e) {
                System.out.println(e.getMessage());
            }	
        } while (opcion < 1 || opcion > 2);
		return opcion;
    }
    
}
