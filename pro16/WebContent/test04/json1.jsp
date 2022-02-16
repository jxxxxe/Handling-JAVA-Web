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
			var jsonStr = '{"name":["홍길동", "이순신", "임꺽정"]}'; //객체의 name:name, value:배열 
			var jsonInfo = JSON.parse(jsonStr); //JSON형식으로 파싱
			var output="회원 이름<br>";
			output+="======<br>";
			for(var i in jsonInfo.name){ //배열을 돌리면 i는 인덱스(cf. 객체를 돌리면 i는 name)
				output+=jsonInfo.name[i]+"<br>";
			}
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