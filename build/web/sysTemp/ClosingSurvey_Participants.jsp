<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Admin Simplenso - Tables</title>
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
    <body id="tables">
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
                        <div class="span12">
                            <!-- Portlet: Fancy Portlets -->
                            <div class="box">
                                <h4 class="box-header round-top">Closing Survey for Participants
                                    <a class="box-btn" title="close"><i class="icon-remove"></i></a>
                                    <a class="box-btn" title="toggle"><i class="icon-minus"></i></a>     
                                    <a class="box-btn" title="config" data-toggle="modal" href="#box-config-modal"><i class="icon-cog"></i></a>
                                </h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="tables">
                                            <thead>
                                            <br>
                                            <h4>Check the box that applies to your answer to the indicated objective.</h4>
                                            <tr>
                                                <th>Overall Activity Objectives</th>
                                                <th>Strongly Agree</th>
                                                <th>Agree</th>
                                                <th>Neutral</th>
                                                <th>Disagree</th>
                                                <th>Strongly Disagree</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td> 1.	The activity was well-organized and flowed smoothly. </td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                </tr>
                                                <tr>
                                                    <td> 2.	Registration procedures were conducted smoothly and effectively.</td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                </tr>
                                                <tr>
                                                    <td>3.	The activity was relevant and catered to my health needs. </td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                </tr>
                                                <tr>
                                                    <td>4.	The resources (medicines, freebies, volunteers, etc.) provided in the activity were sufficient and were properly distributed.</td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                </tr>
                                                <tr>
                                                    <td>5.	The activity provided quality services to the community. </td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                </tr>
                                                <tr>
                                                    <td>6.	The time allotted to the activity was sufficient to attend to my needs.</td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                </tr>
                                                <tr>
                                                    <td>7.	The medical practitioners, health workers and volunteers were fully engaged in the activity and my needs.</td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                </tr>
                                                <tr>
                                                    <td>8.	The activity met my expectations.</td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                    <td class="center"><input class="uniform_on" type="checkbox" id="optionsCheckbox" value="option1" /></td>
                                                </tr>

                                            <br>

                                            </tr>

                                            </tbody>
                                        </table>

                                        <h4>Comments and Suggestions</h4>

                                        <th> <div class="col-lg-10">
                                            <textarea style="width: 60%" class="form-control" rows="6" id="textArea" placeholder="Input your comments and suggestions"></textarea>
                                        </div></th> 
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                            <button type="reset" class="btn">Cancel</button>
                                        </div>
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

                <!-- Chosen multiselect -->
                <script type="text/javascript" language="javascript" src="../scripts/chosen/chosen/chosen.jquery.min.js"></script>  

                <!-- Simplenso Scripts -->
                <script src="../scripts/simplenso/simplenso.js"></script>
            </div></div></body>
</html>