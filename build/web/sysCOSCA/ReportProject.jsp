
<%@page import="Utilities.Year"%>
<%@page import="dbentities.ProjectCharterDateEntity"%>
<%@page import="dbdao.ProjectCharterDateDAO"%>
<%@page import="dbentities.ReportProject2Entity"%>
<%@page import="dbentities.ReportProject1Entity"%>
<%@page import="java.util.List"%>
<%@page import="dbentities.ProjectCharterEntity"%>
<%@page import="dbdao.ProjectCharterDAO"%>
<%@page import="dbdao.ReportProject2DAO"%>
<%@page import="dbdao.ReportProject1DAO"%>
<%@page import="Utilities.GetPercentage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Utilities.Converter"%>
<%@page import="ReportProjectEval.ProjectEvalReport"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Project Summary Report</title>
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
                                <h4 class="box-header round-top">Project Summary Report</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                    <%
                                        String project_id = (String) session.getAttribute("project_id");
                                        
                                        ProjectCharterDAO dao = new ProjectCharterDAO();
                                        ProjectCharterEntity project = dao.getProjectCharter(Integer.parseInt(project_id));
                                        ProjectCharterDateDAO datedao = new ProjectCharterDateDAO();
                                        ProjectCharterDateEntity date = datedao.getProjectDate(project.getId());
                                        
                                        ReportProject1DAO report1dao = new ReportProject1DAO();
                                        ReportProject2DAO report2dao = new ReportProject2DAO();
                                        
                                        List<ReportProject1Entity> report1 = report1dao.getReport(project.getId());
                                        List<ReportProject2Entity> report2 = report2dao.getReport(project.getId());
                                        
                                    %>

                                    <h1 align="center">Center for Social Concern and Action </h1>
                                    <h2 align="center">Project Summary Report </h2>
                                    <h2 align="center"><%=date.getDate_closed() %></h2>

                                    <br><br><br>


                                    <div class="row">
                                        <div class="col-md-8 col-md-offset-2">
                                            <center>
                                            <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                <tbody>
                                                    <tr>
                                                        <td>Project Title</td>
                                                        <td><%=report1.get(0).getTitle() %></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Project Type</td>
                                                        <td><%=report1.get(0).getType() %></td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Target Health Problem</td>
                                                        <td>
                                                            <ul>
                                                                <%for(int x = 0; x < report1.size(); x++ ){%>
                                                                <li><%=report1.get(x).getTarget()%></li>
                                                                <%}%>
                                                            </ul>
                                                        </td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Partner Community</td>
                                                        <td><%=report1.get(0).getPartner_community()%></td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Location</td>
                                                        <td><%=report1.get(0).getLocation()%></td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Sponsoring Student Organization</td>
                                                        <td><%=report1.get(0).getSponsor()%></td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Date of Implementation</td>
                                                        <td><%=report1.get(0).getDate_target_implement()%></td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Brief Description</td>
                                                        <td><%=report1.get(0).getDescription()%></td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Main Objectives</td>
                                                        <td><%=report1.get(0).getObjectives()%></td>
                                                    </tr> 
                                                </tbody>
                                            </table>
                                                    </center>
                                        </div>
                                    </div>
                                                    
                                    <div class="row" id="page-break">
                                        <div class="col-md-6 col-md-offset-3">
                                            <center>
                                            <h4>Number of Participants</h4>
                                            <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                <tbody>
                                                    <tr>
                                                        <td>Actual</td>
                                                        <td>90</td>
                                                    </tr> 
                                                    <tr>
                                                        <td>Target</td>
                                                        <td>100</td>
                                                    </tr> 
                                                    
                                                </tbody>
                                            </table></center>
                                        </div>
                                    </div>
                                                    
                                    <div class="row">
                                        <div class="col-md-10 col-md-offset-1">
                                            <center>
                                            <h4>Project Evaluation</h4>
                                            <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                <thead>
                                                    <tr>
                                                        <th><i>Overall Project Objectives</i></th>
                                                        <th width="15%">Evaluation</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%for(int x= 0; x < report2.size(); x++){ %>
                                                        <tr>
                                                            <td><%=x+1%>. <%=report2.get(x).getQuestiontext()%></td>
                                                            <td><%=report2.get(x).getAnswertext()%></td>
                                                        </tr>
                                                    <%}%>
                                                </tbody>
                                            </table></center>
                                        </div>
                                    </div>

                                            <br><br>
                                            <div class="container">
                                                <p align="center">Date Printed: <%=Year.getCurrentDate() %> </p>
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
        <script>
        printDivCSS = new String ('<link href="../css/printcss.css" rel="stylesheet" type="text/css" media="print">');
        function printDiv(divId) {
            window.frames["print_frame"].document.body.innerHTML=printDivCSS + document.getElementById(divId).innerHTML;
            window.frames["print_frame"].window.focus();
            window.frames["print_frame"].window.print();
        }
        </script>
        <iframe name="print_frame" width="0" height="0" frameborder="0" src="about:blank"></iframe>
                </body>
                </html>