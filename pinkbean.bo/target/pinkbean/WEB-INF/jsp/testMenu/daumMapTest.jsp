<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 이걸 안 넣으면 글자가 깨진당 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${appKey}"></script><!-- 다음 맵을 사용하기 위해 필요한 스크립트 -->
<script type="text/javascript" src="/resources/js/daumMap.js"></script>
<script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script><!-- 다음 약도 스크립트 -->

<div>
	<h1>다음 지도 테스트 화면!</h1></br>

	<h3>다음 지도 api</h3>
	<!-- 다음 지도 api -->
	<div id="map" style="width:500px;height:200px;"></div></br>
	
	<h3>다음 약도</h3>
	<!--
		* Daum 지도 - 약도서비스
		* 한 페이지 내에 약도를 2개 이상 넣을 경우에는
		* 약도의 수 만큼 소스를 새로 생성, 삽입해야 합니다.
	-->
	<div id="daumRoughmapContainer1522737398489" class="root_daum_roughmap root_daum_roughmap_landing"></div>
	달리 키를 발급받을 필요없이 그냥 다음지도에서 검색 > 상세보기 > 약도 생성하기를 통해 만들 수 있다.</br>
	시립과학박물관의 찾아오시는 길도 이 약도보기로 만들어져 있다.</br>

</div>
<script>

</script>