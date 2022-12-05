import java.util.Scanner;

//Update 05/12/2022
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
                if (user.length() >= 6) {
                    System.out.println("Registre Contraseña De Usuario:");
                    String password = read.next();
                    if (password.length() >= 8) {
                        System.out.println("Contraseña De Usuario Muy Grande");
                    } else {
                        if (password.length() <= 4) {
                            System.out.println("Contraseña De Usuario Muy Pequeña");
                        } else {
                            usuario = new Login(user, password);
                            users[i] = usuario;
                            System.out.println("Usuario Registrado Correctamente: "
                                    + users[i].getUser() + " " + users[i].getPassword());

                        }
                    }
                } else if (user.length() >= 7) {
                    System.out.println("Nombre De Usuario Muy grande ");

                } else {
                    System.out.println("Nombre de usuario muy pequeno");
                }

                break;

            }

        }


    }

    public static void inicioSesion() {
        //Con Este Metodo Simplemente Mostrara Los Usuarios Validados
        int i = indice();
        if (i != -1) {
            System.out.println("Inicio De Sesion Validado");
            System.out.println("Bienvenido " + users[i].getUser());
        } else {
            System.out.println("Usuario No Encontrado");
        }


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
            System.out.println("Ingrese Usuario: ");
            String user = read.next();
            if (users[i] != null) {
                if (users[0].getUser().equals(user)) {
                    System.out.println("Ingrese Contraseña: ");
                    String password = read.next();
                    if (users[0].getPassword().equals(password)) {
                        return 0;

                    }
                }

            }
            break;
        }
        return -1;
    }

    public static int indice() {
        System.out.println("Ingrese Usuario: ");
        String user = read.next();
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                System.out.println(users[i].getUser());
                if (users[i].getUser().equals(user)) {
                        return i;
                }
            }

        }
        return -1;
    }

    public static void deleteUser() {
        //El Metodo privilegio de el usuario admin eliminara a cualquier usuar por nombre.

        int buscador = indice();
        if (buscador != -1) {
            users[buscador] = null;
            System.out.println("Usuario eliminado correctamente");
        } else if (buscador == -1){
            System.out.println("Usuario no encontrado");
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
        System.out.println("----------------------------------");
        System.out.println("-          Menu Principal        -");
        System.out.println("-      1.Ingresa Como Admin      -");
        System.out.println("-      2.Ingresa Como Empleado   -");
        System.out.println("-      3.Salir Sistema           -");
        System.out.println("----------------------------------");

    }


}




