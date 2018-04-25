<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 이걸 안 넣으면 글자가 깨진당 -->

<div>
	<h1>메일 테스트 화면!</h1></br>
	<input type="button" id="mailSendBtn" value="전송~!">

</div>
<script>
	$(function(){
		$("#mailSendBtn").on("click",function(){
	        $.ajax({
	            url:'/mail/sendMail',
	            dataType: 'json',
	            success:function(data){
	            	alert(data);
	            },
	            error:function(e){
	            	alert('에러가 발생했습니다.');
	            }
	        })			
		});	
	});
</script>