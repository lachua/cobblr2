<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="Utilities.CompareDate"%>
<%@page import="java.util.Calendar"%>
<%@page import="dbentities.UnavailableProjectEntity"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Admin Simplenso - Forms</title>
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
        <style>
                    body{
                        min-width:1300px;
                    }
        </style>

        <style>
            .pagination ul {
                background-color: white;
            }
        </style>

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../images/ico/favicon.ico" />
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../images/ico/apple-touch-icon-144-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../images/ico/apple-touch-icon-114-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../images/ico/apple-touch-icon-72-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" href="../images/ico/apple-touch-icon-57-precomposed.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body id="forms">
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
                    </div><!--/span-->

                    <!-- Bread Crumb Navigation -->
                    <div class="span10">
                    <jsp:include page="ProjectsShortcut.jsp"></jsp:include>
                        <div class="row-fluid">
                            <div class="span12" id="col0">
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Projects Implemented</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <form method="POST" action="ProjectImplemented">
                                            <%
                                                List<UnavailableProjectEntity> closedProj = (List<UnavailableProjectEntity>) request.getAttribute("closedProj");
                                            %>
                                            <table class="table table-striped table-bordered table-condensed" id="dtable">
                                                <thead>
                                                    <tr>
                                                        <th>Project Title</th>
                                                        <th>Type</th>
                                                        <th>Community</th>
                                                        <th>Location</th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                    </tr>
                                                    <tr>
                                                        <th>Project Title</th>
                                                        <th>Project Type</th>
                                                        <th>Partner Community</th>
                                                        <th>Location</th>
                                                        <th>Description</th>
                                                        <th>Student Name</th>
                                                        <th>Student Contact No.</th>
                                                        <th>Implementation Date</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%for (int x = 0; x < closedProj.size(); x++) {%>
                                                    <tr>
                                                        <td><%=closedProj.get(x).getTitle()%></td>
                                                        <td><%=closedProj.get(x).getType()%></td>
                                                        <td><%=closedProj.get(x).getCommunity_name()%></td>
                                                        <td><%=closedProj.get(x).getCommunity_address()%></td>
                                                        <td><%=closedProj.get(x).getDescription()%></td>
                                                        <td><%=closedProj.get(x).getStudent_firstname()%> <%=closedProj.get(x).getStudent_lastname()%></td>
                                                        <td><%=closedProj.get(x).getStudent_mobileno()%></td>
                                                        <%
                                                            if (CompareDate.getDateDiff(closedProj.get(x).getMeetingdate(), TimeUnit.DAYS) < -7) {
                                                        %>
                                                        <td><span class="badge badge-warning"><%=closedProj.get(x).getMeetingdate()%></span></td>
                                                            <%} else {%>
                                                        <td><span class="badge badge-info"><%=closedProj.get(x).getMeetingdate()%></span></td>
                                                            <%}%>
                                                        <td>
                                                            <button name="ViewFullProjectCharter" value="<%=closedProj.get(x).getProject_id()%>" class="btn btn-inverse">Details</button>
                                                            <button name="WorkStructure" value="<%=closedProj.get(x).getProject_id()%>-<%=closedProj.get(x).getType()%>" class="btn btn-inverse">Tasks</button>
                                                        </td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                            </from>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/.fluid-container-->
        <!-- javascript Templates
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- Google API -->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>

        <!-- jQuery -->
        <script src="../jquery/1.8.3/jquery.min.js"></script>

        <!-- Data Tables -->
        <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

        <!-- jQuery UI Sortable -->
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.core.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.mouse.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.sortable.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>

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

        <script src="../bootstrap/js/jquery-ui.js" type="text/javascript"></script>
        <script src="../bootstrap/js/jquery.dataTables.columnFilter.js" type="text/javascript"></script>
        <script type="text/javascript" charset="utf-8">
            <%
                List<UnavailableProjectEntity> closedProjList = (List<UnavailableProjectEntity>) request.getAttribute("closedProjList");
            %>
            $(document).ready(function() {
                $('#dtable th').bind('mouseup', function(event) {
                    var index = $(this).parent().children().index($(this));
                    var colWidth = $(this).css('width');
                    var input = $('#dtable thead tr:nth-child(2) input:eq(' + index + ')');
                    input.css("width", colWidth);
                });
                $('#dtable').dataTable({
                "sPaginationType": "bootstrap",
                        "aaSorting": [[7, "asc"]]
                }).columnFilter({
                sPlaceHolder: "head:after",
                        aoColumns: [
                                {},
                        {type: "twitter-dropdown", values: ['Dental Mission', 'Medical Mission', 'Medical-Dental Mission', 'Seminar']},
                        {type: "twitter-dropdown", values: [
            <%
                for (int x = 0; x < closedProjList.size(); x++) {
            %>
                        '<%=closedProjList.get(x).getCommunity_name()%>',
            <%
                }
            %>
                        ]},
                        {type: "twitter-dropdown", values: [
            <%
                for (int x = 0; x < closedProjList.size(); x++) {
            %>
                        '<%=closedProjList.get(x).getCommunity_address()%>',
            <%
                }
            %>
                        ]},
                                null,
                                null,
                                null,
                                null,
                                null
                        ]

            });
            $('#dtable thead tr:nth-child(2)').find(':input').each(function(index) {
                var colWidth = $('#dtable thead tr:nth-child(2) th:eq(' + index + ')').css('width');
                $(this).css("width", colWidth);
            });
            });

        </script>
    </body>
</html>