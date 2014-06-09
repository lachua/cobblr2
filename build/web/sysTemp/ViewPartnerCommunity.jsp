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



                    <!-- Table -->
                    <div class="row-fluid">

                        <div class="span12">
                            <!-- Portlet: Browser Usage Graph -->
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Members
                                    <a class="box-btn" title="close"><i class="icon-remove"></i></a>
                                    <a class="box-btn" title="toggle"><i class="icon-minus"></i></a>     
                                    <a class="box-btn" title="config" data-toggle="modal" href="#box-config-modal"><i class="icon-cog"></i></a>
                                </h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered bootstrap-datatable" id="datatable">
                                            <thead>
                                                <tr>
                                                    <th>Partner Organization</th>
                                                    <th>Sector</th>
                                                    <th>Location</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Amihan</td>
                                                    <td>Peasant Woman</td>
                                                    <td>Bry Wawa, Montalban, Rizal</td>
                                                </tr>
                                                <tr>
                                                    <td>Arch Dioses of Manila- Ministry of Ecology</td>
                                                    <td>Church-based</td>
                                                    <td>Tondo, Manila</td>
                                                </tr>
                                                <tr>
                                                    <td>Bantay Dagat (fish wardens)</td>
                                                    <td>Fishers</td>
                                                    <td>Lian, Batangas</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div><!--/span-->
                        </div>
                    </div>  

                    <!-- javascript Templates
                ================================================== -->
                    <!-- Placed at the end of the document so the pages load faster -->

                    <!-- Le javascript
                    ================================================== -->
                    <!-- Placed at the end of the document so the pages load faster -->

                    <!-- jQuery -->
                    <script src="../jquery/1.8.3/jquery.min.js"></script>

                    <!-- Bootstrap -->
                    <script src="../bootstrap/js/bootstrap.min.js"></script>
                    <script src="../scripts/bootbox/bootbox.min.js"></script>

                                    <!-- Simplenso Scripts -->
                                    <script src="../scripts/simplenso/simplenso.js"></script>
                                    </body>
                                    </html>