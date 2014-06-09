<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Admin Simplenso - Forms</title>
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
    <body id="forms">
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

                        <div class="span12 column" id="col0">

                            <!-- Portlet: Fancy Portlets -->
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Projects
                                    <a class="box-btn" title="close"><i class="icon-remove"></i></a>
                                    <a class="box-btn" title="toggle"><i class="icon-minus"></i></a>
                                    <a class="box-btn" title="config" data-toggle="modal" href="#box-config-modal"><i class="icon-cog"></i></a>
                                </h4>
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <form class="form-horizontal" />
                                        <fieldset>
                                            <legend>On-Going Projects</legend>
                                            <p>1. <a href="#" rel='tooltip' title='Project Description'>Project 1</a></p><br>
                                            <p>2. <a href="#" rel='tooltip' title='Project Description'>Project 2</a></p><br>
                                            <p>3. <a href="#" rel='tooltip' title='Project Description'>Project 3</a></p>
                                        </fieldset>
                                        </form>
                                    </div>
                                </div>
                            </div><!--/span-->
                        </div>
                        <!-- Portlet Set 3 -->

                    </div><!--/span-->
                </div><!--/row-->


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
            </div></body>
</html>