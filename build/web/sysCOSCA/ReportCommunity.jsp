
<%@page import="Utilities.Year"%>
<%@page import="dbentities.ReportHealth4Entity"%>
<%@page import="dbentities.ReportHealth23Entity"%>
<%@page import="dbdao.ReportHealth4DAO"%>
<%@page import="dbdao.ReportHealth23DAO"%>
<%@page import="dbdao.ReportHealth23DAO"%>
<%@page import="dbentities.CommunityListEntity"%>
<%@page import="dbdao.CommunityListDAO"%>
<%@page import="Utilities.Converter"%>
<%@page import="dbentities.ReportHealth1Entity"%>
<%@page import="java.util.List"%>
<%@page import="dbdao.ReportHealth1DAO"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Community Health Review</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="HTML5 Admin Simplenso Template" />
        <meta name="author" content="ahoekie" />

        <!-- Bootstrap -->
        <link href="../bootstrap/css/bootstrap.css" rel="stylesheet" id="main-theme-script" />
        <link href="../css/themes/default.css" rel="stylesheet" id="theme-specific-script" />
        <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
        
        <link href="../css/print/print-community.css" rel="stylesheet" type="text/css" media="print">

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
                                    <div id="printDiv">
                                    <h4 class="box-header round-top">Community Health Review</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                        <%
                                            Calendar calstart = (Calendar) session.getAttribute("calstart");        
                                            Calendar calend = (Calendar) session.getAttribute("calend");       
                                            String commId = (String) session.getAttribute("commId");
                                            
                                            CommunityListDAO comdao = new CommunityListDAO();
                                            CommunityListEntity com = comdao.getCommunity(Integer.parseInt(commId));
                                            
                                            ReportHealth1DAO report1dao = new ReportHealth1DAO();
                                            ReportHealth23DAO report2dao = new ReportHealth23DAO();
                                            ReportHealth23DAO report21dao = new ReportHealth23DAO();
                                            ReportHealth23DAO report3dao = new ReportHealth23DAO();
                                            ReportHealth4DAO report4dao = new ReportHealth4DAO();
                                            
                                            List<ReportHealth1Entity> report1 = report1dao.getReport(com.getId(), Converter.toDate(calstart));
                                            List<ReportHealth23Entity> report2 = report2dao.getReport2(com.getId(), Converter.toDate(calstart));
                                            List<ReportHealth23Entity> report3 = report3dao.getReport3(com.getId(), Converter.toDate(calstart));
                                            List<ReportHealth4Entity> report4 = report4dao.getReport(com.getId(), Converter.toDate(calstart), Converter.toDate(calend));
                                            
                                            calstart.add(Calendar.YEAR, -1);
                                            List<ReportHealth23Entity> report21 = report21dao.getReport2(com.getId(), Converter.toDate(calstart));
                                            calstart.add(Calendar.YEAR, 1);
                                            
                                        %>
                                        <h1 align="center">Center for Social Concern and Action </h1>
                                        <h2 align="center">Community Health Review</h2>
                                        <h2 align="center">for the year <%=Converter.toYear(calstart) %> - <%=Converter.toYear(calend)%></h2>

                                        <br>
                                        
                                        <h3 align="center">Community: <%=com.getName() %></h3>
                                        <br><br>
                                        <div class="row">
                                            <div class="col-md-6 col-md-offset-3">
                                                <h4><u>Population</u></h4>
                                                <%for (int x = 0; x < report1.size(); x++){%>
                                                <h4>In <%=report1.get(x).getYear() %>: <%=report1.get(x).getNum_respondents() %></h4>
                                                <%}%>
                                            </div>
                                        </div>
                                        <br><br>

                                        <div class="row">
                                            <div class="col-md-12">
                                                
                                                <p>A. Disease Magnitude Change</p>
                                                <div class="col-md-8 col-md-offset-2">
                                                    <center>
                                                        <div id="barGraph" style="height: 600px;"></div>
                                                    </center>
                                                </div>
                                                
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 col-md-offset-3">
                                                <p>B. Top 10 Diseases in the Community</p>
                                                <center>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <tbody>
                                                            <%for (int u = 0; u < report2.size(); u++) {%>
                                                            <tr>
                                                                <td><%=u+1 %></td>
                                                                <td><%=report2.get(u).getIllness()%></td>
                                                            </tr>
                                                            <%}%>
                                                        </tbody>
                                                    </table>
                                                </center>
                                            </div>
                                        </div>
                                                        
                                        <div class="row">
                                            <div class="col-md-6 col-md-offset-3">
                                                <p>C. Top 3 Felt Family Needs</p>
                                                
                                                <center>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <tbody>
                                                            <%for (int x = 0; x < report3.size(); x++) {%>
                                                            <tr>
                                                                <td><%=x+1 %></td>
                                                                <td><%=report3.get(x).getIllness()%></td>
                                                            </tr>
                                                            <%}%>
                                                        </tbody>
                                                    </table>
                                                </center>
                                            </div>
                                        </div>
                                                        
                                        <div id="page-break" class="row">
                                            <div class="col-md-8 col-md-offset-2">
                                                <p>D. Health Projects Participated In</p>
                                                <center>
                                                    <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                        <thead>
                                                            <tr>
                                                                <th>Date</th>
                                                                <th>Project</th>
                                                                <th>Target Health Problem</th>
                                                                <th>No. of Participants</th>
                                                            </tr>
                                                        </thead>
                                                        
                                                        <tbody>
                                                            <%for (int y = 0; y < report4.size(); y++) {%>
                                                            <tr>
                                                                <td><%=report4.get(y).getDate_implemented() %></td>
                                                                <td><%=report4.get(y).getTitle()%></td>
                                                                <td><%=report4.get(y).getAnswertext()%></td>
                                                                <td><%=report4.get(y).getNum_participants()%></td>
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
                                    </div>
                                    </div>


                                </div><!--/span-->
                                <a class="btn btn-primary" href="javascript:printDiv('printDiv')">Print</a>
                                <a href="ReportYear" class="btn">Back</a>
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
                    ['Project per Target Health Problem', ''+(startYear-1), ''+startYear ],
                    <%for(int z = 0; z < report2.size(); z++){%>
                        <%
                            int pastnum = 0;
                            for(int w = 0; w < report21.size(); w++){
                                if(report2.get(z).getIllness().equalsIgnoreCase(report21.get(w).getIllness())){
                                    pastnum = report21.get(w).getIncidence();
                                    break;
                                }
                            }
                        %>
                    ['<%=report2.get(z).getIllness()%>', <%=pastnum%> , <%=report2.get(z).getIncidence()%>]<%if(z != report2.size()-1){%>,<%}%>
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
                    title: 'Disease Magnitude Change',
                    vAxis: {title: 'No. of Projects', titleTextStyle: {color: 'black'}}
                };

                var chart = new google.visualization.BarChart(document.getElementById('barGraph'));
                chart.draw(view, options);
            }
            
        </script>
        
        <script>
        printDivCSS = new String ('<link href="../css/print/print-community.css" rel="stylesheet" type="text/css" media="print">');
        function printDiv(divId) {
            window.frames["print_frame"].document.body.innerHTML=printDivCSS + document.getElementById(divId).innerHTML;
            window.frames["print_frame"].window.focus();
            window.frames["print_frame"].window.print();
        }
        </script>
        <iframe name="print_frame" width="0" height="0" frameborder="0" src="about:blank"></iframe>
    </body>
</html>