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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body id="forms">
        <textarea style="display:none" id="addDoctorsTemplate">
            <input type="text" name="needs-{0}" id="needs-{0}" required/>
        </textarea>


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
                                    <h4 class="box-header round-top">Medical Professional Requirements</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <form method="POST" action="Doctors" >
                                                <legend>Edit Medical Professional Requirements</legend>
                                                <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable1">
                                                    <thead>
                                                        <tr>
                                                            <th>Specialization</th>
                                                            <th colspan="2">Current Number of Doctors</th>
                                                            <th>Number Required</th>
                                                            <th>Actions</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <%
                                                        List<TaskDetailsEntity> medicalProfessionalList = (List<TaskDetailsEntity>) request.getAttribute("medicalProfessionalList");
                                                        for (int x = 0; x < medicalProfessionalList.size(); x++) {
                                                    %>
                                                    <tr id="row-<%=medicalProfessionalList.get(x).getTask_id()%>">
                                                <input type="hidden" name="size" value="<%=medicalProfessionalList.size()%>"/>
                                                <input type="hidden" name="task_id-<%=x%>" value="<%=medicalProfessionalList.get(x).getTask_id()%>"/>
                                                <input type="hidden" name="title-<%=x%>" value="<%=medicalProfessionalList.get(x).getTitle()%>"/>
                                                <td><%=medicalProfessionalList.get(x).getTitle()%></td>
                                                <td>
                                                    <input type="hidden" name="currentcount-<%=x%>" value="<%=medicalProfessionalList.get(x).getCurrentcount()%>">
                                                    <%=medicalProfessionalList.get(x).getCurrentcount()%>
                                                </td>
                                                    <td>
                                                        <button name="action" value="increase-<%=x%>" type="submit" class="btn btn-success">
                                                            <i class="icon-plus icon-white"></i> Add Professional
                                                        </button>
                                                            <br/>
                                                        <button style="margin-top: 5px" name="action" value="decrease-<%=x%>" type="submit" onclick="isSure()" class="btn btn-warning">
                                                            <i class="icon-minus icon-white"></i> Remove Professional
                                                        </button>
                                                    </td> 
                                                <td>
                                                    <input type="number" name="targetcount-<%=x%>" value="<%=medicalProfessionalList.get(x).getTargetcount()%>" class="input input-small"/>
                                                    <button style="margin-bottom: 10px;" name="action" value="update-<%=x%>" type="submit" class="btn btn-primary">
                                                        <i class="icon-edit icon-white"></i> Update
                                                    </button>
                                                </td>
                                                <td>
                                                    <button name="action" value="delete-<%=x%>" type="submit" class="btn btn-danger">
                                                        <i class="icon-trash icon-white"></i> Cancel Requirement
                                                    </button>

                                                </td>
                                                </tr>
                                                
                                                <%}%>
                                                </tbody>
                                            </table>
                                            <div class="form-actions">
                                                <a href="WorkStructureBack" type="button" class="btn">Back</a>
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


        <%
            if (request.getAttribute("isUpdated") != null) {
                String title = (String) request.getAttribute("isUpdated");
        %>
        <script type="text/javascript">
                                                            window.onload = function() {
                                                                alert("<%=title%> has been updated");
                                                            };
        </script>
        <%}%>

    </body>
</html>