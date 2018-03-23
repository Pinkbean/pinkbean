<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>					
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>	<!-- 타일즈 쓰기 위해 필요한 것 -->		 		
    
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
</head>
<body>

	<table border="1px" bordercolor="black" width="100%" height="100%">					
		<tr>						
			<td width="300px">					
				<tiles:insertAttribute name="menu"/>				
			</td>					
			<td>					
				<tiles:insertAttribute name="body"/>				
			</td>					
		</tr>											
	</table>

</body>
</html>