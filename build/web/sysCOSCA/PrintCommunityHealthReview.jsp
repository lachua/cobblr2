<%@page import="Utilities.Year"%>
<%@page import="Utilities.Converter"%>
<%@page import="Utilities.GetPercentage"%>
<%@page import="dbdao.OfferedAnswerDAO"%>
<%@page import="ReportCommunityHealthReview.CommunityHealthReview"%>

<%@taglib uri="http://pd4ml.com/tlds/pd4ml/2.5" prefix="pd4ml" %>
<%@page contentType="text/html; charset=utf-8" %>
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
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />

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

        <style type="text/css">
            table{;
                  border:1px solid #000;
            }
            table td{
                border:1px solid #000;
            }
        </style>
    </head>
    <pd4ml:transform screenWidth="1000" pageFormat="LETTER" pageOrientation="landscape" pageInsets="15,50,25,25,points" enableImageSplit="false" >
        <body id="members">
            <!-- Main Content Area | Side Nav | Content -->
            <div class="container-fluid">
                <div class="row-fluid">  

                    <div class="row-fluid">
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">

                                <div class="box" id="box-3">        
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <%
                                                CommunityHealthReview review = (CommunityHealthReview) request.getAttribute("review");

                                            %>
                                            <h1 align="center">Center for Social Concern and Action </h1>
                                            <h2 align="center">Community Health Review</h2>
                                            <h2 align="center"><%=review.getCurrentYear() - 1%> to <%=review.getCurrentYear()%></h2>
                                            <br>
                                            <h3 align="center">Community: <%=review.getCommunityCurrent().getCommunity_name()%> </h3>
                                            <br>

                                            <div class="row">
                                                <div class="col-md-8 col-md-offset-2">

                                                    <div style="margin-left: 120px">
                                                        No. of Families Surveyed in <%=review.getCurrentYear() - 1%>: <%=review.getCommunityPast().getNumFamilies()%>
                                                        <br>    Population in <%=review.getCurrentYear() - 1%>: <%=review.getCommunityPast().getNumSurveyed()%>
                                                        <br>
                                                        <br>    No. of Families Surveyed in <%=review.getCurrentYear()%>:     <%=review.getCommunityCurrent().getNumFamilies()%>
                                                        <br>    Population in <%=review.getCurrentYear()%>:     <%=review.getCommunityCurrent().getNumSurveyed()%>
                                                    </div>
                                                    <br> <br>
                                                    <table align="center" >
                                                        <thead>
                                                            <tr>
                                                                <th colspan="7">Diseases Summary</th>
                                                            </tr>
                                                            <tr>
                                                                <th height="10px"></th>
                                                            </tr>
                                                            <tr>
                                                                <th ></th>
                                                                <th >Disease</th>
                                                                <th colspan="2"> <%=review.getCurrentYear() - 1%></th>
                                                                <th colspan="2"> <%=review.getCurrentYear()%></th>
                                                                <th align="right">% Change</th>
                                                            </tr>
                                                            <tr>
                                                                <th></th>
                                                                <th width="200px"></th>
                                                                <th width="100px" align="center">Incidence</th>
                                                                <th width="100px" align="center">Magnitude</th>
                                                                <th width="100px" align="center">Incidence</th>
                                                                <th width="100px" align="center">Magnitude</th>
                                                                <th width="100px"></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                for (int x = 0; x < review.getCommunityCurrent().getTopTenDiseasesList().size(); x++) {
                                                                    OfferedAnswerDAO dao = new OfferedAnswerDAO();
                                                                    String disease = dao.getOfferedAnswer(review.getCommunityCurrent().getTopTenDiseasesList().get(x).getOfferedanswer_id()).getAnswertext();
                                                                    int offered_id = review.getCommunityCurrent().getTopTenDiseasesList().get(x).getOfferedanswer_id();
                                                            %>
                                                            <tr>
                                                                <td><%=x + 1%></td>
                                                                <td><%=disease%></td>
                                                                <%
                                                                    int pastIndex = -1;
                                                                    for (int y = 0; y < review.getCommunityPast().getTopTenDiseasesList().size(); y++) {
                                                                        if (review.getCommunityPast().getTopTenDiseasesList().get(y).getOfferedanswer_id() == offered_id) {
                                                                            pastIndex = y;
                                                                            break;
                                                                        }
                                                                    }
                                                                    int pastIncident = review.getCommunityPast().getTopTenDiseasesList().get(pastIndex).getAnswercount();
                                                                    int currentIncident = review.getCommunityCurrent().getTopTenDiseasesList().get(x).getAnswercount();
                                                                    String pastMag = GetPercentage.getPercent(pastIncident, review.getCommunityPast().getNumSurveyed());
                                                                    String currentMag = GetPercentage.getPercent(currentIncident, review.getCommunityCurrent().getNumSurveyed());
                                                                    double change = Double.parseDouble(currentMag) - Double.parseDouble(pastMag);
                                                                    String color = "";
                                                                    if (change > 0) {
                                                                        color = "green";
                                                                    } else if (change == 0) {
                                                                        color = "black";
                                                                    } else {
                                                                        color = "red";
                                                                    }
                                                                %>
                                                                <td align="center"><%=pastIncident%></td>
                                                                <td align="right"><%=pastMag%>%</td>
                                                                <td align="center"><%=currentIncident%></td>
                                                                <td align="right"><%=currentMag%>%</td>
                                                                <td style="color: <%=color%>" align="right"><strong><%=GetPercentage.decimalToString(change)%>%</strong></td>
                                                            </tr> 
                                                            <% }%>
                                                        </tbody>
                                                    </table>
                                                    <div style="margin-left: 120px">
                                                        <i>*Magnitude refers to the % of affected population. Incidence refers to the no. of cases</i>
                                                    </div>
                                                    <br>
                                                    <br><br><br>
                                                    <h3 align="center">Top 3 Felt Family Needs</h3> 
                                                    <div class="row-fluid ">
                                                        <div class="span6">
                                                            <table align="center" class="table table-striped table-bordered">
                                                                <thead>
                                                                    <tr>
                                                                        <th width="70%">Felt Family Need</th>
                                                                        <th align="right">Incidents in <%=review.getCurrentYear() - 1%></th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <%
                                                                        for (int x = 0; x < review.getCommunityPast().getTopThreeNeeds().size(); x++) {
                                                                            OfferedAnswerDAO dao = new OfferedAnswerDAO();
                                                                            String disease = dao.getOfferedAnswer(review.getCommunityPast().getTopThreeNeeds().get(x).getOfferedanswer_id()).getAnswertext();
                                                                            int offered_id = review.getCommunityPast().getTopThreeNeeds().get(x).getOfferedanswer_id();
                                                                    %>
                                                                    <tr>
                                                                        <td ><%=disease%></td>
                                                                        <td align="center"><%=review.getCommunityPast().getTopThreeNeeds().get(x).getAnswercount()%></td>
                                                                    </tr> 
                                                                    <%
                                                                        }
                                                                    %>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <br>
                                                        <br>
                                                        <div class="span6">
                                                            <table align="center" class="table table-striped table-bordered">
                                                                <thead>
                                                                    <tr>
                                                                        <th width="70%">Felt Family Need</th>
                                                                        <th align="center">Incidents in <%=review.getCurrentYear()%></th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <%
                                                                        for (int x = 0; x < review.getCommunityCurrent().getTopThreeNeeds().size(); x++) {
                                                                            OfferedAnswerDAO dao = new OfferedAnswerDAO();
                                                                            String disease = dao.getOfferedAnswer(review.getCommunityCurrent().getTopThreeNeeds().get(x).getOfferedanswer_id()).getAnswertext();
                                                                            int offered_id = review.getCommunityCurrent().getTopThreeNeeds().get(x).getOfferedanswer_id();
                                                                    %>
                                                                    <tr>
                                                                        <td ><%=disease%></td>
                                                                        <td align="right"><%=review.getCommunityCurrent().getTopThreeNeeds().get(x).getAnswercount()%></td>
                                                                    </tr> 
                                                                    <%
                                                                        }
                                                                    %>

                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <br>
                                                    <table align="center" class="table table-striped table-bordered">
                                                        <thead>

                                                            <tr>
                                                                <th colspan="4">Health Projects previously implemented in the community</th>
                                                            </tr>
                                                            <tr>
                                                                <th width="100px" align="center">Date Implemented</th>
                                                                <th width="150px">Project Title</th>
                                                                <th width="100px" align="left">Project Type</th>
                                                                <th width="50px" align="center">No. of Participants</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                for (int x = 0; x < review.getProjectsImplemented().size(); x++) {
                                                            %>
                                                            <tr>
                                                                <td><%=Converter.toString(review.getProjectsImplemented().get(x).getDate_implemented())%></td>
                                                                <td><%=review.getProjectsImplemented().get(x).getProject_title()%></td>
                                                                <td><%=review.getProjectsImplemented().get(x).getProject_type()%></td>
                                                                <td align="center"><%=review.getProjectsImplemented().get(x).getNumParticipants()%></td>
                                                            </tr> 
                                                            <%
                                                                }
                                                            %>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>

                                            <br><br><br><br>

                                            <div class="container">
                                                <p align="center">Date Printed: <%=Converter.toString(Year.getCurrentDateinCalendar())%> </p>
                                            </div>
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

            <!-- Bootstrap -->
            <script src="../bootstrap/js/bootstrap.min.js"></script>
            <script src="../scripts/bootbox/bootbox.min.js"></script>

            <!-- Simplenso Scripts -->
            <script src="../scripts/simplenso/simplenso.js"></script>
        </body>
        <pd4ml:footer
            pageNumberTemplate="Page $[page] of $[total]"
            titleTemplate="Pro-Health Case-Project Management System"
            titleAlignment="left"
            pageNumberAlignment="right"
            color="#00000"
            initialPageNumber="1"
            pagesToSkip="0"
            fontSize="12"
            fontFace="Arial"
            areaHeight="16"/>
    </pd4ml:transform>
</html>