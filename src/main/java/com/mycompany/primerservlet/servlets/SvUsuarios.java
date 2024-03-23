package com.mycompany.primerservlet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    
    //Creamos una instancia de Controladora
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creamos una lista de usuarios
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = control.traerUsuarios();
        
        //Se obtiene una referencia al objeto HttpSession asociado con la solicitud actual mediante request.getSession().
        HttpSession misesion = request.getSession();
        //Se agrega la lista de usuarios (listaUsuarios) al objeto de sesión utilizando setAttribute().
        //Esto significa que la lista de usuarios estará disponible para otras partes de la aplicación que necesiten acceder a ella mientras la sesión esté activa.
        misesion.setAttribute("listaUsuarios", listaUsuarios);
        
        //Se redirige la respuesta a la página mostrarUsuarios.jsp. 
        //Esto significa que después de que se complete la ejecución de este método, el navegador será redirigido a la página mostrarUsuarios.jsp
        response.sendRedirect("mostrarUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos los datos del formulario index.jsp (request o solicitud, response o repuesta)
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
        //Creamos una instancia de Usuario
        Usuario usu = new Usuario();
        usu.setDni(dni);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setTelefono(telefono);
        
        //Creamos al Usuario
        control.crearUsuario(usu);
        
        //Redirige a la pagina index.jps
        response.sendRedirect("index.jsp");
        
        //Verificamos del lado del servidor, si llegaron los datos al servlet del index.jsp
        //System.out.println("El Dni es: " + dni);
        //System.out.println("El Nombre es: " + nombre);
        //System.out.println("El Apellido es: " + apellido);
        //System.out.println("El Telefono es: " + telefono);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
