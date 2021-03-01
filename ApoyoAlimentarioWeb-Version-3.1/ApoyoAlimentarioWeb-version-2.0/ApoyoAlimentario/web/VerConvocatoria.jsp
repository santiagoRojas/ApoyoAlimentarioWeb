<%@page import="java.util.ArrayList"%>
<%@page import="negocio.Convocatoria"%>
<!DOCTYPE html>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.Date' %>
<html lang="en">

<head>
    <%
String usuario = (String)session.getAttribute("usuario");
String contra = (String)session.getAttribute("contraseña");
ArrayList<Convocatoria> convocatorias = (ArrayList<Convocatoria>)session.getAttribute("convocatorias");
Convocatoria convocatoria = new Convocatoria();
%>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Convocatorias</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/js/all.min.js"></script>
    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" rel="stylesheet">

    <!-- Main CSS-->
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/ValidarYestado.css" rel="stylesheet" media="all">
    
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Convocatorias</h2>
                    
                </div>
                
                    
                <%  if(convocatorias != null){
                    for(int i=0; i<convocatorias.size(); i++){ %>
                    
                    
                    <form method="POST" action="ModificsrConvocatoriaServlet">
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                        <th scope="col">Año</th>
                        <th scope="col">Semestre</th>
                        <th scope="col">Tipo de proceso</th>
                        <th scope="col">Fecha de inicio</th>
                        <th scope="col">Fecha de fin</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <input type="hidden" value="<%=usuario%>" name="usuario">
                            <input type="hidden" value="<%=contra%>" name="contraseña">
                            <input type="hidden" value="<%=convocatorias.get(i).getCodigo() %>" name="codigo">
                            <td><input type="text" name="año" id="año" size="4" maxlength="4" value=<%=convocatorias.get(i).getAnio() %>></td>
                            <td><input type="text" name="semestre" id="semestre" size="8" maxlength="8" value=<%=convocatorias.get(i).getSemestre() %>></td>
                            <td><input type="text" name="tipoProceso" id="tipoProceso" size="14" maxlength="14" value=<%=convocatorias.get(i).getTipoProceso() %>></td>
                            <td><input type="date" name="fechaInicio" id="fechaInicio" value=<%=convocatorias.get(i).getFechaInicio() %>></td>
                            <td><input type="date" name="fechaFin" id="fechaFin" value=<%=convocatorias.get(i).getFechaFin() %>></td>
                            <td><button  type="submit"><i class="fas fa-pen-square fa-2x" style="color:#239B56;"></i></button></td>
                            <td><button type="submit" form="eliminar" value=""><i class="fas fa-times-circle fa-2x" style="color:#E74C3C;"></i></button></td>
                        </tr>
                        </tbody>
                        </table>  
                    </form>
                    <form name="eliminar" id="eliminar" method="POST" action="EliminarConvocatoriaServlet" >
                     <input type="hidden" value="<%=usuario%>" name="usuario">
                     <input type="hidden" value="<%=contra%>" name="contraseña">
                     <input type="hidden" value="<%=convocatorias.get(i).getCodigo() %>" name="codigo"> 
                    </form>
                    
                    
                
                   
                    
                <%} }%>
                <div class="card-body">     
                    <div id="back1">
                        <button class="btn btn--radius-2 btn--red" onclick="window.location.href='Menu.jsp'" >Regresar</button>
                    </div>
                    <form method="POST" action="MostrarConvocatorias">
                      <input type="hidden" value="<%=usuario%>" name="usuario">
                      <input type="hidden" value="<%=contra%>" name="contraseña">
                    <div id="verconvocatorias">
                        <button id="verconvocatorias" name="verconvocatorias" class="btn btn--radius-2 btn--red" type="submit">Ver Convocatorias</button>
                    </div>
                    </form>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/Register.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->
