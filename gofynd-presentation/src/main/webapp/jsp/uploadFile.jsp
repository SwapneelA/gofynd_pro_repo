<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>File Upload Example in Java web application</title>
</head>
<body>
        <h3>Choose File to Upload in Server</h3>
        <form action="UploadFile.htm" method="post" enctype="multipart/form-data">
                <input type="file" name="file" /> 
                <input type="submit" value="upload" />
        </form>
</body>
</html>