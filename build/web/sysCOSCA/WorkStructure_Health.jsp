<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Calendar"%>
<%@page import="dbentities.TaskDetailsEntity"%>
<%@page import="java.util.List"%>
<%@page import="dbentities.ProjectTaskEntity"%>
<%@page import="Utilities.CompareDate"%>
<%@page import="dbentities.UnavailableProjectEntity"%>
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
    <body id="members">
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
                                <strong>DLSU</strong><br />
                                <a>COSCA</a><br />
                                <span class="member-box-links"><a>Logout</a></span>
                            </span>
                        </div>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div><!--/span-->

                    <div class="span10">
                    <jsp:include page="ProjectsShortcut.jsp"></jsp:include>
                        <div class="row-fluid">
                            <div class="span12 ">
                                <div>
                                <%
                                    UnavailableProjectEntity unavailableProj = (UnavailableProjectEntity) request.getAttribute("unavailableProj");
                                    String hidden = "";
                                    String hiddenImp = "";
                                    String badgeColor = "";
                                    if (CompareDate.getDateDiff(unavailableProj.getMeetingdate(), TimeUnit.DAYS) < 3 && CompareDate.getDateDiff(unavailableProj.getMeetingdate(), TimeUnit.DAYS) >= 0) {
                                        hiddenImp = "";
                                        badgeColor = "badge-warning";
                                    } else if (CompareDate.compareDates(unavailableProj.getMeetingdate()) < 0) {
                                        hiddenImp = "hidden";
                                        badgeColor = "badge-success";
                                    } else if (CompareDate.compareDates(unavailableProj.getMeetingdate()) > 0) {
                                        hiddenImp = "";
                                        badgeColor = "badge-important";
                                    }
                                    if (unavailableProj.getStatus() == 3) {
                                        hidden = "hidden";
                                        hiddenImp = "hidden";
                                        badgeColor = "badge-inverse";
                                    }

                                %>
                                <h1><%=unavailableProj.getTitle()%></h1>
                                <ul class="dashboard-member-activity">
                                    <li>
                                        <strong>Type: </strong> <%=unavailableProj.getType()%><br />
                                        <strong>Partner Community: </strong> <%=unavailableProj.getCommunity_name()%><br />
                                        <strong>Location: </strong> <%=unavailableProj.getCommunity_address()%><br/>
                                        <strong>Description: </strong> <%=unavailableProj.getDescription()%> <br/> 
                                        <strong>Project Deadline: </strong> <span id="dateChange" class="badge <%=badgeColor%>"> <%=unavailableProj.getMeetingdate()%> </span><br/><br/>
                                    </li>
                                </ul>
                                <%
                                    if (session.getAttribute("isOnGoing") != null) {
                                %>
                                <div class="row-fluid span6 alert alert-block">
                                    <form id="cancelForm" method="POST" action="WorkStructure_HealthCosca">
                                        <h4>
                                            <strong>Cancel Project?</strong>
                                            <input type="hidden" name="project_id" value="<%=unavailableProj.getProject_id()%>">
                                            <button id="cancel" type="button" style="margin-left: 30px" class="btn btn-mini btn-danger">Cancel</button>
                                        </h4>
                                    </form>
                                </div>
                                <%}%>
                            </div>
                        </div>
                    </div>

                    <%
                        ProjectTaskEntity preActs = (ProjectTaskEntity) request.getAttribute("preActs");
                        String status, button, btncolor;
                        if (preActs.getCompleted() == 0) {
                            badgeColor = "badge-important";
                            status = "Un-Accomplished";
                            button = "Accomplish";
                            btncolor = "btn-success";
                        } else {
                            badgeColor = "badge-success";
                            status = "Accomplished";
                            button = "Un-Accomplish";
                            btncolor = "btn-mini btn-warning";
                        }
                    %>
                    <form method="GET" action="ChangePreActs">
                        <table cellpadding="0" cellspacing="0" border="0" style="background-color: floralwhite;" class="table table-striped table-bordered" id="datatable1">
                            <thead>
                                <tr>
                                    <th><%=preActs.getTitle()%></th>
                                    <th><span style="margin-bottom: 5px" class="badge <%=badgeColor%>"> <%=status%></span></th>
