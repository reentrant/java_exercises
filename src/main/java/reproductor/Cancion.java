package reproductor;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cancion implements Comparable<Cancion> {

    private String titulo;
    private ArrayList<Interprete> interprete = new ArrayList<>();
    private Tiempo duracion;

    Cancion() {
        System.out.println("Titulo de la cancion: ");
        Scanner scanner = new Scanner(System.in);
        this.titulo = scanner.nextLine();
        System.out.println("Cuantos cantantes la interpretan?");
        int numeroCantantes;
        do {
            numeroCantantes = scanner.nextInt();
            int n = 0;
            while (n < numeroCantantes) {
                Interprete nuevo = new Interprete();
                boolean repetido = false;
                for (Interprete i : interprete) {
                    if (i.equals(nuevo)) {
                        System.out.println("WARNING: Interprete repetido");
                        repetido = true;
                        break;
                    }
                }
                if (!repetido) {
                    n++;
                    interprete.add(nuevo);
                }
            }
        } while (numeroCantantes <= 0);

        System.out.println("Cual es la duracion?");
        this.duracion = new Tiempo();
        scanner.close();
    }
    
    Cancion(String titulo, ArrayList<Interprete> interpretes, Tiempo duracion){
        this.titulo = titulo;
        this.interprete = interpretes;
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) obj;

        if (this.titulo.compareToIgnoreCase(other.titulo) != 0) {
            return false;
        }

        if (interprete.isEmpty() || other.interprete.isEmpty()) {
            return false;
        } else if (!this.duracion.equals(other.duracion)) {
            return false;
        } else {
            return interprete.equals(other.interprete);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.titulo);
        hash = 31 * hash + Objects.hashCode(this.interprete);
        hash = 31 * hash + Objects.hashCode(this.duracion);
        return hash;
    }

    /**
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return interprete ArrayList
     */
    public ArrayList<Interprete> getInterpretes() {
        return interprete;
    }

    /**
     * @param cadaInterprete
     */
    public void setInterprete(Interprete cadaInterprete) {
        this.interprete.add(cadaInterprete);
    }

    /**
     * @return  duracion en segundos
     */
    public int getDuracion() {
        return duracion.getMinutos() * 60 + duracion.getSegundos();
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(Tiempo duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cancion[ Titulo: ");
        sb.append(titulo);
        sb.append(", interprete: ");
        sb.append(interprete);
        sb.append(", duracion: ");
        sb.append(duracion);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(Cancion o) {
        return this.titulo.compareToIgnoreCase(o.titulo);
    }

}
