<%-- 
    Document   : CommunityMap
    Created on : Jun 10, 2014, 9:37:10 PM
    Author     : Renliw
--%>
<%@page import="dbentities.CommunityListEntity"%>
<%@page import="java.util.List"%>
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
                                <strong>DLSU</strong><br />
                                <a>COSCA</a><br />
                                <span class="member-box-links"><a>Logout</a></span>
                            </span>
                        </div>
                    <jsp:include page="Navsidebar.jsp"></jsp:include>
                    </div><!--/span-->

                    <div class="span10">
                        <div class="row-fluid">
                            <div class="span12">
                                <!-- Portlet: Browser Usage Graph -->
                                <div class="box" id="box-0">
                                    <h4 class="box-header round-top">Community Map</h4>
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <form method="POST" action="CommunityMap">
                                                <div>
                                                    <a href="MapFilters" class="btn btn-primary">Set Map Filters</a>
                                                    <a href="COSCAHome" class="btn">Back</a>
                                                </div>
                                                <br>
                                                <div id="map_canvas"
                                                     style="
                                                     height: 550px;
                                                     margin: 0px;
                                                     padding: 0px
                                                     ">

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
                <%
                    List<CommunityListEntity> comList = (List<CommunityListEntity>) request.getAttribute("LIST");
                %>
                    var LocationData = [
                <%                        
                        for (int x = 1; x < comList.size(); x++) {
                %>
                        ['<%=comList.get(x).getName()%>',<%=comList.get(x).getLatitude()%>,<%=comList.get(x).getLongitude()%> ]<%if (x + 1 != comList.size()) {%>,<%}%>
                <%
                        }
                %>
                    ];
                    
                function initialize()
                {
                    var map = new google.maps.Map(document.getElementById('map_canvas'));
                    var bounds = new google.maps.LatLngBounds();
                    var infowindow = new google.maps.InfoWindow();

                    for (var i in LocationData)
                    {
                        var p = LocationData[i];
                        var latlng = new google.maps.LatLng(p[1], p[2]);
                        bounds.extend(latlng);

                        var image; 
                        

                        var marker = new google.maps.Marker({
                            position: latlng,
                            map: map,
                            title: p[0],
                            icon: image
                        });

                        google.maps.event.addListener(marker, 'click', function() {
                            infowindow.setContent(this.title);
                            infowindow.open(map, this);
                        });
                    }

                    map.fitBounds(bounds);
                }

                google.maps.event.addDomListener(window, 'load', initialize);

        </script>
    </body>
</html>