
<%@page import="Utilities.Year"%>
<%@page import="dbentities.UnavailableProjectEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Admin Simplenso - Forms</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="HTML5 Admin Simplenso Template" />
        <meta name="author" content="ahoekie" />

        <!-- Bootstrap -->
        <link href="../bootstrap/css/bootstrap.css" rel="stylesheet" id="main-theme-script" />
        <link href="../css/themes/default.css" rel="stylesheet" id="theme-specific-script" />
        <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />

        <!-- Simplenso -->
        <link href="../css/simplenso.css" rel="stylesheet" />

        <!-- Renliw -->
        <link href="../css/renliw.css" rel="stylesheet" />

        <style>
                    body{
                        min-width:1300px;
                    }
        </style>
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
    <body id="forms">
        <!-- Top navigation bar -->
        <jsp:include page="Navtopbar.jsp"></jsp:include>
            <!-- Main Content Area | Side Nav | Content -->
            <div class="container-fluid">
                <div class="row-fluid">
                    <!-- Side Navigation -->
                    <div class="span2">
                        <div class="member-box round-all">
                            <a><img src="../images/member_ph.png" class="member-box-avatar" /></a>
                            <span>
                                <strong>USG</strong><br />
                                <a>CATCH 2T14</a><br />
                                <span class="member-box-links"><a>Logout</a></span>
                            </span>
                        </div>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div><!--/span-->

                    <!-- Bread Crumb Navigation -->
                    <div class="span10">
                    <jsp:include page="ProjectsShortcut.jsp"></jsp:include>
                        <div>
                            <ul class="breadcrumb">
                                <li class="active">
                                    Select Project <span class="divider">/</span>
                                </li>
                                <li class="active">
                                    View Project Details <span class="divider">/</span>
                                </li>
                                <li class="active">
                                    Contact Details<span class="divider">/</span>
                                </li>
                                <li>
                                    Finish
                                </li>
                            </ul>
                        </div>

                        <div class="row-fluid">
                            <div class="span12" id="col0">
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Contact Details</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                                <h3>Thank you for reserving a project for the community</h3>
                                                <br/>
                                                
                                            <div class="row-fluid">
                                                <div class="span6 alert alert-info">
                                                <%
                                                    UnavailableProjectEntity unavailableProj = (UnavailableProjectEntity) request.getAttribute("unavailableProj");
                                                %>
                                                <ul class="dashboard-member-activity">
                                                    <li>
                                                        <strong>Project Title: <%=unavailableProj.getTitle()%> </strong><br />
                                                        <strong>Partner Organization: <%=unavailableProj.getOrg_name()%> </strong><br/>
                                                        <strong>Contact Person: </strong> <%=unavailableProj.getStudent_firstname()%> <%=unavailableProj.getStudent_lastname()%> <br/>  
                                                        <strong>Contact Number: </strong> <%=unavailableProj.getStudent_mobileno()%> <br/>  
                                                        <strong>Type: </strong> <%=unavailableProj.getType()%><br />
                                                        <strong>Partner Community: </strong> <%=unavailableProj.getCommunity_name()%><br />
                                                        <strong>Location: </strong> <%=unavailableProj.getCommunity_address()%><br/>
                                                        <strong>Description: </strong> <%=unavailableProj.getDescription()%> <br/>           
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row-fluid">
                                            <div class="span6 alert alert-info">
                                                <strong>We will contact you before <%=Year.getCurrentDatePlus(2) %>.</strong>
                                            </div>
                                        </div>

                                        <div class="form-actions">
                                            <a href="SOrgHome" type="button" class="btn btn-primary">Finish</a>
                                        </div>
                                    </div>
                                </div>
                            </div><!--/span-->
                        </div>
                    </div><!--/span-->
                </div><!--/row-->
            </div>
        </div><!--/.fluid-container-->
        <!-- javascript Templates
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <!-- jQuery -->
        <script src="../jquery/1.8.3/jquery.min.js"></script>

        <!-- jQuery UI Sortable -->
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.core.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.mouse.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.sortable.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>

        <!-- Bootstrap -->
        <script src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="../scripts/bootbox/bootbox.min.js"></script>

        <!-- Bootstrap Date Picker -->
        <script src="../scripts/datepicker/js/bootstrap-datepicker.js"></script>


        <!-- jQuery Cookie -->
        <script src="../scripts/jquery.cookie/jquery.cookie.js"></script>

        <!-- Full Calender -->
        <script type='text/javascript' src="../scripts/fullcalendar/fullcalendar/fullcalendar.min.js"></script>

        <!-- CK Editor -->
        <script type="text/javascript" src="../scripts/ckeditor/ckeditor.js"></script>

        <!-- Chosen multiselect -->
        <script type="text/javascript" language="javascript" src="../scripts/chosen/chosen/chosen.jquery.min.js"></script>

        <!-- Uniform -->
        <script type="text/javascript" language="javascript" src="../scripts/uniform/jquery.uniform.min.js"></script>

        <!-- Simplenso Scripts -->
        <script src="../scripts/simplenso/simplenso.js"></script>
    </body>
</html>