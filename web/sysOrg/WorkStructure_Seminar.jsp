<%@page import="dbentities.ProjectCharterDateEntity"%>
<%@page import="dbdao.ProjectCharterDateDAO"%>
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
                       
                    <jsp:include page="Navuserbar.jsp"></jsp:include>
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
                                    ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
                                    ProjectCharterDateEntity projdate = project_date.getProjectDate(unavailableProj.getProject_id());

                                    if (CompareDate.getDateDiff(projdate.getDate_target_implement(), TimeUnit.DAYS) < 3 && CompareDate.getDateDiff(projdate.getDate_target_implement(), TimeUnit.DAYS) >= 0) {
                                        hiddenImp = "";
                                        badgeColor = "badge-warning";
                                    } else if (CompareDate.compareDates(projdate.getDate_target_implement()) < 0) {
                                        hiddenImp = "hidden";
                                        badgeColor = "badge-success";
                                    } else if (CompareDate.compareDates(projdate.getDate_target_implement()) > 0) {
                                        hiddenImp = "";
                                        badgeColor = "badge-important";
                                    }
                                    if (unavailableProj.getStatus() == 3 || unavailableProj.getStatus() == 4) {
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
                                        <strong>Project Deadline: </strong> <span id="dateChange" class="badge <%=badgeColor%>"> <%=projdate.getDate_target_implement()%> </span><br/><br/>
                                    </li>
                                </ul>
                                <div class="row-fluid span6 alert alert-danger <%=hiddenImp%>">
                                    <form method="POST" action="WorkStructure_Seminar">
                                        <h4>
                                            <strong>The project is nearing its deadline.</strong>
                                            <button type="submit" style="margin-left: 30px" class="btn btn-large btn-primary">Implement</button>
                                        </h4>
                                    </form>
                                </div>
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
                            button = "Re-Accomplish";
                            btncolor = "btn-mini btn-warning";
                        }
                    %>
                    <form name="preactsForm" id="preactsForm" method="POST" action="ChangePreActs" enctype="multipart/form-data">
                        <table cellpadding="0" cellspacing="0" border="0" style="background-color: floralwhite;" class="table table-striped table-bordered" id="datatable1">
                            <thead>
                                <tr>
                                    <%
                                        if (preActs.getCompleted() == 0) {
                                    %>
                                    <th><%=preActs.getTitle()%></th>
                                        <%} else {%>
                                    <th><a href="ChangePreActs"><%=preActs.getTitle()%></a></th>
                                        <%}%>
                                    <th><span style="margin-bottom: 5px" class="badge <%=badgeColor%>"> <%=status%></span></th>
                                    <th class="<%=hidden%>">
                                        <input name="pdfFile" id="pdfFile" type="file"/>
                                        <button type="submit" class="btn <%=btncolor%> "><%=button%></button>
                                    </th>
                                </tr>
                            </thead>
                        </table>
                    </form

                    <div class="span12">
                        <!-- Portlet: Browser Usage Graph -->
                        <div class="box" id="box-0">
                            <h4 class="box-header round-top">Seminar Speakers</h4>         
                            <div class="box-container-toggle">
                                <div class="box-content">
                                    <div class="row-fluid span12 <%=hidden%>">
                                        <form method="GET" action="Speakers">
                                            <span>Action:</span>
                                            <button name="action" value="add" type="submit" class="btn btn-success">
                                                <i class="icon-plus icon-white"></i> Add New Speaker
                                            </button>
                                            <button name="action" value="edit" type="submit" class="btn btn-primary">
                                                <i class="icon-edit icon-white"></i> Edit Current Numbers
                                            </button>
                                        </form>
                                    </div>
                                    <br/> 
                                    <br/>
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable4">
                                        <thead>
                                            <tr>
                                                <th>Specialization</th>
                                                <th>Current Number of Speaker</th>
                                                <th>Number Required</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                List<TaskDetailsEntity> speakerList = (List<TaskDetailsEntity>) request.getAttribute("speakerList");
                                                for (int x = 0; x < speakerList.size(); x++) {
                                            %>
                                            <tr>
                                                <td><%=speakerList.get(x).getTitle()%></td>
                                                <td><%=speakerList.get(x).getCurrentcount()%></td>
                                                <td><%=speakerList.get(x).getTargetcount()%></td>
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

        <!-- jQuery -->
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/additional-methods.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                // validate signup form on keyup and submit
                $("#preactsForm").validate({
                    rules: {
                        pdfFile: {
                            required: true,
                            extension: "pdf"
                        }},
                    messages: {
                        pdfFile: {
                            required: "This field is mandatory!",
                            extension: "Accepts only .pdf file!"
                        }
                    }
                });
            });
        </script>

        <%
            boolean lack = false;
            String req = "";

            if (session.getAttribute("lackPreacts") != null) {
                lack = true;
                req = req + ", Pre-Activity Requirements";
            }
            if (session.getAttribute("lackSpeaker") != null) {
                lack = true;
                req = req + ", Speakers";
            }

            if (lack) {
        %>
        <script>
            $(document).ready(function() {
                window.alert("Please provide <%=req%>");
            });
        </script>
        <%
                session.removeAttribute("lackPreacts");
                session.removeAttribute("lackSpeaker");
            }
        %>
    </body>
</html>