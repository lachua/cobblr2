<%@page import="Utilities.GetPercentage"%>
<%@page import="Utilities.Converter"%>
<%@page import="ReportYearEndActivity.ActivityReport"%>

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
            <!-- Main Content Area | Side Nav | Content -->
            <div class="container-fluid">
                <div class="row-fluid">  

                    <div class="row-fluid">
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">

                                <div class="box" id="box-3">         
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
                                                <div style="margin-left: 350px">

                                                    <table class="table table-striped table-bordered"  >
                                                        <thead>
                                                            <tr>
                                                                <th colspan="2">Project Count</th>
                                                            </tr>
                                                            <tr>
                                                                <th style="width: 200px">Type of Project</th>
                                                                <th>Total Count</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td><b>Projects Available:</b></td>
                                                                <td><center><%=activity.getNumAvailable()%></center></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Projects Pending:</b></td>
                                                            <td><center><%=activity.getNumPending()%></center></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Projects Confirmed:</b></td>
                                                            <td><center><%=activity.getNumConfirmed()%></center></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Projects On-going:</b></td>
                                                            <td><center><%=activity.getNumOngoing()%></center></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Projects Implemented:</b></td>
                                                            <td><center><%=activity.getNumImplemented()%></center></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Projects Closed:</b></td>
                                                            <td><center><%=activity.getNumClosed()%></center></td>
                                                        </tr>
                                                        <tr>
                                                            <td><b>Projects Canceled:</b></td>
                                                            <td><center><%=activity.getNumCancelled()%></center></td>
                                                        </tr>
                                                        </tbody>
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
                                                        <div style="margin-left: 200px">
                                                            <b  >Projects with student partnership per type</b>
                                                            <br> <i>Showing the project type/s popular to students</i>
                                                            <br> <i>Total Projects: <%=total%></i>
                                                        </div>
                                                        <table style="margin-left: 210px" class="table table-striped table-bordered" >
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
                                                        <div style="margin-left: 200px">
                                                            <b>Projects with no requests for partnership per type</b>
                                                            <br> <i>Showing the project type/s that are not popular to students</i>
                                                            <br> <i>Total Projects: <%=total%></i>
                                                        </div>
                                                        <table  style="margin-left: 210px"  class="table table-striped table-bordered" >
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

                                                    <pd4ml:page.break/>
                                                    <br>
                                                    <br>
                                                    <br>
                                                    <br>
                                                    <div style="margin-left: 200px">
                                                        <b>Comparison of No of Projects Implemented by Student Organizations</b>
                                                    </div>
                                                    <br>
                                                    <table  style="margin-left: 280px"  class="table table-striped table-bordered" >
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 200px">Student Organization</th>
                                                                <th style="width: 120px"><center>No. of Projects Implemented</center></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                for (int x = 0; x < activity.getOrgActivityList().size(); x++) {
                                                            %>
                                                            <tr>
                                                                <td><%=activity.getOrgActivityList().get(x).getString()%></td>
                                                                <td><center><%=activity.getOrgActivityList().get(x).getInteger()%></center></td>
                                                        </tr>
                                                        <%
                                                            }
                                                        %>
                                                        </tbody>
                                                    </table>
                                                    <br>
                                                    <br>
                                                    <br>
                                                    <div style="margin-left: 200px">
                                                        <b>Comparison of No of Projects Received by Partner Communities</b>
                                                    </div>
                                                    <br>
                                                    <table style="margin-left: 250px" class="table table-striped table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 300px">Partner Community</th>
                                                                <th style="width: 120px"><center>No. of Projects Received</center></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                for (int x = 0; x < activity.getCommunityDistributionList().size(); x++) {
                                                            %>
                                                            <tr>
                                                                <td style="width: 300px"><%=activity.getCommunityDistributionList().get(x).getString()%></td>
                                                                <td><center><%=activity.getCommunityDistributionList().get(x).getInteger()%></center></td>
                                                        </tr>
                                                        <%
                                                            }
                                                        %>
                                                        </tbody>
                                                    </table>
                                                    <pd4ml:page.break/>
                                                    <br>
                                                    <br>
                                                    <br>
                                                    <table align="center" class="table table-striped table-bordered" >
                                                        <thead>
                                                            <tr>
                                                                <th colspan="3">Projects Canceled</th>
                                                            </tr>
                                                            <tr>
                                                                <th style="width: 150px">Date Canceled</th>
                                                                <th style="width: 200px">Project Title</th>
                                                                <th style="width: 100px">Student Organization</th>
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
                                                    <br>
                                                    <br>
                                                    <table align="center" class="table table-striped table-bordered" >
                                                        <thead><tr>
                                                                <th colspan="3">Untaken Projects for more than 1 year</th>
                                                            </tr>
                                                            <tr>
                                                                <th style="width: 150px">Date Created</th>
                                                                <th style="width: 200px">Project Title</th>
                                                                <th style="width: 100px">Partner Community</th>
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

                                                        <br><br><br>
                                                        <br>
                                            <div class="container">
                                                <p align="center">Date Printed: <%=Converter.toString(activity.getDatePrinted())%> </p>
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

            <!-- jQuery -->
            <script src="../jquery/1.8.3/jquery.min.js"></script>

            <!-- Bootstrap -->
            <script src="../bootstrap/js/bootstrap.min.js"></script>
            <script src="../scripts/bootbox/bootbox.min.js"></script>

            <!-- Simplenso Scripts -->
            <script src="../scripts/simplenso/simplenso.js"></script>
        </body>
        <pd4ml:footer

            pageNumberTemplate="Page $[page] of $[total]"
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