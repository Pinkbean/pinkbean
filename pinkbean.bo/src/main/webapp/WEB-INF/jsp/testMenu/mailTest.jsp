<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 이걸 안 넣으면 글자가 깨진당 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${appKey}"></script><!-- 다음 맵을 사용하기 위해 필요한 스크립트 -->
<script type="text/javascript" src="/resources/js/daumMap.js"></script>
<script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script><!-- 다음 약도 스크립트 -->

<div>
	<h1>메일 테스트 화면!</h1></br>
	<input type="button" id="mailSendBtn" value="전송~!">

</div>
<script>
	$(function(){
		$("#mailSendBtn").on("click",function(){
	        $.ajax({
	            url:'/mail/mailSend',
	            success:function(data){
	                $('#time').append(data);
	            },
	            error:function(e){
	            	alert('에러가 발생했습니다.');
	            }
	        })			
		});	
	});
</script>