<!--                                    <th><button type="submit" class="btn <%=btncolor%> <%=hidden%>"><%=button%></button></th>-->
                                </tr>
                            </thead>
                        </table>
                    </form>


                    <div class="row-fluid">  
                        <div class="span6">
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Medicine</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
<!--                                        <div class="row-fluid span12 <%=hidden%>">
                                            <form method="GET" action="Medicine">
                                                <span>Action:</span>
                                                <button name="action" value="add" type="submit" class="btn btn-success">
                                                    <i class="icon-plus icon-white"></i> Add New Requirement
                                                </button>
                                                <button name="action" value="edit" type="submit" class="btn btn-primary">
                                                    <i class="icon-edit icon-white"></i> Edit Current Numbers
                                                </button>
                                            </form>
                                        </div>-->
                                        <br/>
                                        <br/>
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable2">
                                            <thead>
                                                <tr>
                                                    <th>Medicine</th>
                                                    <th>Quantity On-Hand</th>
                                                    <th>Quantity Required</th>
                                                    <th>Unit</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    List<TaskDetailsEntity> medicineList = (List<TaskDetailsEntity>) request.getAttribute("medicineList");
                                                    for (int x = 0; x < medicineList.size(); x++) {
                                                %>
                                                <tr>
                                                    <td><%=medicineList.get(x).getTitle()%></td>
                                                    <td><%=medicineList.get(x).getCurrentcount()%></td>
                                                    <td><%=medicineList.get(x).getTargetcount()%></td>
                                                    <td><%=medicineList.get(x).getUnit()%></td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>    

                        <div class="span6">
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Equipment</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <div class="row-fluid span12 <%=hidden%>">
                                            <!--                                            <form method="GET" action="Equipment">
                                                                                            <span>Action:</span>
                                                                                            <button name="action" value="add" type="submit" class="btn btn-success">
                                                                                                <i class="icon-plus icon-white"></i> Add New Requirement
                                                                                            </button>
                                                                                            <button name="action" value="edit" type="submit" class="btn btn-primary">
                                                                                                <i class="icon-edit icon-white"></i> Edit Current Numbers
                                                                                            </button>
                                                                                        </form>-->
                                        </div>
                                        <br/>
                                        <br/>
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable3">
                                            <thead>
                                                <tr>
                                                    <th>Equipments</th>
                                                    <th>Quantity On-Hand</th>
                                                    <th>Quantity Required</th>
                                                    <th>Unit</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    List<TaskDetailsEntity> equipmentList = (List<TaskDetailsEntity>) request.getAttribute("equipmentList");
                                                    for (int x = 0; x < equipmentList.size(); x++) {
                                                %>
                                                <tr>
                                                    <td><%=equipmentList.get(x).getTitle()%></td>
                                                    <td><%=equipmentList.get(x).getCurrentcount()%></td>
                                                    <td><%=equipmentList.get(x).getTargetcount()%></td>
                                                    <td><%=equipmentList.get(x).getUnit()%></td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row-fluid">  
                            <div class="span12">
                                <!-- Portlet: Browser Usage Graph -->
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Medical Professionals</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
<!--                                            <div class="row-fluid span12 <%=hidden%>">
                                                <form method="GET" action="Doctors">
                                                    <span>Action:</span>
                                                    <button name="action" value="add" type="submit" class="btn btn-success">
                                                        <i class="icon-plus icon-white"></i> Add New Requirement
                                                    </button>
                                                    <button name="action" value="edit" type="submit" class="btn btn-primary">
                                                        <i class="icon-edit icon-white"></i> Edit Current Numbers
                                                    </button>
                                                </form>
                                            </div>-->
                                            <br/> 
                                            <br/>
                                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable4">
                                                <thead>
                                                    <tr>
                                                        <th>Specialization</th>
                                                        <th>Current Number of Doctors</th>
                                                        <th>Number Required</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        List<TaskDetailsEntity> medicalProfessionalList = (List<TaskDetailsEntity>) request.getAttribute("medicalProfessionalList");
                                                        for (int x = 0; x < medicalProfessionalList.size(); x++) {
                                                    %>
                                                    <tr>
                                                        <td><%=medicalProfessionalList.get(x).getTitle()%></td>
                                                        <td><%=medicalProfessionalList.get(x).getCurrentcount()%></td>
                                                        <td><%=medicalProfessionalList.get(x).getTargetcount()%></td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div><!--/span-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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

        <script>
            $(document).ready(function() {
                $('#cancel').click(function() {
                    if (confirm('Are you sure you want cancel this project?')) {
                        $('#cancelForm').submit();
                    } else {
                        // Do nothing!
                    }
                });
            });

        </script>
    </body>
</html>