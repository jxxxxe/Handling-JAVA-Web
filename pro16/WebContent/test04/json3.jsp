<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 테스트</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#checkJson").click(function(){
			var jsonStr = '{"name":"홍길동","age":12,"gender":"남자","nickname":"날쌘돌이"}';
			var output="회원 정보<br>";
			output+="======<br>";
			output+="이름 : "+jsonInfo.name+"<br>";
			output+="나이 : "+jsonInfo.age+"<br>";
			output+="성별 : "+jsonInfo.gender+"<br>";
			output+="별명 : "+jsonInfo.nickname+"<br>";
			$('#output').html(output);
		});
	});
</script>
</head>
<body>
 <a id="checkJson" style="cursor:pointer">출력</a><br><br>
 <div id="output"></div>
</body>
</html>