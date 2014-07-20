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
        <script type="text/javascript">
            Conekta.setPublishableKey('key_KJysdbf6PotS2ut2');
            jQuery(function($) {
                $("#card-form").submit(function(event) {
                    var $form;
                    $form = $(this);
                    $form.find("button").prop("disabled", true);
                    Conekta.token.create($form, conektaSuccessResponseHandler, conektaErrorResponseHandler);
                    return false;
                });
                var conektaSuccessResponseHandler;
                conektaSuccessResponseHandler = function(token) {
                    var $form;
                    $form = $("#card-form");
                    $form.append($("<input type=\"hidden\" name=\"conektaTokenId\" />").val(token.id));
                    $form.get(0).submit();
                };
                var conektaErrorResponseHandler;
                conektaErrorResponseHandler = function(response) {
                    var $form;
                    $form = $("#card-form");
                    $form.find(".card-errors").text(response.message);
                    $form.find("button").prop("disabled", false);
                };
            });
        </script>
        <form id="card-form" name="input" action="${pageContext.request.contextPath}/charges" method="post">
            <span class="card-errors">${errors}</span>
            <input type="hidden" id="product_id" name="product_id" value="${product_id}">
            <div class="form-row">
                <label>
                    <span>Nombre del tarjeta habiente</span>
                    <input type="text" size="20" data-conekta="card[name]"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Número de tarjeta de crédito</span>
                    <input type="text" size="20" data-conekta="card[number]"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>CVC</span>
                    <input type="text" size="4" data-conekta="card[cvc]"/>
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Fecha de expiración (MM/AAAA)</span>
                    <input type="text" size="2" data-conekta="card[exp_month]"/>
                </label>
                <span>/</span>
                <input type="text" size="4" data-conekta="card[exp_year]"/>
            </div>
            <input type="submit" value="Submit">
        </form>
    </jsp:body>
</t:wrapper>