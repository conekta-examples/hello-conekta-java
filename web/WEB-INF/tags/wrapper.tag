<%-- 
    Document   : wrapper
    Created on : Jul 18, 2014, 6:49:33 PM
    Author     : mauricio
--%>

<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" type="java.lang.String"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
        <script type="text/javascript" src="https://conektaapi.s3.amazonaws.com/v0.3.0/js/conekta.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <title>${title}</title>
    </head>

    <body>
        <h1>${title}</h1>
        <fieldset>
            <jsp:doBody />
        </fieldset>
            <a href="${pageContext.request.contextPath}/">Home</a>|
            <a href="${pageContext.request.contextPath}/products">Products</a>|
            <a href="${pageContext.request.contextPath}/charges">Charges</a>
        
    </body>
</html>