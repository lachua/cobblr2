<%@page import="dbentities.UnavailableProjectEntity"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Admin Simplenso - Tables</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="HTML5 Admin Simplenso Template" />
        <meta name="author" content="ahoekie" />

        <!-- Bootstrap -->
        <link href="../bootstrap/css/bootstrap.css" rel="stylesheet" id="main-theme-script" />
        <link href="../css/themes/default.css" rel="stylesheet" id="theme-specific-script" />
        <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />

        <!-- Full Calender -->
        <link rel="stylesheet" type="text/css" href="../scripts/fullcalendar/fullcalendar/fullcalendar.css" />

        <!-- Bootstrap Date Picker --> 
        <link href="../scripts/datepicker/css/datepicker.css" rel="stylesheet" />

        <!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
        <link rel="stylesheet" href="../scripts/blueimp-jQuery-File-Upload/css/jquery.fileupload-ui.css" />

        <!-- Bootstrap Image Gallery styles -->
        <link rel="stylesheet" href="../css/bootstrap-image-gallery.min.css" />

        <!-- Uniform -->
        <link rel="stylesheet" type="text/css" media="screen,projection" href="../scripts/uniform/css/uniform.default.css" />

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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

    <body id="forms">
        <!-- Top navigation bar -->
        <jsp:include page="Navtopbar.jsp"></jsp:include>
            <!-- Main Content Area | Side Nav | Content -->    
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span2">
                        
                    <jsp:include page="Navuserbar.jsp"></jsp:include>     
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div><!--/span-->

                    <!-- Bread Crumb Navigation -->
                    <div class="span10">
                    <jsp:include page="ProjectsShortcut.jsp"></jsp:include>
                        <div class="row-fluid">
                            <!-- Portlet Set 1 -->
                            <div class="span12">
                                <!-- Portlet: Fancy Portlets -->
                                <div class="box">
                                    <h4 class="box-header round-top">Closing Survey for Volunteers/Student Organizations</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                        <%
                                            UnavailableProjectEntity closedProj = (UnavailableProjectEntity) request.getAttribute("closedProj");
                                        %>

                                        <h1><%=closedProj.getTitle()%></h1>
                                        <ul class="dashboard-member-activity">
                                            <li>
                                                <strong>Type: </strong> <%=closedProj.getType()%><br />
                                                <strong>Partner Community: </strong> <%=closedProj.getCommunity_name()%><br />
                                                <strong>Location: </strong> <%=closedProj.getCommunity_address()%><br/>
                                                <strong>Description: </strong> <%=closedProj.getDescription()%> <br/> 
                                                <strong>Project Deadline: </strong> <span id="dateChange" class="badge badge-inverse"> <%=closedProj.getMeetingdate()%> </span><br/><br/>
                                            </li>
                                        </ul>
                                        <form id="surveyForm" method="POST" action="SurveyOrg" class="form-horizontal" enctype="multipart/form-data">
                                            <legend>Check the box that applies to your answer to the indicated objective.</legend>
                                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tables">
                                                <thead>
                                                    <tr>
                                                        <th>Overall Activity Objectives</th>
                                                        <th>Strongly Agree</th>
                                                        <th>Agree</th>
                                                        <th>Neutral</th>
                                                        <th>Disagree</th>
                                                        <th>Strongly Disagree</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td> 1.	The activity was well-organized and flowed smoothly. </td>
                                                        <td ><input  type="radio" name="Q-51" id="Q-51" value="205" required/></td>
                                                        <td ><input  type="radio" name="Q-51" id="Q-51" value="204" /></td>
                                                        <td ><input  type="radio" name="Q-51" id="Q-51" value="203" /></td>
                                                        <td ><input  type="radio" name="Q-51" id="Q-51" value="202" /></td>
                                                        <td ><input  type="radio" name="Q-51" id="Q-51" value="201" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td> 2.	Registration procedures were conducted smoothly and effectively.</td>
                                                        <td ><input  type="radio" name="Q-52" id="Q-52" value="205" required/></td>
                                                        <td ><input  type="radio" name="Q-52" id="Q-52" value="204" /></td>
                                                        <td ><input  type="radio" name="Q-52" id="Q-52" value="203" /></td>
                                                        <td ><input  type="radio" name="Q-52" id="Q-52" value="202" /></td>
                                                        <td ><input  type="radio" name="Q-52" id="Q-52" value="201" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>3.	I was able aid and assist the medical practitioners properly and utilized my ability. </td>
                                                        <td ><input  type="radio" name="Q-53" id="Q-53" value="205" required/></td>
                                                        <td ><input  type="radio" name="Q-53" id="Q-53" value="204" /></td>
                                                        <td ><input  type="radio" name="Q-53" id="Q-53" value="203" /></td>
                                                        <td ><input  type="radio" name="Q-53" id="Q-53" value="202" /></td>
                                                        <td ><input  type="radio" name="Q-53" id="Q-53" value="201" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>4.	The resources (medicines, freebies, volunteers, etc.) were properly distributed in the activity were sufficient.</td>
                                                        <td ><input  type="radio" name="Q-54" id="Q-54" value="205" required/></td>
                                                        <td ><input  type="radio" name="Q-54" id="Q-54" value="204" /></td>
                                                        <td ><input  type="radio" name="Q-54" id="Q-54" value="203" /></td>
                                                        <td ><input  type="radio" name="Q-54" id="Q-54" value="202" /></td>
                                                        <td ><input  type="radio" name="Q-54" id="Q-54" value="201" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>5.	The activity provided quality services to the community. </td>
                                                        <td ><input  type="radio" name="Q-55" id="Q-55" value="205" required/></td>
                                                        <td ><input  type="radio" name="Q-55" id="Q-55" value="204" /></td>
                                                        <td ><input  type="radio" name="Q-55" id="Q-55" value="203" /></td>
                                                        <td ><input  type="radio" name="Q-55" id="Q-55" value="202" /></td>
                                                        <td ><input  type="radio" name="Q-55" id="Q-55" value="201" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>6.	The time allotted to the activity was sufficient to attend to the needs of the community.</td>
                                                        <td ><input  type="radio" name="Q-56" id="Q-56" value="205" required/></td>
                                                        <td ><input  type="radio" name="Q-56" id="Q-56" value="204" /></td>
                                                        <td ><input  type="radio" name="Q-56" id="Q-56" value="203" /></td>
                                                        <td ><input  type="radio" name="Q-56" id="Q-56" value="202" /></td>
                                                        <td ><input  type="radio" name="Q-56" id="Q-56" value="201" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>7.	I was able to serve the community and attend to the patients </td>
                                                        <td ><input  type="radio" name="Q-57" id="Q-57" value="205" required/></td>
                                                        <td ><input  type="radio" name="Q-57" id="Q-57" value="204" /></td>
                                                        <td ><input  type="radio" name="Q-57" id="Q-57" value="203" /></td>
                                                        <td ><input  type="radio" name="Q-57" id="Q-57" value="202" /></td>
                                                        <td ><input  type="radio" name="Q-57" id="Q-57" value="201" /></td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                            <div class="control-group">
                                                <label class="control-label"><strong>Other Comments:</strong></label>
                                                <div class="controls">
                                                    <textarea class="input-xxlarge html_editor_on_simple" name="Q-58" id="Q-58" rows="5"></textarea>
                                                </div>
                                            </div>

                                            <legend>Upload Survey from Community</legend>
                                            <div class="control-group">
                                                <label class="control-label" for="fileInput"><strong>File input:</strong><br/>Note: please upload the .csr file from the survey taken taken from the project implementation</label>
                                                <div class="controls">
                                                    <input name="surveyFile" id="surveyFile" class="input-file input-large" type="file" />
                                                </div>
                                            </div>

                                            <div class="form-actions">
                                                <button type="submit" class="btn btn-primary">Close Project</button>
                                                <a href="CloseProjects"  class="btn">Back</a>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


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

        <!-- jQuery UI Draggable & droppable -->
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.draggable.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.droppable.min.js"></script>

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

        <!-- jQuery -->
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/additional-methods.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                // validate signup form on keyup and submit
                $("#surveyForm").validate({
                    rules: {
                        surveyFile: {
                            required: true,
                            extension: "csr"
                        }},
                    messages: {
                        surveyFile: {
                            required: "This field is mandatory!",
                            extension: "Accepts only .csr file!"
                        }
                    }
                });
            });
        </script>
    </body>
</html>