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
                                <strong>USG</strong><br />
                                <a>CATCH2T14</a><br />
                                <span class="member-box-links"><a>Logout</a></span>
                            </span>
                        </div>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                </div><!--/span-->

                <div class="span10">

                    <div class="row-fluid">
                        <div class="span12 ">
                            <div>
                                <h1>Current Project Resources</h1>
                                <br>
                            </div>
                        </div>
                    </div>

                    <div class="row-fluid">  
                        <div class="span6">
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Medicine</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <div class="span8">
                                            <button type="button" class="btn btn-success">
                                                <i class="icon-plus icon-white"></i> Add</button>
                                            <button type="button" class="btn btn-primary">
                                                <i class="icon-edit icon-white"></i> Edit
                                            </button>
                                            <button type="button" class="btn btn-danger">
                                                <i class="icon-trash icon-white"></i> Delete
                                            </button>
                                        </div>
                                        <br/>
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable">
                                            <thead>
                                                <tr>
                                                    <th>Medicine</th>
                                                    <th>Quantity</th>
                                                    <th>Sponsor</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Paracetamol</td>
                                                    <td>500 tabs</td>
                                                    <td>United</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>    

                        <div class="span6">
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Equipment</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <div class="span8">
                                            <button type="button" class="btn btn-success">
                                                <i class="icon-plus icon-white"></i> Add</button>
                                            <button type="button" class="btn btn-primary">
                                                <i class="icon-edit icon-white"></i> Edit
                                            </button>
                                            <button type="button" class="btn btn-danger">
                                                <i class="icon-trash icon-white"></i> Delete
                                            </button>
                                        </div>
                                        <br/>
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable">
                                            <thead>
                                                <tr>
                                                    <th>Materials and Equipment</th>
                                                    <th>Quantity</th>
                                                    <th>Sponsor</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Masks</td>
                                                    <td>100</td>
                                                    <td>United</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row-fluid">  
                            <div class="span12">
                                <!-- Portlet: Browser Usage Graph -->
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Medical Professionals</h4>         
                                    <div class="box-container-toggle">
                                        <div class="box-content">

                                            <div class="span7">
                                                <b> Filter by Specialization:  </b> <select> <option value="generalphysician">General Physician</option>
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
                                                </select> </div>

                                            <div class="span5">
                                                <button type="button" class="btn btn-success">
                                                    <i class="icon-plus icon-white"></i> Add</button>
                                                <button type="button" class="btn btn-primary">
                                                    <i class="icon-edit icon-white"></i> Edit
                                                </button>
                                                <button type="button" class="btn btn-danger">
                                                    <i class="icon-trash icon-white"></i> Delete
                                                </button>
                                            </div>

                                            <br> <hr>

                                            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable">
                                                <thead>
                                                    <tr>
                                                        <th>Medical Professional</th>
                                                        <th>Specialization</th>
                                                        <th>Contact Number</th>
                                                        <th>Email Address</th>
                                                        <th>Address</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Dr. Andres Antonio</td>
                                                        <td>Gynecologist</td>
                                                        <td>09159784431</td>
                                                        <td>andresantonio@gmail.com</td>
                                                        <td>Manila City</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Dr. Fernando Fernandez </td>
                                                        <td>Dentist</td>
                                                        <td>09156985523</td>
                                                        <td>fernandofernandez@gmail.com</td>
                                                        <td>Quezon City</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Dr. Patricia Lim</td>
                                                        <td>General Physician</td>
                                                        <td>09156985523</td>
                                                        <td>patricialim@gmail.com</td>
                                                        <td>Makati City</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Dr. Pedro Santos </td>
                                                        <td>Pediatrician</td>
                                                        <td>09157542355</td>
                                                        <td>pedrosantos@gmail.com</td>
                                                        <td>Pasay City</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Dr. Manuel Velasco </td>
                                                        <td>Opthalmologist</td>
                                                        <td>09156557723</td>
                                                        <td>manualvelasco@gmail.com</td>
                                                        <td>Quezon City</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div><!--/span-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <!--/.fluid-container-->
        <!-- javascript Templates
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <!-- jQuery -->
        <script src="../jquery/1.8.3/jquery.min.js"></script>

        <!-- Data Tables -->
        <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

        <!-- Bootstrap -->
        <script src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="../scripts/bootbox/bootbox.min.js"></script>

        <!-- Chosen multiselect -->
        <script type="text/javascript" language="javascript" src="../scripts/chosen/chosen/chosen.jquery.min.js"></script>

        <!-- Simplenso Scripts -->
        <script src="../scripts/simplenso/simplenso.js"></script>
    </body>
</html>