<%@page import="dbentities.TaskDetailsEntity"%>
<%@page import="java.util.List"%>
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

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <style>
                    body{
                        min-width:1300px;
                    }
        </style>
        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../images/ico/favicon.ico" />
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../images/ico/apple-touch-icon-144-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../images/ico/apple-touch-icon-114-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../images/ico/apple-touch-icon-72-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" href="../images/ico/apple-touch-icon-57-precomposed.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
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
                        <div class="row-fluid">
                            <div class="span12" id="col0">
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Add Speakers</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                        <%String title = (String) request.getAttribute("title");%>
                                        <form method="POST" action="SpeakersIncDec" class="form-horizontal">
                                            <legend>New <%=title%></legend>
                                            <div class="control-group">
                                                <label class="control-label" for="fname">First Name</label>
                                                <div class="controls">
                                                    <input class="input-large" name="fname" id="fname" type="text" placeholder="John" required/>
                                                    <input class="input-mini" name="mi" id="mi" type="text" placeholder="M."/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="lname">Last Name</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" name="lname" id="lname" type="text" placeholder="Doe" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="orgname">Organization Name</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" name="orgname" id="orgname" type="text" placeholder="Medical company" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="address">Address</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" name="address" id="address" type="text" placeholder="Manila City" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="email">E-mail</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" name="email" id="email" type="email" placeholder="john.doe@medical.com" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="contact">Contact No.</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" name="contact" id="contact" type="text" placeholder="+639123456789" required/>
                                                </div>
                                            </div>
                                            <div class="form-actions">
                                                <button name="action" value="add" type="submit" class="btn btn-primary">Add <%=title%></button>
                                                <a href="SpkEditBack" type="button" class="btn">Back</a>
                                            </div>  
                                            
                                            
                                            <div class="control-group">
                                                <legend>Current <%=title%>s</legend>
                                                <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable1">
                                                    <thead>
                                                        <tr>
                                                            <th>Name of Speaker</th>
                                                            <th>Organization Name</th>
                                                            <th>Address</th>
                                                            <th>E-mail</th>
                                                            <th>Contact No.</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            List<TaskDetailsEntity> speakerList = (List<TaskDetailsEntity>) request.getAttribute("speakerList");
                                                            for (int x = 0; x < speakerList.size(); x++) {
                                                        %>
                                                        <tr>
                                                            <td><%=speakerList.get(x).getLastname()%>, <%=speakerList.get(x).getFirstname()%> <%=speakerList.get(x).getMi()%></td>
                                                            <td><%=speakerList.get(x).getOrganizationname()%></td>
                                                            <td><%=speakerList.get(x).getAddress()%></td>
                                                            <td><%=speakerList.get(x).getEmail()%></td>
                                                            <td><%=speakerList.get(x).getMobile()%></td>
                                                        </tr>
                                                        <%}%>
                                                    </tbody>
                                                </table>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div><!--/span-->
                        </div>
                    </div>
                </div><!--/span-->
            </div><!--/row-->
        </div><!--/.fluid-container-->
        <!-- javascript Templates
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <!-- Google API -->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>

        <!-- jQuery -->
        <script src="../jquery/1.8.3/jquery.min.js"></script>

        <!-- Data Tables -->
        <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

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