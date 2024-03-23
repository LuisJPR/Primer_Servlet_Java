package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    //Creamos una instancia de ControladoraPersistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //Crear Usuario
    public void crearUsuario(Usuario usu) {
        controlPersis.crearUsuario(usu);
    }
    
    //Traer Usuarios
    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    //Eliminar Usuario
    public void borrarUsuario(int id_eliminar) {
        controlPersis.borrarUsuario(id_eliminar);
    }

    //Traemos un Usuario
    public Usuario traerUsuario(int id_editar) {
        return controlPersis.traerUsuario(id_editar);
    }

    //Editar Usuario
    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }
    
}
