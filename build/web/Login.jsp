<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Admin Simplenso - Login Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="HTML5 Admin Simplenso Template" />
        <meta name="author" content="ahoekie" />

        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" id="main-theme-script" />
        <link href="css/themes/default.css" rel="stylesheet" id="theme-specific-script" />
        <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />

        <!-- Bootstrap Image Gallery styles -->
        <link rel="stylesheet" href="css/bootstrap-image-gallery.min.css" />

        <!-- Simplenso -->
        <link href="css/simplenso.css" rel="stylesheet" />

        <!-- Renliw -->
        <link href="css/renliw.css" rel="stylesheet" />

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <style>
                    body{
                        min-width:1300px;
                    }
        </style>
        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="images/ico/favicon.ico" />
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      
        
    </head>
  
    

    <body id="dashboard" class="hidden">
        <header>
            <div id="top-band"></div>
            <div class="container">
                <div class="nav-header ">
                    <div class="banner"></div>
                    <br/>
                </div>
            </div>
        </header>
        <div class="container-fluid" >
            <div class="row-fluid">
                <div class="span3">&nbsp;</div>
                <div class="span6">
                    <div class="page-header" >
                        <h1>Community Project Management System</h1>
                    </div>
                    <div class="box">
                        <h4 class="box-header round-top">Sign-In</h4>
                        <div class="box-container-toggle">
                            <div class="box-content">
                                <form class="well form-search" method="POST" action="Login" />
                                <%
                                    Boolean isValid = (Boolean) request.getAttribute("ValidUser");
                                    if (!isValid) {
                                %>
                                <center><h5 style="color: red;">Invalid Username or Password</h5></center>
                                    <%
                                        }
                                    %>
                                <input name="username" type="text" class="input" placeholder="Username" required/>
                                <input name="password" type="password" class="input" placeholder="Password" required/>
                                <button type="submit" class="btn">Sign-In</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!--/span--> 
                </div>
                <!--/span--> 
            </div>
            <!--/row-->
        </div>
        <!--/.fluid-container--> 
        <!-- javascript Templates
            ================================================== --> 
        <!-- Placed at the end of the document so the pages load faster --> 

        <!-- jQuery -->
        <script src="jquery/1.8.3/jquery.min.js"></script>

        <!-- jQuery UI Sortable -->
        <script src="scripts/jquery-ui/ui/minified/jquery.ui.core.min.js"></script>
        <script src="scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>
        <script src="scripts/jquery-ui/ui/minified/jquery.ui.mouse.min.js"></script>
        <script src="scripts/jquery-ui/ui/minified/jquery.ui.sortable.min.js"></script>
        <script src="scripts/jquery-ui/ui/minified/jquery.ui.widget.min.js"></script>

        <!-- Bootstrap -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="scripts/bootbox/bootbox.min.js"></script>

        <!-- Bootstrap Date Picker -->
        <script src="scripts/datepicker/js/bootstrap-datepicker.js"></script>


        <!-- jQuery Cookie -->
        <script src="scripts/jquery.cookie/jquery.cookie.js"></script>

        <!-- Full Calender -->
        <script type='text/javascript' src="scripts/fullcalendar/fullcalendar/fullcalendar.min.js"></script>

        <!-- CK Editor -->
        <script type="text/javascript" src="scripts/ckeditor/ckeditor.js"></script>

        <!-- Chosen multiselect -->
        <script type="text/javascript" language="javascript" src="scripts/chosen/chosen/chosen.jquery.min.js"></script>

        <!-- Uniform -->
        <script type="text/javascript" language="javascript" src="scripts/uniform/jquery.uniform.min.js"></script>

        <!-- Simplenso Scripts -->
        <script src="scripts/simplenso/simplenso.js"></script>
    </body>
</html>
