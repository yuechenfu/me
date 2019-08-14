<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
<h1>文件上传</h1>
<form method="post" action="/recurit/upload/image" enctype="multipart/form-data">
    选择一个图片:
    <input type="file" name="headImage" />
    <br/><br/>
    <input type="submit" value="上传" />
</form>

<form method="post" action="/recurit/upload/file" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="fileName" />
    <br/><br/>
    <input type="submit" value="上传" />
</form>
<c:if test="${headImage != null }">
  <img src="/recurit/upload/show?fileName=${headImage}" style="width: 100px"/>
</c:if>
</body>
</html>