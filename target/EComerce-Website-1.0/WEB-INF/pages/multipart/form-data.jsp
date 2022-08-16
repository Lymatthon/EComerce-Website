
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Upload Multiple File:</h3>

        <!-- MyUploadForm -->
        <form:form modelAttribute="productImages" method="POST"
                   action="/littleshop/uploadMultifile" enctype="multipart/form-data">

                             

            File to upload (1): <form:input path="fileDatas" type="file"/><br />      
            File to upload (2): <form:input path="fileDatas" type="file"/><br />    
            File to upload (3): <form:input path="fileDatas" type="file"/><br />    
            File to upload (4): <form:input path="fileDatas" type="file"/><br />    
            File to upload (5): <form:input path="fileDatas" type="file"/><br />    

            <input type="submit" value="Upload">

        </form:form>


    </body>
</html>
