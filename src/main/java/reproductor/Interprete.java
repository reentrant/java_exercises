package reproductor;

import java.util.Objects;
import java.util.Scanner;

public class Interprete {

    private String nombre;
    private boolean solista;

    Interprete() {
        System.out.println("Nombre: ");
        Scanner scanner = new Scanner(System.in);
        this.nombre = scanner.nextLine();
        System.out.println("Es solista? ");
        if ("no".compareToIgnoreCase(scanner.next()) == 0) {
            this.solista = false;
        } else {
            this.solista = true;
        }
        scanner.close();
    }

    Interprete(String nombre, boolean esSolista) {
        this.nombre = nombre;
        this.solista = esSolista;
    }

    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return solista
     */
    public boolean isSolista() {
        return solista;
    }

    /**
     * @param esSolista
     */
    public void setSolista(boolean esSolista) {
        this.solista = esSolista;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Interprete other = (Interprete) obj;
        
        return this.nombre.compareToIgnoreCase(other.nombre) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        sb.append(", solista: ");
        sb.append(solista);
        return sb.toString();
    }
}
