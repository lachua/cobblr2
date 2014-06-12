<%@page import="dbentities.UnavailableProjectEntity"%>
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

        <!-- Simplenso -->
        <link href="../css/simplenso.css" rel="stylesheet" />

        <!-- Full Calender -->
        <link rel="stylesheet" type="text/css" href="../scripts/fullcalendar/fullcalendar/fullcalendar.css" />

        <!-- Bootstrap Date Picker --> 
        <link href="../scripts/datepicker/css/datepicker.css" rel="stylesheet" />

        <!-- Renliw -->
        <link href="../css/renliw.css" rel="stylesheet" />

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
                    <!-- Side Navigation -->
                    <div class="span2">
                        <div class="member-box round-all">
                            <a><img src="../images/member_ph.png" class="member-box-avatar" /></a>
                            <span>
                                <strong>USG</strong><br />
                                <a>CATCH2T14</a><br />
                                <span class="member-box-links"><a>Logout</a></span>
                            </span>
                        </div>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div><!--/span-->

                    <div class="span10">
                    <jsp:include page="ProjectsShortcut.jsp"></jsp:include> 
                        <div class="row-fluid">
                            <div class="span12">
                                <!-- Portlet: Browser Usage Graph -->
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Finalize Project Charter</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <form method="POST" action="CreateFullProjectCharter">
                                            <%
                                                 UnavailableProjectEntity fullCharter = (UnavailableProjectEntity) request.getAttribute("fullCharter");
                                                 UnavailableProjectEntity unavailableProj;
                                                 if(fullCharter == null){
                                                    unavailableProj = (UnavailableProjectEntity) request.getAttribute("unavailableProj");
                                                 }else{
                                                     unavailableProj = fullCharter;
                                                 }
                                            %>
                                            <legend><%=unavailableProj.getType()%> for <%=unavailableProj.getCommunity_name()%></legend>
                                           
                                            <table class="table table-bordered">
                                                <tbody>
                                                    <tr>
                                                        <td>Project Title</td>
                                                        <td> 
                                                            <input type="text" class="form-control" style="width: 95%" id="inputTitle" name="title" value="<%=unavailableProj.getTitle()%>"/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description</td>
                                                        <td> 
                                                            <textarea style="width: 95%" class="form-control" rows="6" id="textArea" name="description" value="<%=unavailableProj.getDescription()%>"><%=unavailableProj.getDescription()%></textarea>
                                                        </td>                                         
                                                    </tr>
                                                    <tr>
                                                        <td>Prepared By</td>
                                                        <td>
                                                            <input type="text" class="form-control" style="width: 95%" id="inputName" name="preparedby" value="<%=unavailableProj.getPreparedby()%>"/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Implementation Date</td>
                                                        <td>
                                                            <input type="text" class="form-control datepicker" style="width: 95%" id="date" name="date" value="<%=unavailableProj.getMeetingdate()%>"/>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <br>
                                            <h3>Project Objective</h3>
                                            <textarea style="width: 95%" class="form-control" rows="6" id="textArea" name="objective" value="<%=unavailableProj.getObjectives()%>"><%=unavailableProj.getObjectives()%></textarea>
                                            <br>
                                            <h3>Project Scope</h3>
                                            <textarea style="width: 95%" class="form-control" rows="6" id="textArea" name="scope" value="<%=unavailableProj.getScope()%>"><%=unavailableProj.getScope()%></textarea>
                                            <br>
                                            <h3>Additional Requirements</h3>
                                            <textarea style="width: 95%" class="form-control" rows="6" id="textArea" name="requirements" value="<%=unavailableProj.getRequirements()%>"><%=unavailableProj.getRequirements()%></textarea>
                                            <br>
                                            <div class="form-actions">
                                                <button name="action" value="FinalizeFullProjectCharter" type="submit" class="btn btn-primary">Finalize Project Requirements</button>
                                                <a href="SOrgHome" type="button" class="btn">Cancel</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/span-->
        </div><!--/row-->

        <!--===============================================================================-->
        <!-- jQuery -->
        <script src="../jquery/1.8.3/jquery.min.js"></script>

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
    </body>
</html>