
<%@page import="dbentities.AvailableProjectEntity"%>
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

        <!-- Uniform -->
        <link rel="stylesheet" type="text/css" media="screen,projection" href="../scripts/uniform/css/uniform.default.css" />

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
                                <li>
                                    Contact Details<span class="divider">/</span>
                                </li>
                                <li class="active">
                                    Finish
                                </li>
                            </ul>
                        </div>

                        <div class="row-fluid">
                            <div class="span12" id="col0">
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Reservation</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <div class="span12">
                                                <h3>Reserve Project</h3>
                                                <div class="span8 alert alert-info">
                                                <%
                                                    AvailableProjectEntity availableProj = (AvailableProjectEntity) request.getAttribute("availableProject");
                                                %>
                                                <ul class="dashboard-member-activity">
                                                    <li>
                                                        <strong>Project Title: <%=availableProj.getTitle()%> </strong><br />
                                                        <strong>Type: </strong> <%=availableProj.getType()%><br />
                                                        <strong>Partner Community: </strong> <%=availableProj.getCommunity_name()%><br />
                                                        <strong>Location: </strong> <%=availableProj.getCommunity_address()%><br/>
                                                        <strong>Description: </strong> <%=availableProj.getDescription()%> <br/>           
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>

                                        <form class="form-horizontal" method="POST" action="ContactDetails"/>
                                        <fieldset>
                                            <legend>Please Input Contact Details</legend>
                                            <div class="control-group">
                                                <label class="control-label" for="idno">ID No:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="idno" name="idno" type="text" placeholder="ID No." required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="first_name">First Name:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="first_name" name="first_name" type="text" placeholder="Frist Name" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="last_name">Last Name:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="last_name" name="last_name" type="text" placeholder="Last Name" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="position">Organization Position:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="position" name="position" type="text" placeholder="Position" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="email">E-mail Address:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="email" name="email" type="email" placeholder="E-mail" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="mobileno">Mobile Number:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="mobileno" name="mobileno" type="text" placeholder="Contact No." required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <div class="controls">
                                                    <div class="controls span6 alert alert-info">
                                                        <strong>We will contact you within 48hrs upon reservation.</strong>
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>
                                        <div class="form-actions">
                                            <button name="action" value="reserve" type="submit" class="btn btn-primary">Submit Project Request</button>
                                            <a href="ViewInitialProjectCharterOrg" type="button" class="btn">Cancel</a>
                                        </div>
                                        </form> 
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