import java.util.Scanner;


/*
 * Lo Que Realizara Este Programa Es El Inicio De
 * Sesion Y Validacion Del Usuario
 *
 * @Autor: Comunidad
 * @Version: 1.0
 */
public class Sistema {
    /*Este Arreglo de Tipo Login
     * Guardara Los datos que recibe el
     * Constructor.
     */
    static Login[] users = new Login[5];
    static Scanner read = new Scanner(System.in);

    static Login usuario, Admin = new Login("", "");

    // Se crean 2 objetos De login(Usuario,Admin). Tipo Estatico para acceder a los metodos.
    public static void registerUser() {
        /*En este metodo agregaremos
         *Datos a nuestro arreglo
         * para que luego este se han
         * recibidos en el objeto usuario.
         */
        for (int i = 1; i < users.length; i++) {
            if (users[i] == null) {
                System.out.println("Registre Nombre De Usuario:    ");
                String user = read.next();
                System.out.println("Registre Contraseña De Usuario:");
                String password = read.next();
                usuario = new Login(user, password);
                users[i] = usuario;
                break;
            }

        }


    }

    public static void inicioSesion() {
        //Con Este Metodo Simplemente Mostrara Los Usuarios Validados
        int i = index();
        System.out.println("Inicio De Sesion Validado");
        System.out.println("Bienvenido " + users[i].getUser());

    }

    public static void userRegistrados() {
        System.out.println("    -----Usuarios Registrados-----   \n");
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                System.out.println("Usuario " + users[i].getUser());
            } else {
                break;
            }
        }

    }

    public static int index() {
       /*
        *Este Metodo buscara y comparara
        * Los usuarios ingresados por teclado
        * con el objeto admin que guarda sus datos
        * en un arreglo, Si se valida entrara
        * al metodo Admin.
        */
        for (int i = 0; i < users.length; i++) {
            Admin = new Login("admin123", "123");
            users[0] = Admin;
            if (users[i] != null) {
                System.out.println("Ingrese Usuario: ");
                String user = read.next();
                System.out.println("Ingrese Contraseña: ");
                String password = read.next();
                if (users[0].getUser().equals(user)) {
                    if (users[0].getPassword().equals(password)) {
                        return 0;
                    }
                }
            }

        }
        return -1;
    }

    public static void deleteUser() {
        //El Metodo privilegio de el usuario admin eliminara a cualquier usuar por nombre.
        for (int i = 0; i < users.length; i++) {
            if (users != null) {
                System.out.println("Ingrese Nombre De usuario: ");
                String user = read.next();
                if (users[i].getUser().equals(user)) {
                    users[i] = null;
                } else {
                    System.out.println("Usuario No Encontrado");
                    break;
                }
            }

        }
    }

    public static void menuAdmin() {
        int buscador = index();

        if (buscador != -1) {
            if (users[buscador] != null) {
                int opcion2;
                if (buscador == 0) {
                    do {
                        System.out.println("Bienvenido Administrador " + users[buscador].getUser());
                        System.out.println("------------------------------------------");
                        System.out.println("-        Opciones                        -");
                        System.out.println("-     1.Registrar Usuario                -");
                        System.out.println("-     2.Eliminar Usuario                 -");
                        System.out.println("-     3.Iniciar inventario               -");
                        System.out.println("-     4.Salir Admin                       ");
                        System.out.println("------------------------------------------");

                        opcion2 = read.nextInt();
                        switch (opcion2) {
                            case 1:
                                registerUser();
                                break;
                            case 2:
                                deleteUser();
                                break;
                            case 3:
                                System.out.println("Inventario");
                                break;
                            case 4:
                                System.out.println("Sesion Cerrada ");
                                break;
                            default:
                                System.out.println("Opcion Incorrecta");

                        }
                    } while (opcion2 != 4);
                }
            }
        } else {
            System.out.println("Inicio de Sesion Incorrecto");
        }
    }

    public static void menuGeneral() {
        // Menu para la interfaz a a
        System.out.println("          INICIO DE SESION OXXO      ");
        System.out.println("-------------------------------------");
        System.out.println("-        1.Ingresar Como Admin      -");
        System.out.println("-        2.Ingresar Como Empleado   -");
        System.out.println("-        3.Sali del programa        -");
        System.out.println("--------------------------------------");
    }


}
