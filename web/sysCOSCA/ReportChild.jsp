
<%@page import="dbdao.CommunityAnswerDAO"%>
<%@page import="dbentities.AnswerEntity"%>
<%@page import="dbentities.ReportChild7Entity"%>
<%@page import="dbentities.ReportChild6Entity"%>
<%@page import="dbentities.ReportChild5Entity"%>
<%@page import="dbentities.ReportChild4Entity"%>
<%@page import="dbentities.ReportChild3Entity"%>
<%@page import="dbentities.ReportChild2Entity"%>
<%@page import="dbentities.ReportChild1Entity"%>
<%@page import="dbdao.ReportChild7DAO"%>
<%@page import="dbdao.ReportChild6DAO"%>
<%@page import="dbdao.ReportChild5DAO"%>
<%@page import="dbdao.ReportChild4DAO"%>
<%@page import="dbdao.ReportChild3DAO"%>
<%@page import="dbdao.ReportChild2DAO"%>
<%@page import="dbdao.ReportChild1DAO"%>
<%@page import="Utilities.Year"%>
<%@page import="dbentities.CommunityListEntity"%>
<%@page import="dbdao.CommunityListDAO"%>
<%@page import="Utilities.Converter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Health Review of Children Ages 0-5</title>
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
                                    <div id="printDiv">
                                    <h4 class="box-header round-top">Health Review of Children Ages 0-5</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                        <%
                                            Calendar calstart = (Calendar) session.getAttribute("calstart");        
                                            Calendar calend = (Calendar) session.getAttribute("calend");       
                                            String commId = (String) session.getAttribute("commId");
                                            
                                            CommunityListDAO comdao = new CommunityListDAO();
                                            CommunityListEntity com = comdao.getCommunity(Integer.parseInt(commId));
                                            
                                            CommunityAnswerDAO ansdao = new CommunityAnswerDAO();
                                            AnswerEntity ans = ansdao.getLatestSurveyDate(Integer.parseInt(commId), Converter.toDate(calstart),  Converter.toDate(calend));
                                            
                                            ReportChild1DAO report1dao = new ReportChild1DAO();
                                            ReportChild2DAO report2dao = new ReportChild2DAO();
                                            ReportChild3DAO report3dao = new ReportChild3DAO();
                                            ReportChild4DAO report4dao = new ReportChild4DAO();
                                            ReportChild5DAO report5dao = new ReportChild5DAO();
                                            ReportChild6DAO report6dao = new ReportChild6DAO();
                                            ReportChild7DAO report7dao = new ReportChild7DAO();
                                            
                                            List<ReportChild1Entity> report1 = report1dao.getReport(com.getId(), Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportChild2Entity> report2 = report2dao.getReport(com.getId(), Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportChild3Entity> report3 = report3dao.getReport(com.getId(), Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportChild4Entity> report4 = report4dao.getReport(com.getId(), Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportChild5Entity> report5 = report5dao.getReport(com.getId(), Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportChild6Entity> report6 = report6dao.getReport(com.getId(), Converter.toDate(calstart), Converter.toDate(calend));
                                            List<ReportChild7Entity> report7 = report7dao.getReport(com.getId(), Converter.toDate(calstart), Converter.toDate(calend));
                                            
                                        %>
                                        <h1 align="center">Center for Social Concern and Action </h1>
                                        <h2 align="center">Health Review of Children Ages 0-5</h2>
                                        <h2 align="center">for the year <%=Converter.toYear(calstart) %> - <%=Converter.toYear(calend)%></h2>

                                        <br>
                                        
                                        <h2 align="center">Community: <%=com.getName() %></h2>
                                        <h3 align="center">As of <%if(ans != null){%><%=Converter.toString(ans.getDate_answered()) %><%}else{%>N/A<%}%></h3>
                                        <br><br>

                                        <div class="row">
                                            <div class="col-md-8 col-md-offset-2">
                                                <h2>Population of Children Ages 0-5: <%if(!report1.isEmpty()){%><%=report1.get(0).getTotal()%><%}else{%>0<%}%></h2>
                                                <center>
                                                    <div id="age" style="min-height: 300px;"></div>
                                                </center>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-8 col-md-offset-2">
                                                <h2>Vitamin Deficiency</h2>
                                                <center>
                                                    <div id="vitamin" style="min-height: 300px;"></div>
                                                </center>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-8 col-md-offset-2">
                                                <h2>Malnutrition</h2>
                                                <center>
                                                    <div id="malnutrition" style="min-height: 300px;"></div>
                                                </center>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-8 col-md-offset-2">
                                                <h2>New Born Screening</h2>
                                                <center>
                                                    <div id="newborn" style="min-height: 300px;"></div>
                                                </center>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-8 col-md-offset-2">
                                                <h2>Immunization</h2>
                                                <center>
                                                    <div id="immunization" style="min-height: 300px;"></div>
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
            google.setOnLoadCallback(drawChildChart);
            function drawChildChart() {
                //Age Population
                var data = google.visualization.arrayToDataTable([
                    ['Age', 'No. of Children'],
                    <%for(int x=0; x < report2.size(); x++){ %>
                    ['<%=report2.get(x).getAge() %>', <%=report2.get(x).getCount()%>]<%if(x+1 != report2.size()){%>,<%}%>
                    <%}%>
                ]);

                string = '';
                if (<%if(!report1.isEmpty()){%><%=report1.get(0).getTotal()%><%}else{%>0<%}%> == 0) {
                    string = empty;
                }

                var options = {
                    title: string,
                    pieHole: 0.4
                };

                var chart = new google.visualization.PieChart(document.getElementById('age'));
                chart.draw(data, options);
                
                
                //Vitamin Deficeincy
                var data = google.visualization.arrayToDataTable([
                    ['Vitamin Deficiency', 'No of children'],
                     <%for(int x=0; x < report4.size(); x++){ %>
                    ['<%=report4.get(x).getVitamin()%>', <%=report4.get(x).getCount()%>]<%if(x+1 != report4.size()){%>,<%}%>
                    <%}%>
                ]);
                
                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                                 { calc: "stringify",
                                   sourceColumn: 1,
                                   type: "string",
                                   role: "annotation" }]);

                var options = {
                    vAxis: {title: 'Vitamin Deficiency', titleTextStyle: {color: 'black'}}
                };

                var chart = new google.visualization.BarChart(document.getElementById('vitamin'));
                chart.draw(view, options);
                
                //Malnutrition
                var data = google.visualization.arrayToDataTable([
                    ['Malnutrition', 'No of children',{ role: "style" }],
                     <%for(int x=0; x < report5.size(); x++){ %>
                    ['<%=report5.get(x).getBmi()%>', <%=report5.get(x).getCount()%>, "#b87333"]<%if(x+1 != report5.size()){%>,<%}%>
                    <%}%>
                ]);
                
                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                                 { calc: "stringify",
                                   sourceColumn: 1,
                                   type: "string",
                                   role: "annotation" }]);

                var options = {
                    vAxis: {title: 'Malnutrition', titleTextStyle: {color: 'black'}}
                };

                var chart = new google.visualization.BarChart(document.getElementById('malnutrition'));
                chart.draw(view, options);
                
                
                //New Born Screening
                var data = google.visualization.arrayToDataTable([
                    ['New Born Screening', 'No. of Children'],
                    ['With', <%if(!report6.isEmpty()){%><%=report6.get(0).getCount()%><%}else{%>0<%}%>],
                    ['Without', <%if(!report6.isEmpty()){%><%=report6.get(1).getCount()%><%}else{%>0<%}%>]
                  
                ]);

                string = '';
                if (<%if(!report1.isEmpty()){%><%=report1.get(0).getTotal()%><%}else{%>0<%}%> == 0) {
                    string = empty;
                }

                var options = {
                    title: string,
                    pieHole: 0.4
                };

                var chart = new google.visualization.PieChart(document.getElementById('newborn'));
                chart.draw(data, options);
                
                //Immunization
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Immunization');
                data.addColumn('number', 'No. of Children');
                data.addRows([
                    <%for(int x = 0; x < report7.size(); x++){%>
                    ['<%=report7.get(x).getImmunization()%>', <%=report7.get(x).getCount()%>]<%if(x+1 != report7.size()){%>,<%}%>
                    <%}%>
                ]);

                var table = new google.visualization.Table(document.getElementById('immunization'));
                table.draw(data);
            }
        </script>
        <script>
        printDivCSS = new String ('<link href="myprintstyle.css" rel="stylesheet" type="text/css">');
        function printDiv(divId) {
            window.frames["print_frame"].document.body.innerHTML=printDivCSS + document.getElementById(divId).innerHTML;
            window.frames["print_frame"].window.focus();
            window.frames["print_frame"].window.print();
        }
        </script>
        <iframe name="print_frame" width="0" height="0" frameborder="0" src="about:blank"></iframe>
    </body>
</html>