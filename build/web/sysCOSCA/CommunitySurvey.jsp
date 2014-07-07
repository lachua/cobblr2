
<%@page import="classes.ChildSurveyResults"%>
<%@page import="java.util.HashMap"%>
<%@page import="classes.PersonalSurveyResults"%>
<%@page import="classes.PersonalSurveyResults"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="Utilities.Immunization"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Utilities.Year"%>
<%@page import="classes.QuestionAnswerSet"%>
<%@page import="classes.SurveyResults"%>
<%@page import="dbentities.ProjectTypesEntity"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>Admin Simplenso - Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="HTML5 Admin Simplenso Template" />
        <meta name="author" content="ahoekie" />

        <!-- Bootstrap -->
        <link href="../bootstrap/css/bootstrap.css" rel="stylesheet" id="main-theme-script" />
        <link href="../css/themes/default.css" rel="stylesheet" id="theme-specific-script" />
        <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />

        <!-- Full Calender -->
        <link rel="stylesheet" type="text/css" href="../scripts/fullcalendar/fullcalendar/fullcalendar.css" />

        <!-- Bootstrap Date Picker --> 
        <link href="../scripts/datepicker/css/datepicker.css" rel="stylesheet" />

        <!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
        <link rel="stylesheet" href="../scripts/blueimp-jQuery-File-Upload/css/jquery.fileupload-ui.css" />

        <!-- Bootstrap Image Gallery styles -->
        <link rel="stylesheet" href="../css/bootstrap-image-gallery.min.css" />

        <!-- Uniform -->
        <link rel="stylesheet" type="text/css" media="screen,projection" href="../scripts/uniform/css/uniform.default.css" />

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
    <body  class="hidden">
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

                <%
                    SurveyResults currentResult = (SurveyResults) request.getAttribute("currentResult");
                    SurveyResults pastResult = (SurveyResults) request.getAttribute("pastResult");
                    PersonalSurveyResults currentPerResult = (PersonalSurveyResults) request.getAttribute("currentPerResult");
                    PersonalSurveyResults pastPerResult = (PersonalSurveyResults) request.getAttribute("pastPerResult");
                    ChildSurveyResults currentChildResult = (ChildSurveyResults) request.getAttribute("currentChildResult");
                    ChildSurveyResults pastChildResult = (ChildSurveyResults) request.getAttribute("pastChildResult");
                    int thisYear = Year.getCurrentYear();
                    int lastYear = Year.getPreviousYear();
                    QuestionAnswerSet oneSet, twoSet;
                %>

                <!-- Bread Crumb Navigation -->
                <div class="span10">
                    <div class="row-fluid span8">
                        <div id="families_div">
                            <div class="row-fluid">
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Family Structure <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familyStructurePrevious_donut"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Family Structure <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familyStructureCurrent_donut"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span12 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Family Size</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familySize_col"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span12 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Age</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="agePrevious_line"></div>
                                                <div id="ageCurrent_line"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Religion <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="relegionPrevious_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Religion <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="relegionCurrent_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Civil Status <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="civilStatusPrevious_col"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Civil Status <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="civilStatusCurrent_col"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span12 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Educational Attainment</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="educationalAttainment_bar"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">General Family Dynamics <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>General Family Dynamics <%=lastYear%></th>
                                                            <th>Yes</th>
                                                            <th>No</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td colspan="3">1. Misunderstandings in the Family</td>
                                                        </tr>
                                                        <tr>
                                                            <td>a. Battered husband/wife</td>
                                                            <% oneSet = pastResult.getSurveyResults().get(1);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>b. Frequent fights</td>
                                                            <% oneSet = pastResult.getSurveyResults().get(2);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>c. Child abuse</td>
                                                            <% oneSet = pastResult.getSurveyResults().get(3);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="3">2. Characteristics of Communication</td>
                                                        </tr>
                                                        <tr>
                                                            <td>a. Putting-off conversation</td>
                                                            <% oneSet = pastResult.getSurveyResults().get(4);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>b. Use of Inappropriate words(swearing, insults, etc.)</td>
                                                            <% oneSet = pastResult.getSurveyResults().get(5);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">General Family Dynamics <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>General Family Dynamics <%=thisYear%></th>
                                                            <th>Yes</th>
                                                            <th>No</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td colspan="3">1. Misunderstandings in the Family</td>
                                                        </tr>
                                                        <tr>
                                                            <td>a. Battered husband/wife</td>
                                                            <% oneSet = currentResult.getSurveyResults().get(1);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>b. Frequent fights</td>
                                                            <% oneSet = currentResult.getSurveyResults().get(2);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>c. Child abuse</td>
                                                            <% oneSet = currentResult.getSurveyResults().get(3);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="3">2. Characteristics of Communication</td>
                                                        </tr>
                                                        <tr>
                                                            <td>a. Putting-off conversation</td>
                                                            <% oneSet = currentResult.getSurveyResults().get(4);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                        <tr>
                                                            <td>b. Use of Inappropriate words(swearing, insults, etc.)</td>
                                                            <% oneSet = currentResult.getSurveyResults().get(5);%>
                                                            <td><%=oneSet.getAnswerset().get(49)%></td>
                                                            <td><%=oneSet.getAnswerset().get(50)%></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Occupation <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="occupationPrevious_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Occupation <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="occupationCurrent_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!--Filter 1-->

                        <div id="socioeconomic_div">
                            <div class="row-fluid">
                                <div class="span12 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Monthly Income</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="income_bar"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Source of Income <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="incomesourcePrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Source of Income <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="incomesourceCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Felt Family Needs <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familyneedsPrevious_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Felt Family Needs <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familyneedsCurrent_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!--Filter 2-->

                        <div id="home_environment_div">
                            <div class="row-fluid">
                                <div class="span12 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Home & Environment</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="homeenvironment_col"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span12 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Type of Housing Material</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="housingtype_col"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Type of Garbage Disposal <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="garbagetypePrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Type of Garbage Disposal <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="garbagetypeCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Type of Drainage <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="drainagetypePrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Type of Drainage <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="drainagetypeCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Type of Toilet <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="toilettypePrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Type of Toilet <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="toilettypeCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Source of Water <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="watersourcePrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Source of Water <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="watersourceCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Source of Drinking Water <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="drinkingwatersourcePrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Source of Drinking Water <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="drinkingwatersourceCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Drinking Water Storage <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="drinkingwaterstoragePrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Drinking Water Storage <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="drinkingwaterstorageCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Food Storage <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="foodstoragePrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Food Storage<%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="foodstorageCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Household Pests <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="pestsPrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Household Pests <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="pestsCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Presence of Pests Breeding Sites <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="pestsbreedingPrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Presence of Pests' Breeding Sites <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="pestsbreedingCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Pets <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="petsPrevious_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6 ">
                                    <div class="box">
                                        <h4 class="box-header round-top">Pets <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="petsCurrent_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Presence of Accident Hazards <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="accidenthazardsPrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Presence of Accident Hazards <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="accidenthazardsCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!--Filter 3-->

                        <div id='health_div'>
                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Family Health History <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familyhealthPrevious_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Family Health History <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familyhealthCurrent_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Recent Family Illnesses <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familyillnssesPrevious_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Recent Family Illnesses <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="familyillnssesCurrent_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Consulted Person(Health) <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="consultedpersonhealthPrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Consulted Person(Health) <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="consultedpersonhealthCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Consulted Person(Non-Health) <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="consultedpersonnonhealthPrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Consulted Person(Non-Health) <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="consultedpersonnonhealthCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Immunization <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="immunizationPrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Immunization <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="immunizationCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Adequate Activity <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="adequateavtivityPrevious_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Adequate Activity <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="adequateavtivityCurrent_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!--Filter 4-->
                    
                        <div id='child_div'>
                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Child Ages</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="specAge_bar"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                        
                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Child Weight</h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="childWeight_col"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                        
                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Child Meals Per Day <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="childMealsPrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Child Meals Per Day <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="childMealsCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>    
                                        
                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Vitamins Taken </h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="vitaminsPrevious_bar"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                                        
                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Newborn Screening <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="screeningPrevious_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Newborn Screening <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="screeningCurrent_pie"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                        
                            <div class="row-fluid">
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Vaccination <%=lastYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="vaccinationPrevious_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="box">
                                        <h4 class="box-header round-top">Newborn Screening <%=thisYear%></h4>         
                                        <div class="box-container-toggle">
                                            <div class="box-content">
                                                <div id="vaccinationCurrent_table"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!--Filter 5-->
                    </div><!--row fuild span8-->

                    <div id="scroll_div" class="span4">
                        <div class="row-fluid">
                            <div class="span12">
                                <div class="box">
                                    <h4 class="box-header round-top">Filter Survey Results:</h4> 
                                    <div class="box-container-toggle">
                                        <div class="box-content">
                                            <input class="input-small checkbox" id="families_filter" name="families_filter" type="checkbox" checked/>Families<br/>
                                            <input class="input-small checkbox" id="socioeconomic_filter" name="socioeconomic_filter" type="checkbox" checked/>Socioeconomic & Cultural Factors<br/>
                                            <input class="input-small checkbox" id="home_environment_filter" name="home_environment_filter" type="checkbox" checked/>Home & Environmental Factors<br/>
                                            <input class="input-small checkbox" id="health_filter" name="health_filter" type="checkbox" checked/>Health Assessment<br/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="box" id="box-2">
                                <h4 class="box-header round-top">Actions</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <form method="POST" action="CommunitySurvey">
                                            <h3>Survey Details:</h3>
                                            <ul class="dashboard-member-activity">
                                                <li>
                                                    <strong>Location: Community Location</strong><br/>
                                                    <br/>
                                                    <% oneSet = currentResult.getSurveyResults().get(38);%>
                                                    <% twoSet = pastResult.getSurveyResults().get(38);%>
                                                    <strong><u><%=thisYear%> Surveys</u></strong><br />
                                                    <strong>No. of Families Surveyed:</strong> <%=currentResult.getNumFamilies()%> Families <br/>
                                                    <strong>No. of Individuals Surveyed:</strong> <%=currentResult.getNumIndividuals()%> Individuals <br/>
                                                    <strong>No. of Males Surveyed:</strong> <%=currentResult.getNumMales()%> Males <br/>
                                                    <strong>No. of Females Surveyed:</strong> <%=currentResult.getNumFemales()%> Females <br/>
                                                    <br/>
                                                    <strong><u><%=lastYear%> Surveys</u></strong><br />
                                                    <strong>No. of Families Surveyed:</strong> <%=pastResult.getNumFamilies()%> Families <br/>
                                                    <strong>No. of Individuals Surveyed:</strong> <%=pastResult.getNumIndividuals()%> Individuals <br/>
                                                    <strong>No. of Males Surveyed:</strong> <%=pastResult.getNumMales()%> Males <br/>
                                                    <strong>No. of Females Surveyed:</strong> <%=pastResult.getNumFemales()%> Females <br/>
                                                    <br/>
                                                    <button type="submit" name="action" value="EncodeCommunitySurvey" class="btn btn-primary"> Add Surveys</button><br />
                                                </li>
                                            </ul>

                                            <h3>Create Project:</h3>
                                            <div class="control-group">
                                                <label class="control-label">Type of Project</label>
                                                <div class="controls">
                                                    <%
                                                        List<ProjectTypesEntity> types = (List<ProjectTypesEntity>) request.getAttribute("types");
                                                    %>
                                                    <select name="typeOfProjects" class="chzn-select">
                                                        <%
                                                            for (int x = 0; x < types.size(); x++) {
                                                        %>
                                                        <option value="<%=types.get(x).getType()%>"><%=types.get(x).getType()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <button type="submit" name="action" value="CreateInitialProjectCharter" class="btn btn-primary">Create Project</button>
                                            </div>
                                        </form> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>     
                </div>
            </div><!--/row-->
        </div>
        <!--/.fluid-container-->
        <!-- javascript Templates
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->    

        <!-- jQuery -->
        <script src="../jquery/1.8.3/jquery.min.js"></script>

        <!-- Data Tables -->
        <script src="../scripts/DataTables/media/js/jquery.dataTables.js"></script>

        <!-- jQuery UI Sortable -->
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.core.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.mouse.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.sortable.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>

        <!-- jQuery UI Draggable & droppable -->
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.draggable.min.js"></script>
        <script src="../scripts/jquery-ui/ui/minified/jquery.ui.droppable.min.js"></script>

        <!-- Bootstrap -->
        <script src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="../scripts/bootbox/bootbox.min.js"></script>

        <!-- Bootstrap Date Picker -->
        <script src="../scripts/datepicker/js/bootstrap-datepicker.js"></script>


        <!-- jQuery Cookie -->    
        <script src="../scripts/jquery.cookie/jquery.cookie.js"></script>

        <!-- Full Calender -->
        <script type="text/javascript" src="../scripts/fullcalendar/fullcalendar/fullcalendar.min.js"></script>

        <!-- CK Editor -->
        <script type="text/javascript" src="../scripts/ckeditor/ckeditor.js"></script>

        <!-- Chosen multiselect -->
        <script type="text/javascript" language="javascript" src="../scripts/chosen/chosen/chosen.jquery.min.js"></script>  

        <!-- Uniform -->
        <script type="text/javascript" language="javascript" src="../scripts/uniform/jquery.uniform.min.js"></script>

        <!-- Simplenso Scripts -->
        <script src="../scripts/simplenso/simplenso.js"></script>

        <!--Google API-->
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>

        <!--Filters-->
        <script type="text/javascript">
            $(document).ready(function() {
                $('#families_filter').change(function() {
                    if ($('#families_filter').is(':checked')) {
                        $("#families_div").slideDown("slow");
                    } else {
                        $("#families_div").slideUp("slow");
                    }
                });
                $('#socioeconomic_filter').change(function() {
                    if ($('#socioeconomic_filter').is(':checked')) {
                        $("#socioeconomic_div").slideDown("slow");
                    } else {
                        $("#socioeconomic_div").slideUp("slow");
                    }
                });
                $('#home_environment_filter').change(function() {
                    if ($('#home_environment_filter').is(':checked')) {
                        $("#home_environment_div").slideDown("slow");
                    } else {
                        $("#home_environment_div").slideUp("slow");
                    }
                });
                $('#health_filter').change(function() {
                    if ($('#health_filter').is(':checked')) {
                        $("#health_div").slideDown("slow");
                    } else {
                        $("#health_div").slideUp("slow");
                    }
                });
            });


        </script>

        <!--Charts-->
        <script type="text/javascript">
            var empty = 'none';
            var thisYear = <%=thisYear%>;
            var lastYear = <%=lastYear%>;
            var string = '';
            google.load("visualization", "1", {packages: ["corechart", "table"]});
            google.setOnLoadCallback(drawFamilyChart);
            google.setOnLoadCallback(drawSocioChart);
            google.setOnLoadCallback(drawHomeChart);
            google.setOnLoadCallback(drawHealthChart);
            google.setOnLoadCallback(drawChildChart);
            function drawFamilyChart() {
                //Family Structure Previous
                var data = google.visualization.arrayToDataTable([
                    ['Family Structure', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(70);%>
                    ['Nuclear', <%=oneSet.getAnswerset().get(13)%>],
                    ['Single Parent', <%=oneSet.getAnswerset().get(14)%>],
                    ['Extended', <%=oneSet.getAnswerset().get(15)%>],
                    ['Childless', <%=oneSet.getAnswerset().get(16)%>],
                    ['Step Family', <%=oneSet.getAnswerset().get(167)%>],
                    ['Grand Parent', <%=oneSet.getAnswerset().get(168)%>]
                ]);

                string = 'Family Structure ' + lastYear;
                if (<%=oneSet.getAnswerset().get(13)%> === 0 && <%=oneSet.getAnswerset().get(14)%> === 0 && <%=oneSet.getAnswerset().get(15)%> === 0 && <%=oneSet.getAnswerset().get(16)%> === 0 && <%=oneSet.getAnswerset().get(167)%> === 0 && <%=oneSet.getAnswerset().get(168)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string,
                    pieHole: 0.2
                };


                var chart = new google.visualization.PieChart(document.getElementById('familyStructurePrevious_donut'));
                chart.draw(data, options);

                //Family Structure Current
                var data = google.visualization.arrayToDataTable([
                    ['Family Structure', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(70);%>
                    ['Nuclear', <%=oneSet.getAnswerset().get(13)%>],
                    ['Single Parent', <%=oneSet.getAnswerset().get(14)%>],
                    ['Extended', <%=oneSet.getAnswerset().get(15)%>],
                    ['Childless', <%=oneSet.getAnswerset().get(16)%>],
                    ['Step Family', <%=oneSet.getAnswerset().get(167)%>],
                    ['Grand Parent', <%=oneSet.getAnswerset().get(168)%>]
                ]);

                string = 'Family Structure ' + thisYear;
                if (<%=oneSet.getAnswerset().get(13)%> === 0 && <%=oneSet.getAnswerset().get(14)%> === 0 && <%=oneSet.getAnswerset().get(15)%> === 0 && <%=oneSet.getAnswerset().get(16)%> === 0 && <%=oneSet.getAnswerset().get(167)%> === 0 && <%=oneSet.getAnswerset().get(168)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string,
                    pieHole: 0.2
                };

                var chart = new google.visualization.PieChart(document.getElementById('familyStructureCurrent_donut'));
                chart.draw(data, options);

                //Family Size Column
                var data = google.visualization.arrayToDataTable([
            <% oneSet = pastResult.getSurveyResults().get(38);%>
            <% twoSet = currentResult.getSurveyResults().get(38);%>
                    ['Year', 'less than 2 people', '3 people', '4 people', '5 people', '6 people', '7 people', '8+ people'],
                    ['' + lastYear, <%=oneSet.getAnswerset().get(160)%>, <%=oneSet.getAnswerset().get(161)%>, <%=oneSet.getAnswerset().get(162)%>, <%=oneSet.getAnswerset().get(163)%>,<%=oneSet.getAnswerset().get(164)%>, <%=oneSet.getAnswerset().get(165)%>, <%=oneSet.getAnswerset().get(166)%>],
                            ['' + thisYear, <%=twoSet.getAnswerset().get(160)%>, <%=twoSet.getAnswerset().get(161)%>, <%=twoSet.getAnswerset().get(162)%>, <%=twoSet.getAnswerset().get(163)%>,<%=twoSet.getAnswerset().get(164)%>, <%=twoSet.getAnswerset().get(165)%>, <%=twoSet.getAnswerset().get(166)%>]
                ]);

                var options = {
                    title: 'Family Size',
                    hAxis: {title: 'Year', titleTextStyle: {color: 'black'}}
                };

                var chart = new google.visualization.ColumnChart(document.getElementById('familySize_col'));
                chart.draw(data, options);

                //Age Previous Line
                var data = google.visualization.arrayToDataTable([
                    ['Years Old', 'Male', 'Female', 'Total'],
            <% HashMap<Integer, Integer> mapM = pastPerResult.getMaleAges();%>
            <% HashMap<Integer, Integer> mapF = pastPerResult.getFemaleAges();%>
                    ['1-3', <%=mapM.get(151)%>, <%=mapF.get(151)%>, <%=mapM.get(151) + mapF.get(151)%>],
                    ['4-5', <%=mapM.get(152)%>, <%=mapF.get(152)%>, <%=mapM.get(152) + mapF.get(152)%>],
                    ['6-10', <%=mapM.get(153)%>, <%=mapF.get(153)%>, <%=mapM.get(153) + mapF.get(153)%>],
                    ['11-14', <%=mapM.get(154)%>, <%=mapF.get(154)%>, <%=mapM.get(154) + mapF.get(154)%>],
                    ['15-17', <%=mapM.get(155)%>, <%=mapF.get(155)%>, <%=mapM.get(155) + mapF.get(155)%>],
                    ['18-20', <%=mapM.get(156)%>, <%=mapF.get(156)%>, <%=mapM.get(156) + mapF.get(156)%>],
                    ['21-40', <%=mapM.get(157)%>, <%=mapF.get(157)%>, <%=mapM.get(157) + mapF.get(157)%>],
                    ['41-60', <%=mapM.get(158)%>, <%=mapF.get(158)%>, <%=mapM.get(158) + mapF.get(158)%>],
                            ['61+', <%=mapM.get(159)%>, <%=mapF.get(159)%>, <%=mapM.get(159) + mapF.get(159)%>]
                ]);

                var options = {
                    title: 'Age ' + lastYear
                };

                var chart = new google.visualization.LineChart(document.getElementById('agePrevious_line'));
                chart.draw(data, options);

                //Age Current Line
                var data = google.visualization.arrayToDataTable([
                    ['Years Old', 'Male', 'Female', 'Total'],
            <%  mapM = currentPerResult.getMaleAges();%>
            <% mapF = currentPerResult.getFemaleAges();%>
                    ['1-3', <%=mapM.get(151)%>, <%=mapF.get(151)%>, <%=mapM.get(151) + mapF.get(151)%>],
                    ['4-5', <%=mapM.get(152)%>, <%=mapF.get(152)%>, <%=mapM.get(152) + mapF.get(152)%>],
                    ['6-10', <%=mapM.get(153)%>, <%=mapF.get(153)%>, <%=mapM.get(153) + mapF.get(153)%>],
                    ['11-14', <%=mapM.get(154)%>, <%=mapF.get(154)%>, <%=mapM.get(154) + mapF.get(154)%>],
                    ['15-17', <%=mapM.get(155)%>, <%=mapF.get(155)%>, <%=mapM.get(155) + mapF.get(155)%>],
                    ['18-20', <%=mapM.get(156)%>, <%=mapF.get(156)%>, <%=mapM.get(156) + mapF.get(156)%>],
                    ['21-40', <%=mapM.get(157)%>, <%=mapF.get(157)%>, <%=mapM.get(157) + mapF.get(157)%>],
                    ['41-60', <%=mapM.get(158)%>, <%=mapF.get(158)%>, <%=mapM.get(158) + mapF.get(158)%>],
                            ['61+', <%=mapM.get(159)%>, <%=mapF.get(159)%>, <%=mapM.get(159) + mapF.get(159)%>]
                ]);

                var options = {
                    title: 'Age ' + thisYear
                };

                var chart = new google.visualization.LineChart(document.getElementById('ageCurrent_line'));
                chart.draw(data, options);

                //Religion Previous
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Relegion');
                data.addColumn('number', 'Husband');
                data.addColumn('number', 'Wife');
                data.addColumn('number', 'Total');
                data.addRows([
            <%
                oneSet = pastResult.getSurveyResults().get(36);
                twoSet = pastResult.getSurveyResults().get(37);
            %>
                    ['Catholic', <%=oneSet.getAnswerset().get(6)%>, <%=twoSet.getAnswerset().get(6)%>, <%=oneSet.getAnswerset().get(6) + twoSet.getAnswerset().get(6)%>],
                    ['Iglesia ni Cristo', <%=oneSet.getAnswerset().get(7)%>, <%=twoSet.getAnswerset().get(7)%>, <%=oneSet.getAnswerset().get(7) + twoSet.getAnswerset().get(7)%>],
                    ['Muslim', <%=oneSet.getAnswerset().get(8)%>, <%=twoSet.getAnswerset().get(8)%>, <%=oneSet.getAnswerset().get(8) + twoSet.getAnswerset().get(8)%>],
                    ['Protestant', <%=oneSet.getAnswerset().get(9)%>, <%=twoSet.getAnswerset().get(9)%>, <%=oneSet.getAnswerset().get(9) + twoSet.getAnswerset().get(9)%>],
                    ['Budhist', <%=oneSet.getAnswerset().get(10)%>, <%=twoSet.getAnswerset().get(10)%>, <%=oneSet.getAnswerset().get(10) + twoSet.getAnswerset().get(10)%>],
                    ['Born Again', <%=oneSet.getAnswerset().get(11)%>, <%=twoSet.getAnswerset().get(11)%>, <%=oneSet.getAnswerset().get(11) + twoSet.getAnswerset().get(11)%>],
                    ['Baptist', <%=oneSet.getAnswerset().get(12)%>, <%=twoSet.getAnswerset().get(12)%>, <%=oneSet.getAnswerset().get(12) + twoSet.getAnswerset().get(12)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>, <%=twoSet.getAnswerset().get(82)%>, <%=oneSet.getAnswerset().get(82) + twoSet.getAnswerset().get(82)%>]
                ]);
                var table = new google.visualization.Table(document.getElementById('relegionPrevious_table'));
                table.draw(data);

                //Religion Current
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Relegion');
                data.addColumn('number', 'Husband');
                data.addColumn('number', 'Wife');
                data.addColumn('number', 'Total');
                data.addRows([
            <%
                oneSet = currentResult.getSurveyResults().get(36);
                twoSet = currentResult.getSurveyResults().get(37);
            %>
                    ['Catholic', <%=oneSet.getAnswerset().get(6)%>, <%=twoSet.getAnswerset().get(6)%>, <%=oneSet.getAnswerset().get(6) + twoSet.getAnswerset().get(6)%>],
                    ['Iglesia ni Cristo', <%=oneSet.getAnswerset().get(7)%>, <%=twoSet.getAnswerset().get(7)%>, <%=oneSet.getAnswerset().get(7) + twoSet.getAnswerset().get(7)%>],
                    ['Muslim', <%=oneSet.getAnswerset().get(8)%>, <%=twoSet.getAnswerset().get(8)%>, <%=oneSet.getAnswerset().get(8) + twoSet.getAnswerset().get(8)%>],
                    ['Protestant', <%=oneSet.getAnswerset().get(9)%>, <%=twoSet.getAnswerset().get(9)%>, <%=oneSet.getAnswerset().get(9) + twoSet.getAnswerset().get(9)%>],
                    ['Budhist', <%=oneSet.getAnswerset().get(10)%>, <%=twoSet.getAnswerset().get(10)%>, <%=oneSet.getAnswerset().get(10) + twoSet.getAnswerset().get(10)%>],
                    ['Born Again', <%=oneSet.getAnswerset().get(11)%>, <%=twoSet.getAnswerset().get(11)%>, <%=oneSet.getAnswerset().get(11) + twoSet.getAnswerset().get(11)%>],
                    ['Baptist', <%=oneSet.getAnswerset().get(12)%>, <%=twoSet.getAnswerset().get(12)%>, <%=oneSet.getAnswerset().get(12) + twoSet.getAnswerset().get(12)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>, <%=twoSet.getAnswerset().get(82)%>, <%=oneSet.getAnswerset().get(82) + twoSet.getAnswerset().get(82)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('relegionCurrent_table'));
                table.draw(data);

                //Civil Status Previous Column
                var data = google.visualization.arrayToDataTable([
                    ['Civil Status', '' + lastYear],
            <%oneSet = pastPerResult.getSurveyResults().get(32);%>
                    ['Single', <%=oneSet.getAnswerset().get(1)%>],
                    ['Married', <%=oneSet.getAnswerset().get(2)%>],
                    ['Widowed', <%=oneSet.getAnswerset().get(3)%>],
                    ['Separated', <%=oneSet.getAnswerset().get(4)%>],
                    ['Live-In', <%=oneSet.getAnswerset().get(5)%>]
                ]);

                var options = {
                    title: 'Civil Status ' + lastYear
                };

                var chart = new google.visualization.PieChart(document.getElementById('civilStatusPrevious_col'));
                chart.draw(data, options);

                //Civil StatusCurrent Column
                var data = google.visualization.arrayToDataTable([
                    ['Civil Status', '' + thisYear],
            <%oneSet = currentPerResult.getSurveyResults().get(32);%>
                    ['Single', <%=oneSet.getAnswerset().get(1)%>],
                    ['Married', <%=oneSet.getAnswerset().get(2)%>],
                    ['Widowed', <%=oneSet.getAnswerset().get(3)%>],
                    ['Separated', <%=oneSet.getAnswerset().get(4)%>],
                    ['Live-In', <%=oneSet.getAnswerset().get(5)%>]
                ]);

                var options = {
                    title: 'Civil Status ' + thisYear
                };

                var chart = new google.visualization.PieChart(document.getElementById('civilStatusCurrent_col'));
                chart.draw(data, options);

                //Educational Attainment Bar
                var data = google.visualization.arrayToDataTable([
                    ['Educational Attainment', '' + lastYear, '' + thisYear],
            <%twoSet = currentPerResult.getSurveyResults().get(33);%>
            <%oneSet = pastPerResult.getSurveyResults().get(33);%>
                    ['5 and below', <%=oneSet.getAnswerset().get(17)%>, <%=twoSet.getAnswerset().get(17)%>],
                    ['Pre-School', <%=oneSet.getAnswerset().get(18)%>, <%=twoSet.getAnswerset().get(18)%>],
                    ['Elementary', <%=oneSet.getAnswerset().get(19)%>, <%=twoSet.getAnswerset().get(19)%>],
                    ['HS Level', <%=oneSet.getAnswerset().get(20)%>, <%=twoSet.getAnswerset().get(20)%>],
                    ['HS Graduate', <%=oneSet.getAnswerset().get(21)%>, <%=twoSet.getAnswerset().get(21)%>],
                    ['Vocational', <%=oneSet.getAnswerset().get(22)%>, <%=twoSet.getAnswerset().get(22)%>],
                    ['College Level', <%=oneSet.getAnswerset().get(23)%>, <%=twoSet.getAnswerset().get(23)%>],
                            ['College Graduate', <%=oneSet.getAnswerset().get(24)%>, <%=twoSet.getAnswerset().get(24)%>]
                ]);

                var options = {
                    title: 'Educational Attainment',
                    vAxis: {title: 'Educational Attainment', titleTextStyle: {color: 'black'}}
                };

                var chart = new google.visualization.BarChart(document.getElementById('educationalAttainment_bar'));
                chart.draw(data, options);

                //Occupation Previous
                var data = new google.visualization.DataTable();

                data.addColumn('string', 'Occupation');
                data.addColumn('number', 'No. of People');
                data.addRows([
            <%
                if (pastPerResult.getJobcount().size() == 0) {
            %>
                ['No data', 0]
            <%
                }
                for (int x = 0; x < pastPerResult.getJobcount().size(); x++) {
            %>
                ['<%=pastPerResult.getJobcount().get(x).getJob()%>', <%=pastPerResult.getJobcount().get(x).getCount()%>],
            <%
                }
            %>
                ]);
                        var table = new google.visualization.Table(document.getElementById('occupationPrevious_table'));
                table.draw(data);

                //Occupation Current
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Occupation');
                data.addColumn('number', 'No. of People');
                data.addRows([
            <%
                if (currentPerResult.getJobcount().size() == 0) {
            %>
                ['No data', 0]
            <%
                }
                for (int x = 0; x < currentPerResult.getJobcount().size(); x++) {
            %>
                ['<%=currentPerResult.getJobcount().get(x).getJob()%>', <%=currentPerResult.getJobcount().get(x).getCount()%>],
            <%
                }
            %>
                ]);
                        var table = new google.visualization.Table(document.getElementById('occupationCurrent_table'));
                table.draw(data);
            }
            
            function drawSocioChart() {
                //Monthly Income Bar
                var data = google.visualization.arrayToDataTable([
                    ['Monthly Income', '' + lastYear, '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(6);%>
            <% twoSet = pastResult.getSurveyResults().get(6);%>
                    ['Below 5,000 pesos', <%=twoSet.getAnswerset().get(146)%>, <%=oneSet.getAnswerset().get(146)%>],
                    ['5,000-10,000 pesos', <%=twoSet.getAnswerset().get(147)%>, <%=oneSet.getAnswerset().get(147)%>],
                    ['10,000-15,000 pesos', <%=twoSet.getAnswerset().get(148)%>, <%=oneSet.getAnswerset().get(148)%>],
                    ['15,000-20,000 pesos', <%=twoSet.getAnswerset().get(149)%>, <%=oneSet.getAnswerset().get(149)%>],
                            ['20,000-30,000 pesos', <%=twoSet.getAnswerset().get(150)%>, <%=oneSet.getAnswerset().get(150)%>]
                ]);

                var options = {
                    title: 'Monthly Income',
                    vAxis: {title: 'Monthly Income', titleTextStyle: {color: 'black'}}
                };

                var chart = new google.visualization.BarChart(document.getElementById('income_bar'));
                chart.draw(data, options);

                //Income Source Previous
                var data = google.visualization.arrayToDataTable([
                    ['Source of Income', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(7);%>
                    ['Father', <%=oneSet.getAnswerset().get(51)%>],
                    ['Mother', <%=oneSet.getAnswerset().get(52)%>],
                    ['Both', <%=oneSet.getAnswerset().get(53)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Source of Income ' + lastYear;
                if (<%=oneSet.getAnswerset().get(51)%> === 0 && <%=oneSet.getAnswerset().get(52)%> === 0 && <%=oneSet.getAnswerset().get(53)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('incomesourcePrevious_pie'));
                chart.draw(data, options);

                //Income Source Current
                var data = google.visualization.arrayToDataTable([
                    ['Source of Income', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(7);%>
                    ['Father', <%=oneSet.getAnswerset().get(51)%>],
                    ['Mother', <%=oneSet.getAnswerset().get(52)%>],
                    ['Both', <%=oneSet.getAnswerset().get(53)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Source of Income ' + thisYear;
                if (<%=oneSet.getAnswerset().get(51)%> === 0 && <%=oneSet.getAnswerset().get(52)%> === 0 && <%=oneSet.getAnswerset().get(53)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('incomesourceCurrent_pie'));
                chart.draw(data, options);


                //Felt Family Needs Previous
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Needs');
                data.addColumn('number', 'No. of Familes');
                data.addRows([
            <%oneSet = pastResult.getSurveyResults().get(8);%>
                    ['Medicine', <%=oneSet.getAnswerset().get(54)%>],
                    ['Additional Income', <%=oneSet.getAnswerset().get(55)%>],
                    ['Education ', <%=oneSet.getAnswerset().get(56)%>],
                    ['Food ', <%=oneSet.getAnswerset().get(57)%>],
                    ['Owned Comfort Room ', <%=oneSet.getAnswerset().get(58)%>],
                    ['Medical Assistance ', <%=oneSet.getAnswerset().get(59)%>],
                    ['Livelihood ', <%=oneSet.getAnswerset().get(60)%>],
                    ['Counseling ', <%=oneSet.getAnswerset().get(61)%>],
                    ['Parenting ', <%=oneSet.getAnswerset().get(62)%>],
                    ['Housing ', <%=oneSet.getAnswerset().get(63)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('familyneedsPrevious_table'));
                table.draw(data);

                //Felt Family Needs Current
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Needs');
                data.addColumn('number', 'No. of Familes');
                data.addRows([
            <%oneSet = currentResult.getSurveyResults().get(8);%>
                    ['Medicine', <%=oneSet.getAnswerset().get(54)%>],
                    ['Additional Income', <%=oneSet.getAnswerset().get(55)%>],
                    ['Education ', <%=oneSet.getAnswerset().get(56)%>],
                    ['Food ', <%=oneSet.getAnswerset().get(57)%>],
                    ['Owned Comfort Room ', <%=oneSet.getAnswerset().get(58)%>],
                    ['Medical Assistance ', <%=oneSet.getAnswerset().get(59)%>],
                    ['Livelihood ', <%=oneSet.getAnswerset().get(60)%>],
                    ['Counseling ', <%=oneSet.getAnswerset().get(61)%>],
                    ['Parenting ', <%=oneSet.getAnswerset().get(62)%>],
                    ['Housing ', <%=oneSet.getAnswerset().get(63)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('familyneedsCurrent_table'));
                table.draw(data);
            }
            function drawHomeChart() {
                //Home & Environment Column
                var data = google.visualization.arrayToDataTable([
            <% oneSet = currentResult.getSurveyResults().get(9);%>
            <% twoSet = pastResult.getSurveyResults().get(9);%>
                ['Home & Environment', '' + lastYear, '' + thisYear],
                        ['Lot Owned', <%=twoSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(49)%>],
                        ['Lot Not Owned', <%=twoSet.getAnswerset().get(50)%>, <%=oneSet.getAnswerset().get(50)%>],
            <% oneSet = currentResult.getSurveyResults().get(10);%>
            <% twoSet = pastResult.getSurveyResults().get(10);%>
                ['House Owned', <%=twoSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(49)%>],
                        ['House Not Owned', <%=twoSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(49)%>]
                ]);
                        var options = {
                            title: 'Home & Environment'
                        };

                var chart = new google.visualization.ColumnChart(document.getElementById('homeenvironment_col'));
                chart.draw(data, options);

                //Type of Housing Material Column
                var data = google.visualization.arrayToDataTable([
                    ['Type of Housing Material', '' + lastYear, '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(11);%>
            <% twoSet = pastResult.getSurveyResults().get(11);%>
                    ['Wood', <%=twoSet.getAnswerset().get(65)%>, <%=oneSet.getAnswerset().get(65)%>],
                    ['Concrete', <%=twoSet.getAnswerset().get(66)%>, <%=oneSet.getAnswerset().get(66)%>],
                    ['Mixed', <%=twoSet.getAnswerset().get(67)%>, <%=oneSet.getAnswerset().get(67)%>],
                            ['Others', <%=twoSet.getAnswerset().get(82)%>, <%=oneSet.getAnswerset().get(82)%>]
                ]);

                var options = {
                    title: 'Type of Housing Material'
                };

                var chart = new google.visualization.ColumnChart(document.getElementById('housingtype_col'));
                chart.draw(data, options);

                //Type of Garbage Disposal Previous
                var data = google.visualization.arrayToDataTable([
                    ['Type of Garbage Disposal', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(12);%>
                    ['Collected', <%=oneSet.getAnswerset().get(68)%>],
                    ['Thrown Elsewhere', <%=oneSet.getAnswerset().get(69)%>]
                ]);

                string = 'Type of Garbage Disposal ' + lastYear;
                if (<%=oneSet.getAnswerset().get(68)%> === 0 && <%=oneSet.getAnswerset().get(69)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('garbagetypePrevious_pie'));
                chart.draw(data, options);

                //Type of Garbage Disposal Current
                var data = google.visualization.arrayToDataTable([
                    ['Type of Garbage Disposal', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(12);%>
                    ['Collected', <%=oneSet.getAnswerset().get(68)%>],
                    ['Thrown Elsewhere', <%=oneSet.getAnswerset().get(69)%>]
                ]);

                string = 'Type of Garbage Disposal ' + thisYear;
                if (<%=oneSet.getAnswerset().get(68)%> === 0 && <%=oneSet.getAnswerset().get(69)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('garbagetypeCurrent_pie'));
                chart.draw(data, options);

                //Type of Drainage System Previous
                var data = google.visualization.arrayToDataTable([
                    ['Type of Drainage System', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(14);%>
                    ['Open', <%=oneSet.getAnswerset().get(70)%>],
                    ['Closed', <%=oneSet.getAnswerset().get(71)%>]
                ]);

                title: 'Type of Drainage System ' + lastYear;
                if (<%=oneSet.getAnswerset().get(70)%> === 0 && <%=oneSet.getAnswerset().get(71)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('drainagetypePrevious_pie'));
                chart.draw(data, options);

                //Type of Drainage System Current
                var data = google.visualization.arrayToDataTable([
                    ['Type of Drainage System', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(14);%>
                    ['Open', <%=oneSet.getAnswerset().get(70)%>],
                    ['Closed', <%=oneSet.getAnswerset().get(71)%>]
                ]);

                title: 'Type of Drainage System ' + thisYear;
                if (<%=oneSet.getAnswerset().get(70)%> === 0 && <%=oneSet.getAnswerset().get(71)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('drainagetypeCurrent_pie'));
                chart.draw(data, options);

                //Type of Toilet Previous
                var data = google.visualization.arrayToDataTable([
                    ['Type of Toilet', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(13);%>
                    ['Water Sealed', <%=oneSet.getAnswerset().get(72)%>],
                    ['No Toilet', <%=oneSet.getAnswerset().get(73)%>]
                ]);

                string = 'Type of Toilet ' + lastYear;
                if (<%=oneSet.getAnswerset().get(72)%> === 0 && <%=oneSet.getAnswerset().get(73)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('toilettypePrevious_pie'));
                chart.draw(data, options);

                //Type of Toilet Current
                var data = google.visualization.arrayToDataTable([
                    ['Type of Toilet', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(13);%>
                    ['Water Sealed', <%=oneSet.getAnswerset().get(72)%>],
                    ['No Toilet', <%=oneSet.getAnswerset().get(73)%>]
                ]);

                string = 'Type of Toilet ' + thisYear;
                if (<%=oneSet.getAnswerset().get(72)%> === 0 && <%=oneSet.getAnswerset().get(73)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('toilettypeCurrent_pie'));
                chart.draw(data, options);

                //Source of Water Previous
                var data = google.visualization.arrayToDataTable([
                    ['Source of Water', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(15);%>
                    ['Owned', <%=oneSet.getAnswerset().get(74)%>],
                    ['Bought', <%=oneSet.getAnswerset().get(75)%>],
                    ['Shared', <%=oneSet.getAnswerset().get(76)%>]
                ]);

                string = 'Source of Water ' + lastYear;
                if (<%=oneSet.getAnswerset().get(74)%> === 0 && <%=oneSet.getAnswerset().get(75)%> === 0 && <%=oneSet.getAnswerset().get(76)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('watersourcePrevious_pie'));
                chart.draw(data, options);

                //Source of Water Current
                var data = google.visualization.arrayToDataTable([
                    ['Source of Water', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(15);%>
                    ['Owned', <%=oneSet.getAnswerset().get(74)%>],
                    ['Bought', <%=oneSet.getAnswerset().get(75)%>],
                    ['Shared', <%=oneSet.getAnswerset().get(76)%>]
                ]);

                string = 'Source of Water ' + thisYear;
                if (<%=oneSet.getAnswerset().get(74)%> === 0 && <%=oneSet.getAnswerset().get(75)%> === 0 && <%=oneSet.getAnswerset().get(76)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('watersourceCurrent_pie'));
                chart.draw(data, options);

                //Source of Drinking Water Previous
                var data = google.visualization.arrayToDataTable([
                    ['Source of Drinking Water', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(16);%>
                    ['Refrigirated', <%=oneSet.getAnswerset().get(77)%>],
                    ['Covered', <%=oneSet.getAnswerset().get(78)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Source of Drinking Water ' + lastYear;
                if (<%=oneSet.getAnswerset().get(77)%> === 0 && <%=oneSet.getAnswerset().get(78)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('drinkingwatersourcePrevious_pie'));
                chart.draw(data, options);

                //Source of Drinking Water Current
                var data = google.visualization.arrayToDataTable([
                    ['Source of Drinking Water', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(16);%>
                    ['Refrigirated', <%=oneSet.getAnswerset().get(77)%>],
                    ['Covered', <%=oneSet.getAnswerset().get(78)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Source of Drinking Water ' + thisYear;
                if (<%=oneSet.getAnswerset().get(77)%> === 0 && <%=oneSet.getAnswerset().get(78)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('drinkingwatersourceCurrent_pie'));
                chart.draw(data, options);

                //Drinking Water Storage Previous
                var data = google.visualization.arrayToDataTable([
                    ['Drinking Water Storage', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(17);%>
                    ['Plastic Pitchers', <%=oneSet.getAnswerset().get(79)%>],
                    ['Bottles', <%=oneSet.getAnswerset().get(80)%>],
                    ['Jars or Clay Pots', <%=oneSet.getAnswerset().get(81)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Drinking Water Storage ' + lastYear;
                if (<%=oneSet.getAnswerset().get(79)%> === 0 && <%=oneSet.getAnswerset().get(80)%> === 0 && <%=oneSet.getAnswerset().get(81)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('drinkingwaterstoragePrevious_pie'));
                chart.draw(data, options);

                //Drinking Water Storage Current
                var data = google.visualization.arrayToDataTable([
                    ['Drinking Water Storage', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(17);%>
                    ['Plastic Pitchers', <%=oneSet.getAnswerset().get(79)%>],
                    ['Bottles', <%=oneSet.getAnswerset().get(80)%>],
                    ['Jars or Clay Pots', <%=oneSet.getAnswerset().get(81)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Drinking Water Storage ' + thisYear;
                if (<%=oneSet.getAnswerset().get(79)%> === 0 && <%=oneSet.getAnswerset().get(80)%> === 0 && <%=oneSet.getAnswerset().get(81)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('drinkingwaterstorageCurrent_pie'));
                chart.draw(data, options);

                //Food Storage Previous
                var data = google.visualization.arrayToDataTable([
                    ['Food Storage', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(18);%>
                    ['Covered', <%=oneSet.getAnswerset().get(83)%>],
                    ['Refrigerated', <%=oneSet.getAnswerset().get(84)%>],
                    ['Cabinet', <%=oneSet.getAnswerset().get(85)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Food Storage ' + lastYear;
                if (<%=oneSet.getAnswerset().get(83)%> === 0 && <%=oneSet.getAnswerset().get(84)%> === 0 && <%=oneSet.getAnswerset().get(85)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('foodstoragePrevious_pie'));
                chart.draw(data, options);

                //Food Storage Current
                var data = google.visualization.arrayToDataTable([
                    ['Food Storage', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(18);%>
                    ['Covered', <%=oneSet.getAnswerset().get(83)%>],
                    ['Refrigerated', <%=oneSet.getAnswerset().get(84)%>],
                    ['Cabinet', <%=oneSet.getAnswerset().get(85)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Food Storage ' + thisYear;
                if (<%=oneSet.getAnswerset().get(83)%> === 0 && <%=oneSet.getAnswerset().get(84)%> === 0 && <%=oneSet.getAnswerset().get(85)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('foodstorageCurrent_pie'));
                chart.draw(data, options);

                //Pests Previous
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Pests');
                data.addColumn('number', 'No. of Familes with Pests');
                data.addRows([
            <% oneSet = pastResult.getSurveyResults().get(20);%>
                    ['Rat', <%=oneSet.getAnswerset().get(86)%>],
                    ['Cockroach', <%=oneSet.getAnswerset().get(87)%>],
                    ['Bed Bugs', <%=oneSet.getAnswerset().get(88)%>],
                    ['Termite', <%=oneSet.getAnswerset().get(89)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('pestsPrevious_pie'));
                table.draw(data, options);

                //Pests Current
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Pests');
                data.addColumn('number', 'No. of Familes with Pests');
                data.addRows([
            <% oneSet = currentResult.getSurveyResults().get(20);%>
                    ['Rat', <%=oneSet.getAnswerset().get(86)%>],
                    ['Cockroach', <%=oneSet.getAnswerset().get(87)%>],
                    ['Bed Bugs', <%=oneSet.getAnswerset().get(88)%>],
                    ['Termite', <%=oneSet.getAnswerset().get(89)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('pestsCurrent_pie'));
                table.draw(data, options);

                //Presence of Pests' Breeding Sites Previous
                var data = google.visualization.arrayToDataTable([
                    ['Presence of Pests Breeding Sites', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(19);%>
                    ['Yes', <%=oneSet.getAnswerset().get(49)%>],
                    ['No', <%=oneSet.getAnswerset().get(50)%>]
                ]);

                string = 'Presence of Pests Breeding Sites ' + lastYear;
                if (<%=oneSet.getAnswerset().get(49)%> === 0 && <%=oneSet.getAnswerset().get(50)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('pestsbreedingPrevious_pie'));
                chart.draw(data, options);

                //Presence of Pests' Breeding Sites Current
                var data = google.visualization.arrayToDataTable([
                    ['Presence of Pests Breeding Sites', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(19);%>
                    ['Yes', <%=oneSet.getAnswerset().get(49)%>],
                    ['No', <%=oneSet.getAnswerset().get(50)%>]
                ]);

                string = 'Presence of Pests Breeding Sites ' + thisYear;
                if (<%=oneSet.getAnswerset().get(49)%> === 0 && <%=oneSet.getAnswerset().get(50)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('pestsbreedingCurrent_pie'));
                chart.draw(data, options);

                //Pets Previous
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Pets');
                data.addColumn('number', 'No. of Familes with Pets');
                data.addRows([
            <% oneSet = pastResult.getSurveyResults().get(21);%>
                    ['Dog', <%=oneSet.getAnswerset().get(90)%>],
                    ['Cat', <%=oneSet.getAnswerset().get(91)%>],
                    ['Rooster/Chicken', <%=oneSet.getAnswerset().get(92)%>],
                    ['Pig', <%=oneSet.getAnswerset().get(93)%>],
                    ['Dove', <%=oneSet.getAnswerset().get(94)%>],
                    ['Duck', <%=oneSet.getAnswerset().get(95)%>],
                    ['Monkey', <%=oneSet.getAnswerset().get(96)%>],
                    ['Snake', <%=oneSet.getAnswerset().get(97)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('petsPrevious_table'));
                table.draw(data);

                //Pets Current
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Pets');
                data.addColumn('number', 'No. of Familes with Pets');
                data.addRows([
            <% oneSet = currentResult.getSurveyResults().get(21);%>
                    ['Dog', <%=oneSet.getAnswerset().get(90)%>],
                    ['Cat', <%=oneSet.getAnswerset().get(91)%>],
                    ['Rooster/Chicken', <%=oneSet.getAnswerset().get(92)%>],
                    ['Pig', <%=oneSet.getAnswerset().get(93)%>],
                    ['Dove', <%=oneSet.getAnswerset().get(94)%>],
                    ['Duck', <%=oneSet.getAnswerset().get(95)%>],
                    ['Monkey', <%=oneSet.getAnswerset().get(96)%>],
                    ['Snake', <%=oneSet.getAnswerset().get(97)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('petsCurrent_table'));
                table.draw(data);

                //Presence of Accident Hazards Previous
                var data = google.visualization.arrayToDataTable([
                    ['Presence of Accident Hazards', '' + lastYear],
            <% oneSet = pastResult.getSurveyResults().get(22);%>
                    ['Yes', <%=oneSet.getAnswerset().get(49)%>],
                    ['No', <%=oneSet.getAnswerset().get(50)%>]
                ]);

                string = 'Presence of Accident Hazards ' + lastYear;
                if (<%=oneSet.getAnswerset().get(49)%> === 0 && <%=oneSet.getAnswerset().get(50)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('accidenthazardsPrevious_pie'));
                chart.draw(data, options);

                //Presence of Accident Hazards Current
                var data = google.visualization.arrayToDataTable([
                    ['Presence of Accident Hazards', '' + thisYear],
            <% oneSet = currentResult.getSurveyResults().get(22);%>
                    ['Yes', <%=oneSet.getAnswerset().get(49)%>],
                    ['No', <%=oneSet.getAnswerset().get(50)%>]
                ]);

                string = 'Presence of Accident Hazards ' + thisYear;
                if (<%=oneSet.getAnswerset().get(49)%> === 0 && <%=oneSet.getAnswerset().get(50)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('accidenthazardsCurrent_pie'));
                chart.draw(data, options);
            }
            function drawHealthChart() {
                //Family Health History Previous
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Sickness');
                data.addColumn('number', 'No. of Persons');
                data.addRows([
            <%oneSet = pastPerResult.getSurveyResults().get(34);%>
                    ['Allergy', <%=oneSet.getAnswerset().get(98)%>],
                    ['Altherosclerosis', <%=oneSet.getAnswerset().get(99)%>],
                    ['Asthma', <%=oneSet.getAnswerset().get(100)%>],
                    ['Cough & Colds', <%=oneSet.getAnswerset().get(101)%>],
                    ['Dengue', <%=oneSet.getAnswerset().get(102)%>],
                    ['Diabetes', <%=oneSet.getAnswerset().get(103)%>],
                    ['Gl Obstruction', <%=oneSet.getAnswerset().get(104)%>],
                    ['Hemmorhage', <%=oneSet.getAnswerset().get(105)%>],
                    ['Kidney Stones', <%=oneSet.getAnswerset().get(106)%>],
                    ['Overfatigue', <%=oneSet.getAnswerset().get(107)%>],
                    ['Pneumonia', <%=oneSet.getAnswerset().get(108)%>],
                    ['Renal Faliure', <%=oneSet.getAnswerset().get(109)%>],
                    ['Fever', <%=oneSet.getAnswerset().get(110)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('familyhealthPrevious_table'));
                table.draw(data);

                //Family Health History Current
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Sickness');
                data.addColumn('number', 'No. of Persons');
                data.addRows([
            <%oneSet = currentPerResult.getSurveyResults().get(34);%>
                    ['Allergy', <%=oneSet.getAnswerset().get(98)%>],
                    ['Altherosclerosis', <%=oneSet.getAnswerset().get(99)%>],
                    ['Asthma', <%=oneSet.getAnswerset().get(100)%>],
                    ['Cough & Colds', <%=oneSet.getAnswerset().get(101)%>],
                    ['Dengue', <%=oneSet.getAnswerset().get(102)%>],
                    ['Diabetes', <%=oneSet.getAnswerset().get(103)%>],
                    ['Gl Obstruction', <%=oneSet.getAnswerset().get(104)%>],
                    ['Hemmorhage', <%=oneSet.getAnswerset().get(105)%>],
                    ['Kidney Stones', <%=oneSet.getAnswerset().get(106)%>],
                    ['Overfatigue', <%=oneSet.getAnswerset().get(107)%>],
                    ['Pneumonia', <%=oneSet.getAnswerset().get(108)%>],
                    ['Renal Faliure', <%=oneSet.getAnswerset().get(109)%>],
                    ['Fever', <%=oneSet.getAnswerset().get(110)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('familyhealthCurrent_table'));
                table.draw(data);

                //Recent Illnesses Previous
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Recent Illnesses');
                data.addColumn('number', 'No. of Persons');
                data.addRows([
            <%oneSet = pastPerResult.getSurveyResults().get(35);%>
                    ['Allergy', <%=oneSet.getAnswerset().get(98)%>],
                    ['Altherosclerosis', <%=oneSet.getAnswerset().get(99)%>],
                    ['Asthma', <%=oneSet.getAnswerset().get(100)%>],
                    ['Cough & Colds', <%=oneSet.getAnswerset().get(101)%>],
                    ['Dengue', <%=oneSet.getAnswerset().get(102)%>],
                    ['Diabetes', <%=oneSet.getAnswerset().get(103)%>],
                    ['Gl Obstruction', <%=oneSet.getAnswerset().get(104)%>],
                    ['Hemmorhage', <%=oneSet.getAnswerset().get(105)%>],
                    ['Kidney Stones', <%=oneSet.getAnswerset().get(106)%>],
                    ['Overfatigue', <%=oneSet.getAnswerset().get(107)%>],
                    ['Pneumonia', <%=oneSet.getAnswerset().get(108)%>],
                    ['Renal Faliure', <%=oneSet.getAnswerset().get(109)%>],
                    ['Fever', <%=oneSet.getAnswerset().get(110)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('familyillnssesPrevious_table'));
                table.draw(data);

                //Recent Illnesses Current
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Recent Illnesses');
                data.addColumn('number', 'No. of Persons');
                data.addRows([
            <%oneSet = currentPerResult.getSurveyResults().get(35);%>
                    ['Allergy', <%=oneSet.getAnswerset().get(98)%>],
                    ['Altherosclerosis', <%=oneSet.getAnswerset().get(99)%>],
                    ['Asthma', <%=oneSet.getAnswerset().get(100)%>],
                    ['Cough & Colds', <%=oneSet.getAnswerset().get(101)%>],
                    ['Dengue', <%=oneSet.getAnswerset().get(102)%>],
                    ['Diabetes', <%=oneSet.getAnswerset().get(103)%>],
                    ['Gl Obstruction', <%=oneSet.getAnswerset().get(104)%>],
                    ['Hemmorhage', <%=oneSet.getAnswerset().get(105)%>],
                    ['Kidney Stones', <%=oneSet.getAnswerset().get(106)%>],
                    ['Overfatigue', <%=oneSet.getAnswerset().get(107)%>],
                    ['Pneumonia', <%=oneSet.getAnswerset().get(108)%>],
                    ['Renal Faliure', <%=oneSet.getAnswerset().get(109)%>],
                    ['Fever', <%=oneSet.getAnswerset().get(110)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('familyillnssesCurrent_table'));
                table.draw(data);

                //Consulted Person(Health) Previous
                var data = google.visualization.arrayToDataTable([
                    ['Consulted Person(Health)', 'Number of Families'],
            <% oneSet = pastResult.getSurveyResults().get(25);%>
                    ['Masseuse', <%=oneSet.getAnswerset().get(117)%>],
                    ['Nurse', <%=oneSet.getAnswerset().get(118)%>],
                    ['Doctor', <%=oneSet.getAnswerset().get(119)%>],
                    ['Barangay Health Worker', <%=oneSet.getAnswerset().get(120)%>],
                    ['Priest', <%=oneSet.getAnswerset().get(121)%>],
                    ['Barangay', <%=oneSet.getAnswerset().get(122)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Consulted Person(Health) ' + lastYear;
                if (<%=oneSet.getAnswerset().get(117)%> === 0 && <%=oneSet.getAnswerset().get(118)%> === 0 && <%=oneSet.getAnswerset().get(119)%> === 0 && <%=oneSet.getAnswerset().get(120)%> === 0 && <%=oneSet.getAnswerset().get(121)%> === 0 && <%=oneSet.getAnswerset().get(122)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('consultedpersonhealthPrevious_pie'));
                chart.draw(data, options);

                //Consulted Person(Health) Current
                var data = google.visualization.arrayToDataTable([
                    ['Consulted Person(Health)', 'Number of Families'],
            <% oneSet = currentResult.getSurveyResults().get(25);%>
                    ['Masseuse', <%=oneSet.getAnswerset().get(117)%>],
                    ['Nurse', <%=oneSet.getAnswerset().get(118)%>],
                    ['Doctor', <%=oneSet.getAnswerset().get(119)%>],
                    ['Barangay Health Worker', <%=oneSet.getAnswerset().get(120)%>],
                    ['Priest', <%=oneSet.getAnswerset().get(121)%>],
                    ['Barangay', <%=oneSet.getAnswerset().get(122)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Consulted Person(Health) ' + thisYear;
                if (<%=oneSet.getAnswerset().get(117)%> === 0 && <%=oneSet.getAnswerset().get(118)%> === 0 && <%=oneSet.getAnswerset().get(119)%> === 0 && <%=oneSet.getAnswerset().get(120)%> === 0 && <%=oneSet.getAnswerset().get(121)%> === 0 && <%=oneSet.getAnswerset().get(122)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('consultedpersonhealthCurrent_pie'));
                chart.draw(data, options);

                //Consulted Person(Non-Health) Previous
                var data = google.visualization.arrayToDataTable([
                    ['Consulted Person(Non-Health)', 'Number of Families'],
            <% oneSet = pastResult.getSurveyResults().get(26);%>
                    ['Family', <%=oneSet.getAnswerset().get(123)%>],
                    ['Relatives', <%=oneSet.getAnswerset().get(124)%>],
                    ['Friends', <%=oneSet.getAnswerset().get(125)%>],
                    ['Bombay', <%=oneSet.getAnswerset().get(126)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Consulted Person(Non-Health) ' + lastYear;
                if (<%=oneSet.getAnswerset().get(123)%> === 0 && <%=oneSet.getAnswerset().get(124)%> === 0 && <%=oneSet.getAnswerset().get(125)%> === 0 && <%=oneSet.getAnswerset().get(126)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('consultedpersonnonhealthPrevious_pie'));
                chart.draw(data, options);

                //Consulted Person(Non-Health) Current
                var data = google.visualization.arrayToDataTable([
                    ['Consulted Person(Non-Health)', 'Number of People'],
            <% oneSet = currentResult.getSurveyResults().get(26);%>
                    ['Family', <%=oneSet.getAnswerset().get(123)%>],
                    ['Relatives', <%=oneSet.getAnswerset().get(124)%>],
                    ['Friends', <%=oneSet.getAnswerset().get(125)%>],
                    ['Bombay', <%=oneSet.getAnswerset().get(126)%>],
                    ['Others', <%=oneSet.getAnswerset().get(82)%>]
                ]);

                string = 'Consulted Person(Non-Health) ' + thisYear;
                if (<%=oneSet.getAnswerset().get(123)%> === 0 && <%=oneSet.getAnswerset().get(124)%> === 0 && <%=oneSet.getAnswerset().get(125)%> === 0 && <%=oneSet.getAnswerset().get(126)%> === 0 && <%=oneSet.getAnswerset().get(82)%> === 0) {
                    string = empty;
                }

                var options = {
                    title: string
                };

                var chart = new google.visualization.PieChart(document.getElementById('consultedpersonnonhealthCurrent_pie'));
                chart.draw(data, options);

                //Immunization Previous
                var data = new google.visualization.DataTable();
                        data.addColumn('string', 'Sickness');
                data.addColumn('number', 'Number of Immunized People');
                data.addRows([
            <%
                oneSet = pastPerResult.getSurveyResults().get(27);
                ArrayList<Integer> alP = new ArrayList();
                for (int x = 130; x <= 139; x++) {
                    alP.add(oneSet.getAnswerset().get(x));
                }
            %>
                    ['BCG', <%=oneSet.getAnswerset().get(130)%>],
                    ['OPT1', <%=oneSet.getAnswerset().get(131)%>],
                    ['OPT2', <%=oneSet.getAnswerset().get(132)%>],
                    ['OPT3', <%=oneSet.getAnswerset().get(133)%>],
                    ['OPV1', <%=oneSet.getAnswerset().get(134)%>],
                    ['OPV2', <%=oneSet.getAnswerset().get(135)%>],
                    ['OPV3', <%=oneSet.getAnswerset().get(136)%>],
                    ['Measles', <%=oneSet.getAnswerset().get(137)%>],
                    ['Flu', <%=oneSet.getAnswerset().get(138)%>],
                    ['Hepatitis', <%=oneSet.getAnswerset().get(139)%>],
                    ['Complete', <%=Immunization.getComplete(alP)%>],
                    ['Incomplete', <%=Immunization.getIncomplete(alP)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('immunizationPrevious_pie'));
                table.draw(data, options);

                //Immunization Current
                var data = new google.visualization.DataTable();
                    data.addColumn('string', 'Sickness');
                data.addColumn('number', 'Number of Immunized People');
                data.addRows([
                    <%
                        oneSet = currentPerResult.getSurveyResults().get(27);
                        ArrayList<Integer> alC = new ArrayList();
                        for (int x = 130; x < 139; x++) {
                            alC.add(oneSet.getAnswerset().get(x));
                        }
                    %>
                    ['BCG', <%=oneSet.getAnswerset().get(130)%>],
                    ['OPT1', <%=oneSet.getAnswerset().get(131)%>],
                    ['OPT2', <%=oneSet.getAnswerset().get(132)%>],
                    ['OPT3', <%=oneSet.getAnswerset().get(133)%>],
                    ['OPV1', <%=oneSet.getAnswerset().get(134)%>],
                    ['OPV2', <%=oneSet.getAnswerset().get(135)%>],
                    ['OPV3', <%=oneSet.getAnswerset().get(136)%>],
                    ['Measles', <%=oneSet.getAnswerset().get(137)%>],
                    ['Flu', <%=oneSet.getAnswerset().get(138)%>],
                    ['Hepatitis', <%=oneSet.getAnswerset().get(139 )%>],
                    ['Complete', <%=Immunization.getComplete(alC)%>],
                    ['Incomplete', <%=Immunization.getIncomplete(alC)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('immunizationCurrent_pie'));
                table.draw(data, options);

                //Adequate Activity Previous
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Activity');
                data.addColumn('number', 'Yes');
                data.addColumn('number', 'No');
                data.addRows([
            <%oneSet = pastResult.getSurveyResults().get(28);%>
                    ['Rest & Sleep', <%=oneSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(50)%>],
            <%oneSet = pastResult.getSurveyResults().get(29);%>
                    ['Excercise', <%=oneSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(50)%>],
            <%oneSet = pastResult.getSurveyResults().get(30);%>
                    ['Relaxation Excercise', <%=oneSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(50)%>],
            <%oneSet = pastResult.getSurveyResults().get(31);%>
                    ['Stress Management', <%=oneSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(50)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('adequateavtivityPrevious_table'));
                table.draw(data);

                //Adequate Activity Current
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Activity');
                data.addColumn('number', 'Yes');
                data.addColumn('number', 'No');
                data.addRows([
            <%oneSet = currentResult.getSurveyResults().get(28);%>
                    ['Rest & Sleep', <%=oneSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(50)%>],
            <%oneSet = currentResult.getSurveyResults().get(29);%>
                    ['Excercise', <%=oneSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(50)%>],
            <%oneSet = currentResult.getSurveyResults().get(30);%>
                    ['Relaxation Excercise', <%=oneSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(50)%>],
            <%oneSet = currentResult.getSurveyResults().get(31);%>
                    ['Stress Management', <%=oneSet.getAnswerset().get(49)%>, <%=oneSet.getAnswerset().get(50)%>]
                ]);

                var table = new google.visualization.Table(document.getElementById('adequateavtivityCurrent_table'));
                table.draw(data);
             
            }
            
             function drawChildChart() {
                //Child Age
                var data = google.visualization.arrayToDataTable([
                    ['Child Ages', '' + lastYear, '' + thisYear],
            <% oneSet = currentChildResult.getSurveyResults().get(71);%>
            <% twoSet = pastChildResult.getSurveyResults().get(71);%>
                    ['0-3 months old', <%=twoSet.getAnswerset().get(207)%>, <%=oneSet.getAnswerset().get(207)%>],
                    ['4-6 months old', <%=twoSet.getAnswerset().get(208)%>, <%=oneSet.getAnswerset().get(208)%>],
                    ['7-9 months old', <%=twoSet.getAnswerset().get(209)%>, <%=oneSet.getAnswerset().get(209)%>],
                    ['10-11 months old', <%=twoSet.getAnswerset().get(210)%>, <%=oneSet.getAnswerset().get(210)%>],
                    ['1 year old', <%=twoSet.getAnswerset().get(211)%>, <%=oneSet.getAnswerset().get(211)%>],
                    ['2 years old', <%=twoSet.getAnswerset().get(212)%>, <%=oneSet.getAnswerset().get(212)%>],
                    ['3 years old', <%=twoSet.getAnswerset().get(213)%>, <%=oneSet.getAnswerset().get(213)%>],
                    ['4 years old', <%=twoSet.getAnswerset().get(214)%>, <%=oneSet.getAnswerset().get(214)%>],
                    ['5 years old', <%=twoSet.getAnswerset().get(215)%>, <%=oneSet.getAnswerset().get(215)%>]
                ]);

                var options = {
                    title: 'Child Ages',
                    vAxis: {title: 'Child Ages', titleTextStyle: {color: 'black'}}
                };

                var chart = new google.visualization.BarChart(document.getElementById('specAge_bar'));
                chart.draw(data, options);
            }
        </script>
    </body>
</html>