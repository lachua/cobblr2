
<%@page import="java.util.List"%>
<%@page import="dbentities.StudentOrgEntity"%>
<%@page import="dbdao.StudentOrgDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Create Account</title>
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
                                <h4 class="box-header round-top">Create New Account</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        
                                        <form id="createForm" method="POST" action="AccountCreateSOrg" class="form-horizontal">
                                        <fieldset>
                                            <legend>Create New Account</legend>
                                            <%
                                                StudentOrgDAO dao;
                                                dao = new StudentOrgDAO();
                                                List<StudentOrgEntity> usg = dao.getOrgsUnder("USG");
                                                dao = new StudentOrgDAO();
                                                List<StudentOrgEntity> cso = dao.getOrgsUnder("CSO");
                                                
                                                if(request.getAttribute("isExisting") != null){ 
                                                    int type = (Integer)request.getAttribute("type");
                                                    String orgType = (String) request.getAttribute("orgType");
                                                    int usgId = (Integer) request.getAttribute("usgId");
                                                    int csoId = (Integer) request.getAttribute("csoId");
                                                    String newusername = (String) request.getAttribute("newusername");
                                            %>
                                            <div class="control-group">
                                                <label class="control-label" for="type">Account Type:</label>
                                                <div class="controls">
                                                    <select id="type" name="type" class="chzn-select">
                                                        <option value="1" <%if(type == 1){%>selected<%}%>>COSCA</option>
                                                        <option value="2" <%if(type == 2){%>selected<%}%>>Student Organization</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div id="studentinfo" <%if(type == 1){%>hidden<%}%>>
                                                <div class="control-group">
                                                    <label class="control-label" for="orgType">Organization Under:</label>
                                                    <div class="controls">
                                                        <select id="orgType" name="orgType" class="chzn-select">
                                                            <option value="USG" <%if(orgType.equals("USG")){%>selected<%}%>>USG</option>
                                                            <option value="CSO" <%if(orgType.equals("CSO")){%>selected<%}%>>CSO</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div id="usgorg">
                                                    <div class="control-group">
                                                        <label class="control-label" for="usgId">Organization Name:</label>
                                                        <div class="controls">
                                                            <select id="usgId" name="usgId" class="chzn-select">
                                                                <%for(int x = 0; x < usg.size(); x++){%>
                                                                    <option value="<%=usg.get(x).getId()%>" <%if(usgId == usg.get(x).getId()){%>selected<%}%>><%=usg.get(x).getName()%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div id="csoorg" hidden>
                                                    <div class="control-group">
                                                        <label class="control-label" for="csoId">Organization Name:</label>
                                                        <div class="controls">
                                                            <select id="csoId" name="csoId" class="chzn-select">
                                                                <%for(int x = 0; x < cso.size(); x++){%>
                                                                    <option value="<%=cso.get(x).getId()%>" <%if(csoId == cso.get(x).getId()){%>selected<%}%>><%=cso.get(x).getName()%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="newusername">Username:</label>
                                                <div class="controls">
                                                    <input type="text" id="newusername" name="newusername" placeholder="username" value="<%=newusername%>" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="newpassword">Password:</label>
                                                <div class="controls">
                                                    <input type="password" id="newpassword" name="newpassword" placeholder="password" value="" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="confpassword">Confirm Password:</label>
                                                <div class="controls">
                                                    <input type="password" id="confpassword" name="confpassword" placeholder="confirm password" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <div class="controls">
                                                    <span class=" badge badge-important">Username Already Taken</span>
                                                </div>
                                            </div>
                                            
                                            <%}else{%>
                                            
                                            <div class="control-group">
                                                <label class="control-label" for="type">Account Type:</label>
                                                <div class="controls">
                                                    <select id="type" name="type" class="chzn-select">
                                                        <option value="1">COSCA</option>
                                                        <option value="2">Student Organization</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div id="studentinfo" hidden>
                                                <div class="control-group" id="StudentOrg">
                                                    <label class="control-label" for="orgType">Organization Under:</label>
                                                    <div class="controls">
                                                        <select id="orgType" name="orgType" class="chzn-select">
                                                            <option value="USG">USG</option>
                                                            <option value="CSO">CSO</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div id="usgorg">
                                                    <div class="control-group">
                                                        <label class="control-label" for="usgId">Organization Name:</label>
                                                        <div class="controls">
                                                            <select id="usgId" name="usgId" class="chzn-select">
                                                                <%for(int x = 0; x < usg.size(); x++){%>
                                                                    <option value="<%=usg.get(x).getId() %>"><%=usg.get(x).getName()%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div id="csoorg" hidden>
                                                    <div class="control-group">
                                                        <label class="control-label" for="csoId">Organization Name:</label>
                                                        <div class="controls">
                                                            <select id="csoId" name="csoId" class="chzn-select">
                                                                <%for(int x = 0; x < cso.size(); x++){%>
                                                                    <option value="<%=cso.get(x).getId()%>"><%=cso.get(x).getName()%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="newusername">Username:</label>
                                                <div class="controls">
                                                    <input type="text" id="newusername" name="newusername" placeholder="username" value="" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="newpassword">Password:</label>
                                                <div class="controls">
                                                    <input type="password" id="newpassword" name="newpassword" placeholder="password" value="" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="confpassword">Confirm Password:</label>
                                                <div class="controls">
                                                    <input type="password" id="confpassword" name="confpassword" placeholder="confirm password" required/>
                                                </div>
                                            </div>
                                            <%}%>
                                            <div class="form-actions">
                                                <button type="submit" class="btn btn-primary">Add Account</button>
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
                        $('#studentinfo').slideUp();
                    } else if (this.value == 2) {
                        $('#studentinfo').slideDown();
                    }
            });
            
            $('#orgType').on('change', function() {
                    if (this.value == 'USG') {
                        $('#usgorg').slideDown();
                        $('#csoorg').slideUp();
                    } else if (this.value == 'CSO') {
                        $('#usgorg').slideUp();
                        $('#csoorg').slideDown();
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