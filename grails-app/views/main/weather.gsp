<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main_tl"/>
    <title></title>
</head>
<body>
<div class="wrapper">
    <g:render template="/main/templates/today/today" model="[current: weather_results.current, hourlies: weather_results.todayHourlyList, city: weather_results.city, percent: weather_results.halfDayPercent]"/>
    <g:render template="/main/templates/forecast/delimiter" model="[count: weather_results.forecast.size()]"/>
    <g:render template="/main/templates/forecast/core" model="[forecast: weather_results.forecast]"/>
    %{--<g:render template="/main/templates/forecast/mob"/>--}%
    %{--<g:render template="/main/templates/footer_banner"/>--}%
    %{--<g:render template="/main/templates/footer"/>--}%
</div>
</body>
</html>