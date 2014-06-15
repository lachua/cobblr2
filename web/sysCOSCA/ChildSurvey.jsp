<%-- 
    Document   : ChildSurvey
    Created on : Jun 14, 2014, 7:55:35 AM
    Author     : Renliw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <!-- Uniform -->
        <link rel="stylesheet" type="text/css" media="screen,projection" href="../scripts/uniform/css/uniform.default.css" />

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
                    <div class="row-fluid">
                        <div class="span12" id="col4">
                            <div class="box" id="box-3">
                                <h4 class="box-header round-top">Community Child Survey</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <form method="POST" action="EncodeCommunitySurvey" id="surveyForm" class="form-horizontal">
                                            <fieldset>
                                                <legend>Encode Survey for *Child 1*</legend>
                                            <div class="control-group">
                                                <label class="control-label" for="childage">Specific Age:</label>
                                                <div class="controls">
                                                    <select name="childage" id="childage" class="chzn-select">
                                                        <option value="">0-3 months old</option>
                                                        <option value="">4-6 months old</option>
                                                        <option value="">7-9 months old</option>
                                                        <option value="">10-11 months old</option>
                                                        <option value="">1 year old</option>
                                                        <option value="">2 years old</option>
                                                        <option value="">3 years old</option>
                                                        <option value="">4 years old</option>
                                                        <option value="">5 years old</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="height">Height:</label>
                                                <div class="controls">
                                                    <input class="input-small" id="height" name="height" type="number" required/>in
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="weight">Weight:</label>
                                                <div class="controls">
                                                    <input class="input-small" id="weight" name="weight" type="number" required/>lbs
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="vitamins">Vitamin Deficiencies</label>
                                                <div class="controls">
                                                   <label class="checkbox"><input type="checkbox" id="vitA" name="healthHistory-{0}" value="" />Vitamin A</label>
                                                    <label class="checkbox"><input type="checkbox" id="vitB12" name="healthHistory-{0}" value="" />Vitamin B12</label>
                                                    <label class="checkbox"><input type="checkbox" id="vitC" name="healthHistory-{0}" value="" />Vitamin C</label>
                                                    <label class="checkbox"><input type="checkbox" id="vitD" name="healthHistory-{0}" value="" />Vitamin D</label>
                                                    <label class="checkbox"><input type="checkbox" id="vitIron" name="healthHistory-{0}" value="" />Iron</label>
                                                    <label class="checkbox"><input type="checkbox" id="vitOthers" name="healthHistory-{0}" value="" />Others</label>
                                                </div>
                                            </div>
                                                
                                            <div class="control-group">
                                                <label class="control-label" for="screening">With New Born Screening:</label>
                                                <div class="controls">
                                                    <input class="radio" type="radio" name="screening" value="" required>Yes<br>
                                                    <input class="radio" type="radio" name="screening" value="">No<br>
                                                </div>
                                            </div>
                                                
                                            <div class="control-group">
                                                <label class="control-label" for="vaccine">Vaccinations</label>
                                                <div class="controls">
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>BCG</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>DTP1</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>DTP2</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>DTP3</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>OVP1</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>OVP2</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>OVP3</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>Measles</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>Flu</label>
                                                    <label class="checkbox"><input type="checkbox" name="vaccine" value="" checked/>Hepatitis</label>
                                                 </div>
                                            </div>

                                            <div class="form-actions">
                                                <a href="COSCAHome" class="btn btn-primary">Submit</a>
                                                <a href="CommunitySurvey" class="btn">Cancel</a>
                                            </div>
                                        </fieldset>
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

    <!-- JQuery Valdation -->
    <script src="../jquery/jquery-validate/jquery.validate.js"></script>
    <script>
        $().ready(function() {
            // validate signup form on keyup and submit
            $("#surveyForm").validate({
                rules: {
                    height: {
                        min: 0
                    },
                    width: {
                        min: 0
                    }
                },
                highlight: function(element, errorClass, validClass) {
                    this.findByName(element.name).parent().parent().addClass(errorClass).removeClass(validClass);
                },
                unhighlight: function(element, errorClass, validClass) {
                    this.findByName(element.name).parent().parent().removeClass(errorClass).addClass(validClass);
                },
                errorPlacement: function(error, element) {
                    var id = element[0]['id'];
                    $(element).before("<label for='" + id + "' class='error'>" + error.text() + "</label>");
                }
            });
        });
    </script>
</body>
</html>