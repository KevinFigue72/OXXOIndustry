import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         * En este metodo principal
         * Compilaran todos los metodos
         * De La Clase Sistema
         */
        Scanner read = new Scanner(System.in);
        int opcion;
        do {
            /*Con El metodo userRegistrados, mostrara
             *Los usuarios registrados en el sitema
             * por parte del Admin
             */
            Sistema.userRegistrados();
            Sistema.menuGeneral();
            opcion = read.nextInt();
            switch (opcion) {
                case 1:
                    Sistema.menuAdmin();
                    break;
                case 2:
                   Sistema.inicioSesion();
                    break;

                case 3:
                    System.out.println("Programa Terminado");
                    break;

            }

        } while (opcion != 3);
    }
}