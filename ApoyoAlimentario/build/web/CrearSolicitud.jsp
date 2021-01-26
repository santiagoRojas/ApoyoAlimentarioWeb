<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.Date' %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%
String usuario = (String)session.getAttribute("usuario");
String contra = (String)session.getAttribute("contrase�a");
%>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Crear Solicitud</title>

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
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Crear Solicitud</h2>
                </div>
                <div class="card-body">
                    <form action="CrearSolicitud" method="POST">
                      <input type="hidden" value="<%=usuario%>" name="usuario">
                      <input type="hidden" value="<%=contra%>" name="contrase�a">
                      <div class="form-row p-t-20">
                          <label class="label label--block">A continuación se presentarán una seria de preguntas que debe responder con total sinceridad, ya que cada una de estas se confrontará con los papeles subidos al sistema</label>
                      </div>
                      <div class="form-row m-b-55">
                        <div class="name">Semestre</div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5" type="text" name="semestre" id="semestre">
                            </div>
                        </div>
                      </div>
                        <div class="form-row m-b-55">
                          <div class="name">Ingresos Familiares</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="number" name="IFamiliar" id="IFamiliar">
                                  <label class="label--desc">Ingresos en Cantidad de salarios minimos familiares</label>
                              </div>
                          </div>
                        </div>
                        <div class="form-row p-t-20">
                          <label class="label label--block" id="Tit">Condiciones Familiares</label>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Sostiene el hogar donde vive</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="sostienehogar" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="sostienehogar" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Se sostiene asi mismo</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="sostienemismo" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="sostienemismo" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Vive fuera del nucleo familiar</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="vfnucleofamiliar" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="vfnucleofamiliar" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Tiene cónyugue, hijos u otras personasa su cargo </label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="personasAcargo" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="personasAcargo" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                          <label class="label label--block" id="Tit">Procedencia y lugar de residencia</label>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Vive en casa del empleador.</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="casaempleador" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="casaempleador" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Condición de desplazamiento forzado,
                                                              indígena, minorías étnicas y culturales ó
                                                              proviene de municipios distintos a Bogotá.</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="condicion" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="condicion" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Reside en zonas de alto grado de
                                                              vulnerabilidad social y económica, ó
                                                              reside en estrato 1,2 y 3.</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="reside" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="reside" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                          <label class="label label--block" id="Tit">Condiciones de salud</label>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Presenta algún tipo de discapacidad física o mental</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="discapacidad" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="discapacidad" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Sufre alguna patología o sintomatología asociada con problemas de alimentación</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="problemaalimentacion" value="SI">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="problemaalimentacion" value="NO">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                          <div class="name">Valor matrícula</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="number" name="Vmatricula" id="Vmatricula">
                              </div>
                          </div>
                        </div>
                        <div class="card-heading1">
                            <h2 class="title">Subir Documentos</h2>
                        </div>
                        <div class="form-row p-t-20">
                          <label class="label label--block">A continuacion se presentara un campo en donde  debera subir sus archivos en la herramienta Drive, nombrandolos con su codigo institucional_Nombre del documento; ejemplo: 12345_IngresosFamiliares.
                              <br>
                              <br>
                              Además la  carpeta tambien tiene que tener  su nombre y codigo de la siguiente manera: 12345_Nombres_Apellidos
                              <br>
                              <br>
                              Nota: Debe dar permisos para que el encargado pueda manipular dichos  documentos.</label>
                        </div>
                        <div class="form-row m-b-55">
                          <div class="name">Link</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="link" id="link">
                              </div>
                          </div>
                        </div>
                        <div id="enviars">
                            <button class="btn btn--radius-2 btn--red" type="submit">Enviar Solicitud</button>
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
