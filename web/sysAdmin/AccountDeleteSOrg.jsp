
<%@page import="dbentities.UserEntity"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Delete Account</title>
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

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../images/ico/favicon.ico" />
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../images/ico/apple-touch-icon-144-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../images/ico/apple-touch-icon-114-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../images/ico/apple-touch-icon-72-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" href="../images/ico/apple-touch-icon-57-precomposed.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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
                            <div class="box">
                                <h4 class="box-header round-top">Delete Existing Account</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        
                                        <form id="createForm" method="POST" action="AccountDeleteSOrg" class="form-horizontal">
                                        <fieldset>
                                            <legend>Delete Existing Account</legend>
                                            <div class="control-group">
                                                <label class="control-label" for="type">Account Type:</label>
                                                <div class="controls">
                                                    <select id="type" name="type" class="chzn-select">
                                                        <option value="1">COSCA</option>
                                                        <option value="2">Student Organization</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div id="coscaDiv">
                                                <%List<UserEntity> cosca = (List<UserEntity>) request.getAttribute("cosca");%>
                                                <div class="control-group" id="StudentOrg">
                                                    <label class="control-label" for="coscaAccts">Account Name:</label>
                                                    <div class="controls">
                                                        <select id="coscaAccts" name="coscaAccts" class="chzn-select">
                                                            <%for(int x = 0; x < cosca.size(); x++){%>
                                                            <option value="<%=cosca.get(x).getUsername()%>"><%=cosca.get(x).getUsername()%></option>
                                                            <%}%>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="studentDiv" hidden>
                                                <%List<UserEntity> sorg = (List<UserEntity>) request.getAttribute("sorg");%>
                                                <div class="control-group">
                                                    <label class="control-label" for="studentAccts">Account Name:</label>
                                                    <div class="controls">
                                                        <select id="studentAccts" name="studentAccts" class="chzn-select">
                                                            <%for(int x = 0; x < sorg.size(); x++){%>
                                                            <option value="<%=sorg.get(x).getUsername()%>"><%=sorg.get(x).getUsername()%></option>
                                                            <%}%>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-actions">
                                                <button type="submit" class="btn btn-primary">Delete Account</button>
                                                <a href="AdminHome" class="btn">Cancel</a>
                                            </div>
                                        </fieldset>
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
        
        <!-- Data Tables -->
        <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

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
        
        <!-- JQuery Valdation -->
        <script src="../jquery/jquery-validate/jquery.validate.js"></script>
        <script>
            $('#type').on('change', function() {
                    if (this.value == 1) {
                        $('#coscaDiv').slideDown();
                        $('#studentDiv').slideUp();
                    } else if (this.value == 2) {
                        $('#coscaDiv').slideUp();
                        $('#studentDiv').slideDown();
                    }
            });
            
            // validate signup form on keyup and submit
            $("#createForm").validate({
                rules: {
                    newpassword: {
                        minlength: 5
                    },
                    confpassword: {
                        minlength: 5,
			equalTo: "#newpassword"
                    }
                }
            });
        </script>
    </body>
</html>