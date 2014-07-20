<%@page import="Utilities.CompareDate"%>
<%@page import="dbentities.ProjectCharterEntity"%>
<%@page import="dbdao.ProjectCharterDAO"%>
<%@page import="dbentities.NotificationEntity"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Home</title>
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
                        <div class="row-fluid">
                            <form method="POST" action="SOrgHome">
                                <div class="span4">
                                    <div class="box">
                                        <h4 class="box-header round-top">New Projects</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                            <%
                                                List<NotificationEntity> notif = (List<NotificationEntity>) request.getAttribute("notif");
                                                boolean hasNewProjectNotif = false;
                                                for (int x = 0; x < notif.size(); x++) {
                                                     if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_NewProject")) {
                                                        hasNewProjectNotif = true;
                                                        break;
                                                    }
                                                }

                                                if (!hasNewProjectNotif) {
                                            %>
                                            <h4 class="alert alert-info">No new notifications</h4>
                                            <%
                                            } else {
                                                for (int x = 0; x < notif.size(); x++) {
                                                    ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                                                    ProjectCharterEntity charter = charterDAO.getProjectCharter(notif.get(x).getProject_id());
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_NewProject")) {
                                            %>
                                            <div class="alert alert-success">
                                                <button name="action" value="<%=notif.get(x).getId_notification()%>" type="submit" class="close"  >×</button>
                                                <strong>Date: <%=notif.get(x).getDate().toString()%></strong><br/>
                                                A new project titled "<strong><%=charter.getTitle()%></strong>" has been created.<br/>
                                                You can <a href="ViewAvailableProjects">reserve the project</a>.
                                            </div>
                                            <%
                                            }
                                                    }
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div><!--/span-->
                            </div>
                                        
                                        <div class="span4">
                                    <div class="box">
                                        <h4 class="box-header round-top">Project Approvals</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                            <%
                                                boolean hasProjectNotif = false;
                                                for (int x = 0; x < notif.size(); x++) {
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_PendingApprove")) {
                                                        hasProjectNotif = true;
                                                        break;
                                                    } else if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_PendingDisapprove")) {
                                                        hasProjectNotif = true;
                                                        break;
                                                    } 
                                                }

                                                if (!hasProjectNotif) {
                                            %>
                                            <h4 class="alert alert-info">No new notifications</h4>
                                            <%
                                            } else {
                                                for (int x = 0; x < notif.size(); x++) {
                                                    ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                                                    ProjectCharterEntity charter = charterDAO.getProjectCharter(notif.get(x).getProject_id());
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_PendingApprove")) {
                                            %>
                                            <div class="alert alert-success">
                                                <button name="action" value="<%=notif.get(x).getId_notification()%>" type="submit" class="close"  >×</button>
                                                <strong>Date: <%=notif.get(x).getDate().toString()%></strong><br/>
                                                Your request for the project entitled <strong><%=charter.getTitle()%></strong> has been approved.<br/>
                                                You can now <a href="ConfirmProjects" >start planning</a>.
                                            </div>
                                            <%
                                            } else if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_PendingDisapprove")) {
                                            %>
                                            <div class="alert alert-error">
                                                <button name="action" value="<%=notif.get(x).getId_notification()%>" type="submit" class="close" >×</button>
                                                <strong>Date: <%=notif.get(x).getDate().toString()%></strong><br/>
                                                Your request for the project entitled <strong><%=charter.getTitle()%></strong> has been disapproved.<br/>
                                                For the reason of: <%=notif.get(x).getComments()%>. <br/>
                                                But you can <a href="ViewAvailableProjects">request for another project</a>
                                            </div>
                                            <%
                                            }
                                                    }
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div><!--/span-->
                            </div>
                                        
                                        <div class="span4">
                                    <div class="box">
                                        <h4 class="box-header round-top">Implementations</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                            <%
                                                boolean hasImplementationNotif = false;
                                                for (int x = 0; x < notif.size(); x++) {
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_Implementation")) {
                                                        if (CompareDate.compareDates(notif.get(x).getDate()) > 0) {
                                                            hasImplementationNotif = true;
                                                            break;
                                                        }
                                                    } else if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_CancelProject")) {
                                                        hasImplementationNotif = true;
                                                        break;
                                                    }
                                                }

                                                if (!hasImplementationNotif) {
                                            %>
                                            <h4 class="alert alert-info">No new notifications</h4>
                                            <%
                                            } else {
                                                for (int x = 0; x < notif.size(); x++) {
                                                    ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                                                    ProjectCharterEntity charter = charterDAO.getProjectCharter(notif.get(x).getProject_id());
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_Implementation")) {
                                                if (CompareDate.compareDates(notif.get(x).getDate()) > 0) {
                                            %>
                                            <div class="alert alert-block">
                                                <button name="action" value="<%=notif.get(x).getId_notification()%>" type="submit" class="close"  >×</button>
                                                <strong>Date: <%=notif.get(x).getDate().toString()%></strong><br/>
                                                The project "<strong><%=charter.getTitle()%></strong>" is nearing its deadline, <strong><%=notif.get(x).getComments()%></strong>.<br/>
                                                View <a href="CurrentProjects">project details</a>.
                                            </div>
                                            <%
                                                }
                                            } else if (notif.get(x).getNotificationtext().equalsIgnoreCase("ORG_CancelProject")) {
                                            %>
                                            <div class="alert alert-block">
                                                <button name="action" value="<%=notif.get(x).getId_notification()%>" type="submit" class="close"  >×</button>
                                                <strong>Date: <%=notif.get(x).getDate().toString()%></strong><br/>
                                                The project "<strong><%=charter.getTitle()%></strong>" has been canceled.<br/>
                                                <a href="ViewAvailableProjects">Reserve another project</a>.
                                            </div>
                                            <%
                                                        }
                                                    }
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div><!--/span-->
                            </div>
                        </form>
                    </div>
                </div>
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