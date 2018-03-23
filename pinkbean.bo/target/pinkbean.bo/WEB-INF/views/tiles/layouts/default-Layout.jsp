<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>					
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>					
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko" xml:lang="ko">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, width=device-width">
<meta name="format-detection" content="telephone=no">
<meta name="robots" content="noindex, nofollow" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PINKBEAN</title>
<link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
<link rel="stylesheet" type="text/css" href="../../resources/css/vendors/uniform.default.css">
<link rel="stylesheet" type="text/css" href="../../resources/css/vendors/owl.carousel.min.css">
<link rel="stylesheet" type="text/css" href="../../resources/css/vendors/owl.theme.default.min.css">
<link rel="stylesheet" type="text/css" href="../../resources/css/vendors/datepicker.min.css">
<link rel="stylesheet" type="text/css" href="../../resources/css/vendors/fontawesome-all.css">
<!-- <link rel="stylesheet" type="text/css" href="../../resources/css/vendors/selectric.css"> -->
<script src="../../resources/js/ui/lib/jquery-3.2.0/jquery-3.2.0.min.js"></script>
<script src="../../resources/js/ui/lib/owl.carousel-2.2.1/owl.carousel.min.js"></script>
<script src="../../resources/js/ui/lib/jquery.treemenu/jquery.treemenu.js"></script>
<script src="../../resources/js/ui/lib/datepicker-0.5.1/datepicker.min.js"></script>
<script src="../../resources/js/ui/common-ui.js"></script>
<!-- <script src="../../resources/js/ui/lib/jquery.uniform-2.2.0/jquery.uniform.min.js"></script> -->
<!-- <script src="../../resources/js/ui/lib/jquery.selectric-1.11.1/jquery.selectric.min.js"></script> -->
</head>
<body>

	<table>					
		<tr>						
			<td>					
				<tiles:insertAttribute name="menu"/>				
			</td>					
			<td>					
				<tiles:insertAttribute name="body"/>				
			</td>					
		</tr>											
	</table>

</body>
</html>