package reproductor;

import java.util.Objects;
import java.util.Scanner;

public abstract class Video extends Multimedia {

    private final String titulo;
    private final Genero genero;

    Video() {
        int tipo;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual es el titulo?");
        this.titulo = scanner.nextLine();
        System.out.println("Cual es el genero?");
        do {
            System.out.println("1. DRAMA,\n"
                    + "2. TERROR,\n"
                    + "3. COMEDIA,\n"
                    + "4. ACCION,\n"
                    + "5. ROMANCE,\n"
                    + "6. HISTORICO,\n"
                    + "7. SUSPENSE,\n"
                    + "8. THRILLER,\n"
                    + "9. DOCUMENTAL,\n"
                    + "10. MUSICAL,\n"
                    + "11. INDIE");

            tipo = scanner.nextInt();
        } while (tipo < 1 || tipo > 12);
        this.genero = Genero.values()[tipo - 1];
        System.out.println("An~o de Creacion?");
        this.fecha = new Fecha(0, 0, scanner.nextInt());
        scanner.close();
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Video other = (Video) obj;

        if (this.getTitulo().compareToIgnoreCase(other.getTitulo()) != 0) {
            return false;
        }

        return this.genero.equals(other.genero) && super.equals(other);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.getTitulo());
        hash = 61 * hash + Objects.hashCode(this.genero);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo: ");
        sb.append(getTitulo());
        sb.append(", Genero: ");
        sb.append(genero);
        return sb.toString();
    }
}
