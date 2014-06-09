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
                        <div class="member-box round-all">
                            <a><img src="../images/member_ph.png" class="member-box-avatar" /></a>
                            <span>
                                <strong>DLSU</strong><br />
                                <a>COSCA</a><br />
                                <span class="member-box-links"><a>Logout</a></span>
                            </span>
                        </div>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>

                    </div><!--/span-->

                    <div class="span10">
                    <jsp:include page="ResourcesShortcut.jsp"></jsp:include>
                    <div class="row-fluid">    
                        <div class="span12 column" id="col0">
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Add New Medical Professional Contact</h4>
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <form class="form-horizontal">
                                            <fieldset>
                                                <legend> Medical Professional Contact Details </legend>
                                                <div class="control-group">
                                                    <label class="control-label" for="focusedInput">Last Name</label>
                                                    <div class="controls">
                                                        <input class="input-xlarge focused" id="lastname" type="text" value="" />
                                                    </div>
                                                </div>

                                                <div class="control-group">
                                                    <label class="control-label" for="focusedInput">First Name</label>
                                                    <div class="controls">
                                                        <input class="input-xlarge focused" id="firstname" type="text" value="" />
                                                    </div>
                                                </div>

                                                <div class="control-group">
                                                    <label class="control-label">Select Specialization: </label>
                                                    <div class="controls">
                                                        <select id="specialization" class="chzn-select">
                                                            <option value="generalphysician">General Physician</option>
                                                            <option value="Pediatrician">Pediatrician</option>
                                                            <option value="gynecologist">Gynecologist</option>
                                                            <option value="ophthalmologist">Ophthalmologist</option>
                                                            <option value="dentist">Dentist</option>
                                                            <option value="dermatologist">Dermatologist</option>
                                                            <option value="ent">ENT</option>
                                                            <option value="orthopedic">Orthopedic</option>
                                                            <option value="cardiologist">Cardiologist</option>
                                                            <option value="neurologist">Neurologist</option>
                                                            <option value="urologist">Urologist</option>
                                                            <option value="psychiatrist">Psychiatrist</option>
                                                            <option value="pathologist">Pathologist</option>
                                                            <option value="radriologist">Radiologist</option>
                                                            <option value="anesthesiologist">Anesthesiologist</option>
                                                            <option value="generalsurgeon">General Surgeon</option>
                                                            <option value="oncologist">Oncologist</option>
                                                            <option value="nephrologist">Nephrologist</option>
                                                            <option value="endocrinologist">Endocrinologist</option>
                                                            <option value="veterinary">Veterinary</option>
                                                        </select> 
                                                    </div> 
                                                </div>

                                                <div class="control-group">
                                                    <label class="control-label" for="focusedInput">Contact Number</label>
                                                    <div class="controls">
                                                        <input class="input-xlarge focused" id="contactnumber" type="text" placeholder="(+63)" />
                                                    </div>
                                                </div>

                                                <div class="control-group">
                                                    <label class="control-label" for="focusedInput">Email Address</label>
                                                    <div class="controls">
                                                        <input class="input-xlarge focused" id="emailaddress" type="text" placeholder="cosca@dlsu.edu.ph" />
                                                    </div>
                                                </div>

                                                <div class="control-group">
                                                    <label class="control-label" for="focusedInput">Address</label>
                                                    <div class="controls">
                                                        <input class="input-xxlarge focused" id="address" type="text" value="" />
                                                    </div>
                                                </div>


                                                <div class="form-actions">
                                                    <a href="MedicalProfessionals_AddSuccess.jsp" type="submit" class="btn btn-primary">Add</a>
                                                    <a href="MedicalProfessionals.jsp" type="reset" class="btn">Cancel</a>
                                                </div>
                                            </fieldset>
                                        </form>
                                    </div>
                                </div>

                            </div> 
                        </div> <!--/span-->


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