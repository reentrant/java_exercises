package reproductor;

import java.util.Scanner;

public class Menu {

    private int opcion;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public void mostrar() {
        System.out.println("1. Nueva cancion");
        System.out.println("2. Mostrar canciones");
        System.out.println("3. Nuevo CD");
        System.out.println("4. Nuevo CD por interprete");
        System.out.println("5. Nuevo CD por duracion de las canciones");
        System.out.println("6. Nuevo DVD");
        System.out.println("7. Nuevo BlueRay");
        System.out.println("8. Mostrar CDs");
        System.out.println("9. Mostrar DVDs");
        System.out.println("10. Mostrar BlueRays");
        System.out.println("11. Mostrar Video");
        System.out.println("12. Mostrar Series");
        System.out.println("13. Mostrar serie con mas temporadas");
        System.out.println("14. Mostrar todo");
        System.out.println("15. Que vemos hoy");
        System.out.println("16. Que escuchamos hoy");
        System.out.println("0. Salir");
    }

    public int leer() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
        } while (opcion < 0 || opcion > 16);
        sc.close();
        return opcion;
    }
}
