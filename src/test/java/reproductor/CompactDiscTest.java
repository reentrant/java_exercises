package reproductor;

import java.util.ArrayList;


public class CompactDiscTest {

    static ArrayList<Cancion> listaCanciones = new ArrayList<>();

    ;
    public CompactDiscTest() {
    }

    public static void main(String[] args) {

        CompactDiscTest app = new CompactDiscTest();

        Interprete i1 = new Interprete("Jose Jose", true);
        Interprete i2 = new Interprete("Jesus Adrian", true);
        ArrayList<Interprete> listI1 = new ArrayList<>();
        listI1.add(i1);
        ArrayList<Interprete> listI2 = new ArrayList<>();
        listI2.add(i2);
        System.out.println(listI1.size());
        Cancion c1 = new Cancion("Gavilan o paloma", listI1, new Tiempo(3, 1));
        Cancion c2 = new Cancion("el triste", listI1, new Tiempo(3, 2));
        Cancion c3 = new Cancion("Amor amor", listI1, new Tiempo(3, 3));
        Cancion c4 = new Cancion("Que seas mi Universo", listI2, new Tiempo(3, 3));

        listaCanciones.add(c4);
        listaCanciones.add(c1);
        listaCanciones.add(c2);
        listaCanciones.add(c3);

//        HashSet indicesNoRepetidos = new HashSet();
//        
//        while( indicesNoRepetidos.size() < arrayDeCanciones.length) {
//            int index = (int) (listaCanciones.size() * Math.random());
//            System.out.println(index);
//            indicesNoRepetidos.add(index);
//            arrayDeCanciones[indicesNoRepetidos.size()-1] = listaCanciones.get(index);
//            System.out.println(Arrays.toString(arrayDeCanciones));
//        }
        //CompactDisc cd = new CompactDisc(arrayDeCanciones);
        System.out.println("Duracion Maxima de la cancion");

        Tiempo duracionMaxima = new Tiempo();
        System.out.println(duracionMaxima);

        ArrayList<Integer> indices = new ArrayList<>();
        int numCancionesPorDuracion = 0;
        for (Cancion c : listaCanciones) {
            if (c.getDuracion() < duracionMaxima.getDuracionSegundos() && numCancionesPorDuracion < 20) {
                System.out.println(c);
                indices.add(numCancionesPorDuracion);
            }
            numCancionesPorDuracion++;
        }
        Cancion[] arrayDeCanciones = app.llenarArrayDeCanciones(indices);

        System.out.println(app.calcularTiempoTotal(arrayDeCanciones));
        CD cd = new CD(arrayDeCanciones);
        System.out.println(cd);

    }

    public Cancion[] llenarArrayDeCanciones(ArrayList<Integer> listaDeIndices) {
        Cancion[] arrayDeCanciones = new Cancion[listaDeIndices.size()];
        for (int j = 0; j < listaDeIndices.size(); j++) {
            arrayDeCanciones[j] = listaCanciones.get(listaDeIndices.get(j));
        }
        return arrayDeCanciones;
    }

    int calcularTiempoTotal(Cancion[] array) {
        int totalDeSegundos = 0;
        for (Cancion cancion : array) {
            totalDeSegundos += cancion.getDuracion();
            System.out.println(cancion.getDuracion());
        }

        int minutos = totalDeSegundos / 60;
        int residuo = totalDeSegundos % 60;
        System.out.print("Duracion Total: ");
        System.out.print(minutos);
        System.out.println(":" + residuo);

        return totalDeSegundos;
    }
}
