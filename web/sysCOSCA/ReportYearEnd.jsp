<%@page import="Utilities.GetPercentage"%>
<%@page import="Utilities.Converter"%>
<%@page import="ReportYearEndActivity.ActivityReport"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

    <body id="members">
        <!-- Top navigation bar -->
        <jsp:include page="Navtopbar.jsp"></jsp:include>
            <!-- Main Content Area | Side Nav | Content -->
            <div class="container-fluid">
                <div class="row-fluid">  

                    <div class="row-fluid">
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">

                                <div class="box" id="box-3">
                                    <h4 class="box-header round-top">Year End Report</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                        <%
                                            ActivityReport activity = (ActivityReport) request.getAttribute("activity");
                                        %> 
                                        <h1 align="center">Center for Social Concern and Action </h1>
                                        <h2 align="center">Year End Activity Report </h2>
                                        <h2 align="center"><%=Converter.toStringYear(activity.getDateStart())%> to <%=Converter.toStringYear(activity.getDateEnd())%></h2>

                                        <br><br>

                                        <div class="row">
                                            <div class="col-md-6 col-md-offset-3">

                                                <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                    <tr>
                                                        <td><b>Total Projects Available:</b></td>
                                                        <td width="10%"><%=activity.getNumAvailable()%></td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Total Projects Pending:</b></td>
                                                        <td width="10%"><%=activity.getNumPending()%></td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Total Projects Confirmed:</b></td>
                                                        <td width="10%"><%=activity.getNumConfirmed()%></td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Total Projects On-going:</b></td>
                                                        <td width="10%"><%=activity.getNumOngoing()%></td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Total Projects Implemented:</b></td>
                                                        <td width="10%"><%=activity.getNumImplemented()%></td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Total Projects Closed:</b></td>
                                                        <td width="10%"><%=activity.getNumClosed()%></td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Total Projects Canceled:</b></td>
                                                        <td width="10%"><%=activity.getNumCancelled()%></td>
                                                    </tr>
                                                </table>

                                                <br>

                                            </div>
                                            <div class="col-md-9 col-md-offset-2">     
                                                <div class="col-md-6 col-md-offset">
                                                    <%
                                                        int total = 0;
                                                        for (int x = 0; x < activity.getActiveProjectsList().size(); x++) {
                                                            total = total + activity.getActiveProjectsList().get(x).getInteger();
                                                        }
                                                    %>
                                                    <br>
                                                    <b>Projects with student partnership per type</b>
                                                    <br> <i>Showing the project type/s popular to students</i>
                                                    <br> <i>Total Projects: <%=total%></i>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <%
                                                            for (int x = 0; x < activity.getActiveProjectsList().size(); x++) {
                                                                String str = GetPercentage.getPercent(activity.getActiveProjectsList().get(x).getInteger(), total);
                                                                String perc = GetPercentage.decimalToString(Double.parseDouble(str));
                                                        %>

                                                        <tr>
                                                            <td><%=activity.getActiveProjectsList().get(x).getString()%>:</td>
                                                            <td width="10%"><%=activity.getActiveProjectsList().get(x).getInteger()%></td>
                                                            <td width="10%"><%=perc%>%</td>
                                                        </tr>
                                                        <%
                                                            }
                                                        %>
                                                    </table>
                                                </div>

                                                <div class="col-md-6">
                                                    <%
                                                        total = 0;
                                                        for (int x = 0; x < activity.getInactiveProjectsList().size(); x++) {
                                                            total = total + activity.getInactiveProjectsList().get(x).getInteger();
                                                        }
                                                    %>
                                                    <br>
                                                    <b>Projects with no requests for partnership per type</b>
                                                    <br> <i>Showing the project type/s that are not popular to students</i>
                                                    <br> <i>Total Projects: <%=total%></i>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <%
                                                            for (int x = 0; x < activity.getInactiveProjectsList().size(); x++) {
                                                                String str = GetPercentage.getPercent(activity.getInactiveProjectsList().get(x).getInteger(), total);
                                                                String perc = GetPercentage.decimalToString(Double.parseDouble(str));
                                                        %>

                                                        <tr>
                                                            <td><%=activity.getInactiveProjectsList().get(x).getString()%>:</td>
                                                            <td width="10%"><%=activity.getInactiveProjectsList().get(x).getInteger()%></td>
                                                            <td width="10%"><%=perc%>%</td>
                                                        </tr>
                                                        <%
                                                            }
                                                        %>
                                                    </table>  
                                                </div></div>

                                            <div class="col-md-6 col-md-offset-3">

                                                <br>
                                                <b>Comparison of No of Projects Implemented by Student Organizations</b>
                                                <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                    <thead>
                                                        <tr>
                                                            <th>Student Organization</th>
                                                            <th>No. of Projects Implemented</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            for (int x = 0; x < activity.getOrgActivityList().size(); x++) {
                                                        %>
                                                        <tr>
                                                            <td><%=activity.getOrgActivityList().get(x).getString()%></td>
                                                            <td><%=activity.getOrgActivityList().get(x).getInteger()%></td>
                                                        </tr>
                                                        <%
                                                            }
                                                        %>
                                                    </tbody>
                                                </table>

                                                <br>
                                                <b>Comparison of No of Projects Received by Partner Communities</b>
                                                <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                    <thead>
                                                        <tr>
                                                            <th>Partner Community</th>
                                                            <th>No. of Projects Received</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            for (int x = 0; x < activity.getCommunityDistributionList().size(); x++) {
                                                        %>
                                                        <tr>
                                                            <td><%=activity.getCommunityDistributionList().get(x).getString()%></td>
                                                            <td><%=activity.getCommunityDistributionList().get(x).getInteger()%></td>
                                                        </tr>
                                                        <%
                                                            }
                                                        %>
                                                    </tbody>
                                                </table>

                                                <br>
                                                <b>Projects Canceled</b>
                                                <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                    <thead>
                                                        <tr>
                                                            <th>Date Canceled</th>
                                                            <th>Project Title</th>
                                                            <th>Student Organization</th>
                                                        </tr>
                                                    </thead>
                                                    <%
                                                        for (int x = 0; x < activity.getCancelledProjectsList().size(); x++) {
                                                    %>
                                                    <tr>
                                                        <td><%=Converter.toStringFullMdy(activity.getCancelledProjectsList().get(x).getMeetingdate())%></td>
                                                        <td><%=activity.getCancelledProjectsList().get(x).getProjectTitle()%></td>
                                                        <td><%=activity.getCancelledProjectsList().get(x).getOwnerName()%></td>
                                                    </tr>
                                                    <%}%>
                                                </table>

                                                <br>
                                                <b>Projects Available for more than a year</b>
                                                <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                    <thead>
                                                        <tr>
                                                            <th>Date Created</th>
                                                            <th>Project Title</th>
                                                            <th>Partner Community</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            for (int x = 0; x < activity.getDeadProjectsList().size(); x++) {
                                                        %>
                                                        <tr>
                                                            <td><%=Converter.toStringFullMdy(activity.getDeadProjectsList().get(x).getDate_created())%></td>
                                                            <td><%=activity.getDeadProjectsList().get(x).getProjectTitle()%></td>
                                                            <td><%=activity.getDeadProjectsList().get(x).getOwnerName()%></td>
                                                        </tr>
                                                        <%}%>
                                                    </tbody>
                                                </table>

                                            </div>
                                        </div>

                                        <br><br>
                                        <div class="container">
                                            <p align="center">Date Printed: <%=Converter.toString(activity.getDatePrinted())%> </p>
                                        </div>
                                        <form method="POST" action="ReportYearEnd">
                                            <button class="btn btn-primary">View as PDF</button>
                                            <a href="ReportYear" class="btn">Back</a>
                                        </form>
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

        <!-- jQuery -->
        <script src="../jquery/1.8.3/jquery.min.js"></script>

        <!-- Bootstrap -->
        <script src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="../scripts/bootbox/bootbox.min.js"></script>

        <!-- Simplenso Scripts -->
        <script src="../scripts/simplenso/simplenso.js"></script>
    </body>
</html>