<%-- 
    Document   : MapFilters
    Created on : Jun 12, 2014, 10:11:38 PM
    Author     : Renliw
--%>

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

        <!-- Data Tables -->
        <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
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
                </div>

                <div class="span10">
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="box" id="box-0">
                                <h4 class="box-header round-top">Select Filter</h4>
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <form class="form-horizontal" method="POST" action="MapFilters">
                                            <fieldset>
                                                <legend>Select Filter</legend>
                                                <div class="alert alert-info">
                                                    <strong>Select a filter to plot community health status</strong>
                                                </div>
                                                
                                                <div class="control-group">
                                                    <label class="control-label"><strong>Sicknesses:</strong></label>
                                                    <div class="controls">
                                                        <input class="radio" type="radio" name="filter" value="35-98">Allergy<br>
                                                        <input class="radio" type="radio" name="filter" value="35-99">Altherosclerosis<br>
                                                        <input class="radio" type="radio" name="filter" value="35-100">Asthma<br>
                                                        <input class="radio" type="radio" name="filter" value="35-101">Coughs & Colds<br>
                                                        <input class="radio" type="radio" name="filter" value="35-102">Dengue<br>
                                                        <input class="radio" type="radio" name="filter" value="35-103">Diabetes<br>
                                                        <input class="radio" type="radio" name="filter" value="35-104">Gl Obstruction<br>
                                                        <input class="radio" type="radio" name="filter" value="35-105">Hemmorhage<br>
                                                        <input class="radio" type="radio" name="filter" value="35-106">KidneyStones<br>
                                                        <input class="radio" type="radio" name="filter" value="35-107">Overfatigue<br>
                                                        <input class="radio" type="radio" name="filter" value="35-108">Pneumonia<br>
                                                        <input class="radio" type="radio" name="filter" value="35-109">Renal Failure<br>
                                                        <input class="radio" type="radio" name="filter" value="35-110">Fever
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label" ><strong>Child Vaccinations:</strong></label>
                                                    <div class="controls">
                                                        <input class="radio" type="radio" name="filter" value="76-223">Flu<br>
                                                        <input class="radio" type="radio" name="filter" value="76-224">Hepatitis B<br>
                                                        <input class="radio" type="radio" name="filter" value="76-225">MVC1<br>
                                                        <input class="radio" type="radio" name="filter" value="76-226">MVC2<br>
                                                        <input class="radio" type="radio" name="filter" value="76-227">TT 2+<br>
                                                        <input class="radio" type="radio" name="filter" value="76-228">BGC<br>
                                                        <input class="radio" type="radio" name="filter" value="76-229">DTP<br>
                                                        <input class="radio" type="radio" name="filter" value="76-230">Rotavirus<br>
                                                        <input class="radio" type="radio" name="filter" value="76-231">Pneumococcal<br>
                                                        <input class="radio" type="radio" name="filter" value="76-232">OPV1<br>
                                                        <input class="radio" type="radio" name="filter" value="76-233">OPV3
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label"><strong>Child Vitamin Deficiency:</strong></label>
                                                    <div class="controls">
                                                        <input class="radio" type="radio" name="filter" value="74-216">A<br>
                                                        <input class="radio" type="radio" name="filter" value="74-217">B12<br>
                                                        <input class="radio" type="radio" name="filter" value="74-218">C<br>
                                                        <input class="radio" type="radio" name="filter" value="74-219">D<br>
                                                        <input class="radio" type="radio" name="filter" value="74-220">Iron<br>
                                                        <input class="radio" type="radio" name="filter" value="74-221">Zinc<br>
                                                        <input class="radio" type="radio" name="filter" value="74-222">Multi-Vitamins<br>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label class="control-label"><strong>Child Malnutrition:</strong></label>
                                                    <div class="controls">
                                                        <input class="radio" type="radio" name="filter" value="77-234">Under weight<br>
                                                        <input class="radio" type="radio" name="filter" value="77-236">Over weight<br>
                                                        <input class="radio" type="radio" name="filter" value="77-237">Obese<br>
                                                    </div>
                                                </div>
                                                <div class="form-actions">
                                                    <button type="submit" class="btn btn-primary">View on Map</button>
                                                    <a href="MapCommunity" class="btn">Back</a>
                                                </div>
                                            </fieldset>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/span-->
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
