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

    public int leer() {
    	int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 6);
        sc.close();
        return opcion;
    }
}
