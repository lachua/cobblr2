
<%@page import="Utilities.Year"%>
<%@page import="java.util.List"%>
<%@page import="dbentities.ReportCanceledEntity"%>
<%@page import="dbdao.ReportCanceledDAO"%>
<%@page import="Utilities.Converter"%>
<%@page import="java.util.Calendar"%>
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

    <body id="members">
        <!-- Top navigation bar -->
        <jsp:include page="Navtopbar.jsp"></jsp:include>
            <!-- Main Content Area | Side Nav | Content -->
            <div class="container-fluid">
                <div class="row-fluid">  
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">
                                <div class="box" id="box-3">
                                    <h4 class="box-header round-top">Exception Report - Projects Cancelled</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                        <%
                                            Calendar calstart = (Calendar) session.getAttribute("calstart");        
                                            Calendar calend = (Calendar) session.getAttribute("calend");
                                            
                                            ReportCanceledDAO reportdao = new ReportCanceledDAO();
                                            List<ReportCanceledEntity> report = reportdao.getReport(Converter.toDate(calstart), Converter.toDate(calend));
                                            
                                        %>
                                        <h1 align="center">Center for Social Concern and Action </h1>
                                        <h2 align="center">Projects Cancelled</h2>
                                        <h2 align="center">for the year <%=Converter.toYear(calstart) %> - <%=Converter.toYear(calend)%></h2>

                                        <br><br>

                                        <div class="row">
                                            <div class="col-md-8 col-md-offset-2">
                                                <center>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <thead>
                                                            <tr>
                                                                <th>Date</th>
                                                                <th>Partner Community</th>
                                                                <th width="20%">Sponsoring Student Organization</th>
                                                                <th width="40%">Reason</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%for (int x = 0; x < report.size(); x++) {%>
                                                            <tr>
                                                                <td><%=report.get(x).getDate_cancelled().toString() %></td>
                                                                <td><%=report.get(x).getCommunity_name()%></td>
                                                                <td><%=report.get(x).getOrg_name()%></td>
                                                                <td><%=report.get(x).getCancel_reason()%></td>
                                                            </tr>
                                                            <%}%>
                                                        </tbody>
                                                    </table>
                                                </center>
                                            </div>
                                        </div>

                                        <br><br>
                                        <div class="container">
                                            <p align="center">Date Printed: <%=Year.getCurrentDate()%></p>
                                        </div>
                                        <form method="POST" action="ReportMagnitude">
                                            <button class="btn btn-primary">View as PDF</button>
                                            <a href="ReportYear" class="btn">Back</a>
                                        </form>
                                    </div>


                                </div><!--/span-->
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