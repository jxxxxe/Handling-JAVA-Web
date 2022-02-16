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
			var jsonStr = '{"members":[{"name":"박지성","age":25,"gender":"남자","nickname":"날쌘돌이"},'
				+'{"name":"손흥민","age":31,"gender":"남자","nickname":"탱크"},'
				+'{"name":"홍길동","age":12,"gender":"남자","nickname":"홍당무"}]}';
			var output="회원 정보<br>";
			var jsonInfo=JSON.parse(jsonStr);
			output+="======<br>";
			for(var i in jsonInfo.members){
				output+="이름 : "+jsonInfo.members[i].name+"<br>";
				output+="나이 : "+jsonInfo.members[i].age+"<br>";
				output+="성별 : "+jsonInfo.members[i].gender+"<br>";
				output+="별명 : "+jsonInfo.members[i].nickname+"<br><br>";
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