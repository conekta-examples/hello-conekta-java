<%-- 
    Document   : index
    Created on : Jul 18, 2014, 6:53:45 PM
    Author     : mauricio
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:wrapper>
    <jsp:attribute name="title">New Product</jsp:attribute>
    <jsp:body>
        <form name="input" action="${pageContext.request.contextPath}/products" method="post">
            <p>
                <label>Name</label>
                <input id="name" name="name" type="text">
            </p>
            <p>
                <label>Description</label>
                <textarea id="description" name="description" rows="4" cols="20">
                    
                </textarea>
            </p>
            <p>
                <label>Price</label>
                <input id="price" name="price" type="number">
            </p>
            <p>
                <label>Is subscription?</label>
                <input id="is_subscription" name="is_subscription" type="number" min="0" max="1">
            </p>
            <input type="submit" value="Submit">
        </form>
    </jsp:body>
</t:wrapper>