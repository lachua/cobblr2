
<%@page import="Utilities.Converter"%>
<%@page import="ReportDiseases.MorbidityReport"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Top 10 Diseases Report</title>
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
                                <h4 class="box-header round-top">Top 10 Diseases Report</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                    <%
                                        MorbidityReport morbidity = (MorbidityReport) request.getAttribute("morbidity");
                                    %>
                                    <h1 align="center">Center for Social Concern and Action </h1>
                                    <h2 align="center">Morbidity: Top Diseases Report </h2>
                                    <h2 align="center">for the year <%=Converter.toStringYear(morbidity.getPeriodStart())%> to <%=Converter.toStringYear(morbidity.getPeriodEnd())%></h2>

                                    <br><br><br><br>

                                    <div class="row">
                                        <div class="col-md-6 col-md-offset-3">
                                            <table cellpadding="0" cellspacing="0" class="table table-striped table-bordered" border="0" width="400"  id="tables">
                                                <thead>
                                                <th></th>
                                                <th>Disease</th>
                                                <th>Magnitude</th>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        for (int x = 0; x < morbidity.getDiseaseList().size(); x++) {
                                                    %>
                                                    <tr>
                                                        <td><%=x + 1%></td>
                                                        <td><%=morbidity.getDiseaseList().get(x).getIllness()%></td>
                                                        <td><%=morbidity.getDiseaseList().get(x).getCount()%></td>
                                                    </tr> 
                                                    <%
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <br><br>
                                    <div class="container">
                                        <p align="center">Date Printed: <%=Converter.toString(morbidity.getDatePrinted())%> </p>
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