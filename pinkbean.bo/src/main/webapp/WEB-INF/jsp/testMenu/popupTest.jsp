<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 이걸 안 넣으면 글자가 깨진당 -->
<script type="text/javascript" src="/resources/js/popUp.js"></script>
<div>
	<h1>팝업 테스트 화면!</h1></br>
	<button id="popup" class="sampleBtn popup">팝업버튼</button> <br><br>
	
	<h3> 미리보기 테스트 </h3>
	<form id="major">
		<button id="popupContent" class="sampleBtn popup">팝업버튼</button> <br><br>
		<textarea id="contents" name="contents" rows="10" cols="50">
			이 값을 전달하려고 한다. 잘 될까?
			<table style="width: 100%; border: 1px solid #444444;">
				<tr>
					<th>
						<h1>태그도 제대로 적용되는지 함 보려고 아예 textarea 안에 태그를 넣어봤습니다.</h1>
					</th>
				</tr>
			</table>
		</textarea>
	</form>

	<h3> 아래는 영상 </h3>
	<iframe width="272" height="212" src="https://www.youtube.com/embed/Pom4gZ_RBsc" frameborder="0" allowfullscreen=""></iframe>
</div>