<%@page import="Utilities.Compare"%>
<%@page import="java.util.List"%>
<%@page import="dbentities.ProjectTargetEntity"%>
<%@page import="dbdao.ProjectTargetDAO"%>
<%@page import="java.util.Date"%>
<%@page import="dbentities.ProjectCharterDateEntity"%>
<%@page import="dbdao.ProjectCharterDateDAO"%>
<%@page import="dbentities.UnavailableProjectEntity"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Edit Project Charter</title>
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
        
        <!-- Chosen multiselect -->
        <link type="text/css" href="../scripts/chosen/chosen/chosen.intenso.css" rel="stylesheet" />  

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
                        
                    <jsp:include page="Navuserbar.jsp"></jsp:include>
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
                                                            <%
                                                                ProjectCharterDateDAO project_date = new ProjectCharterDateDAO();
                                                                ProjectCharterDateEntity projdate = project_date.getProjectDate(unavailableProj.getProject_id());
                                                                Date date = new Date();
                                                                if(unavailableProj.getStatus() == 2){
                                                                    date = projdate.getDate_target_implement();
                                                                }else if(unavailableProj.getStatus() == 3){
                                                                    date = projdate.getDate_implemented();
                                                                }else if(unavailableProj.getStatus() == 4){
                                                                    date = projdate.getDate_closed();
                                                                }else if(unavailableProj.getStatus() == 6){
                                                                    date = projdate.getDate_cancelled();
                                                                }else{
                                                                    date = unavailableProj.getMeetingdate();
                                                                }
                                                            %>
                                                            <input type="text" class="form-control datepicker" style="width: 95%" id="date" name="date" value="<%=date%>"/>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <br>
                                            <h3>Project Objective</h3>
                                            <textarea style="width: 95%" class="form-control" rows="6" id="textArea" name="objective" value="<%=unavailableProj.getObjectives()%>"><%=unavailableProj.getObjectives()%></textarea>
                                            <br>
                                            <h3>Target Concern(s)</h3>
                                            <%
                                                ProjectTargetDAO targetDAO = new ProjectTargetDAO();
                                                List<ProjectTargetEntity> targets = targetDAO.getAllProjectTarget(unavailableProj.getProject_id());
                                            %>
                                            <select required style="width: 95%" class="chzn-select" id="target_sickness"  name="target_sickness" multiple >
                                                <optgroup label="If concerns below is not applicable:">
                                                    <option value="82" <%if(Compare.isProjectTarget(targets, 82)){%>selected<%}%>>Others</option>
                                                </optgroup>
                                                <optgroup label="Sicknesses:">
                                                    <option value="98" <%if(Compare.isProjectTarget(targets, 98)){%>selected<%}%>>Allergy</option>
                                                    <option value="99" <%if(Compare.isProjectTarget(targets, 99)){%>selected<%}%>>Altherosclerosis</option>
                                                    <option value="100" <%if(Compare.isProjectTarget(targets, 100)){%>selected<%}%>>Asthma</option>
                                                    <option value="101" <%if(Compare.isProjectTarget(targets, 101)){%>selected<%}%>>Coughs & Colds</option>
                                                    <option value="102" <%if(Compare.isProjectTarget(targets, 102)){%>selected<%}%>>Dengue</option>
                                                    <option value="103" <%if(Compare.isProjectTarget(targets, 103)){%>selected<%}%>>Diabetes</option>
                                                    <option value="104" <%if(Compare.isProjectTarget(targets, 104)){%>selected<%}%>>Gl Obstruction</option>
                                                    <option value="105" <%if(Compare.isProjectTarget(targets, 105)){%>selected<%}%>>Hemmorhage</option>
                                                    <option value="106" <%if(Compare.isProjectTarget(targets, 106)){%>selected<%}%>>KidneyStones</option>
                                                    <option value="107" <%if(Compare.isProjectTarget(targets, 107)){%>selected<%}%>>Overfatigue</option>
                                                    <option value="108" <%if(Compare.isProjectTarget(targets, 108)){%>selected<%}%>>Pneumonia</option>
                                                    <option value="109" <%if(Compare.isProjectTarget(targets, 109)){%>selected<%}%>>Renal Failure</option>
                                                    <option value="110" <%if(Compare.isProjectTarget(targets, 110)){%>selected<%}%>>Fever</option>
                                                </optgroup>
                                                <optgroup label="Child Vaccinations:">
                                                    <option value="223" <%if(Compare.isProjectTarget(targets, 223)){%>selected<%}%>>Flu</option>
                                                    <option value="224" <%if(Compare.isProjectTarget(targets, 224)){%>selected<%}%>>Hepatitis B</option>
                                                    <option value="225" <%if(Compare.isProjectTarget(targets, 225)){%>selected<%}%>>MVC1</option>
                                                    <option value="226" <%if(Compare.isProjectTarget(targets, 226)){%>selected<%}%>>MVC2</option>
                                                    <option value="227" <%if(Compare.isProjectTarget(targets, 227)){%>selected<%}%>>TT 2+</option>
                                                    <option value="228" <%if(Compare.isProjectTarget(targets, 228)){%>selected<%}%>>BGC</option>
                                                    <option value="229" <%if(Compare.isProjectTarget(targets, 229)){%>selected<%}%>>DTP</option>
                                                    <option value="230" <%if(Compare.isProjectTarget(targets, 230)){%>selected<%}%>>Rotavirus</option>
                                                    <option value="231" <%if(Compare.isProjectTarget(targets, 231)){%>selected<%}%>>Pneumococcal</option>
                                                    <option value="232" <%if(Compare.isProjectTarget(targets, 232)){%>selected<%}%>>OPV1</option>
                                                    <option value="233" <%if(Compare.isProjectTarget(targets, 233)){%>selected<%}%>>OPV3</option>
                                                </optgroup>
                                                <optgroup label="Child Vitamin Deficiency:">
                                                    <option value="216" <%if(Compare.isProjectTarget(targets, 216)){%>selected<%}%>>Vitamin A</option>
                                                    <option value="217" <%if(Compare.isProjectTarget(targets, 217)){%>selected<%}%>>Vitamin B12</option>
                                                    <option value="218" <%if(Compare.isProjectTarget(targets, 218)){%>selected<%}%>>Vitamin C</option>
                                                    <option value="219" <%if(Compare.isProjectTarget(targets, 219)){%>selected<%}%>>Vitamin D</option>
                                                    <option value="220" <%if(Compare.isProjectTarget(targets, 220)){%>selected<%}%>>Iron</option>
                                                    <option value="221" <%if(Compare.isProjectTarget(targets, 221)){%>selected<%}%>>Zinc</option>
                                                    <option value="222" <%if(Compare.isProjectTarget(targets, 222)){%>selected<%}%>>Multi-Vitamins</option>
                                                </optgroup>
                                                <optgroup label="Child Malnutrition:">
                                                    <option value="234" <%if(Compare.isProjectTarget(targets, 234)){%>selected<%}%>>Under weight</option>
                                                    <option value="236" <%if(Compare.isProjectTarget(targets, 236)){%>selected<%}%>>Over weight</option>
                                                    <option value="237" <%if(Compare.isProjectTarget(targets, 237)){%>selected<%}%>>Obese</option>
                                                </optgroup>
                                            </select>
                                            <br>
                                            <h3>Number of Beneficiaries</h3>
                                            <%
                                                    ProjectCharterDateDAO dateDAO = new ProjectCharterDateDAO();
                                                    ProjectCharterDateEntity dateEntity = dateDAO.getProjectDate(unavailableProj.getProject_id());
                                            %>
                                            <input style="width: 95%" class="form-control" type="number" id="target_number" name="target_number" min="1" value="<%=dateEntity.getTarget_participant_num()%>" required/>
                                            <br>
                                            <h3>Project Scope</h3>
                                            <textarea style="width: 95%" class="form-control" rows="6" id="textArea" name="scope" value="<%=unavailableProj.getScope()%>"><%=unavailableProj.getScope()%></textarea>
                                            <br>
                                            <h3>Additional Requirements</h3>
                                            <textarea style="width: 95%" class="form-control" rows="6" id="textArea" name="requirements" value="<%=unavailableProj.getRequirements()%>"><%=unavailableProj.getRequirements()%></textarea>
                                            <br>
                                            <div class="form-actions">
                                                <button name="action" value="FinalizeFullProjectCharter" type="submit" class="btn btn-primary">Finalize Project Requirements</button>
                                                <a href="SOrgHome" class="btn">Cancel</a>
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

        <!-- Chosen multiselect -->
        <script type="text/javascript" language="javascript" src="../scripts/chosen/chosen/chosen.jquery.min.js"></script>

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