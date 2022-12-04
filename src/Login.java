public class Login {
    private String user;
    private String password;
    /*
     *Crearemos un constructor de Nuestra clase
     * Se Utilizara para incializar
     * variables.
     */
    public Login(String user,String password){
        this.user = user;
        this.password = password;
    }
    //Con Los Getters Y Setters agregraremos o mostraremos Datos.

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
