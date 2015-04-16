<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main_custom"/>
    <title></title>
</head>

<body>
El Tiempo en ${weather.data.name}
%{--<g:select name="cities" from="${cities}" optionKey="urlName" optionValue="name"/>--}%
%{--<button name="show" onclick="showWeather();">Show</button>--}%
<br>
<g:each in="${weather.data.weather.keySet()}" status="i" var="entryKey">
    Date: ${entryKey}
    %{--<g:set var="forecast" value="${weather.data.weather.get(entryKey)}"/>
    <g:each in="${forecast.forecast.keySet()}" var="dayPart">
        <g:set var="weather" value="${forecast.forecast.get(dayPart)}"/>
        ${dayPart}     ${weather.temperature.low} - ${weather.temperature.high}    cloud:${weather.could.name}     wind:${weather.wind.name},speed:${weather.wind.speed_low}-${weather.wind.speed_high}
    </g:each>--}%
    <br>
    <br>
</g:each>
<script>
    function showWeather() {
        var city = document.getElementsByName('cities')[0].value;
        var ajax = new XMLHttpRequest();
        ajax.open("GET", "${createLink(controller: 'main', action: 'weather')}?city=" + city, true);
        ajax.onreadystatechange = function() {
            if (ajax.readyState == 4 && ajax.status == 200) {
                document.getElementById('weather_results').innerHTML = ajax.responseText;
            }
        };
        ajax.send()
    };
</script>
</body>
</html>