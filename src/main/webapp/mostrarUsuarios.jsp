<%@page import="java.util.List"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Lista de Usuarios Registrados</h1>
            <% 
                List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                int cont = 1;
                for(Usuario asu : listaUsuarios) {
            %>
            
                    <p><b>Usuario N° <%=cont%></b></p>
                    <p>Id: <%=asu.getId()%></p>
                    <p>Dni: <%=asu.getDni()%></p>
                    <p>Nombre: <%=asu.getNombre()%></p>
                    <p>Apellido: <%=asu.getApellido()%></p>
                    <p>Telefono: <%=asu.getTelefono()%></p>
                    <p>---------------------------------------</p>
                    <% cont++; %>
            
            <% } %>
    </body>
</html>
