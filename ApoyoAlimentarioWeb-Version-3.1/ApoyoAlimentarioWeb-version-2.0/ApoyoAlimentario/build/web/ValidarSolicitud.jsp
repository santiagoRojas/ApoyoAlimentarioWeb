<%@page import="negocio.PedirSolicitudes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocio.Solicitud"%>
<!DOCTYPE html>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.Date' %>
<html lang="en">

<head>
    <%
String usuario = (String)session.getAttribute("usuario");
String contra = (String)session.getAttribute("contraseña");
PedirSolicitudes pedirSolicitud = (PedirSolicitudes)session.getAttribute("solicitudes");
%>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Validar Solicitudes</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/ValidarYestado.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <form action="GuardarSolicitudes" method="POST">
                <div class="card-heading">
                    <h2 class="title">Validar Solicitudes</h2>
                </div>
                    
                    <%if(pedirSolicitud != null){%>
                    <input name="usuario" value="<%=usuario%>" type="hidden"> 
                    <input name="contraseña" value="<%=contra%>" type="hidden">
                    <input name="numSolicitudes" value="<%=pedirSolicitud.getSolicitudes().size()%>" type="hidden">
                        <% 
                            for(int i = 0; i < pedirSolicitud.getSolicitudes().size() ; i++){

                        %>
                        <input name="idSolicitud<%=i%>" value="<%=pedirSolicitud.getSolicitudes().get(i).getNum()%>" type="hidden">

                        <div class="form-row p-t-20">
                            <label class="label label--block">Solicitud <%=i+1%>: puntaje(<%=pedirSolicitud.getSolicitudes().get(i).getPuntaje()%>) Link: <%=pedirSolicitud.getSocioEconomico().get(i).getFormulario()%>  </label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">PENDIENTE
                                    <input type="radio" checked="checked" name="estado<%=i%>" value="PENDIENTE">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">RECHAZADO
                                    <input type="radio" name="estado<%=i%>" value="RECHAZADO">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">APROVADO
                                    <input type="radio" name="estado<%=i%>" value="APROBADO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    <div class="card-body">     
                        <div id="back1">
                            <button class="btn btn--radius-2 btn--red" type="submit" >Enviar</button>
                        </div>
                    </div>
                <%}%>
                </form>
                <form action="ValidarSolicitudes" method="POST">
                    <input name="usuario" value="<%=usuario%>" type="hidden"> 
                    <input name="contraseña" value="<%=contra%>" type="hidden">
                    <button class="btn btn--radius-2 btn--red" type="submit" >Mostrar Solicitudes</button>
                </form>
                <div class="card-body">     
                    <div id="back1">
                        <button class="btn btn--radius-2 btn--red" onclick="window.location.href='Menu.jsp'" >Regresar</button>
                    </div>
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
