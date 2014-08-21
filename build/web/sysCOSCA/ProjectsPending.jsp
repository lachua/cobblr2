<%@page import="dbentities.OrgProjectEntity"%>
<%@page import="dbdao.OrgProjectDAO"%>
<%@page import="dbentities.ProjectCharterAndDatesEntity"%>
<%@page import="dbdao.ProjectCharterAndDatesDAO"%>
<%@page import="dbentities.ProjectCharterEntity"%>
<%@page import="dbdao.ProjectCharterDAO"%>
<%@page import="dbentities.ProjectCharterDateEntity"%>
<%@page import="dbdao.ProjectCharterDateDAO"%>
<%@page import="Utilities.CompareDate"%>
<%@page import="java.util.Calendar"%>
<%@page import="dbentities.UnavailableProjectEntity"%>
<%@page import="dbentities.AvailableProjectEntity"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Pending Projects</title>
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
                        
                    <jsp:include page="Navuserbar.jsp"></jsp:include>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div><!--/span-->

                    <!-- Bread Crumb Navigation -->
                    <div class="span10">
                    <jsp:include page="ProjectsShortcut.jsp"></jsp:include>
                        <div class="row-fluid">
                            <div class="span12" id="col0">
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Projects Pending</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <form method="POST" action="ProjectsPending">
                                            <%
                                                List<UnavailableProjectEntity> unavailableProj = (List<UnavailableProjectEntity>) request.getAttribute("unavailableProj");
                                                    
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
                                                        <th></th>
                                                    </tr>
                                                    <tr>
                                                        <th>Project Title</th>
                                                        <th>Project Type</th>
                                                        <th>Partner Community</th>
                                                        <th>Location</th>
                                                        <th>Description</th>
                                                        <th>Partner Organization</th>
                                                        <th>Student Name</th>
                                                        <th>Student Contact No.</th>
                                                        <th>Meeting Date</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        for (int x = 0; x < unavailableProj.size(); x++) {
                                                           OrgProjectDAO partnerdao = new OrgProjectDAO();
                                                            List<OrgProjectEntity> partners = partnerdao.getpartners(unavailableProj.get(x).getProject_id() , unavailableProj.get(x).getOrg_id());
                                                    %>
                                                    <tr>
                                                        <td><%=unavailableProj.get(x).getTitle()%></td>
                                                        <td><%=unavailableProj.get(x).getType()%></td>
                                                        <td><%=unavailableProj.get(x).getCommunity_name()%></td>
                                                        <td><%=unavailableProj.get(x).getCommunity_address()%></td>
                                                        <td><%=unavailableProj.get(x).getDescription()%></td>
                                                        <td>
                                                            <%=unavailableProj.get(x).getOrg_name()%>  
                                                            <br>
                                                            <ul>
                                                            <%for (OrgProjectEntity partner : partners){ %>
                                                            <li style="font-size: smaller"><%=partner.getOrgName() %></li>
                                                            <%}%>
                                                            </ul>
                                                        </td>
                                                        <td>
                                                            <%=unavailableProj.get(x).getStudent_firstname()%> <%=unavailableProj.get(x).getStudent_lastname()%>
                                                            <br>
                                                            <ul>
                                                            <%for (OrgProjectEntity partner : partners){ %>
                                                            <li style="font-size: smaller"><%=partner.getFirstname() %> <%=partner.getLastname() %></li>
                                                            <%}%>
                                                            </ul>
                                                        </td>
                                                        <td>
                                                            <%=unavailableProj.get(x).getStudent_mobileno()%>
                                                             <br>
                                                            <ul>
                                                            <%for (OrgProjectEntity partner : partners){ %>
                                                            <li style="font-size: smaller"><%=partner.getMobileno()%></li>
                                                            <%}%>
                                                            </ul>
                                                        </td>
                                                        <%
                                                            if (CompareDate.compareDates(unavailableProj.get(x).getMeetingdate()) < 0) {
                                                        %>
                                                        <td>
                                                            <span class="badge badge-info"><%=unavailableProj.get(x).getMeetingdate()%></span>
                                                        </td>
                                                            <%} else if (CompareDate.compareDates(unavailableProj.get(x).getMeetingdate()) > 0) {%>
                                                        <td>
                                                            <span class="badge badge-important"><%=unavailableProj.get(x).getMeetingdate()%></span>
                                                        </td>
                                                            <%} else {%>
                                                        <td>
                                                            <span class="badge badge-warning"><%=unavailableProj.get(x).getMeetingdate()%></span>
                                                        </td>
                                                            <%}%>
                                                        <td><button name="ConfirmProject" value="<%=unavailableProj.get(x).getProject_id()%>" class="btn btn-primary">Details</button></td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </form>
                                    </div>
                                </div>
                            </div><!--/span-->
                        </div>   
                    </div>

                    <div class="row-fluid">
                        <div class="span12" id="col0">
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Projects Confirmed</h4>
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <form method="GET" action="ViewInitialProjectCharterConfirmed">
                                            <%
                                                List<UnavailableProjectEntity> confirmedProj = (List<UnavailableProjectEntity>) request.getAttribute("confirmedProj");
                                            %>
                                            <table class="table table-striped table-bordered table-condensed" id="dtable2">
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
                                                        <th></th>
                                                    </tr>
                                                    <tr>
                                                        <th>Project Title</th>
                                                        <th>Project Type</th>
                                                        <th>Partner Community</th>
                                                        <th>Location</th>
                                                        <th>Description</th>
                                                        <th>Partner Organization</th>
                                                        <th>Student Name</th>
                                                        <th>Student Contact No.</th>
                                                        <th>Date Confirmed</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%for (int x = 0; x < confirmedProj.size(); x++) {
                                                           OrgProjectDAO partnerdao = new OrgProjectDAO();
                                                            List<OrgProjectEntity> partners = partnerdao.getpartners(confirmedProj.get(x).getProject_id() , confirmedProj.get(x).getOrg_id());%>
                                                    <tr>
                                                        <td><%=confirmedProj.get(x).getTitle()%></td>
                                                        <td><%=confirmedProj.get(x).getType()%></td>
                                                        <td><%=confirmedProj.get(x).getCommunity_name()%></td>
                                                        <td><%=confirmedProj.get(x).getCommunity_address()%></td>
                                                        <td><%=confirmedProj.get(x).getDescription()%></td>
                                                        <td><%=confirmedProj.get(x).getOrg_name()%>
                                                            <br>
                                                            <ul>
                                                            <%for (OrgProjectEntity partner : partners){ %>
                                                            <li style="font-size: smaller"><%=partner.getOrgName() %></li>
                                                            <%}%>
                                                            </ul></td>
                                                        <td><%=confirmedProj.get(x).getStudent_firstname()%> <%=confirmedProj.get(x).getStudent_lastname()%>
                                                            <ul>
                                                            <%for (OrgProjectEntity partner : partners){ %>
                                                            <li style="font-size: smaller"><%=partner.getFirstname() %> <%=partner.getLastname() %></li>
                                                            <%}%>
                                                            </ul></td>
                                                        <td><%=confirmedProj.get(x).getStudent_mobileno()%>
                                                             <br>
                                                            <ul>
                                                            <%for (OrgProjectEntity partner : partners){ %>
                                                            <li style="font-size: smaller"><%=partner.getMobileno()%></li>
                                                            <%}%>
                                                            </ul></td>
                                                        <%
                                                            ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
                                                            ProjectCharterDateEntity projdate = project_date.getProjectDate(confirmedProj.get(x).getProject_id());
                                                            if (CompareDate.compareDates(projdate.getDate_confirmed()) < 0) {
                                                        %>
                                                        <td><span class="badge badge-info"><%=projdate.getDate_confirmed()%></span>
                                                            <%} else if (CompareDate.compareDates(projdate.getDate_confirmed()) > 0) {%>
                                                        <td><span class="badge badge-important"><%=projdate.getDate_confirmed()%></span>
                                                            <%} else {%>
                                                        <td><span class="badge badge-warning"><%=projdate.getDate_confirmed()%></span>
                                                            <%}%>
                                                        <td><button name="ConfirmedDetails" value="<%=confirmedProj.get(x).getProject_id()%>" class="btn btn-inverse">Details</button></td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </form>
                                    </div>
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
                List<UnavailableProjectEntity> unavailableProjList = (List<UnavailableProjectEntity>) request.getAttribute("unavailableProjList");
                List<UnavailableProjectEntity> confirmedProjList = (List<UnavailableProjectEntity>) request.getAttribute("confirmedProjList");
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
        "aaSorting": [[8, "asc"]]
                    }).columnFilter({
                    sPlaceHolder: "head:after",
        aoColumns: [
                            {},
        {type: "twitter-dropdown", values: ['Dental Mission', 'Medical Mission', 'Medical-Dental Mission', 'Seminar']},
                            {type: "twitter-dropdown", values: [
            <%
                for (int x = 0; x < unavailableProjList.size(); x++) {
            %>
                            '<%=unavailableProjList.get(x).getCommunity_name()%>',
            <%
}
            %>
                            ]},
                            {type: "twitter-dropdown", values: [
            <%
for (int x = 0; x < unavailableProjList.size(); x++) {
            %>
                                    '<%=unavailableProjList.get(x).getCommunity_address()%>',
            <%
}
            %>
                            ]},
                                    null,
                                    null,
                    null,                                     null,
                            null,
                                    null
                    ]

                            });
                    $('#dtable thead tr:nth-child(2)').find(':input').each(function(index) {
                            var colWidth = $('#dtable thead tr:nth-child(2) th:eq(' + index + ')').css('width');
                            $(this).css("width", colWidth);
                });
                
                //dtable2
                            $('#dtable2 th').bind('mouseup', function(event) {
                            var index = $(this).parent().children().index($(this));
                            var colWidth = $(this).css('width');
                    var input = $('#dtable2 thead tr:nth-child(2) input:eq(' + index + ')');
                            input.css("width", colWidth);
                            });
                            $('#dtable2').dataTable({
                    "sPaginationType": "bootstrap",
                            "aaSorting": [[8, "asc"]]
                    }).columnFilter({
                    sPlaceHolder: "head:after",
                            aoColumns: [
                            {},
                            {type: "twitter-dropdown", values: ['Dental Mission', 'Medical Mission', 'Medical-Dental Mission', 'Seminar']},
                            {type: "twitter-dropdown", values: [
            <%
                for (int x = 0; x < unavailableProjList.size(); x++) {
            %>
                            '<%=unavailableProjList.get(x).getCommunity_name()%>',
            <%
                }
            %>
                                    ]},
                                    {type: "twitter-dropdown", values: [
            <%
                for (int x = 0; x < unavailableProjList.size(); x++) {
            %>
                            '<%=unavailableProjList.get(x).getCommunity_address()%>',
            <%
                }
            %>
                    ]},
                                    null,
                                    null,
                            null,
                    null,
                    null,
                                    null
                            ]

                });
                $('#dtable2 thead tr:nth-child(2)').find(':input').each(function(index) {
                    var colWidth = $('#dtable2 thead tr:nth-child(2) th:eq(' + index + ')').css('width');
                    $(this).css("width", colWidth);
                });
                });

        </script>
    </body>
</html>