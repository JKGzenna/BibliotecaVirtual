<%-- 
    Document   : newjsp
    Created on : 27-nov-2018, 13:15:05
    Author     : Arranque 4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Categorias</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <%@include file="css.jsp"%>
    </head>
    <body>
        <%@include file="menu.jsp"%>
<!--        <div class ="form-control">-->
            <div class="table-header">
                Desde aquí puede añadir o eliminar una Categoría
            </div>
            <div>
                <form action="CategoriaController" method="post" class="form-horizontal"
                      <br>
                      <br>
                      <div class="form-group">
<!--                          <label class="col-sm-control-label no-padding-right">-->
                          <label class="col-sm-1">
                              Nombre:
                          </label>
                          <div class="col-sm-3">
                              <input type="text" name="nombre" value="" placeholder="Nombre de Categoría"/>
                          </div>
                      </div>
                      <br>
                      <div class="col-sm-3">
                          <button name="Registrar" class="btn btn-success" type="submit" value="Registrar"
                                      <i class="fa fa-save"></i>
                                      Registrar
                          </button>     
                          <button name="Eliminar" class="btn btn-danger" type="submit" value="Eliminar"
                                  <i class="fa fa-remove"></i>
                                      Eliminar
                          </button>    
                      </div>
                </form>
                <br>
                <%=(request.getAttribute("mensaje")!=null?request.getAttribute("mensaje"):"")%>
            </div>
        </div>
    </body>
</html>
