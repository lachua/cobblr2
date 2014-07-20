<%@page import="dbentities.UnavailableProjectEntity"%>
<%@page import="java.util.Calendar"%>
<%@page import="Utilities.Year"%>
<%@page import="dbentities.CommunityListEntity"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Reports</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="HTML5 Admin Simplenso Template" />
        <meta name="author" content="ahoekie" />

        <!-- Bootstrap -->
        <link href="../bootstrap/css/bootstrap.css" rel="stylesheet" id="main-theme-script" />
        <link href="../css/themes/default.css" rel="stylesheet" id="theme-specific-script" />
        <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />

        <!-- Data Tables -->
        <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

        <!-- Bootstrap Date Picker --> 
        <link href="../scripts/datepicker/css/datepicker.css" rel="stylesheet" />

        <!-- Chosen multiselect -->
        <link type="text/css" href="../scripts/chosen/chosen/chosen.intenso.css" rel="stylesheet" />   

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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    </head>
    <body id="members">
        <!-- Top navigation bar -->
        <jsp:include page="Navtopbar.jsp"></jsp:include>
            <!-- Main Content Area | Side Nav | Content -->
            <div class="container-fluid">
                <div class="row-fluid">
                    <!-- Side Navigation -->
                    <div class="span2">
                        <div class="member-box round-all">
                            <a><img src="../images/member_ph.png" class="member-box-avatar" /></a>
                            <span>
                                <strong>DLSU</strong><br />
                                <a>COSCA</a><br />
                                <span class="member-box-links"><a>Logout</a></span>
                            </span>
                        </div>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div>

                    <div class="span10">
                        <div class="row-fluid">
                            <div class="span12">
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Reports</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <form class="form-horizontal">
                                                <legend>Select Reports</legend>
                                                <div class="control-group">
                                                    <label class="control-label" for="reportType">Select Reports</label>
                                                    <div class="controls">
                                                        <select id="reportType" name="reportType" class="chzn-select input-xxlarge">
                                                            <option value="0"></option>
                                                            <option value="2">Annual Report</option>
                                                            <option value="3">Comparative Analysis of Magnitude of Disease Report</option>
                                                            <option value="6">Community Health Review</option>
                                                            <option value="5">Exception Report- Project Cancelled</option>
                                                            <option value="7">Health Review of Children Ages 0-5</option>
                                                            <option value="8">Project Summary Report</option>
                                                            <option value="1">Top Diseases Reports</option>
                                                            <option value="4">Year End Report</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </form>

                                            <!--Top Diseases -->
                                            <div id="report1" style="display: none;">
                                                <form id="top10Form" class="form-horizontal" method="GET" action="ReportDiseases">
                                                    <div class="control-group">
                                                        <label class="control-label" for="datefrom">Select Date Range</label>
                                                        <div class="controls">
                                                            <div style="width: 50px">From:</div>
                                                            <select id="datefrom" name="datefrom" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x-1%>"><%=Year.getCurrentYear() - x-1%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                            </select>
                                                            <div style="width: 50px">To:</div>   
                                                            <select id="dateto" name="dateto" class="chzn-select input input-xlarge " >
                                                                <%
                                                                    for (int x = 0; x < 10; x++) {
                                                                %>
                                                                <option value="<%=Year.getCurrentYear() - x%>"><%=Year.getCurrentYear() - x%> </option> 
                                                                <%
                                                                    }
                                                                %>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-actions">
                                                        <button type="button" id="top10Button" name="top10" class="btn btn-primary">See Top Diseases Report</button>
                                                    </div>
                                                </form>
                                            </div>


                                        <!--Annual Report-->
                                        <div id="report2" style="display: none; ">
                                            <form id="annualForm" class="form-horizontal" method="GET" action="ReportAnnual" >
                                                <div class="control-group">
                                                    <label class="control-label" for="date">Select Date Range</label>
                                                    <div class="controls">
                                                        <div style="width: 50px">From:</div>
                                                        <select id="datestart" name="datestart" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x-1%>"><%=Year.getCurrentYear() - x-1%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                        <div style="width: 50px">To:</div>   
                                                        <select id="dateend" name="dateend" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x%>"><%=Year.getCurrentYear() - x %> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button id="annual" type="button" name="yearEnd" class="btn btn-primary">See Annual Report</button>
                                                </div>
                                            </form>
                                        </div>

                                        <!--Comparative Analysis of Magnitude of Disease Report-->
                                        <div id="report3" style="display: none; ">
                                            <form id="magnitudeForm" class="form-horizontal" method="GET" action="ReportMagnitude" >
                                                <div class="control-group">
                                                    <label class="control-label" for="date">For Disease:</label>
                                                    <div class="controls">
                                                    <select id="disease" name="disease" class="chzn-select input input-xlarge " >
                                                        <optgroup label="Sicknesses:">
                                                            <option value="35-98">Allergy</option>
                                                            <option value="35-99">Altherosclerosis</option>
                                                            <option value="35-100">Asthma</option>
                                                            <option value="35-101">Coughs & Colds</option>
                                                            <option value="35-102">Dengue</option>
                                                            <option value="35-103">Diabetes</option>
                                                            <option value="35-104">Gl Obstruction</option>
                                                            <option value="35-105">Hemmorhage</option>
                                                            <option value="35-106">KidneyStones</option>
                                                            <option value="35-107">Overfatigue</option>
                                                            <option value="35-108">Pneumonia</option>
                                                            <option value="35-109">Renal Failure</option>
                                                            <option value="35-110">Fever</option>
                                                        </optgroup>
                                                        <optgroup label="Child Vaccinations:">
                                                            <option value="76-223">Flu</option>
                                                            <option value="76-224">Hepatitis B</option>
                                                            <option value="76-225">MVC1</option>
                                                            <option value="76-226">MVC2</option>
                                                            <option value="76-227">TT 2+</option>
                                                            <option value="76-228">BGC</option>
                                                            <option value="76-229">DTP</option>
                                                            <option value="76-230">Rotavirus</option>
                                                            <option value="76-231">Pneumococcal</option>
                                                            <option value="76-232">OPV1</option>
                                                            <option value="76-233">OPV3</option>
                                                        </optgroup>
                                                        <optgroup label="Child Vitamin Deficiency:">
                                                            <option value="74-216">Vitamin A</option>
                                                            <option value="74-217">Vitamin B12</option>
                                                            <option value="74-218">Vitamin C</option>
                                                            <option value="74-219">Vitamin D</option>
                                                            <option value="74-220">Iron</option>
                                                            <option value="74-221">Zinc</option>
                                                            <option value="74-222">Multi-Vitamins</option>
                                                        </optgroup>
                                                        <optgroup label="Child Malnutrition:">
                                                            <option value="77-234">Under weight</option>
                                                            <option value="77-236">Over weight</option>
                                                            <option value="77-237">Obese</option>
                                                        </optgroup>
                                                    </select>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label" for="date">Select Date Range</label>
                                                    <div class="controls">
                                                        <div style="width: 50px">From:</div>
                                                        <select id="magdatestart" name="magdatestart" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x %>"><%=Year.getCurrentYear() - x%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                        <div style="width: 50px">To:</div>   
                                                        <select id="magdateend" name="magdateend" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x + 1%>"><%=Year.getCurrentYear() - x +1%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button id="magnitude" type="button" name="magnitude" class="btn btn-primary">See Comparative Analysis of Magnitude of Disease Report</button>
                                                </div>
                                            </form>
                                        </div>   
                                                        
                                        <!--Year End Report-->
                                        <div id="report4" style="display: none; ">
                                            <form id="yearendForm" class="form-horizontal" method="GET" action="ReportEnd" >
                                                <div class="control-group">
                                                    <label class="control-label" for="date">Select Date Range</label>
                                                    <div class="controls">
                                                        <div style="width: 50px">From:</div>
                                                        <select id="yrenddatestart" name="yrenddatestart" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x %>"><%=Year.getCurrentYear() - x%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                        <div style="width: 50px">To:</div>   
                                                        <select id="yrenddateend" name="yrenddateend" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x + 1%>"><%=Year.getCurrentYear() - x + 1%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button id="yearend" type="button" name="yearend" class="btn btn-primary">See Year End Report</button>
                                                </div>
                                            </form>
                                        </div>
                                                        
                                        <!--Canceled Report-->
                                        <div id="report5" style="display: none; ">
                                            <form id="cancelForm" class="form-horizontal" method="GET" action="ReportCanceled" >
                                                <div class="control-group">
                                                    <label class="control-label" for="date">Select Date Range</label>
                                                    <div class="controls">
                                                        <div style="width: 50px">For:</div>
                                                        <select id="canceldatestart" name="canceldatestart" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x%>"><%=Year.getCurrentYear() - x%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                        <div style="width: 50px">And:</div>   
                                                        <select id="canceldateend" name="canceldateend" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x+1%>"><%=Year.getCurrentYear() - x+1%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button id="cancel" type="button" name="cancel" class="btn btn-primary">See Exception Report- Project Cancelled</button>
                                                </div>
                                            </form>
                                        </div>
                                                        
                                        <!--Community Health-->
                                        <div id="report6" style="display: none; ">
                                            <form id="commForm" class="form-horizontal" method="GET" action="ReportCommunity" >
                                                <div class="control-group">
                                                    <label class="control-label" for="commId">Select Project</label>
                                                    <div class="controls">
                                                        <select id="commId" name="commId" class="chzn-select input input-xlarge " >
                                                            <%
                                                                List<CommunityListEntity> comlist = (List<CommunityListEntity>) request.getAttribute("comlist");
                                                                for (int x = 1; x < comlist.size(); x++) {
                                                            %>
                                                            <option value="<%=comlist.get(x).getId()%>"><%=comlist.get(x).getName()%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label" for="commdate">Select Date Range</label>
                                                    <div class="controls">
                                                        <div style="width: 50px">For:</div>
                                                        <select id="commdatestart" name="commdatestart" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x-1%>"><%=Year.getCurrentYear() - x-1%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                        <div style="width: 50px">And:</div>   
                                                        <select id="commdateend" name="commdateend" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x%>"><%=Year.getCurrentYear() - x%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button id="comm" type="button" name="comm" class="btn btn-primary">See Community Health Review</button>
                                                </div>
                                            </form>
                                        </div>
                                                        
                                        <!--Child Health-->
                                        <div id="report7" style="display: none; ">
                                            <form id="childForm" class="form-horizontal" method="GET" action="ReportChild" >
                                                <div class="control-group">
                                                    <label class="control-label" for="childId">Select Project</label>
                                                    <div class="controls">
                                                        <select id="childId" name="childId" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 1; x < comlist.size(); x++) {
                                                            %>
                                                            <option value="<%=comlist.get(x).getId()%>"><%=comlist.get(x).getName()%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label" for="childdate">Select Date Range</label>
                                                    <div class="controls">
                                                        <div style="width: 50px">For:</div>
                                                        <select id="childdatestart" name="childdatestart" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x-1%>"><%=Year.getCurrentYear() - x-1%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                        <div style="width: 50px">And:</div>   
                                                        <select id="childdateend" name="childdateend" class="chzn-select input input-xlarge " >
                                                            <%
                                                                for (int x = 0; x < 10; x++) {
                                                            %>
                                                            <option value="<%=Year.getCurrentYear() - x%>"><%=Year.getCurrentYear() - x%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button id="child" type="button" name="child" class="btn btn-primary">See Health Review of Children Ages 0-5</button>
                                                </div>
                                            </form>
                                        </div>

                                        <!--Project Evaluation-->
                                        <div id="report8" style="display: none;">
                                            <form class="form-horizontal" method="GET" action="ReportProject">
                                                <div class="control-group">
                                                    <label class="control-label" for="project">Select Project</label>
                                                    <div class="controls">
                                                        <select id="project" name="project" class="chzn-select input input-xlarge " >
                                                            <%
                                                                List<UnavailableProjectEntity> charter = (List<UnavailableProjectEntity>) request.getAttribute("charter");
                                                                for (int x = 0; x < charter.size(); x++) {
                                                            %>
                                                            <option value="<%=charter.get(x).getProject_id()%>"><%=charter.get(x).getTitle()%> </option> 
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button type="submit" name="projectEval" class="btn btn-primary">See Project Evaluation Report</button>
                                                </div>
                                            </form>
                                        </div>

                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/span-->
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

        <script src="../jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>

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

        <script type="text/javascript">

            $(document).ready(function() {
                $('#top10Button').click(function() {
                    var x = $('#datefrom').val();
                    var y = $('#dateto').val();
                    if (x < y) {
                        $('#top10Form').submit();
                    } else {
                        alert("Please Input Valid Dates");
                    }
                });

                $('#annual').click(function() {
                    var x = $('#datestart').val();
                    var y = $('#dateend').val();
                    if (x < y) {
                        $('#annualForm').submit();
                    } else {
                        alert("Please Input Valid Dates");
                    }
                });
                
                $('#magnitude').click(function() {
                    var x = $('#magdatestart').val();
                    var y = $('#magdateend').val();
                    if (x < y) {
                        $('#magnitudeForm').submit();
                    } else {
                        alert("Please Input Valid Dates");
                    }
                });
                
                $('#yearend').click(function() {
                    var x = $('#yrenddatestart').val();
                    var y = $('#yrenddateend').val();
                    if (x < y) {
                        $('#yearendForm').submit();
                    } else {
                        alert("Please Input Valid Dates");
                    }
                });
                
                $('#cancel').click(function() {
                    var x = $('#canceldatestart').val();
                    var y = $('#canceldateend').val();
                    if (x < y) {
                        $('#cancelForm').submit();
                    } else {
                        alert("Please Input Valid Dates");
                    }
                });
                
                 $('#comm').click(function() {
                    var x = $('#commdatestart').val();
                    var y = $('#commdateend').val();
                    if (x < y) {
                        $('#commForm').submit();
                    } else {
                        alert("Please Input Valid Dates");
                    }
                });
                
                 $('#child').click(function() {
                    var x = $('#childdatestart').val();
                    var y = $('#childdateend').val();
                    if (x < y) {
                        $('#childForm').submit();
                    } else {
                        alert("Please Input Valid Dates");
                    }
                });


                $('#reportType').on('change', function() {
                    if (this.value == 0) {
                        $('#report1').slideUp();
                        $('#report2').slideUp();
                        $('#report3').slideUp();
                        $('#report4').slideUp();
                        $('#report5').slideUp();
                        $('#report6').slideUp();
                        $('#report7').slideUp();
                        $('#report8').slideUp();
                    } else if (this.value == 1) {
                        $('#report1').slideDown();
                        $('#report2').slideUp();
                        $('#report3').slideUp();
                        $('#report4').slideUp();
                        $('#report5').slideUp();
                        $('#report6').slideUp();
                        $('#report7').slideUp();
                        $('#report8').slideUp();
                    } else if (this.value == 2) {
                        $('#report1').slideUp();
                        $('#report2').slideDown();
                        $('#report3').slideUp();
                        $('#report4').slideUp();
                        $('#report5').slideUp();
                        $('#report6').slideUp();
                        $('#report7').slideUp();
                        $('#report8').slideUp();
                    } else if (this.value == 3) {
                        $('#report1').slideUp();
                        $('#report2').slideUp();
                        $('#report3').slideDown();
                        $('#report4').slideUp();
                        $('#report5').slideUp();
                        $('#report6').slideUp();
                        $('#report7').slideUp();
                        $('#report8').slideUp();
                    } else if (this.value == 4) {
                        $('#report1').slideUp();
                        $('#report2').slideUp();
                        $('#report3').slideUp();
                        $('#report4').slideDown();
                        $('#report5').slideUp();
                        $('#report6').slideUp();
                        $('#report7').slideUp();
                        $('#report8').slideUp();
                    } else if (this.value == 5) {
                        $('#report1').slideUp();
                        $('#report2').slideUp();
                        $('#report3').slideUp();
                        $('#report4').slideUp();
                        $('#report5').slideDown();
                        $('#report6').slideUp();
                        $('#report7').slideUp();
                        $('#report8').slideUp();
                    } else if (this.value == 6) {
                        $('#report1').slideUp();
                        $('#report2').slideUp();
                        $('#report3').slideUp();
                        $('#report4').slideUp();
                        $('#report5').slideUp();
                        $('#report6').slideDown();
                        $('#report7').slideUp();
                        $('#report8').slideUp();
                    } else if (this.value == 7) {
                        $('#report1').slideUp();
                        $('#report2').slideUp();
                        $('#report3').slideUp();
                        $('#report4').slideUp();
                        $('#report5').slideUp();
                        $('#report6').slideUp();
                        $('#report7').slideDown();
                        $('#report8').slideUp();
                    } else if (this.value == 8) {
                        $('#report1').slideUp();
                        $('#report2').slideUp();
                        $('#report3').slideUp();
                        $('#report4').slideUp();
                        $('#report5').slideUp();
                        $('#report6').slideUp();
                        $('#report7').slideUp();
                        $('#report8').slideDown();
                    }
                });
            });

        </script>
    </body>
</html>