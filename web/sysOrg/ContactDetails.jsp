
<%@page import="dbentities.UserEntity"%>
<%@page import="java.util.List"%>
<%@page import="dbentities.StudentOrgEntity"%>
<%@page import="dbdao.StudentOrgDAO"%>
<%@page import="dbentities.AvailableProjectEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Contact Details</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="HTML5 Admin Simplenso Template" />
        <meta name="author" content="ahoekie" />

        <!-- Bootstrap -->
        <link href="../bootstrap/css/bootstrap.css" rel="stylesheet" id="main-theme-script" />
        <link href="../css/themes/default.css" rel="stylesheet" id="theme-specific-script" />
        <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
        
        <!-- Chosen multiselect -->
        <link type="text/css" href="../scripts/chosen/chosen/chosen.intenso.css" rel="stylesheet" />   

        <!-- Uniform -->
        <link rel="stylesheet" type="text/css" media="screen,projection" href="../scripts/uniform/css/uniform.default.css" />

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
        <%
            UserEntity user = (UserEntity) request.getSession().getAttribute("UserEntity");          
            StudentOrgDAO dao = new StudentOrgDAO();
            List<StudentOrgEntity> entities = dao.getOrgsUnderExcept("CSO", "USG", user.getId());
        %>
        <textarea style="display:none" id="partnerOrgTemplate">
            <h4>Partner Organization no.{0}</h4>
            <div class="control-group">                                     
                <label class="control-label" for="mobileno">In Partnership with:</label>
                <div class="controls">
                    <select id="partnerOrgs" name="partnerOrgs" class="chzn-select partners">
                        <%for(int x = 0; x < entities.size(); x++){%>
                        <option value="<%=entities.get(x).getId()%>"><%=entities.get(x).getName() %></option>
                        <%}%>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="idno">ID No:</label>
                <div class="controls">
                    <input class="input-xlarge" id="idno" name="idno" type="number" placeholder="ID No." required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="first_name">First Name:</label>
                <div class="controls">
                    <input class="input-xlarge" id="first_name" name="first_name" type="text" placeholder="Frist Name" required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="last_name">Last Name:</label>
                <div class="controls">
                    <input class="input-xlarge" id="last_name" name="last_name" type="text" placeholder="Last Name" required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="position">Organization Position:</label>
                <div class="controls">
                    <input class="input-xlarge" id="position" name="position" type="text" placeholder="Position" required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="email">E-mail Address:</label>
                <div class="controls">
                    <input class="input-xlarge" id="email" name="email" type="email" placeholder="E-mail" required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="mobileno">Mobile Number:</label>
                <div class="controls">
                    <input class="input-xlarge" id="mobileno" name="mobileno" type="text" placeholder="Contact No." required/>
                </div>
            </div>
        </textarea>
        
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
                        <div>
                            <ul class="breadcrumb">
                                <li class="active">
                                    Select Project <span class="divider">/</span>
                                </li>
                                <li class="active">
                                    View Project Details <span class="divider">/</span>
                                </li>
                                <li>
                                    Contact Details<span class="divider">/</span>
                                </li>
                                <li class="active">
                                    Finish
                                </li>
                            </ul>
                        </div>

                        <div class="row-fluid">
                            <div class="span12" id="col0">
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Reservation</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <div class="span12">
                                                <h3>Reserve Project</h3>
                                                <div class="span8 alert alert-info">
                                                <%
                                                    AvailableProjectEntity availableProj = (AvailableProjectEntity) request.getAttribute("availableProject");                                          
                                                %>
                                                <ul class="dashboard-member-activity">
                                                    <li>
                                                        <strong>Project Title: <%=availableProj.getTitle()%> </strong><br />
                                                        <strong>Type: </strong> <%=availableProj.getType()%><br />
                                                        <strong>Partner Community: </strong> <%=availableProj.getCommunity_name()%><br />
                                                        <strong>Location: </strong> <%=availableProj.getCommunity_address()%><br/>
                                                        <strong>Description: </strong> <%=availableProj.getDescription()%> <br/>           
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>

                                        <form class="form-horizontal" method="POST" action="ContactDetails">
                                        <fieldset>
                                            <legend>Please Input Contact Details</legend>
                                            <h3>Head Organization: <%=user.getName() %></h3>
                                            <div class="control-group">
                                                <label class="control-label" for="idno">ID No:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="idno" name="idno" type="number" placeholder="ID No." required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="first_name">First Name:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="first_name" name="first_name" type="text" placeholder="Frist Name" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="last_name">Last Name:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="last_name" name="last_name" type="text" placeholder="Last Name" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="position">Organization Position:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="position" name="position" type="text" placeholder="Position" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="email">E-mail Address:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="email" name="email" type="email" placeholder="E-mail" required/>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="mobileno">Mobile Number:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="mobileno" name="mobileno" type="text" placeholder="Contact No." required/>
                                                </div>
                                            </div>
                                            <div id="partnerOrg"></div>
                                            <div class="controls">
                                                <button class="btn btn-small" id="addPartnerOrg" type="button"><i class="icon-plus"></i>Add Partner Organization</button>
                                            </div>
                                            <br />
                                            <div class="control-group">
                                                <div class="controls">
                                                    <div class="controls span6 alert alert-info">
                                                        <strong>We will contact you within 48hrs upon reservation.</strong>
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>
                                        <div class="form-actions">
                                            <button id="reserve" type="button" class="btn btn-primary">Submit Project Request</button>
                                            <button name="action" value="reserve" id="submitBtn" type="submit" class="hidden"></button>
                                            <a href="ViewInitialProjectCharterOrg" class="btn">Cancel</a>
                                        </div>
                                        </form> 
                                    </div>
                                </div>
                            </div><!--/span-->
                        </div>
                    </div><!--/span-->
                </div><!--/row-->
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
        $().ready(function() {
            //dynamic partnership fields
            var partnerOrgTemplate = jQuery.validator.format($.trim($("#partnerOrgTemplate").val()));
            function addPartnerOrgRow() {
                $(partnerOrgTemplate(partnerOrgCount++)).appendTo("#partnerOrg");
            }
            var partnerOrgCount = 1;
            $("#addPartnerOrg").click(addPartnerOrgRow);
            
            
            //check duplicates
            $("#reserve").click(function(){
                var partners = [];
                var elements = document.getElementsByClassName("partners");
                for(var i=0; i<elements.length; i++) {
                    partners.push(elements[i].value);
                };
                
                if(find_duplicates(partners)){
                    alert("You have duplicate partner organizations.");
                }else{
                    $("#submitBtn").click();
                }
            });
            
            function find_duplicates(arr) {
                var len=arr.length,counts={};

                for (var i=0;i<len;i++) {
                  var item = arr[i];
                  counts[item] = counts[item] >= 1 ? counts[item] + 1 : 1;
                }

                for (var item in counts) {
                  if(counts[item] > 1) return true;
                }
            }
        });
        </script>
    </body>
</html>