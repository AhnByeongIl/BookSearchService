<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
            <tr>
                <th scope="col">Keyword</th>
                <th scope="col">검색일시</th>
            </tr>
        </thead>
    <tbody>
        <c:forEach items="${histories}" var="list" >
            <tr>
                <td><c:out value="${list.keyword}"/></td>
                <td><c:out value="${list.date}"/></td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
</div>