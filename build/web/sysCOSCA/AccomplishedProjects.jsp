<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Prohealth - Accomplished Projects</title>
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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
    <body id="forms">
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
                    <div>
                        <ul class="breadcrumb">
                            <li >
                                Select Projects <span class="divider">/</span>
                            </li>
                            <li class="active">
                                Confirm Projects <span class="divider">/</span>
                            </li>
                            <li class="active">
                                Finish <span class="divider">/</span>
                            </li>
                        </ul>
                    </div>
                    
                    <div class="row-fluid">
                        <div class="span12" id="col0">
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Confirm Projects</h4>
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <h2>Pending Project Proposals</h2>
                                        <ul class="dashboard-member-activity">
                                            <li>
                                                <strong>Project Title: <a href="ConfirmOrgProject.jsp">Smile</a></strong><br />
                                                <strong>Partner Organization: USG </strong><br/>
                                                <strong>Contact Person: </strong> John Doe <br/>  
                                                <strong>Contact Number: </strong> 09123456789 <br/>  
                                                <strong>Meeting Date </strong> <span class="badge badge-important"> 01/20/2014 </span><br/>
                                                <strong>Type: </strong> Dental Mission<br />
                                                <strong>Partner Community: </strong> Bantay Dagat<br />
                                                <strong>Location: </strong> Lian, Batangas<br/>
                                                <strong>Description: </strong> Smile is a dental mission that aims to provide dental services to the members of Bantay Dagat in Lian, Batangas. <br/>           

                                            </li>
                                        </ul>
                                        <br/>
                                        <ul class="dashboard-member-activity">
                                            <li>
                                                <strong>Project Title: <a>Smile</a> </strong><br />
                                                <strong>Partner Organization: USG </strong><br/>
                                                <strong>Contact Person: </strong> John Doe <br/>  
                                                <strong>Contact Number: </strong> 09123456789 <br/>  
                                                <strong>Meeting Date </strong> <span class="badge badge-info"> 03/20/2014 </span><br/>
                                                <strong>Type: </strong> Dental Mission<br />
                                                <strong>Partner Community: </strong> Bantay Dagat<br />
                                                <strong>Location: </strong> Lian, Batangas<br/>
                                                <strong>Description: </strong> Smile is a dental mission that aims to provide dental services to the members of Bantay Dagat in Lian, Batangas. <br/>           
                                                
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="form-actions">
                                        <a href="COSCAHome.jsp" type="reset" class="btn">Back</a>
                                    </div>
                                </div>
                            </div><!--/span-->
                        </div>
                    </div>
                </div><!--/span-->
            </div><!--/row-->
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