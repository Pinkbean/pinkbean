<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 이걸 안 넣으면 글자가 깨진당 -->	

<!-- 타일즈 쓰기 위해 필요한 것 -->		
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>	

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>


<!-- headerStart -->

<!-- headerCSS -->

<!-- headerJS -->
<script type="text/javascript" src="/resources/js/lib/jquery-3.2.0/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/lib/jquery-3.2.0/jquery.js"></script>

<!-- eval -->
<%-- Daum API appKey --%>
<%-- <spring:eval var="appKey" expression="@environment['pinkbean.kakao.javaScriptKey']" /> --%>