<!DOCTYPE html>
<html>
<head lang="en">
	<title>Spring Boot Demo - FreeMarker</title>
	<link href="/css/index.css" rel="stylesheet" />
</head>
<body>
	<center>
		<img src="/images/yefan.jpg" />
		<h1 id="title">${title}</h1>
	</center>
	
	<script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
	
	<form method="POST" enctype="multipart/form-data" action="/file/upload">	
	文件：<input type="file" name="titaniumeFile" /> <input type="submit" value="上传" />	
	</form>
	
	<script>
		$(function(){
			$('#title').click(function(){
				alert('点击了');
			});
		})
	</script>
</body>
</html>