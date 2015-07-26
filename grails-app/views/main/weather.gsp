<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main_tl"/>
    <title></title>
</head>
<body>
<div class="wrapper">
    <g:render template="/main/templates/today/today" model="[current: weather_results.current, city: weather_results.city, percent: weather_results.halfDayPercent]"/>
    %{--<g:render template="/main/templates/forecast/delimiter"/>--}%
    %{--<g:render template="/main/templates/forecast/core"/>--}%
    %{--<g:render template="/main/templates/forecast/mob"/>--}%
    %{--<g:render template="/main/templates/footer_banner"/>--}%
    %{--<g:render template="/main/templates/footer"/>--}%
</div>
</body>
</html>