<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main_tl"/>
    <title></title>
</head>

<body>
<div class="wrapper">
    <g:render template="/main/templates/today/today"/>
    <g:render template="/main/templates/forecast/delimiter"/>
    <g:render template="/main/templates/forecast/core"/>
    <g:render template="/main/templates/forecast/mob"/>
    <g:render template="/main/templates/footer_banner"/>
    <g:render template="/main/templates/footer"/>
</div>
</body>
</html>