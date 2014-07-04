<%@page import="dbentities.AvailableProjectEntity"%>
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
                        
                    <jsp:include page="Navuserbar.jsp"></jsp:include>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div><!--/span-->

                    <div class="span10">
                    <jsp:include page="ProjectsShortcut.jsp"></jsp:include>

                        <div>
                            <ul class="breadcrumb">
                                <li class="active">
                                    Select Project <span class="divider">/</span>
                                </li>
                                <li>
                                    View Project Details <span class="divider">/</span>
                                </li>
                                <li class="active">
                                    Contact Details<span class="divider">/</span>
                                </li>
                                <li class="active">
                                    Finish 
                                </li>
                            </ul>
                        </div>

                        <div class="row-fluid">
                            <div class="span12">
                                <!-- Portlet: Browser Usage Graph -->
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Initial Project Charter</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <form method="POST" action="ViewInitialProjectCharterOrg">
                                            <%
                                                AvailableProjectEntity availableProject = (AvailableProjectEntity) request.getAttribute("availableProject");

                                            %>
                                            <legend><%=availableProject.getTitle()%></legend>
                                            <blockquote>
                                                <p>Community Name: <%=availableProject.getCommunity_name()%></p>
                                                <p>Community Address: <%=availableProject.getCommunity_address()%></p>
                                                <p>Prepared by: <%=availableProject.getPreparedby()%></p>
                                            </blockquote>

                                            <legend>Brief Description</legend>
                                            <blockquote>
                                                <p><%=availableProject.getDescription()%></p>
                                            </blockquote>

                                            <legend>Main Objective</legend>
                                            <blockquote>
                                                <p><%=availableProject.getObjectives()%></p>
                                            </blockquote>

                                            <legend>Project Scope</legend>
                                            <blockquote>
                                                <p><%=availableProject.getScope()%></p>
                                            </blockquote>

                                            <legend>Additional Requirements</legend>
                                            <blockquote>
                                                <p><%=availableProject.getRequirements()%></p>
                                            </blockquote>

                                            <legend>Location Map</legend>
                                            <div id="map_canvas"
                                                 style="
                                                 height: 500px;
                                                 margin: 0px;
                                                 padding: 0px
                                                 ">

                                            </div>

                                            <div class="form-actions">
                                                <button type="submit" class="btn btn-primary">Reserve Project</button>
                                                <a href="ViewAvailableProjects" type="button" class="btn">Back</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--/span-->
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



        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
        <script>
            var geocoder;
            var map;
            var mapOptions;
            function initialize() {
                geocoder = new google.maps.Geocoder();
                var latlng = new google.maps.LatLng(-34.397, 150.644);
                mapOptions = {
                    zoom: 9,
                    center: latlng
                };
                map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
                codeAddress();
            }

            function codeAddress() {
                var address = "<%=availableProject.getCommunity_address() %>";
                geocoder.geocode({'address': address}, function(results, status) {
                    if (status === google.maps.GeocoderStatus.OK) {
                        map.setCenter(results[0].geometry.location);
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location
                        });
                        if (results[0].geometry.viewport)
                            map.fitBounds(results[0].geometry.viewport);
                    } else {
                        alert('Geocode was not successful for the following reason: ' + status);
                    }
                });
            }

            google.maps.event.addDomListener(window, 'load', initialize);

        </script>
    </body>
</html>