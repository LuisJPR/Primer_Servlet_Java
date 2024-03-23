<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formularios de Prueba</title>
    </head>
    <body>
        <h1>Datos del Usuario</h1>
        <!<!-- Cuando llenamos el formulario y hacemos clic en el boton enviar, los datos se envian al servlet SvUsuarios mediante el parametro 'name' -->
        <form action="SvUsuarios" method="POST">
            <p><label>Dni: </label> <input type="text" name="dni"></p>
            <p><label>Nombre: </label> <input type="text" name="nombre"></p>
            <p><label>Apellido: </label> <input type="text" name="apellido"></p>
            <p><label>Telefono: </label> <input type="text" name="telefono"></p>
            <button type="submit">Enviar</button>
        </form>
        
        <!<!-- Cuando hacemos click en el boton Mostrar Usuario nos llevara a mostrarUsuarios.jsp pero antes pasa por el servlet SvUsuarios -->
        <h1>Ver lista de Usuarios</h1>
        <p>Para ver los datos de los usuarios cargados haga click en el siguiente boton</p>
        <form action="SvUsuarios" method="GET">
            <button type="submit">Mostrar Usuarios</button>
        </form>
        
        <!<!-- Cuando hacemos click en el boton Eliminar Usuario, el parametro 'name' se enviar al servlet SvEliminar -->
        <h1>Eliminar Usuario</h1>
        <p>Ingrese el ID del usuario que quiere eliminar</p>
        <form action="SvEliminar" method="POST">
            <p><label>Id: </label><input type="text" name="id_usuario"></p>
            <button type="submit">Eliminar Usuario</button>
        </form>
        
        <!<!-- Cuando hacemos click en el boton Editar Usuario, el parametro 'name' se enviar al servlet SvEliminar -->
        <h1>Editar Usuario</h1>
        <p>Ingrese el ID del usuario que quiere editar</p>
        <form action="SvEditar" method="GET">
            <p><label>Id: </label><input type="text" name="id_usuarioEdit"></p>
            <button type="submit">Editar Usuario</button>
        </form>
        
    </body>
</html>
