package com.mycompany.primerservlet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
    
    //Creamos una instancia de Controladora
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos el id_editar del formulario index.jsp
        int id_editar = Integer.parseInt(request.getParameter("id_usuarioEdit"));
        
        Usuario usu = control.traerUsuario(id_editar);
        
        //Se obtiene una referencia al objeto HttpSession asociado con la solicitud actual mediante request.getSession().
        HttpSession misesion = request.getSession();
        misesion.setAttribute("usuEditar", usu);
        
        //Redirige a la pagina editar.jps
        response.sendRedirect("editar.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos los datos del formulario editar.jsp
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
        //Traemos al usuarios al cual estamos editando
        Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");
        usu.setDni(dni);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setTelefono(telefono);
        
        //Editamos al usuario al Usuario
        control.editarUsuario(usu);
        
        //Redirige a la pagina index.jps
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
