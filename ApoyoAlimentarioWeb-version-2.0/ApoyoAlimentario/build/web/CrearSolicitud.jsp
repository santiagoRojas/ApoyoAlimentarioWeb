<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.Date' %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%
String usuario = (String)session.getAttribute("usuario");
String contra = (String)session.getAttribute("contraseña");
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
                      <input type="hidden" value="<%=contra%>" name="contraseña">
                      <input type="hidden" value=1 name="numconvocatoria">
                      <div class="form-row p-t-20">
                          <label class="label label--block">A continuación se presentarán una seria de preguntas que debe responder con total sinceridad, ya que cada una de estas se confrontará con los papeles subidos al sistema</label>
                      </div>
                      <div class="form-row m-b-55">
                        <div class="name">Código</div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5" type="text" name="codigo" id="codigo">
                            </div>
                        </div>
                      </div>
                        <div class="form-row m-b-55">
                          <div class="name">Ingresos Familiares</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="radio" checked="checked" name="IFamiliar" id="cerouno" value=1>
                                  <label class="label--desc"> 0 - 1.0 SMMLV</label>
                                  <input class="input--style-5" type="radio" name="IFamiliar" id="unodos" value=2>
                                  <label class="label--desc"> > 1.1 - 2.0 SMMLV </label>
                                  <input class="input--style-5" type="radio" name="IFamiliar" id="dostres" value=3>
                                  <label class="label--desc"> > 2.1 -  3.0 SMMLV  </label>
                                  <input class="input--style-5" type="radio" name="IFamiliar" id="trescuatro" value=4>
                                  <label class="label--desc"> > 3.1 - 4.0 SMMLV   </label>
                                  <input class="input--style-5" type="radio" name="IFamiliar" id="mayorcuatro" value=5>
                                  <label class="label--desc"> > 4.1 SMMLV   </label>
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
                                    <input type="radio" checked="checked" name="sostienehogar" value=6>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="sostienehogar" value=0>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Se sostiene asi mismo</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="sostienemismo" value=7>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="sostienemismo" value=0>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Vive fuera del nucleo familiar</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="vfnucleofamiliar" value=8>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="vfnucleofamiliar" value=0>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Tiene cónyugue, hijos u otras personas a su cargo </label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="personasAcargo" value=9>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="personasAcargo" value=0>
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
                                    <input type="radio" checked="checked" name="casaempleador" value=10>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="casaempleador" value=0>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Condición de desplazamiento forzado,
                                                              indí­gena, minorí­as étnicas y culturales ó
                                                              proviene de municipios distintos a Bogotá.</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="condicion" value=11>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="condicion" value=0>
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
                                    <input type="radio" checked="checked" name="reside" value=12>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="reside" value=0>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                          <label class="label label--block" id="Tit">Condiciones de salud</label>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Presenta algún tipo de discapacidad fí­sica o mental</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="discapacidad" value=13>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="discapacidad" value=0>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">Sufre alguna patologí­a o sintomatologí­a asociada con problemas de alimentación</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Si
                                    <input type="radio" checked="checked" name="problemaalimentacion" value=14>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">No
                                    <input type="radio" name="problemaalimentacion" value=0>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                          <div class="name">Valor matrí­cula</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="radio" checked="checked" name="Vmatricula" id="cerocienmil" value=15>
                                  <label class="label--desc"> Entre O y 100.000 </label>
                                  <input class="input--style-5" type="radio" name="Vmatricula" id="cientrecientos" value=16>
                                  <label class="label--desc"> Entre 100.001 y 300.000  </label>
                                  <input class="input--style-5" type="radio" name="Vmatricula" id="trecientosquinientos" value=17>
                                  <label class="label--desc"> Entre 300.001 y 500.000  </label>
                                  <input class="input--style-5" type="radio" name="Vmatricula" id="quinientossetecientos" value=18>
                                  <label class="label--desc"> Entre 500.001 y 700.000  </label>
                                  <input class="input--style-5" type="radio" name="Vmatricula" id="setecientosnovecientos" value=19>
                                  <label class="label--desc"> Entre 700.001 y 900.000  </label>
                                  <input class="input--style-5" type="radio" name="Vmatricula" id="mayornovecientos" value=20>
                                  <label class="label--desc"> < 900.000  </label>
                              </div>
                          </div>
                        </div>
                        <div class="card-heading1">
                            <h2 class="title">Subir Documentos</h2>
                        </div>
                        <div class="form-row p-t-20">
                          <label class="label label--block">A continuación se presentará un campo en donde  debera subir sus archivos en la herramienta Drive, nombrandolos con su codigo institucional_Nombre del documento; ejemplo: 12345_IngresosFamiliares.
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
