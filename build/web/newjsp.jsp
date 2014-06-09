<%@page import="org.zefer.pd4ml.taglib/"%>
<%@ taglib uri="WEB-INF/tlds/pd4ml.tld" prefix="pd4ml" %><pd4ml:transform
	screenWidth="400"
	pageFormat="A5"
	pageOrientation="landscape"
	pageInsets="15,15,15,15,points"
	enableImageSplit="false"
	inline="true"
	fileName="myreport.pdf"
	interpolateImages="false">

<pd4ml:footer
	titleTemplate="[${title}]"
	pageNumberTemplate="page ${page}"
	titleAlignment="left"
	pageNumberAlignment="right"
	color="#008000"
	initialPageNumber="1"
	pagesToSkip="1"
	fontSize="14"
	areaHeight="18"/>

<html>
	<head>
		<title>pd4ml header/footer test</title>
		<style type="text/css">
			body {
				color: #000000;
				background-color: #FFFFFF;
				font-family: Tahoma, "Sans-Serif";
				font-size: 10pt;
			}
		</style>
	</head>
	<body>

		<img src="images/logos.gif" width="125" height="74">

		<p>

		Hello, World!

<pd4ml:page.break/>