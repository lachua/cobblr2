<%@page import="dbentities.ResourceDirectoryEntity"%>
<%@page import="java.util.List"%>
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
                    <jsp:include page="ResourcesShortcut.jsp"></jsp:include>

                        <div class="row-fluid">    
                            <div class="span12">
                                <!-- Portlet: Browser Usage Graph -->
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Suppliers</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <form class="form-horizontal" method="POST" action="MedicalSuppliersCOSCA">
                                                <div id="contactDetail" class="row-fluid">
                                                    <legend>New Supplier</legend>
                                                    <div class="control-group">
                                                        <label class="control-label" for="orgname">Company Name</label>
                                                        <div class="controls">
                                                            <input class="input-xlarge" name="orgname" id="orgname" type="text" placeholder="Org Name" required/>
                                                        </div>
                                                    </div>
                                                    <div class="control-group">
                                                        <label class="control-label" for="desc">Supplies</label>
                                                        <div class="controls">
                                                            <input class="input-xlarge" name="desc" id="desc" type="text" placeholder="Paracetamol, Thermometer" required/>
                                                        </div>
                                                    </div>
                                                    <legend>Contact Person</legend>
                                                    <div class="control-group">
                                                        <label class="control-label" for="fname">First Name</label>
                                                        <div class="controls">
                                                            <input class="input-large" name="fname" id="fname" type="text" placeholder="John" required/>
                                                            <input class="input-mini" name="mi" id="mi" type="text" placeholder="M."/>
                                                        </div>
                                                    </div>
                                                    <div class="control-group">
                                                        <label class="control-label" for="lname">Last Name</label>
                                                        <div class="controls">
                                                            <input class="input-xlarge" name="lname" id="lname" type="text" placeholder="Doe" required/>
                                                        </div>
                                                    </div>
                                                    <div class="control-group">
                                                        <label class="control-label" for="email">E-mail</label>
                                                        <div class="controls">
                                                            <input class="input-xlarge" name="email" id="email" type="email" placeholder="john.doe@medical.com" required/>
                                                        </div>
                                                    </div>
                                                    <div class="control-group">
                                                        <label class="control-label" for="contact">Contact No.</label>
                                                        <div class="controls">
                                                            <input class="input-xlarge" name="contact" id="contact" type="text" placeholder="+639123456789" required/>
                                                        </div>
                                                    </div>
                                                    <div class="control-group">
                                                        <label class="control-label" for="address">Address</label>
                                                        <div class="controls">
                                                            <input class="input-xlarge" name="address" id="address" type="text" placeholder="Manila City" required/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button id="add" name="add" type="button" class="btn btn-primary">Add New Supplier</button>
                                                </div>  
                                            </form>
                                            <br/>

                                            <form method="POST" action="MedicalSuppliersCOSCA">
                                                <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable">
                                                    <thead>
                                                        <tr>
                                                            <th>Company</th>
                                                            <th>Supplies</th>
                                                            <th>Contact Person</th>
                                                            <th>Contact Number</th>
                                                            <th>Email</th>
                                                            <th>Address</th>
                                                            <th>Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <%
                                                        List<ResourceDirectoryEntity> resource = (List<ResourceDirectoryEntity>) request.getAttribute("resource");
                                                        for (int x = 0; x < resource.size(); x++) {
                                                    %>
                                                    <tr>
                                                        <td><%=resource.get(x).getOrganizationname()%></td>
                                                        <td><%=resource.get(x).getDescription()%></td>
                                                        <td><%=resource.get(x).getFirstname() + " " + resource.get(x).getLastname()%></td>
                                                        <td><%=resource.get(x).getMobile()%></td>
                                                        <td><%=resource.get(x).getEmail()%></td>
                                                        <td><%=resource.get(x).getAddress()%></td>
                                                        <td>
                                                            <button name="delete" value="<%=resource.get(x).getId()%>" type="submit" class="btn btn-danger"><i class="icon-trash icon-white"></i> Delete</button>
                                                        </td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>
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

        <!-- Le javascript
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

        <script>
            $(document).ready(function() {
                $('#contactDetail').hide();

                $('#add').click(function() {
                    $('#contactDetail').slideDown();

                    var originalBtn = $("#add");
                    var newBtn = originalBtn.clone();

                    newBtn.attr("type", "submit");
                    newBtn.insertBefore(originalBtn);
                    originalBtn.remove();
                });
            });
        </script>
    </body>
</html>