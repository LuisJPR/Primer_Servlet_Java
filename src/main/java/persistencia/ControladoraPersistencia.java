package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    //Creamos una instancia de UsuarioJpaController
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    
    //Operacion CREATE
    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    }
    
    //Operacion READ
    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
    }

    //Operacion DELETE
    public void borrarUsuario(int id_eliminar) {
        try {
            usuJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Operacion Traer Usuario
    public Usuario traerUsuario(int id_editar) {
        return usuJpa.findUsuario(id_editar);
    }

    //Operacion Update
    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
