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
    <jsp:attribute name="title">Product Index</jsp:attribute>
    <jsp:body>
        <table>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Is Subscription?</th>
            <th>Buy</th>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.isSubscription}</td>
                    <td><a href="${pageContext.request.contextPath}/products/${product.id}/buy">Buy</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/products/new">New product</a>
    </jsp:body>
</t:wrapper>