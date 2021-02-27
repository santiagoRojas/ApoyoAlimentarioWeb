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

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

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
                     <input type="hidden" value="<%=usuario%>" name="usuario">
                     <input type="hidden" value="<%=contra%>" name="contraseña">
                     <input type="hidden" value="<%=convocatorias.get(i).getCodigo() %>" name="codigo">
                    <div class="name">Año:</div><input type="text" name="año" id="año" value=<%=convocatorias.get(i).getAnio() %>>  
                    <div class="name">Semestre:</div><input type="text" name="semestre" id="semestre" value=<%=convocatorias.get(i).getSemestre() %>>
                    <div class="name">Tipo de Proceso:</div><input type="text" name="tipoProceso" id="tipoProceso" value=<%=convocatorias.get(i).getTipoProceso() %>> 
                    <div class="name">Fecha de inicio:</div><input type="date" name="fechaInicio" id="fechaInicio" value=<%=convocatorias.get(i).getFechaInicio() %>> 
                    <div class="name">Fecha de fin:</div><input type="date" name="fechaFin" id="fechaFin" value=<%=convocatorias.get(i).getFechaFin() %>> 
                    <button class="btn btn--radius-2 btn--red" type="submit">Modificar</button>
                    </form>
                    <form method="POST" action="EliminarConvocatoriaServlet" >
                     <input type="hidden" value="<%=usuario%>" name="usuario">
                     <input type="hidden" value="<%=contra%>" name="contraseña">
                     <input type="hidden" value="<%=convocatorias.get(i).getCodigo() %>" name="codigo"> 
                    <button class="btn btn--radius-2 btn--red" type="submit">Eliminar</button>
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
                        <button class="btn btn--radius-2 btn--red" type="submit">Ver Convocatorias</button>
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
