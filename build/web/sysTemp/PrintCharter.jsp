
<%@page import="Utilities.Year"%>
<%@page import="dbentities.UnavailableProjectEntity"%>
<%@page import="Utilities.Converter"%>

<%@taglib uri="http://pd4ml.com/tlds/pd4ml/2.5" prefix="pd4ml" %>
<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Admin Simplenso - Member List</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="HTML5 Admin Simplenso Template" />
        <meta name="author" content="ahoekie" />

        <!-- Bootstrap -->
        <link href="../bootstrap/css/bootstrap.css" rel="stylesheet" id="main-theme-script" />
        <link href="../css/themes/default.css" rel="stylesheet" id="theme-specific-script" />
        <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Simplenso -->
        <link href="../css/simplenso.css" rel="stylesheet" />

        <!-- Renliw -->
        <link href="../css/renliw.css" rel="stylesheet" />


        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../images/ico/favicon.ico" />
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../images/ico/apple-touch-icon-144-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../images/ico/apple-touch-icon-114-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../images/ico/apple-touch-icon-72-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" href="../images/ico/apple-touch-icon-57-precomposed.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

    <pd4ml:transform screenWidth="1000" pageFormat="LETTER" pageOrientation="landscape" pageInsets="15,50,25,25,points" enableImageSplit="false" >
        <body id="members">
            <!-- Top navigation bar -->
            <!-- Main Content Area | Side Nav | Content -->
            <div class="container-fluid">
                <div class="row-fluid">  
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">

                            <div class="box" id="box-3">
                                <h4 class="box-header round-top"></h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <%
                                             UnavailableProjectEntity unavailableProj = (UnavailableProjectEntity) request.getAttribute("unavailableProj");
                                        %>
                                        <h1 align="center">Center for Social Concern and Action </h1>
                                        <h2 align="center">Initial Project Charter </h2>
                                        <h2 align="center">Project <%=unavailableProj.getTitle() %></h2>

                                        <br><br><br><br>

                                        <div class="row">
                                            <div>
                                                
                                                <table align="center" class="table table-striped table-bordered"  id="tables">
                                                    <tbody>
                                                        <tr>
                                                            <td><b>Partner Community Details</b></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Partner Community Name: </td>
                                                            <td><%=unavailableProj.getCommunity_name() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Partner Community Address: </td>
                                                            <td><%=unavailableProj.getCommunity_address() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Student Organization Details</b></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Student Organization Name: </td>
                                                            <td><%=unavailableProj.getOrg_name() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Contact Person: </td>
                                                            <td><%=unavailableProj.getStudent_firstname() %> <%=unavailableProj.getStudent_lastname() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Contact Number: </td>
                                                            <td><%=unavailableProj.getStudent_mobileno() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Project Details</b></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Project Type: </td>
                                                            <td><%=unavailableProj.getType() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Project Description: </td>
                                                            <td><%=unavailableProj.getDescription() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Project Objectives: </td>
                                                            <td><%=unavailableProj.getObjectives() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Project Scope: </td>
                                                            <td><%=unavailableProj.getScope() %></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Additional Project Requirements: </td>
                                                            <td><%=unavailableProj.getRequirements() %></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <br><br>
                                        <div class="container">
                                            <p align="center">Date Printed: <%=Converter.toString(Year.getCurrentDateinCalendar())%> </p>
                                        </div>
                                    </div>
                                </div><!--/span-->
                            </div>
                        </div> 
                    </div>
                </div>
            </div><!--/.fluid-container-->
            <!-- javascript Templates
        ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->

            <!-- jQuery -->
            <script src="../jquery/1.8.3/jquery.min.js"></script>

            <!-- Bootstrap -->
            <script src="../bootstrap/js/bootstrap.min.js"></script>
            <script src="../scripts/bootbox/bootbox.min.js"></script>

            <!-- Simplenso Scripts -->
            <script src="../scripts/simplenso/simplenso.js"></script>

        </body>

        <pd4ml:footer
            titleTemplate="Pro-Health Case-Project Management System"
            titleAlignment="left"
            pageNumberAlignment="right"
            color="#00000"
            initialPageNumber="1"
            pagesToSkip="0"
            fontSize="12"
            fontFace="Arial"
            areaHeight="16"/>
    </pd4ml:transform>
</html>