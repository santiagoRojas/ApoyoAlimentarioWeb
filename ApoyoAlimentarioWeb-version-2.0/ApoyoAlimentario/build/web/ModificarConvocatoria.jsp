<%@page import="negocio.Convocatoria"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <%
String usuario = (String)session.getAttribute("usuario");
String contra = (String)session.getAttribute("contraseña");
Convocatoria convocatoria = (Convocatoria) session.getAttribute("convocatoria");
%>

    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Modificar Convocatoria</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/CrearSolicitud.css" rel="stylesheet" media="all">
</head>

<body>
<alert><%=usuario%></alert>
<alert><%=contra%></alert>
<alert><%=convocatoria.getCodigo() %></alert>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Modificar Convocatoria</h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="CrearConvocatoriaServlet">
                      <input type="hidden" value="<%=usuario%>" name="usuario">
                      <input type="hidden" value="<%=contra%>" name="contraseña">
                      <div class="form-row m-b-55">
                        <div class="name">Semestre</div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5" type="text" name="semestre" id="semestre" required>
                            </div>
                        </div>
                      </div>
                      <div class="form-row m-b-55">
                        <div class="name">Año</div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5" type="text" name="anio" id="anio" required>
                            </div>
                        </div>
                      </div>
                      <div class="form-row">
                            <div class="name">Tipo de Proceso</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="tipoProceso" id="tipoProceso">
                                            <option disabled="disabled" selected="selected">Elegir opción</option>
                                            <option value="1">General</option>
                                            <option value="2">Radicación</option>
                                            <option value="3">Validación</option>
                                            <option value="4">Publicación</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                      <div class="form-row m-b-55">
                        <div class="name">Fecha de inicio</div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5" type="date" name="fechaInicio" id="fechaInicio" value="2021-01-01"
                                       min="2020-01-01" max="2022-12-31" required>
                            </div>
                        </div>
                      </div>
                      <div class="form-row m-b-55">
                        <div class="name">Fecha de finalización</div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5" type="date" name="fechaFin" id="fechaFin" value="2021-01-01"
                                       min="2020-01-01" max="2022-12-31" required>
                            </div>
                        </div>
                      </div>
                        <div id="enviars">
                            <button class="btn btn--radius-2 btn--red" type="submit" onclick="test()">Crear</button>
                        </div>
                    </form>
                    <div id="back1">
                        <button class="btn btn--radius-2 btn--red" onclick="window.location.href='Menu.jsp'">Regresar</button>
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
