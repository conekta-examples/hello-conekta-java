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
    <jsp:attribute name="title">Charge Index</jsp:attribute>
    <jsp:body>
        <table>
            <th>Id</th>
            <th>Livemode</th>
            <th>Created At</th>
            <th>Status</th>
            <th>Currency</th>
            <th>Description</th>
            <th>Reference Id</th>
            <th>Failure Code</th>
            <th>Failure Message</th>
            <th>Amount</th>
            <c:forEach items="${charges}" var="charge">
                <tr>
                    <td>${charge.id}</td>
                    <td>${charge.livemode}</td>
                    <td>${charge.createdAt}</td>
                    <td>${charge.status}</td>
                    <td>${charge.currency}</td>
                    <td>${charge.description}</td>
                    <td>${charge.referenceId}</td>
                    <td>${charge.failureCode}</td>
                    <td>${charge.failureMessage}</td>
                    <td>${charge.amount}</td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>
</t:wrapper>