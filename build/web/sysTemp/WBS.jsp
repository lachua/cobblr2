<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

        <!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
        <link rel="stylesheet" href="../scripts/blueimp-jQuery-File-Upload/css/jquery.fileupload-ui.css" />

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
    <body id="tables">
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
                                <a>CATCH 2T14</a><br />
                                <span class="member-box-links"><a>Logout</a></span>
                            </span>
                        </div>          
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                </div><!--/span-->

                <!-- Bread Crumb Navigation -->
                <div class="span10">
                    <div class="row-fluid">
                        <!-- Portlet Set 1 -->
                        <div class="span12">
                            <!-- Portlet: Fancy Portlets -->
                            <div class="box">
                                <h4 class="box-header round-top">Project Smile</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <ul class="dashboard-member-activity">
                                            <li>
                                                <strong>Project Title: <a href="WBS.jsp"> Smile </a> </strong><br />
                                                <strong>Type: </strong> Dental Mission<br />
                                                <strong>Partner Community: </strong> Bantay Dagat<br />
                                                <strong>Location: </strong> Lian, Batangas<br/>
                                                <strong>Description: </strong> Smile is a dental mission that aims to provide dental services to the members of Bantay Dagat in Lian, Batangas. <br/> 
                                                <strong>Project Deadline: </strong> <span class="badge badge-important"> March 5,2014 </span>
                                                
                                            </li>
                                        </ul>
                                        <br/>
                                        

                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable">
                                            <thead>
                                                <tr>
                                                    <th>Tasks</th>
                                                    <th>Goal</th>
                                                    <th >Actual</th>
                                                    <th>Status</th>
                                                    <th>Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td> Doctors </td>
                                                    <td class="center">5</td>
                                                    <td class="center">
                                                        <input class="input-medium focused" id="focusedInput" type="text" value="1" />
                                                    </td>
                                                    <td class="center">
                                                        <div class="progress progress-danger progress-striped active">
                                                            <div class="bar" style="width: 20%"></div>
                                                        </div>

                                                    </td>
                                                    <td class="center">
                                                        <a class="btn btn-success" href="#" rel="tooltip" title="View">
                                                            <i class="icon-zoom-in icon-white"></i>
                                                            Update
                                                        </a>
                                                        <a class="btn btn-info" href="ResourcesDetails.jsp" rel="tooltip" title="View">
                                                            <i class="icon-zoom-in icon-white"></i>
                                                            View Info   
                                                        </a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> Medicine </td>
                                                    <td class="center">100</td>
                                                    <td class="center">
                                                        <input class="input-medium focused" id="focusedInput" type="text" value="1" />
                                                    </td>
                                                    <td class="center">
                                                        <div class="progress progress-danger progress-striped active">
                                                            <div class="bar" style="width: 20%"></div>
                                                        </div>

                                                    </td>
                                                    <td class="center">
                                                        <a class="btn btn-success" href="#" rel="tooltip" title="View">
                                                            <i class="icon-zoom-in icon-white"></i>
                                                            Update
                                                        </a>
                                                        <a class="btn btn-info" href="ResourcesDetails.jsp" rel="tooltip" title="View">
                                                            <i class="icon-zoom-in icon-white"></i>
                                                            View Info   
                                                        </a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td> Equipments </td>
                                                    <td class="center">10</td>
                                                    <td class="center">
                                                        <input class="input-medium focused" id="focusedInput" type="text" value="3" />
                                                    </td>
                                                    <td class="center">
                                                        <div class="progress progress-danger progress-striped active">
                                                            <div class="bar" style="width: 20%"></div>
                                                        </div>


                                                    </td>
                                                    <td class="center">
                                                        <a class="btn btn-success" href="#" rel="tooltip" title="View">
                                                            <i class="icon-zoom-in icon-white"></i>
                                                            Update
                                                        </a>
                                                        <a class="btn btn-info" href="ResourcesDetails.jsp" rel="tooltip" title="View">
                                                            <i class="icon-zoom-in icon-white"></i>
                                                            View Info   
                                                        </a>    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Pre-Acts</td>
                                                    <td class="center">Accomplished</td>
                                                    <td class="center">Unaccomplished</td>
                                                    <td class="center">
                                                        <span class="badge badge-warning">Pending</span>
                                                    </td>
                                                    <td class="center">
                                                        <a class="btn btn-success" href="#">
                                                            <i class="icon-zoom-in icon-white"></i>
                                                            Accomplish
                                                        </a>
                                                    </td>
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
        </div><!--/.fluid-container-->
        <!-- javascript Templates
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->    

        <!-- jQuery -->
        <script src="../jquery/1.8.3/jquery.min.js"></script>

        <!-- Data Tables -->
        <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

        <!-- Bootstrap -->
        <script src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="../scripts/bootbox/bootbox.min.js"></script>

        <!-- Simplenso Scripts -->
        <script src="../scripts/simplenso/simplenso.js"></script>
    </body>
</html>