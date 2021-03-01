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
                    <h2 class="title">Crear solicitud</h2>   
                </div>
                <div class="card-body">
                <form action="CrearSolicitud" method="POST">
                <div class="form-row p-t-20">
                          <label class="label label--block" id="Tit">Convocatoria</label>
                </div>
                <div class="overflow-auto">   
                <%  if(convocatorias != null){
                    for(int i=0; i<convocatorias.size(); i++){ %>
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                        <th scope="col"></th>
                        <th scope="col">Año</th>
                        <th scope="col">Semestre</th>
                        <th scope="col">Tipo de proceso</th>
                        <th scope="col">Fecha de inicio</th>
                        <th scope="col">Fecha de fin</th>
                        <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <input type="hidden" value="<%=usuario%>" name="usuario">
                            <input type="hidden" value="<%=contra%>" name="contraseña">
                            <td><input type="radio" name="numconvocatoria" id="numconvocatoria" value=<%=convocatorias.get(i).getCodigo() %>></td>
                            <td><p><%=convocatorias.get(i).getAnio() %></p></td>
                            <td><p><%=convocatorias.get(i).getSemestre() %></p></td>
                            <td><p><%=convocatorias.get(i).getTipoProceso() %></p></td>
                            <td><p><%=convocatorias.get(i).getFechaInicio() %></p></td>
                            <td><p><%=convocatorias.get(i).getFechaFin() %></p></td>   
                        </tr>
                        </tbody>
                        </table>   
                <%} }%>
                </div>
                
                
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
                      <div class="form-row p-t-20">
                            <label class="label label--block">Ingresos Familiares</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">0 - 1.0 SMMLV
                                    <input type="radio" checked="checked" name="IFamiliar" value=1>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">> 1.1 - 2.0 SMMLV
                                    <input type="radio" name="IFamiliar" id="unodos" value=2>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container" id="dosatres"> > 2.1 -  3.0 SMMLV  
                                      <input type="radio" name="IFamiliar" id="dostres" value=3>
                                      <span class="checkmark"></span>
                                </label>
                                <label class="radio-container"> > 3.1 - 4.0 SMMLV  
                                      <input  type="radio" name="IFamiliar" id="trescuatro" value=4>
                                      <span class="checkmark"></span>
                                </label>
                                <label class="radio-container" id="mayoracuatro"> > 4.1 SMMLV   
                                      <input type="radio" name="IFamiliar" id="mayorcuatro" value=5>
                                      <span class="checkmark"></span>
                                </label>
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
                          
                          
                          <div class="p-t-15">
                                <label class="radio-container m-r-55">Entre O y 100.000
                                    <input type="radio" checked="checked" name="Vmatricula" id="cerocienmil" value=15>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">Entre 100.001 y 300.000 
                                    <input type="radio" name="Vmatricula" id="cientrecientos" value=16>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">Entre 300.001 y 500.000 
                                      <input type="radio" name="Vmatricula" id="trecientosquinientos" value=17>
                                      <span class="checkmark"></span>
                                </label>
                                <label class="radio-container" id="acomodar">Entre 500.001 y 700.000 
                                      <input  type="radio" name="Vmatricula" id="quinientossetecientos" value=18>
                                      <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">Entre 700.001 y 900.000  
                                      <input type="radio" name="Vmatricula" id="setecientosnovecientos" value=19>
                                      <span class="checkmark"></span>
                                </label>
                                <label class="radio-container" id="acomodar"> > 900.000  
                                      <input type="radio" name="Vmatricula" id="mayornovecientos" value=20>
                                      <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                          <label class="label label--block" id="Tit">Subir documentos</label>
                        </div>
                        <div class="form-row p-t-20">
                          <label class="label label--block">A continuación se presentará varios campos en donde  debera subir sus archivos en la herramienta Drive, nombrandolos con su codigo institucional_Nombre del documento; ejemplo: 12345_IngresosFamiliares.
                              <br>
                              <br>
                              Nota: Debe dar permisos para que el encargado pueda manipular dichos  documentos.</label>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name" id="namel">Link Formulario de solicitud de apoyo</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="lformSolicitudapoyo" id="lformSolicitudapoyo">
                              </div>
                          </div>
                        </div>
                
                        <div class="form-row m-b-55">
                          <div class="name" id="namel">Link Carta a director de Bienestar</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="lcartadirector" id="lcartadirector">
                              </div>
                          </div>
                        </div>
                        
                
                        <div class="form-row m-b-55">
                          <div class="name" id="namel">Link Certificado de Estratificación</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="lcertificadoestratificacion" id="lcertificadoestratificacion">
                              </div>
                          </div>
                        </div>
                
                        <div class="form-row m-b-55">
                          <div class="name" id="namel">Link Recibo Público</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="lrecibopublico" id="lrecibopublico">
                              </div>
                          </div>
                        </div>
                
                        <div class="form-row m-b-55">
                          <div class="name" id="namel">Link Recibo de Pago de la universidad</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="lrecibouniversidad" id="lrecibouniversidad">
                              </div>
                          </div>
                        </div>
                
                
                        <div class="form-row m-b-55">
                          <div class="name" id="namel">Link Certificado Desplazamiento Forzoso</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="ldesplazamientoforzoso" id="ldesplazamientoforzoso">
                              </div>
                          </div>
                        </div>
                
                        <div class="form-row m-b-55">
                          <div class="name" id="namel">Link Certificado Civil de Nacimiento de Hijos</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="lnacimientohijos" id="lnacimientohijos">
                              </div>
                          </div>
                        </div>
                
                        <div class="form-row m-b-55">
                          <div class="name"  id="namel">Link Certificado de Discapacidad Médica</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="ldiscapacidadmedica" id="ldiscapacidadmedica">
                              </div>
                          </div>
                        </div>
                
                
                        <div class="form-row m-b-55">
                          <div class="name" id="namel">Link Certificado de Ingresos</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="lingresos" id="lingresos">
                              </div>
                          </div>
                        </div>
                
                
                        <div class="form-row m-b-55">
                          <div class="name" id="namel">Link Examen de Diagnostico Médico</div>
                          <div class="value">
                              <div class="input-group">
                                  <input class="input--style-5" type="url" name="lediagnosticomedico" id="lediagnosticomedico">
                              </div>
                          </div>
                        </div>
                
                        <div id="enviarsol">
                            <button class="btn btn--radius-2 btn--red" type="submit">Enviar Solicitud</button>
                        </div>
                        
                </form>
                <div id="backM">
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
