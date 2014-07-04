<%@page import="Utilities.Year"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
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
        <style>
                    body{
                        min-width:1400px;
                    }
        </style>

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../images/ico/favicon.ico" />
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../images/ico/apple-touch-icon-144-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../images/ico/apple-touch-icon-114-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../images/ico/apple-touch-icon-72-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" href="../images/ico/apple-touch-icon-57-precomposed.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

    <body id="members">
        <!--Templates-->
        <textarea style="display:none" id="familyMemberTemplate">
            <tr id="familyMember-{0}">
                <input name="numOfFamilyMem" type="hidden">
                <td><input class="input-small" id="name" name="name" type="text" placeholder="person {0}" required></input></td>
                <td><input class="input-mini" id="age" name="age" type="number" required></input></td>
                <td>
                    <select class="input-mini" id="gender" name="gender" required>
                        <option value>Select..</option>
                        <option value="M">M</option>
                        <option value="F">F</option>
                    </select>
                </td>
                <td>
                    <select class="input-mini" id="civilStatus" name="civilStatus" required>
                        <option value>Select..</option>
                        <option value="1">Single</option>
                        <option value="2">Married</option>
                        <option value="3">Widowed</option>
                        <option value="4">Separated</option>
                        <option value="5">Live-In</option>
                    </select>
                </td>
                <td>
                    <select class="input-small" id="positionInFamily" name="positionInFamily" required>
                        <option value>Select..</option>
                        <option value="Father">Father</option>
                        <option value="Mother">Mother</option>
                        <option value="Grandfather">Grandfather</option>
                        <option value="Grandmother">Grandmother</option>
                        <option value="Sibling">Sibling</option>
                        <option value="Child">Child</option>
                        <option value="Cousin">Cousin</option>
                    </select>
                </td>
                <td>
                    <select class="input-small" id="eduactionalAttainment" name="eduactionalAttainment" required>
                        <option value>Select..</option>
                        <option value="17">5 and below</option>
                        <option value="18">Pre-school</option>
                        <option value="19">Elementary</option>
                        <option value="20">HS Level</option>
                        <option value="21">HS Grdauate</option>
                        <option value="22">Vocational</option>
                        <option value="23">College Level</option>
                        <option value="24">College Graduate</option>
                    </select>
                </td>
                <td><input class="input-mini" id="work" name="work" type="text"></input></td>
                <td><label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="98" />Allergy</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="99" />Altherosclerosis</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="100" />Asthma</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="101" />Coughs & Colds</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="102" />Dengue</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="103" />Diabetes</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="104" />Gl Obstruction</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="105" />Hemmorhage</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="106" />KidneyStones</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="107" />Overfatigue</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="108" />Pneumonia</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="109" />Renal Failure</label>
                    <label class="checkbox"><input type="checkbox" id="healthHistory-{0}" name="healthHistory-{0}" value="110" />Fever</label>
                </td>
                <td>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="98" />Allergy</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="99" />Altherosclerosis</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="100" />Asthma</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="101" />Coughs & Colds</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="102" />Dengue</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="103" />Diabetes</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="104" />Gl Obstruction</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="105" />Hemmorhage</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="106" />KidneyStones</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="107" />Overfatigue</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="108" />Pneumonia</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="109" />Renal Failure</label>
                    <label class="checkbox"><input type="checkbox" id="illnesses-{0}" name="illnesses-{0}" value="110" />Fever</label>
                </td>
                <td>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="130" checked/>BCG</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="131" checked/>DTP1</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="132" checked/>DTP2</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="133" checked/>DTP3</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="134" checked/>OVP1</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="135" checked/>OVP2</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="136" checked/>OVP3</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="137" checked/>Measles</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="138" checked/>Flu</label>
                    <label class="checkbox"><input type="checkbox" id="familyImmunization-immunization-{0}" name="familyImmunization-immunization-{0}" value="139" checked/>Hepatitis</label>
                </td>
            </tr>
    </textarea>


    <textarea style="display:none" id="familyNeedsTemplate">
                <br/>
                <select type="text" name="needs" id="needs" required>
                <option value="54">Medicine</option>
                <option value="55">Additional Income</option>
                <option value="56">Education</option>
                <option value="57">Food</option>
                <option value="58">Owned Comfort Room</option>
                <option value="59">Medical Assistance</option>
                <option value="60">Livelihood</option>
                <option value="61">Counseling</option>
                <option value="62">Parenting</option>
                <option value="63">Housing</option>
            </select>
    </textarea>

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
                    <div class="row-fluid">
                        <div class="span12" id="col4">
                            <div class="box" id="box-3">
                                <h4 class="box-header round-top">Community Survey</h4>         
                                <div class="box-container-toggle">
                                    <div class="box-content">
                                        <form method="POST" action="EncodeCommunitySurvey" id="surveyForm" class="form-horizontal">
                                            <fieldset>
                                            <%
                                                String community_id = (String) request.getAttribute("community_id");
                                                String community_name = (String) request.getAttribute("community_name");
                                            %>
                                            <legend>Encode Survey for <%=community_name%></legend>
                                            <input type="hidden" name="community_id" value="<%=community_id%>"/>

                                            <div class="control-group">
                                                <label class="control-label" for="yearOfSurvey">Year of Survey:</label>
                                                <div class="controls">
                                                    <select name="yearOfSurvey" id="yearOfSurvey" class="chzn-select">
                                                        <option value="<%=Year.getCurrentYear()%>"><%=Year.getCurrentYear()%></option>
                                                        <option value="<%=Year.getPreviousYear()%>"><%=Year.getPreviousYear()%></option>
                                                    </select>
                                                </div>
                                            </div>

                                            <br/><h2>Family Structure</h2>

                                            <div class="control-group">
                                                <label class="control-label" for="familyName">Family Name:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="familyName" name="familyName" type="text" required/>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="address">Address:</label>
                                                <div class="controls">
                                                    <input class="input-xxlarge" id="address" name="address" type="text" required/>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="yearsInCommunity">No. of Years in Community:</label>
                                                <div class="controls">
                                                    <input class="input-small" id="yearsInCommunity" name="yearsInCommunity" type="number" required/>
                                                </div>
                                            </div>

                                            <!--<div class="control-group">
                                                <label class="control-label" for="noOfFamilyMembers">No. of Family Members</label>
                                                <div class="controls">
                                                    <input class="input-small" id="noOfFamilyMembers" name="noOfFamilyMembers" type="number" required/>
                                                </div>
                                            </div>-->

                                            <label><br/><strong>Religion</strong></label>

                                            <div class="control-group">
                                                <label class="control-label" for="relegionOfFather">Father:</label>
                                                <div class="controls">
                                                    <select id="relegionOfFather" name="relegionOfFather" class="chzn-select">
                                                        <option value></option>
                                                        <option value="6">Catholic</option>
                                                        <option value="7">Iglesia Ni Kristo</option>
                                                        <option value="8">Muslim</option>
                                                        <option value="9">Protestant</option>
                                                        <option value="10">Buddhist</option>
                                                        <option value="11">Born Again</option>
                                                        <option value="12">Baptist</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="relegionOfMother" >Mother: </label>
                                                <div class="controls">
                                                    <select id="relegionOfMother" name="relegionOfMother" class="chzn-select">
                                                        <option value></option>
                                                        <option value="6">Catholic</option>
                                                        <option value="7">Iglesia Ni Kristo</option>
                                                        <option value="8">Muslim</option>
                                                        <option value="9">Protestant</option>
                                                        <option value="10">Buddhist</option>
                                                        <option value="11">Born Again</option>
                                                        <option value="12">Baptist</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <!--<label><br/><strong>Place of Origin</strong></label>
                                            <div class="control-group">
                                                <label class="control-label" for="fatherOrigin">Father:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="fatherOrigin" name="fatherOrigin" type="text"/>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="motherOrigin">Mother:</label>
                                                <div class="controls">
                                                    <input class="input-xlarge" id="motherOrigin" name="motherOrigin" type="text"/>
                                                </div>
                                            </div>-->

                                            <br/>
                                            <div class="control-group">
                                                <label class="control-label" for="typeOfFamily"><strong>Type of Family</strong></label>
                                                <div class="controls">
                                                    <select id="typeOfFamily" name="typeOfFamily" class="chzn-select">
                                                        <option value="Nuclear">Nuclear</option>
                                                        <option value="Single Parent">Single Parent</option>
                                                        <option value="Extended">Extended</option>
                                                        <option value="Childless">Childless</option>
                                                        <option value="Step Family">Step Family</option>
                                                        <option value="Grand Family">Grand Family</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <br/>
                                            <h2>Members of the Family</h2>
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Name</th>
                                                        <th>Age</th>
                                                        <th>Gender</th>
                                                        <th>Civil Status</th>
                                                        <th>Position in the Family</th>
                                                        <th>Educational Attainment</th>
                                                        <th>Work</th>
                                                        <th>Health History</th>
                                                        <th>Illnesses</th>
                                                        <th>Immunization</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="familyMember">

                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <td colspan="11"><button class="btn btn-small" id="addFamilyMember" type="button"><i class="icon-plus"></i>Add New Family Member</button></td>
                                                    </tr>
                                                </tfoot>
                                            </table>

                                            <br/><h2>Family Status</h2>
                                            <label><strong>Misunderstanding in the Family</strong></label>
                                            <div class="control-group">
                                                <label class="control-label" for="battered">a. Battered husband/wife</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="battered" name="battered" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="battered" name="battered" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="fights">b. Frequent fights</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="fights" name="fights" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="fights" name="fights" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="childabuse">c. Child abuse</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="childabuse" name="childabuse" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="childabuse" name="childabuse" value="50"/>No</label>
                                                </div>
                                            </div>

                                            <label><strong>Characteristics of Communication</strong></label>
                                            <div class="control-group">
                                                <label class="control-label" for="puttingoff">a. Putting-off conversations</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="puttingoff" name="puttingoff" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="puttingoff" name="puttingoff" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="2b">b. Use of inappropriate words(such as insults, bad words)</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="inappropriateword" name="inappropriateword" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="inappropriateword" name="inappropriateword" value="50"/>No</label>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="income"><strong>Monthly Family Income</strong></label>
                                                <div class="controls">
                                                    <select class="input-xlarge" id="income" name="income" required>
                                                        <option value="146">Below 5,000 pesos</option>
                                                        <option value="147">5,000 - 10,000 pesos</option>
                                                        <option value="148">10,000 - 15,000 pesos</option>
                                                        <option value="149">15,000 - 20,000 pesos</option>
                                                        <option value="150">20,000 - 30,000 pesos</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="sourceincome"><strong>Source of Monthly Family Income</strong></label>
                                                <div class="controls">
                                                    <select class="input-xlarge" id="sourceincome" name="sourceincome" required>
                                                        <option value="51">Father</option>
                                                        <option value="52">Mother</option>
                                                        <option value="53">Both</option>
                                                        <option value="82">Others</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="needs"><strong>Felt Family Needs</strong></label>
                                                <div class="controls">
                                                    <div id="familyNeeds"></div>
                                                    <button class="btn btn-small" id="addFamilyNeeds" type="button"><i class="icon-plus"></i>Add Family Needs</button>
                                                </div>
                                            </div>

                                            <br/><h2>Home and Environmental Factors</h2>
                                            <div class="control-group">
                                                <label class="control-label" for="hasLot">Lot Owned</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="hasLot" name="hasLot"  value="49" required/>Yes</label>
                                                    <label><input type="radio" id="hasLot" name="hasLot" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="hasHouse">House Owned</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="hasHouse" name="hasHouse" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="hasHouse" name="hasHouse" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="typeOfHouse">Type of House</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="typeOfHouse" name="typeOfHouse" value="65" required/>Wood</label>
                                                    <label><input type="radio" id="typeOfHouse" name="typeOfHouse" value="66"/>Concrete</label>
                                                    <label><input type="radio" id="typeOfHouse" name="typeOfHouse" value="67"/>Mixed</label>
                                                    <label><input type="radio" id="typeOfHouse" name="typeOfHouse" value="82"/>Others</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="typeOfGarbageDisposal">Type of Garbage Disposal</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="typeOfGarbageDisposal" name="typeOfGarbageDisposal" value="68" required/>Collected</label>
                                                    <label><input type="radio" id="typeOfGarbageDisposal" name="typeOfGarbageDisposal" value="69"/>Thrown in the river</label>
                                                    <label><input type="radio" id="typeOfGarbageDisposal" name="typeOfGarbageDisposal" value="82"/>Others</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="typeOfToilet">Type of Toilet</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="typeOfToilet" name="typeOfToilet" value="72" required/>Water Sealed</label>
                                                    <label><input type="radio" id="typeOfToilet" name="typeOfToilet" value="73"/>No Toilet</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="typeOfDrainage">Type of Drainage System</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="typeOfDrainage" name="typeOfDrainage" value="70" required/>Open</label>
                                                    <label><input type="radio" id="typeOfDrainage" name="typeOfDrainage" value="71"/>Closed</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="sourceOfWater">Source of Water</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="sourceOfWater" name="sourceOfWater" value="74" required/>Owned</label>
                                                    <label><input type="radio" id="sourceOfWater" name="sourceOfWater" value="75"/>Bought</label>
                                                    <label><input type="radio" id="sourceOfWater" name="sourceOfWater" value="76"/>Shared</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="sourceOfDrinkingWater">Source of Drinking Water</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="sourceOfDrinkingWater" name="sourceOfDrinkingWater" value="77" required/>Refrigerated</label>
                                                    <label><input type="radio" id="sourceOfDrinkingWater" name="sourceOfDrinkingWater" value="78"/>Covered</label>
                                                    <label><input type="radio" id="sourceOfDrinkingWater" name="sourceOfDrinkingWater" value="82"/>Others</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="drinkingWaterStorage">Drinking Water Storage</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="drinkingWaterStorage" name="drinkingWaterStorage" value="79" required/>Plastic Pitchers</label>
                                                    <label><input type="radio" id="drinkingWaterStorage" name="drinkingWaterStorage" value="80"/>Bottles</label>
                                                    <label><input type="radio" id="drinkingWaterStorage" name="drinkingWaterStorage" value="81"/>Jars or Clay Pots</label>
                                                    <label><input type="radio" id="drinkingWaterStorage" name="drinkingWaterStorage" value="82"/>Others</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="foodStorage">Food Storage</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="foodStorage" name="foodStorage" value="83" required/>Covered</label>
                                                    <label><input type="radio" id="foodStorage" name="foodStorage" value="84"/>Refrigerated</label>
                                                    <label><input type="radio" id="foodStorage" name="foodStorage" value="85"/>Cabinet</label>
                                                    <label><input type="radio" id="foodStorage" name="foodStorage" value="82"/>Others</label>
                                                </div>
                                            </div>
                                            <!--<div class="control-group">
                                                <label class="control-label" for="pestsPresence">Presence of Pests</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="pestsPresence" name="pestsPresence" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="pestsPresence" name="pestsPresence" value="50"/>No</label>
                                                </div>
                                            </div>-->
                                            <div class="control-group">
                                                <label class="control-label" for="breedingSite">Presence of Pests' Breeding Sites</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="breedingSite" name="breedingSite" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="breedingSite" name="breedingSite" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="typeOfPests">Type of Pests</label>
                                                <div class="controls">
                                                    <select id="typeOfPests" name="typeOfPests" multiple class="chzn-select">
                                                        <option value="86">Rat</option>
                                                        <option value="87">Cockroach</option>
                                                        <option value="88">Bed Bug</option>
                                                        <option value="89">Termite</option>
                                                        <option value="82">Others</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="typeOfPets">Pets/Animals Kept</label>
                                                <div class="controls">
                                                    <select id="typeOfPets" name="typeOfPets" multiple class="chzn-select">
                                                        <option value="90">Dog</option>
                                                        <option value="91">Cat</option>
                                                        <option value="92">Chicken/Rooster</option>
                                                        <option value="93">Pig</option>
                                                        <option value="94">Dove</option>
                                                        <option value="95">Duck</option>
                                                        <option value="96">Monkey</option>
                                                        <option value="97">Snake</option>
                                                        <option value="82">Others</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="typeofhazards">Presence of Accident Hazards</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="typeofhazards" name="typeofhazards" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="typeofhazards" name="typeofhazards" value="50"/>No</label>
                                                </div>
                                            </div>

                                            <br/><h2>Health Assessments</h2>
                                            <div class="control-group">
                                                <label class="control-label" for="mealsPerDay">Meals per Day</label>
                                                <div class="controls">
                                                    <input type="number" id="mealsPerDay" name="mealsPerDay" class="input-medium" required/>
                                                </div>
                                            </div>

                                            <br/>
                                            <div class="control-group">
                                                <label class="control-label" for="healthPerson">Consulted Person on Health Concerns</label>
                                                <div class="controls">
                                                    <select id="healthPerson" multiple name="healthPerson" class="chzn-select" required>
                                                        <option value="117">Massage Therapist</option>
                                                        <option value="118">Nurse</option>
                                                        <option value="119">Doctor</option>
                                                        <option value="120">Barangay Health Worker</option>
                                                        <option value="121">Priest</option>
                                                        <option value="122">Barangay</option>
                                                        <option value="82">Others</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="nonHealthPerson">Consulted Person on Non-Health Concerns</label>
                                                <div class="controls">
                                                    <select id="nonHealthPerson" name="nonHealthPerson" multiple class="chzn-select" required>
                                                        <option value="123">Family</option>
                                                        <option value="124">Relatives</option>
                                                        <option value="125">Friends</option>
                                                        <option value="126">Bombay</option>
                                                        <option value="82">Others</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="adequateRest">Adequate Rest & Sleep</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="adequateRest" name="adequateRest" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="adequateRest" name="adequateRest" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="exercise">Adequate Exercise</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="exercise" name="exercise" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="exercise" name="exercise" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="relaxation">Adequate Relaxation Exercise</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="relaxation" name="relaxation" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="relaxation" name="relaxation" value="50"/>No</label>
                                                </div>
                                            </div>
                                            <div class="control-group">
                                                <label class="control-label" for="stressManagement">Adequate Stress Management</label>
                                                <div class="controls">
                                                    <label><input type="radio" id="stressManagement" name="stressManagement" value="49" required/>Yes</label>
                                                    <label><input type="radio" id="stressManagement" name="stressManagement" value="50"/>No</label>
                                                </div>
                                            </div>

                                            <div class="form-actions">
                                                <button id="submitbtn" name="action" value="SurveySubmitted" type="submit" class="btn btn-primary">Submit</button>
                                                <a href="CommunitySurvey" class="btn">Cancel</a>
                                                <!--<a href="ChildSurvey.jsp" class="btn">Child Survey</a>-->
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
        $.validator.addMethod("familyMemberDetails", function(value, element) {
            return !this.optional(element) && !this.optional($(element).parent().prev().children("select")[0]);
        }, "Please select both the item and its amount.");

        $().ready(function() {
            //dynamic family member fields
            var familyMemberTemplate = jQuery.validator.format($.trim($("#familyMemberTemplate").val()));
            function addFamilyMemberRow() {
                $(familyMemberTemplate(familyMemberCount++)).appendTo("#familyMember");
            }
            var familyMemberCount = 1;
            addFamilyMemberRow();
            $("#addFamilyMember").click(addFamilyMemberRow);

            //dynamic family needs fields
            var familyNeedsTemplate = jQuery.validator.format($.trim($("#familyNeedsTemplate").val()));
            function addFamilyNeedsRow() {
                $(familyNeedsTemplate(familyNeedsCount++)).appendTo("#familyNeeds");
            }
            var familyNeedsCount = 1;
            addFamilyNeedsRow();
            $("#addFamilyNeeds").click(addFamilyNeedsRow);

            //dynamic family health history fields
            var familyHealthHistoryTemplate = jQuery.validator.format($.trim($("#familyHealthHistoryTemplate").val()));
            function addFamilyHealthHistoryRow() {
                $(familyHealthHistoryTemplate(familyHealthHistoryCount++)).appendTo("#familyHealthHistory");
            }
            var familyHealthHistoryCount = 1;
            addFamilyHealthHistoryRow();
            $("#addFamilyHealthHistory").click(addFamilyHealthHistoryRow);

            //dynamic family illnessses fields
            var familyIllnessesTemplate = jQuery.validator.format($.trim($("#familyIllnessesTemplate").val()));
            function addFamilyIllnessesRow() {
                $(familyIllnessesTemplate(familyIllnessesCount++)).appendTo("#familyIllnesses");
            }
            var familyIllnessesCount = 1;
            addFamilyIllnessesRow();
            $("#addFamilyIllnesses").click(addFamilyIllnessesRow);

            //dynamic family illnessses fields
            var familyImmunizationTemplate = jQuery.validator.format($.trim($("#familyImmunizationTemplate").val()));
            function addFamilyImmunizationRow() {
                $(familyImmunizationTemplate(familyImmunizationCount++)).appendTo("#familyImmunization");
            }
            var familyImmunizationCount = 1;
            addFamilyImmunizationRow();
            $("#addFamilyImmunization").click(addFamilyImmunizationRow);

            // validate signup form on keyup and submit
            $("#surveyForm").validate({
                onkeyup: false,
                onclick: false,
                rules: {
                    yearsInCommunity: {
                        min: 0
                    },
                    noOfFamilyMembers: {
                        min: 0
                    },
                    age: {
                        min: 0
                    },
                    mealsPerDay: {
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
                    $(element).before("<label for='" + id + "' id="+ "error-container" +" class='error'>" + error.text() + "</label>");
                }
            });
        });
    </script>
</body>
</html>