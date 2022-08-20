package reproductor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class ReproductorApp {

    static ArrayList<Cancion> canciones = new ArrayList<>();
    static ArrayList<Multimedia> coleccion = new ArrayList<>();
    static final int MAX_NUM_CANCIONES = 20;
    Scanner scanner;

    ReproductorApp() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ReproductorApp app = new ReproductorApp();
        Menu menu = new Menu();
        int opcion;
        do {
            menu.mostrar();
            opcion = menu.leer();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    app.nuevaCancion();
                    break;
                case 2:
                    app.mostrarCanciones();
                    break;
                case 3:
                    app.nuevoCD();
                    break;
                case 4:
                    app.nuevoCDInterprete();
                    break;
                case 5:
                    app.nuevoCDTiempo();
                    break;
                case 6:
                    app.nuevoDVD();
                    break;
                case 7:
                    app.nuevoBlueRay();
                    break;
                case 8:
                    app.mostrarCDs();
                    break;
                case 9:
                    app.mostrarDVDs();
                    break;
                case 10:
                    app.mostrarBlueRays();
                    break;
                case 11:
                    app.mostrarVideo();
                    break;
                case 12:
                    app.mostrarSeries();
                    break;
                case 13:
                    app.mostrarSerieMasLarga();
                    break;
                case 14:
                    app.mostrarTodo();
                    break;
                case 15:
                    app.seleccionaAzarDVDoBR();
                    break;
                case 16:
                    app.seleccionaAzarCD();
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }


    private void nuevaCancion() {
        Cancion nueva = new Cancion();
        System.out.println(nueva);
        boolean repetida = false;
        for (Cancion c : canciones) {
            if (c.equals(nueva)) {
                repetida = true;
                System.out.println("WARNING: Canción repetida");
                break;
            }
        }
        if (!repetida) {
            canciones.add(nueva);
        }
    }


    private void mostrarCanciones() {
        System.out.println("Escoja el criterio:\n"
                + "1. Por titulo\n"
                + "2. Por duracion\n"
                + "3. Por Interprete\n"
        );
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                for (Cancion c : canciones) {
                    System.out.println(c);
                }
                break;
            case 2:
                canciones.sort(new ComparadorDeCancionPorDuracion());
                for (Cancion c : canciones) {
                    System.out.println(c);
                }
                break;

            case 3:
                canciones.sort(new ComparadorDeCancionPorInterprete());
                for (Cancion c : canciones) {
                    System.out.println(c);
                }
        }
    }


    private void nuevoCD() {
        System.out.println("Numero de canciones N que contendra el CD");
        int n;
        Cancion[] arrayCanciones;
        do {
            n = scanner.nextInt();
            if (n > canciones.size()) {
                System.out.println("Solo hay " + canciones.size() + " canciones.");
            }
        } while (n > canciones.size());

        arrayCanciones = new Cancion[n];

        HashSet cancionesNoRepetidas = new HashSet();

        while (cancionesNoRepetidas.size() < arrayCanciones.length) {
            int index = (int) (canciones.size() * Math.random());
            cancionesNoRepetidas.add(index);
            arrayCanciones[cancionesNoRepetidas.size() - 1] = canciones.get(index);
        }
        CD cd = new CD(arrayCanciones);
        agregarDiscoNoRepetido(cd);
    }

    private void nuevoCDInterprete() {
        System.out.println("Introduzca el Intérprete");
        String cantante = scanner.next();
        ArrayList<Integer> indices = new ArrayList<>();
        int numCancionesPorInterprete = 0;
        canciones.sort(new ComparadorDeCancionPorInterprete());
        for (Cancion c : canciones) {
            for (Interprete i : c.getInterpretes()) {
                // 
                if (i.getNombre().compareToIgnoreCase(cantante) == 0
                        && numCancionesPorInterprete < MAX_NUM_CANCIONES) {
                    indices.add(numCancionesPorInterprete);
                }
            }
            numCancionesPorInterprete++;
        }
        Cancion[] arrayDeCanciones = llenarArrayDeCanciones(indices);
        CD cd = new CD(arrayDeCanciones);
        agregarDiscoNoRepetido(cd);
    }

    private void nuevoCDTiempo() {
        System.out.println("Duracion Maxima de la cancion");
        Tiempo duracionMaxima = new Tiempo();
        ArrayList<Integer> indices = new ArrayList<>();
        int numCancionesPorDuracion = 0;
        for (Cancion c : canciones) {
            if (c.getDuracion() < duracionMaxima.getDuracionSegundos()
                    && numCancionesPorDuracion < MAX_NUM_CANCIONES) {
                indices.add(numCancionesPorDuracion);
            }
            numCancionesPorDuracion++;
        }
        Cancion[] arrayDeCanciones = llenarArrayDeCanciones(indices);
        CD cd = new CD(arrayDeCanciones);
        agregarDiscoNoRepetido(cd);
    }

    Cancion[] llenarArrayDeCanciones(ArrayList<Integer> listaDeIndices) {
        Cancion[] arrayDeCanciones = new Cancion[listaDeIndices.size()];
        for (int j = 0; j < listaDeIndices.size(); j++) {
            arrayDeCanciones[j] = canciones.get(listaDeIndices.get(j));
        }
        return arrayDeCanciones;
    }

    private void nuevoDVD() {
        DVD nuevo = new DVD();
        agregarDiscoNoRepetido(nuevo);
    }

    private void nuevoBlueRay() {
        BlueRay nuevo = new BlueRay();
        agregarDiscoNoRepetido(nuevo);
    }

    void agregarDiscoNoRepetido(Multimedia disc) {
        System.out.println(disc);
        boolean discoRepetido = false;
        for (Multimedia m : coleccion) {
            if (m.equals(disc)) {
                discoRepetido = true;
                System.out.println("WARNING: Contenido repetido. Medio no agregado.");
                break;
            }
        }
        if (!discoRepetido) {
            coleccion.add(disc);
        }
    }

    /**
     * método mostrarCDs(). Es el encargado de mostrar todos los CDs contenidos en el ArrayList.
     */
    private void mostrarCDs() {
        for (Multimedia disc : coleccion) {
            if (disc.getClass().equals(CD.class)) {
                System.out.println(disc);
            }
        }
    }

    /**
     * mostrarDVDs(). mostrar todos los DVD.
     */
    private void mostrarDVDs() {
        for (Multimedia disco : coleccion) {
            if (disco.getClass().equals(DVD.class)) {
                System.out.println(disco);
            }
        }
    }

    /**
     * mostrarBlueRays(). mostrar todos los BR.
     */
    private void mostrarBlueRays() {
        for (Multimedia disco : coleccion) {
            if (disco.getClass().equals(BlueRay.class)) {
                System.out.println(disco);
            }
        }
    }

    /**
     * mostrarVideo(). mostrar todos los DVD y BR .
     */
    private void mostrarVideo() {
        for (Multimedia disco : coleccion) {
            if (disco.getClass().equals(BlueRay.class) || disco.getClass().equals(DVD.class)) {
                System.out.println(disco);
            }
        }
    }


    private void mostrarSeries() {
        ArrayList<BlueRay> blueRays = new ArrayList<>(); 
        for (Multimedia disco : coleccion) {
            if (disco.getClass().equals(BlueRay.class)) {
                blueRays.add((BlueRay) disco);
            }
        }
        
        blueRays.sort(new ComparadorDeBRaysPorTitulo());
        for (BlueRay br: blueRays) {
            System.out.println(br);
        }
    }


    private void mostrarSerieMasLarga() {
        BlueRay blueRayMasTemporadas = null;
        for (Multimedia disco : coleccion) {
            if (disco.getClass().equals(BlueRay.class)) {
                BlueRay blue = (BlueRay) disco;
                if (blueRayMasTemporadas == null) {
                    blueRayMasTemporadas = blue;
                } else if (blue.getTemporadas() > blueRayMasTemporadas.getTemporadas()) {
                    blueRayMasTemporadas = blue;
                } 
            }
        }
        System.out.println(blueRayMasTemporadas);
        
    }


    private void mostrarTodo() {
        for (Multimedia disco : coleccion) {
            System.out.println(disco);
        }
    }

    /**
     * seleccionaAzarDVDoBR().
     * Selecciona al azar un DVD o BR.
     */
    private void seleccionaAzarDVDoBR() {
        ArrayList<Video> videos = new ArrayList<>();
        for (Multimedia disco : coleccion) {
            if (disco.getClass().equals(BlueRay.class) || disco.getClass().equals(DVD.class)) {
                videos.add((Video) disco);
            }
        }
        int videoIndex = (int) (videos.size() * Math.random());
        System.out.println(videos.get(videoIndex));
    }

    /**
     * seleccionaAzarCD().
     * Selecciona un CD al azar.
     */
    private void seleccionaAzarCD() {
        ArrayList<CD> cds = new ArrayList<>();
        for (Multimedia disco : coleccion) {
            if (disco.getClass().equals(CD.class)) {
                cds.add((CD) disco);
            }
        }
        int cdIndex = (int) (cds.size() * Math.random());
        System.out.println(cds.get(cdIndex));    
    }

}

class ComparadorDeCancionPorDuracion implements Comparator<Cancion> {

    @Override
    public int compare(Cancion o1, Cancion o2) {
        return o1.getDuracion() - o2.getDuracion();
    }
}

class ComparadorDeCancionPorInterprete implements Comparator<Cancion> {

    @Override
    public int compare(Cancion c1, Cancion c2) {
        Interprete interprete1 = c1.getInterpretes().get(0);
        Interprete interprete2 = c2.getInterpretes().get(0);
        return interprete1.getNombre().compareToIgnoreCase(interprete2.getNombre());
    }
       
}

class ComparadorDeBRaysPorTitulo implements Comparator<BlueRay> {
    @Override
    public int compare(BlueRay b1, BlueRay b2) {
        return b1.getTitulo().compareToIgnoreCase(b2.getTitulo());
    }    
}