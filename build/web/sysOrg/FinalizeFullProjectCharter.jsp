<%@page import="dbdao.OfferedAnswerDAO"%>
<%@page import="dbentities.UnavailableProjectEntity"%>
<%@page import="dbentities.ProjectCharterEntity"%>
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

        <!-- Chosen multiselect -->
        <link type="text/css" href="../scripts/chosen/chosen/chosen.intenso.css" rel="stylesheet" />   

        <!-- Bootstrap Date Picker --> 
        <link href="../scripts/datepicker/css/datepicker.css" rel="stylesheet" />

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
                    <!-- Side Navigation -->
                    <div class="span2">
                        
                    <jsp:include page="Navuserbar.jsp"></jsp:include>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div><!--/span-->

                    <div class="span10">

                        <div class="row-fluid">
                            <div class="span12">
                                <!-- Portlet: Browser Usage Graph -->
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Initial Project Charter</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <!-- The file upload form used as target for the file upload widget -->
                                            <form method="POST" action="FinalizeFullProjectCharter">
                                            <%
                                                UnavailableProjectEntity fullCharter = (UnavailableProjectEntity) request.getAttribute("fullCharter");
                                                String[] target_sickness = (String[]) request.getAttribute("target_sickness");
                                                String target_number = (String) request.getAttribute("target_number");
                                            %>
                                            <h3><%=fullCharter.getTitle()%></h3>
                                            <blockquote>
                                                <p><%=fullCharter.getType()%></p>
                                                <p>For Community: <%=fullCharter.getCommunity_name() %></p>
                                                <p>Prepared by: <%=fullCharter.getPreparedby()%></p>
                                                <p>Implementation Date: <%=fullCharter.getMeetingdate()%></p>
                                            </blockquote>

                                            <h3>Brief Description</h3>
                                            <blockquote>
                                                <p><%=fullCharter.getDescription()%></p>
                                            </blockquote>

                                            <h3>Main Objective</h3>
                                            <blockquote>
                                                <p><%=fullCharter.getObjectives()%></p>
                                            </blockquote>

                                            <h3>Target Concern(s)</h3>
                                            <blockquote>
                                                <ul>
                                                    <%
                                                    String answertext ="";
                                                    for(int x = 0; x < target_sickness.length; x++){
                                                        OfferedAnswerDAO answer = new OfferedAnswerDAO();
                                                        answertext = answer.getOfferedAnswer(Integer.parseInt(target_sickness[x])).getAnswertext();
                                                    %>
                                                    <li><%=answertext %></li>
                                                    <%}%>
                                                </ul>
                                            </blockquote>
                                            
                                            <h3>Number of Beneficiaries</h3>
                                            <blockquote>
                                                <p><%=target_number%> people</p>
                                            </blockquote>
                                            
                                            <h3>Project Scope</h3>
                                            <blockquote>
                                                <p><%=fullCharter.getScope()%></p>
                                            </blockquote>

                                            <h3>Additional Requirements</h3>
                                            <blockquote>
                                                <p><%=fullCharter.getRequirements()%></p>
                                            </blockquote>
                                            <div class="form-actions">
                                                <button name="action" value="CreateWorkStructure" type="submit" class="btn btn-primary">Finish</button>
                                                <a href="CreateFullProjectCharter" class="btn">Back</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--/span-->
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