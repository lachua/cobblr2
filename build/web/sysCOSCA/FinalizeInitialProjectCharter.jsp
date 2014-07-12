<%@page import="java.util.ArrayList"%>
<%@page import="dbentities.ProjectCharterTargetEntity"%>
<%@page import="dbentities.ProjectCharterAndDatesEntity"%>
<%@page import="java.util.List"%>
<%@page import="dbdao.OfferedAnswerDAO"%>
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

        <!-- Simplenso -->
        <link href="../css/simplenso.css" rel="stylesheet" />

        <!-- Renliw -->
        <link href="../css/renliw.css" rel="stylesheet" />

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        
        <style>
            tr td:first-child{
                font-weight: bold;
            }
            td:nth-child(2) {  
                font-size: 120%;
            }
            td:nth-child(3) {  
                font-style: italic;
            }
            td:nth-child(4) {  
                font-style: italic;
            }
            td:nth-child(5) {  
                font-style: italic;
            }
            td:nth-child(6) {  
                font-style: italic;
            }
        </style>

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
                                            <form method="POST" action="FinalizeInitialProjectCharter">
                                            <%
                                                String communityName = (String) request.getAttribute("communityName");
                                                ProjectCharterEntity initialCharter = (ProjectCharterEntity) request.getAttribute("initialCharter");
                                                String[] target_sickness = (String[]) request.getAttribute("target_sickness");
                                                String target_number = (String) request.getAttribute("target_number");
                                                List<ProjectCharterTargetEntity> pastCharters = ( List<ProjectCharterTargetEntity>) request.getAttribute("pastCharters");
                                                ArrayList<Integer> comIndex = new ArrayList();
                                                int comID = pastCharters.get(0).getId();
                                                comIndex.add(0);
                                                for(int x = 0; x < pastCharters.size(); x++){
                                                    if(comID != pastCharters.get(x).getId()){
                                                        comIndex.add(x);
                                                        comID = pastCharters.get(x).getId();
                                                    }
                                                }
                                            %>
                                            
                                            
                                            <h3>For Community: <%=communityName%></h3>
                                            <table class="table table-striped table-bordered" >
                                                <thead>
                                                    <tr>
                                                        <th></th>
                                                        <th>New Project</th>
                                                        <th colspan="3">Past Projects</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>asdas
                                                        <td>Project Title:</td>
                                                        <td width="30%"><%=initialCharter.getTitle() %></td>
                                                        <%for(int x = 0; x < comIndex.size(); x++){%>
                                                        <td><%=pastCharters.get(comIndex.get(x)).getTitle() %></td>
                                                        <%}%>
                                                    </tr>
                                                    <tr>
                                                        <td>Type of Project:</td>
                                                        <td><%=initialCharter.getType() %></td>
                                                        <%for(int x = 0; x < comIndex.size(); x++){%>
                                                        <td><%=pastCharters.get(comIndex.get(x)).getType()%></td>
                                                        <%}%>
                                                    </tr>
                                                    <tr>
                                                        <td>Target Concern(s):</td>
                                                        <td>
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
                                                        </td>
                                                        <%for(int x = 0; x < comIndex.size(); x++){%>
                                                        <td>
                                                            <ul>
                                                                <%
                                                                int currentCom = pastCharters.get(x).getId();
                                                                for(int y = comIndex.get(x); y < pastCharters.size(); y++){
                                                                  if(pastCharters.get(y).getId() ==  currentCom){
                                                                    OfferedAnswerDAO answer = new OfferedAnswerDAO();
                                                                    answertext = answer.getOfferedAnswer(pastCharters.get(y).getOfferedanswer_id()).getAnswertext();
                                                                %>
                                                                <li><%=answertext %></li>
                                                                <%}}%>
                                                            </ul>
                                                        </td>
                                                        <%}%>
                                                    </tr>
                                                    <tr>
                                                        <td>Brief Description:</td>
                                                        <td><%=initialCharter.getDescription() %></td>
                                                        <%for(int x = 0; x < comIndex.size(); x++){%>
                                                        <td><%=pastCharters.get(comIndex.get(x)).getDescription()%></td>
                                                        <%}%>
                                                    </tr>
                                                    <tr>
                                                        <td>Main Objective:</td>
                                                        <td><%=initialCharter.getObjectives() %></td>
                                                        <%for(int x = 0; x < comIndex.size(); x++){%>
                                                        <td><%=pastCharters.get(comIndex.get(x)).getObjectives()%></td>
                                                        <%}%>
                                                    </tr>
                                                    <tr>
                                                        <td>Number of Beneficiaries:</td>
                                                        <td><%=target_number %></td>
                                                        <%for(int x = 0; x < comIndex.size(); x++){%>
                                                        <td><%=pastCharters.get(comIndex.get(x)).getTarget_participant_num()%></td>
                                                        <%}%>
                                                    </tr>
                                                    <tr>
                                                        <td>Project Scope:</td>
                                                        <td><%=initialCharter.getScope() %></td>
                                                        <%for(int x = 0; x < comIndex.size(); x++){%>
                                                        <td><%=pastCharters.get(comIndex.get(x)).getScope()%></td>
                                                        <%}%>
                                                    </tr>
                                                    <tr>
                                                        <td>Additional Requirements:</td>
                                                        <td><%=initialCharter.getRequirements() %></td>
                                                        <%for(int x = 0; x < comIndex.size(); x++){%>
                                                        <td><%=pastCharters.get(comIndex.get(x)).getRequirements()%></td>
                                                        <%}%>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            
                                            <div class="form-actions">
                                                <button name="action" value="ProjectList" type="submit" class="btn btn-primary">Finish</button>
                                                <a href="CreateInitialProjectCharter" class="btn">Back</a>
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