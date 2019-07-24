<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>

        <link rel="stylesheet" type="text/css" href="/assets/libs/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/libs/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/libs/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" type="text/css" href="/assets/css/main.css" />
        <link rel="stylesheet" type="text/css" href="/assets/libs/jqgrid/css/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="/assets/libs/jqgrid/css/ui.jqgrid.css" />

        <script src="/assets/libs/jquery/jquery-3.2.0.min.js"></script>
        <script src="/assets/libs/bootstrap/js/bootstrap.min.js"></script>
        <script src="/assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="/assets/libs/bootstrap/js/bootstrap4-toggle.min.js"></script>
        <script src="/assets/libs/jqgrid/js/i18n/grid.locale-kr.js"></script>
        <script src="/assets/libs/jqgrid/js/jquery.jqGrid.min.js"></script>

    </head>
    <body>
        <div class="paddingAll30">
            <tiles:insertAttribute name="header"/>
            <div class="container" style="margin-top:130px;">
                <tiles:insertAttribute name="body"/>
            </div>
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>

<script>
/*(function () {
  const root = document.querySelector('.container');
  const navigation = document.getElementById('nav');
  const account = document.getElementById('accountArea');

  function render(data) {
    const json = JSON.parse(data);
    root.innerHTML = `<h1>${json.title}</h1><p>${json.content}</p>`;
  }

  function renderHtml(html) {
    root.innerHTML = html;
  }

  function get(url) {
    return new Promise((resolve, reject) => {
      const req = new XMLHttpRequest();
      req.open('GET', url);
      req.send();

      req.onreadystatechange = function () {
        if (req.readyState === XMLHttpRequest.DONE) {
          if (req.status === 200) resolve(req.response);
          else reject(req.statusText);
        }
      };
    });
  }

  const routes = {
    'home': function () {
      get('/')
        .then(res => renderHtml(res));
    },
    'login': function () {
      get('/account/login')
        .then(res => renderHtml(res));
    },
    'signUp': function () {
      get('/account/signUp')
        .then(res => renderHtml(res));
    },
    'bookSearch': function () {
      get('/book/search')
        .then(res => renderHtml(res));
    },
    'mHistory': function () {
      get('/book/search')
        .then(res => renderHtml(res));
    },
    'topTen': function () {
      get('/book/search')
        .then(res => renderHtml(res));
    },
    otherwise(page) {
      root.innerHTML = `${page} Not Found`;
    }
  };

  function router(page) {
    (routes[page] || routes.otherwise)(page);
  }

  navigation.addEventListener('click', e => {
    if (!e.target || e.target.nodeName !== 'A') return;
    e.preventDefault();
    router(e.target.id);
  });

  account.addEventListener('click', e => {
    if (!e.target || e.target.nodeName !== 'A') return;
    e.preventDefault();
    router(e.target.id);
  });


  window.addEventListener('DOMContentLoaded', () => router);
}());*/
</script>