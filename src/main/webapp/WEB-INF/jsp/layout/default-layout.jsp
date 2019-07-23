<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
    <head>

        <meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>

        <link rel="stylesheet" type="text/css" href="/assets/libs/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/libs/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/libs/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/css/main.css" />

        <script src="/assets/libs/jquery/jquery-3.2.0.min.js"></script>
        <script src="/assets/libs/bootstrap/js/bootstrap.min.js"></script>
        <script src="/assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="/assets/libs/bootstrap/js/bootstrap4-toggle.min.js"></script>

    </head>
    <body>
        <div class="paddingAll30">
            <tiles:insertAttribute name="header"/>
            <div style="margin-top:50px;">
                <tiles:insertAttribute name="body"/>
            </div>
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>