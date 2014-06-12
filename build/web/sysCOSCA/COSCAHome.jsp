
<%@page import="Utilities.CompareDate"%>
<%@page import="dbentities.ProjectCharterEntity"%>
<%@page import="dbdao.ProjectCharterDAO"%>
<%@page import="dbentities.NotificationEntity"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
                        <div class="row-fluid">
                            <form method="POST" action="COSCAHome">
                                <div class="span4 column">
                                    <div class="box">
                                        <h4 class="box-header round-top">Nearing Deadlines</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                            <%
                                                List<NotificationEntity> notif = (List<NotificationEntity>) request.getAttribute("notif");
                                                boolean hasImplementationNotif = false;
                                                for (int x = 0; x < notif.size(); x++) {
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("COSCA_Implementation")) {
                                                        if (CompareDate.compareDates(notif.get(x).getDate()) > 0) {
                                                            hasImplementationNotif = true;
                                                            break;
                                                        }
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
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("COSCA_Implementation")) {
                                                        if (CompareDate.compareDates(notif.get(x).getDate()) > 0) {
                                            %>
                                            <div class="alert alert-block">
                                                <button name="action" value="<%=notif.get(x).getId_notification()%>" type="submit" class="close"  >×</button>
                                                <strong>Date: <%=notif.get(x).getDate().toString()%></strong><br/>
                                                The project "<strong><%=charter.getTitle()%></strong>" is nearing its deadline, <strong><%=notif.get(x).getComments()%></strong>.<br/>
                                                View <a href="OnGoingProjects">project details</a>.
                                            </div>
                                            <%
                                                            }
                                                        }
                                                    }
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div><!--/span-->
                            </div>

                            <div class="span4 column">
                                <div class="box">
                                    <h4 class="box-header round-top">New Reservations</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <%
                                                boolean hasProjectReservationNotif = false;

                                                for (int x = 0; x < notif.size(); x++) {
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("COSCA_ProjectReserved")) {
                                                        hasProjectReservationNotif = true;
                                                        break;
                                                    }
                                                }

                                                if (!hasProjectReservationNotif) {
                                            %>
                                            <h4 class="alert alert-info">No new notifications</h4>
                                            <%
                                            } else {
                                                for (int x = 0; x < notif.size(); x++) {
                                                    ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                                                    ProjectCharterEntity charter = charterDAO.getProjectCharter(notif.get(x).getProject_id());
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("COSCA_ProjectReserved")) {
                                            %>
                                            <div class="alert alert-success">
                                                <button name="action" value="<%=notif.get(x).getId_notification()%>" type="submit" class="close"  >×</button>
                                                <strong>Date: <%=notif.get(x).getDate().toString()%></strong><br/>
                                                The project "<strong><%=charter.getTitle()%></strong>" has been reserved, the meeting date is <br/><strong><%=notif.get(x).getComments()%></strong>.<br/>
                                                View the <a href="ProjectsPending" >pending reservations</a>.
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

                            <div class="span4 column">
                                <div class="box" >
                                    <h4 class="box-header round-top">Accomplished Full Charter</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <%
                                                boolean hasFullCharterNotif = false;
                                                for (int x = 0; x < notif.size(); x++) {
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("COSCA_FinalizedFullCharter")) {
                                                        hasFullCharterNotif = true;
                                                        break;
                                                    }
                                                }

                                                if (!hasFullCharterNotif) {
                                            %>
                                            <h4 class="alert alert-info">No new notifications</h4>
                                            <%
                                            } else {
                                                for (int x = 0; x < notif.size(); x++) {
                                                    ProjectCharterDAO charterDAO = new ProjectCharterDAO();
                                                    ProjectCharterEntity charter = charterDAO.getProjectCharter(notif.get(x).getProject_id());
                                                    if (notif.get(x).getNotificationtext().equalsIgnoreCase("COSCA_FinalizedFullCharter")) {
                                            %>
                                            <div class="alert alert-success">
                                                <button name="action" value="<%=notif.get(x).getId_notification()%>" type="submit" class="close"  >×</button>
                                                <strong>Date: <%=notif.get(x).getDate().toString()%></strong><br/>
                                                The project charter of "<strong><%=charter.getTitle()%></strong>" has been edited.<br/>
                                                View the <a href="OnGoingProjects" >project details</a>.
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

        <!-- Bootstrap -->
        <script src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="../scripts/bootbox/bootbox.min.js"></script>

        <!-- Simplenso Scripts -->
        <script src="../scripts/simplenso/simplenso.js"></script>
    </body>
</html>