package cuerpos.geometricos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class CuerposGeometricosApp {

    ArrayList<CuerpoGeometrico> listaDeCuerposGeometricos = new ArrayList<>();

    public static void main(String[] args) {
        CuerposGeometricosApp app = new CuerposGeometricosApp();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("Menu: \n"
                    + "1. Nuevo cuerpo geometrico\n"
                    + "2. Mostrar todos\n"
                    + "3. Mostrar prismas\n"
                    + "4. Mostrar circulares\n"
                    + "0. Salir\n");
            opcion = scanner.next();
            switch (opcion) {
                case "0":
                    break;
                case "1":
                    app.agregarNuevoCuerpoGeometrico();
                    break;
                case "2":
                    app.mostrarTodos();
                    break;
                case "3":
                    app.mostrarPrismas();
                    break;
                case "4":
                    app.mostrarCirculares();
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (!"0".equals(opcion));
        scanner.close();
    }

    /**
     * agregar nuevo cuerpo geometrico: Mediante esta opcion se crea un nuevo objeto y se anade al
     * ArrayList. En el ArrayList no puede haber cuerpos geometricos repetidos. Si se intenta crear
     * uno que ya existe se muestra un mensaje indicandolo y se vuelve al menu principal. Se
     * consideran dos cuerpos geometricos iguales cuando son de la misma clase y tienen todos sus
     * datos iguales.
     */
    void agregarNuevoCuerpoGeometrico() {
        String opcion;
        CuerpoGeometrico nuevoObjeto;
        String menu = "Menu Tipos de Nuevos Objetos:\n"
                + "1. Prisma Regular Triangular\n"
                + "2. Prisma Regular Cuadrangular\n"
                + "3. Cilindro Recto\n"
                + "4. Cilindro Oblicuo\n"
                + "5. Cono\n"
                + "6. Tronco de Cono\n";

        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);
        opcion = scanner.next();
        switch (opcion) {
            case "1":
                nuevoObjeto = new PrismaRegularTriangular();
                break;
            case "2":
                nuevoObjeto = new PrismaRegularCuadrangular();
                break;
            case "3":
                nuevoObjeto = new CilindroRecto();
                break;
            case "4":
                nuevoObjeto = new CilindroOblicuo();
                break;
            case "5":
                nuevoObjeto = new Cono();
                break;
            case "6":
                nuevoObjeto = new TroncoDeCono();
                break;
            default:
            	scanner.close();
                return;
        }
        boolean duplicado = false;
        for (CuerpoGeometrico cuerpo : listaDeCuerposGeometricos) {
            if (cuerpo.equals(nuevoObjeto)) {
                System.out.println("WARNING: Cuerpo geometrico duplicado");
                duplicado = true;
                break;
            }
        }
        if (!duplicado) {
            listaDeCuerposGeometricos.add(nuevoObjeto);
        }
        scanner.close();
    }

    /**
     * Mostrar todos: Muestra todos los cuerpos geometricos creados ordenados alfabeticamente por
     * color usando Collections.sort()
     */
    void mostrarTodos() {
        Collections.sort(listaDeCuerposGeometricos);
        for (CuerpoGeometrico cuerpo : listaDeCuerposGeometricos) {
            System.out.println(cuerpo);
        }
    }

    /**
     * Mostrar prismas: Muestra todos los prismas que contiene el ArrayList de la siguiente forma.
     * Primero muestra todos los prismas regulares triangulares ordenados por area de menor a mayor.
     * A continuacion muestra todos los prismas regulares cuadrangulares ordenados por volumen de
     * menor a mayor.
     */
    void mostrarPrismas() {
        ArrayList<PrismaRegular> triangulares = new ArrayList<>();
        ArrayList<PrismaRegular> cuadrangulares = new ArrayList<>();
        
        for (CuerpoGeometrico cuerpo: listaDeCuerposGeometricos) {
            if (cuerpo.nombre.endsWith("Triangular")) {
                triangulares.add((PrismaRegular) cuerpo);
            } else if (cuerpo.nombre.endsWith("Cuadrangular")) {
                cuadrangulares.add((PrismaRegular) cuerpo);
            }
        }
        triangulares.sort(new OrdenarPorArea());   
        for (PrismaRegular prisma: triangulares) {
            System.out.println(prisma);
        }
        cuadrangulares.sort(new OrdenarPorVolumen());
        for (PrismaRegular prisma: cuadrangulares) {
            System.out.println(prisma);
        }
    }

    /**
     * Mostrar circulares: Muestra todos los cuerpos geometricos circulares que contiene el
     * ArrayList de la siguiente forma. Primero muestra todos los cilindros (rectos y oblicuos)
     * ordenados por area de mayor a menor. A continuacion muestra todos los conos y troncos de cono
     * ordenados por volumen de mayor a menor.
     */
    void mostrarCirculares() {
        ArrayList<CuerpoGeometricoCircular> cilindros = new ArrayList<>();
        ArrayList<CuerpoGeometricoCircular> conos = new ArrayList<>();
        
        for (CuerpoGeometrico cuerpo: listaDeCuerposGeometricos) {
            if (cuerpo.nombre.startsWith("Prisma")) {
                // ignorarlo;
            } else if (cuerpo.nombre.startsWith("Cilindro")) {
                cilindros.add((CuerpoGeometricoCircular) cuerpo);
            } else {
                conos.add((CuerpoGeometricoCircular) cuerpo);
            }
        }
        cilindros.sort(new OrdenarPorArea());
        Collections.reverse(cilindros);
        for (CuerpoGeometricoCircular cuerpo: cilindros) {
            System.out.println(cuerpo);
        }
        
        conos.sort(new OrdenarPorVolumen());
        Collections.reverse(conos);
        for (CuerpoGeometricoCircular cuerpo: conos) {
            System.out.println(cuerpo);
        }

    }
}

class OrdenarPorArea implements Comparator<CuerpoGeometrico> {
    
    @Override
    public int compare(CuerpoGeometrico o1, CuerpoGeometrico o2) {
        return Double.compare(o1.area(), o2.area());
    }
}

class OrdenarPorVolumen implements Comparator<CuerpoGeometrico> {
    
    @Override
    public int compare(CuerpoGeometrico o1, CuerpoGeometrico o2) {
        return Double.compare(o1.volumen(), o2.volumen());
    }
}