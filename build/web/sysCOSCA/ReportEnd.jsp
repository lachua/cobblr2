
<%@page import="Utilities.Year"%>
<%@page import="java.util.List"%>
<%@page import="dbentities.ReportYearEnd4Entity"%>
<%@page import="dbentities.ReportYearEnd3Entity"%>
<%@page import="dbentities.ReportYearEnd2Entity"%>
<%@page import="dbentities.ReportYearEnd1Entity"%>
<%@page import="dbdao.ReportYearEnd4DAO"%>
<%@page import="dbdao.ReportYearEnd3DAO"%>
<%@page import="dbdao.ReportYearEnd2DAO"%>
<%@page import="dbdao.ReportYearEnd1DAO"%>
<%@page import="Utilities.Converter"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Year End Activity Report</title>
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
                                    <h4 class="box-header round-top">Year End Activity Report</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                        <%
                                            Calendar calstart = (Calendar) session.getAttribute("calstart");        
                                            Calendar calend = (Calendar) session.getAttribute("calend");
                                            
                                            ReportYearEnd1DAO report1dao = new ReportYearEnd1DAO();
                                            ReportYearEnd2DAO report2dao = new ReportYearEnd2DAO();
                                            ReportYearEnd3DAO report3dao = new ReportYearEnd3DAO();
                                            ReportYearEnd4DAO report4dao = new ReportYearEnd4DAO();
                                            
                                            List<ReportYearEnd1Entity> report1 = report1dao.getReport(Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportYearEnd2Entity> report2 = report2dao.getReport(Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportYearEnd3Entity> report3 = report3dao.getReport(Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportYearEnd4Entity> report4 = report4dao.getReport(Converter.toDate(calstart), Converter.toDate(calend));
                                        %>
                                        <h1 align="center">Center for Social Concern and Action </h1>
                                        <h2 align="center">Year End Activity Report</h2>
                                        <h2 align="center">for the year <%=Converter.toYear(calstart) %> - <%=Converter.toYear(calend)%></h2>

                                        <br><br>

                                        <div class="row">
                                            <div class="col-md-6 col-md-offset-3">
                                                <p>A. Project per Status</p>
                                                <center>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <tbody>
                                                            <%for (int x = 0; x < report1.size(); x++) {%>
                                                            <tr>
                                                                <td><%=report1.get(x).getStatus()%></td>
                                                                <td><%=report1.get(x).getCount()%></td>
                                                            </tr>
                                                            <%}%>
                                                        </tbody>
                                                    </table>
                                                </center>
                                            </div>
                                        </div>
                                                        
                                        <div class="row">
                                            
                                                <div class="col-md-6 col-md-offset-3">
                                                <p>B. Project per Target Health Problem</p>
                                                </div>
                                                <div class="col-md-8 col-md-offset-2">
                                                    <center>
                                                        <div id="barGraph" style="height: 500px;"></div>
                                                    </center>
                                                </div>
                                                <div class="col-md-6 col-md-offset-3">
                                                    <center>
                                                        <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                            <thead>
                                                                <tr>
                                                                    <th rowspan="2">Target Health Problem</th>
                                                                    <th colspan="2"><center>Projects</center></th>
                                                                </tr>
                                                                <tr>
                                                                    <th>No. of Projects Available</th>
                                                                    <th>No. of Projects Implemented</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <%for (int x = 0; x < report2.size(); x++) {%>
                                                                <tr>
                                                                    <td><%=report2.get(x).getAnswertext()%></td>
                                                                    <td><%=report2.get(x).getCount_available()%></td>
                                                                    <td><%=report2.get(x).getCount_implemented()%></td>
                                                                </tr>
                                                                <%}%>
                                                            </tbody>
                                                        </table>
                                                    </center>
                                            </div>
                                        </div>
                                                            
                                        <div class="row">
                                            <div class="col-md-6 col-md-offset-3">
                                                <p>C. Projects Implemented per Partner Community</p>
                                                <center>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <thead>
                                                            <tr>
                                                                <th rowspan="2">Partner Community</th>
                                                                <th rowspan="2">Projects Participated In</th>
                                                                <th colspan="2">No. of Participants</th>
                                                            </tr>
                                                            <tr>
                                                                <th>Target</th>
                                                                <th>Actual</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%int count = 0;%>
                                                            <%for (int x = 0; x < report3.size(); x++) {%>
                                                            <tr>
                                                                <%
                                                                    if(count == 0){
                                                                        String start = report3.get(x).getName();
                                                                    for(int y = x; y < report3.size(); y++ ){
                                                                        if(start.equals(report3.get(y).getName())){
                                                                            count++;
                                                                        }else{
                                                                            break;
                                                                        }
                                                                    }
                                                                %>
                                                                <td rowspan="<%=count%>"><%=report3.get(x).getName() %></td>
                                                                <%
                                                                    }
                                                                %>
                                                                <td><%=report3.get(x).getTitle()%></td>
                                                                <td><%=report3.get(x).getTarget_participant_num()%></td>
                                                                <td><%=report3.get(x).getActual_participant()%></td>
                                                            </tr>
                                                            <%count--;%>
                                                            <%}%>
                                                        </tbody>
                                                    </table>
                                                </center>
                                            </div>
                                        </div>
                                                        
                                                                            
                                        <div class="row">
                                            <div class="col-md-6 col-md-offset-3">
                                                <p>D. Projects per Sponsoring Student Organization</p>
                                                <center>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <thead>
                                                            <tr>
                                                                <th>Student Organization</th>
                                                                <th>Project Sponsored</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%count = 0;%>
                                                            <%for (int x = 0; x < report4.size(); x++) {%>
                                                            <tr>
                                                                <%
                                                                    if(count == 0){
                                                                        String start = report4.get(x).getName();
                                                                    for(int y = x; y < report4.size(); y++ ){
                                                                        if(start.equals(report4.get(y).getName())){
                                                                            count++;
                                                                        }else{
                                                                            break;
                                                                        }
                                                                    }
                                                                %>
                                                                <td rowspan="<%=count%>"><%=report4.get(x).getName() %></td>
                                                                <%
                                                                    }
                                                                %>
                                                                <td><%=report4.get(x).getTitle()%></td>
                                                            </tr>
                                                            <%count--;%>
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
        
        <!--Google API-->
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <!--Charts-->
        <script type="text/javascript">
            var empty = 'none';
            var startYear = <%=Converter.toYear(calstart) %>;
            var endYear = <%=Converter.toYear(calend)%>;
            var string = '';
            google.load("visualization", "1", {packages: ["corechart", "table"]});
            google.setOnLoadCallback(drawReportChart);
            function drawReportChart() {
                //Monthly Income Bar
                var data = google.visualization.arrayToDataTable([
                    ['Project per Target Health Problem', 'Available', 'Implemented'],
                    <%for(int x = 0; x < report2.size(); x++){%>
                    ['<%=report2.get(x).getAnswertext() %>', <%=report2.get(x).getCount_available()%>, <%=report2.get(x).getCount_implemented()%>]<%if(x != report2.size()-1){%>,<%}%>
                    <%}%>
                ]);
                
                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                                 { calc: "stringify",
                                   sourceColumn: 1,
                                   type: "string",
                                   role: "annotation" },
                                 2,{ calc: "stringify",
                                   sourceColumn: 2,
                                   type: "string",
                                   role: "annotation" }]);

                var options = {
                    title: 'Project per Target Health Problem',
                    vAxis: {title: 'No. of Projects', titleTextStyle: {color: 'black'}}
                };

                var chart = new google.visualization.BarChart(document.getElementById('barGraph'));
                chart.draw(view, options);
            }
            
        </script>
    </body>
</html>