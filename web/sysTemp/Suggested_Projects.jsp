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
        <link type="text/css" href="scripts/chosen/chosen/chosen.intenso.css" rel="stylesheet" />   

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
                                        <form id="fileupload" action="scripts/blueimp-jQuery-File-Upload/server/php/" method="POST" enctype="multipart/form-data">
                                            <legend>By Location</legend>


                                            <div class="control-group">
                                                <label class="control-label" for="multiSelect">Select the first letter of the city.</label>
                                                <div class="controls">
                                                    <select multiple="multiple" id="multiSelect">
                                                        <option>A</option>
                                                        <option>B</option>
                                                        <option>C</option>
                                                        <option>D</option>
                                                        <option>E</option>
                                                        <option>F</option>
                                                        <option>G</option>
                                                        <option>H</option>
                                                        <option>I</option>
                                                        <option>J</option>
                                                        <option>K</option>
                                                        <option>L</option>
                                                        <option>M</option>
                                                        <option>N</option>
                                                        <option>O</option>
                                                        <option>P</option>
                                                        <option>Q</option>
                                                        <option>R</option>
                                                        <option>S</option>
                                                        <option>T</option>
                                                        <option>U</option>
                                                        <option>V</option>
                                                        <option>W</option>
                                                        <option>X</option>
                                                        <option>Y</option>
                                                        <option>Z</option>                                
                                                    </select>
                                                </div>
                                            </div>
                                            <br> 

                                            <h2>M
                                                <br><small>Shows all the cities that begin with M</small>
                                            </h2>
                                            <div class="control-group">
                                                <label class="control-label" for="optionsCheckbox"></label>
                                                <div class="controls">
                                                    <label class="checkbox">
                                                        <input type="checkbox" id="optionsCheckbox" value="option1">
                                                        Makati
                                                    </label>
                                                    <label class="checkbox">
                                                        <input type="checkbox" id="optionsCheckbox" value="option2">
                                                        Malabon
                                                    </label>
                                                    <label class="checkbox">
                                                        <input type="checkbox" id="optionsCheckbox" value="option3">
                                                        Mandaluyong
                                                    </label>
                                                    <label class="checkbox">
                                                        <input type="checkbox" id="optionsCheckbox" value="option4">
                                                        Manila
                                                    </label>

                                                    <br>
                                                    <button type="reset" class="btn">View Projects</button>                                                                                                             
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

<!-- Data Tables -->
<script src="scripts/DataTables/media/js/jquery.dataTables.js"></script>

<!-- jQuery UI Sortable -->
<script src="scripts/jquery-ui/ui/minified/jquery.ui.core.min.js"></script>
<script src="scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>
<script src="scripts/jquery-ui/ui/minified/jquery.ui.mouse.min.js"></script>
<script src="scripts/jquery-ui/ui/minified/jquery.ui.sortable.min.js"></script>
<script src="scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>

<!-- Bootstrap -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="scripts/bootbox/bootbox.min.js"></script>

<!-- Chosen multiselect -->
<script type="text/javascript" language="javascript" src="scripts/chosen/chosen/chosen.jquery.min.js"></script>

<!-- Simplenso Scripts -->
<script src="scripts/simplenso/simplenso.js"></script>
</body>
</html>