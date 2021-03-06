<%-- 
    Document   : CommunityMap
    Created on : Jun 10, 2014, 9:37:10 PM
    Author     : Renliw
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="dbdao.CommunityListDAO"%>
<%@page import="dbentities.QuestionEntity"%>
<%@page import="dbdao.QuestionDAO"%>
<%@page import="dbentities.FilterEntity"%>
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
                                            <div>
                                                <form method="POST" action="CommunityMap">
                                                    <div>
                                                        <a href="MapFilters" class="btn btn-primary">Set Map Filters</a>
                                                        <a href="COSCAHome" class="btn">Back</a>
                                                    </div>
                                                </form>
                                                <br/>
                                            </div>
                                            <div>
                                                <div>
                                                    <button id="mapBtn" style="color: black;" class="btn btn-link">View Map</button>
                                                    <button id="dataBtn" style="color: blue;" class="btn btn-link">View Data</button>
                                                </div>
                                            </div>

                                            <div id="map">
                                                <div id="map_canvas"
                                                     style="
                                                     height: 550px;
                                                     width: 100%;
                                                     margin: 0px;
                                                     padding: 0px">
                                                </div>
                                                <br/>
                                            </div>
                                            <div id="tabledata" style="display: none;">
                                                <%
                                                     List<CommunityListEntity> comList = (List<CommunityListEntity>) request.getAttribute("comlist");
                                                     List<FilterEntity> filterList = (List<FilterEntity>) request.getAttribute("filterList");
                                                     String[] imagetype = new String[comList.size()];
                                                     
                                                     if(filterList == null){
                                                %>
                                                <table class="table table-condensed bootstrap-datatable" id="datatable">
                                                     <thead>
                                                        <tr>
                                                            <th>Community Name</th>
                                                            <th>Community Address</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            for(int x = 0; x < comList.size(); x++){
                                                        %>
                                                        <tr>
                                                            <td><button style="text-align: left;" id="com-<%=x%>" class="btn btn-link"><%=comList.get(x).getName() %></button></td>
                                                            <td><%=comList.get(x).getAddress()%></td>
                                                        </tr>
                                                        <%
                                                            }
                                                        %>
                                                    </tbody>
                                                </table>
                                                <%  }else{  
                                                         int question_id = (Integer)request.getAttribute("question_id");
                                                         QuestionDAO questionDAO = new QuestionDAO();
                                                         QuestionEntity questionEntity = questionDAO.getQuestion(question_id);
                                                %>
                                                
                                                <table class="table table-condensed bootstrap-datatable" id="datatable">
                                                    <thead>
                                                        <tr>
                                                            <th colspan="5">Filter for: <%=questionEntity.getQuestiontext()%></th>
                                                        </tr>
                                                        <tr>
                                                            <th>Community Name</th>
                                                            <th>Total Community Members</th>
                                                            <th>Total Affected</th>
                                                            <th>Percent Affected</th>
                                                            <th>Status</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>                                                        
                                                        <%
                                                        String badgetype, badgeword;
                                                        for(int x = 0; x < filterList.size(); x++){
                                                           double percent_affected = filterList.get(x).getPercent_affected();
                                                           if(percent_affected >= 20.0){
                                                               badgetype = "badge-important";
                                                               badgeword = "High";
                                                               imagetype[x] = "../images/markers/red_cross.png";
                                                           }else if(percent_affected >= 10.0){
                                                               badgetype = "badge-warning";
                                                               badgeword = "Medium";
                                                               imagetype[x] = "../images/markers/yellow_exclamation.png";
                                                           }else{
                                                               badgetype = "badge-success";
                                                               badgeword = "Low";
                                                               imagetype[x] = "../images/markers/green_star.png";
                                                           }
                                                        %>
                                                            <tr>
                                                                <td><button style="text-align: left;" id="com-<%=x%>" class="btn btn-link"><%=comList.get(x).getName() %></button></td>
                                                                <td><%=filterList.get(x).getTotal_community_members() %></td>
                                                                <td><%=filterList.get(x).getTotal_affected() %></td>
                                                                <td><%=String.format("%.2f",filterList.get(x).getPercent_affected()) %>%</td>
                                                                <td><span class="badge <%=badgetype%>"><%=badgeword%></span></td>
                                                            </tr>
                                                        <%}%>
                                                    </tbody>
                                                </table>
                                                <%  }%>
                                                
                                            </div>
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

            <!-- Bootstrap -->
            <script src="../bootstrap/js/bootstrap.min.js"></script>
            <script src="../scripts/bootbox/bootbox.min.js"></script>

            <!-- Data Tables -->
            <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

            <!-- Simplenso Scripts -->
            <script src="../scripts/simplenso/simplenso.js"></script>

            <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
            <script>
                    $("#mapBtn").click(function() {
                        $("#mapBtn").css( "color", "black" );
                        $("#dataBtn").css( "color", "blue" );
                        $('#tabledata').hide("slow", function(){
                            $('#map').show("slow");
                        });
                    });
                    
                    $("#dataBtn").click(function() {
                        $("#mapBtn").css( "color", "blue" );
                        $("#dataBtn").css( "color", "black" );
                        $('#map').hide("slow", function(){
                            $('#tabledata').show("slow");
                        });
                    });
                    
                function initialize()
                {
                    var map = new google.maps.Map(document.getElementById('map_canvas'));
                    var bounds = new google.maps.LatLngBounds();
                    var infowindow = new google.maps.InfoWindow({
                         disableAutoPan: true
                            });
                    
                    <%
                    for(int q = 0; q < comList.size(); q++){
                    %>
                        var latlng = new google.maps.LatLng(<%=comList.get(q).getLatitude()%>, <%=comList.get(q).getLongitude()%>);
                        bounds.extend(latlng);

                        var image;
                        <%if(filterList != null){%>
                        image = {
                            url: '<%=imagetype[q]%>',
                            size: new google.maps.Size(50, 50),
                            origin: new google.maps.Point(0, 0),
                            anchor: new google.maps.Point(17, 34),
                            scaledSize: new google.maps.Size(50, 50)
                          };
                        <%}%>
                            
                        var marker = new google.maps.Marker({
                            position: latlng,
                            map: map,
                            title: '<%=comList.get(q).getName()%>',
                            icon: image
                        });

                        google.maps.event.addListener(marker, 'click', function() {
                            infowindow.setContent(this.title);
                            infowindow.open(map, this);
                        });
                            
                        var id = 'com-<%=q%>';
                        
                        var myButton = document.getElementById(id);
                        google.maps.event.addDomListener(myButton, 'click', function() {
                             $("#mapBtn").css( "color", "black" );
                        $("#dataBtn").css( "color", "blue" );
                        $('#tabledata').hide("slow", function(){
                            $('#map').show("slow");
                        });
                            map.setZoom(16);
                            map.setCenter(new google.maps.LatLng(<%=comList.get(q).getLatitude()%>, <%=comList.get(q).getLongitude()%>));
                        });
                    <%
                    }
                    %>


                    map.fitBounds(bounds);
                }

                google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </body>
</html>