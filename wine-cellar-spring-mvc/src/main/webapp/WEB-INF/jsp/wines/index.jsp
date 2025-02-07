<%--
  Created by IntelliJ IDEA.
  User: MarekScholtz
  Date: 9.12.2016
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:template title="Wines">
<jsp:attribute name="body">

    <my:a href="/wines/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        New wine
    </my:a>

    <table class="table">
        <thead>
        <tr>
            <th><fmt:message key="number"/></th>
            <th><fmt:message key="wine.name"/></th>
            <th><fmt:message key="wine.vintage"/></th>
            <th><fmt:message key="wine.batch"/></th>
            <th><fmt:message key="wine.predicate"/></th>
            <th><fmt:message key="wine.predicateEquivalent"/></th>
            <th><fmt:message key="wine.description"/></th>
            <th><fmt:message key="wine.notes"/></th>
            <th><fmt:message key="wine.alcoholVolume"/></th>
            <th><fmt:message key="wine.residualSugar"/></th>
            <th><fmt:message key="wine.acidity"/></th>
            <th><fmt:message key="wine.grapeSugarContent"/></th>
                <%--<th><fmt:message key="wine.wineLists"/></th>--%>
            <th class="text-center"><fmt:message key="edit"/></th>
            <th class="text-center"><fmt:message key="remove"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${wines}" var="wine">
        <c:set var="count" value="${count + 1}" scope="page"/>
    <tr>
        <td class="col-xs-3 lead-column">${count}.</td>
        <td class="col-xs-3 text-center"><c:out value="${wine.name}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.vintage}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.batch}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.predicate}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.predicateEquivalent}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.description}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.notes}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.alcoholVolume}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.residualSugar}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.acidity}"/></td>
        <td class="col-xs-3 text-center"><c:out value="${wine.grapeSugarContent}"/></td>
            <%--<td class="col-xs-3 text-center"><c:out value="${wine.wineLists}"/></td>--%>

            <form:form method="get" action="${pageContext.request.contextPath}/wines/update/${wine.id}" cssClass="form-horizontal">
                <td class="col-xs-1 text-center">
                    <button class="btn btn-default" type="submit">
                        <span class="sr-only"><fmt:message key="edit"/></span>
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </button>
                </td>
            </form:form>

            <form:form method="post" action="${pageContext.request.contextPath}/wines/remove/${wine.id}" cssClass="form-horizontal">
                <td class="col-xs-1 text-center">
                    <button class="btn btn-default" type="submit">
                        <span class="sr-only"><fmt:message key="remove"/></span>
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </button>
                </td>
            </form:form>
    </tr>
    </c:forEach>
        </tbody>
    </table>


</jsp:attribute>
</my:template>
