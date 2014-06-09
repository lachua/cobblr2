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
                            <strong>USG</strong><br />
                            <a>CATCH2T14</a><br />
                            <span class="member-box-links"><a>Settings</a> | <a>Logout</a></span>
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
                                <h4 class="box-header round-top">Suggested Projects
                                </h4>
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <!-- The file upload form used as target for the file upload widget -->
                                        <form id="fileupload" action="../scripts/blueimp-jQuery-File-Upload/server/php/" method="POST" enctype="multipart/form-data">
                                            <legend>Insert Chosen Location</legend>


                                            <h4>Available Projects:
                                            </h4>
                                            <div class="control-group">
                                                <label class="control-label" for="optionsCheckbox"></label>
                                                <div class="controls">
                                                    <label class="checkbox">
                                                        <input type="checkbox" id="optionsCheckbox" value="option1">
                                                        Project 1
                                                    </label>
                                                    <label class="checkbox">
                                                        <input type="checkbox" id="optionsCheckbox" value="option2">
                                                        Project 2
                                                    </label>
                                                    <label class="checkbox">
                                                        <input type="checkbox" id="optionsCheckbox" value="option3">
                                                        Project 3
                                                    </label>
                                                    <label class="checkbox">
                                                        <input type="checkbox" id="optionsCheckbox" value="option4">
                                                        Project 4
                                                    </label>

                                                    <br>
                                                    <button type="reset" class="btn">View Project Charter</button>


                                                    </form>         
                                                </div>
                                            </div>                                               
                                    </div>
                                </div>
                            </div>
                            </table>
                        </div>
                    </div>
                </div><!--/span-->
            </div>
        </div>

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

<!-- Chosen multiselect -->
<script type="text/javascript" language="javascript" src="../scripts/chosen/chosen/chosen.jquery.min.js"></script>

<!-- Uniform -->
<script type="text/javascript" language="javascript" src="../scripts/uniform/jquery.uniform.min.js"></script>

<!-- Simplenso Scripts -->
<script src="../scripts/simplenso/simplenso.js"></script>
</body>
</html>