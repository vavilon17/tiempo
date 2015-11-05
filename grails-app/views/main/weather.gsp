<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<g:set var="cityName" value="${weather_results.city.printName}"/>
<head>
    <title>Tiempo en ${cityName} - Pronóstico del tiempo en ${weather_results.city.country.nativeName}</title>
    <meta name="layout" content="main_tl"/>
    <meta name="description" content="Tiempo en ${cityName} - Pronóstico meteorológico del tiempo. Temperatura, velocidad del viento, presión, la humedad"/>
    <meta name="keywords" content="tiempo en ${cityName}, pronóstico del tiempo en ${cityName}, tiempo ${cityName} hoy, tiempo ${cityName} mañana, tiempo en ${cityName} fin de semana, tiempo ${cityName} para 5 Días, clima ${cityName}, pronóstico ${cityName}"/>
</head>
<body>
<g:render template="/main/templates/seo/ga"/>
<div class="wrapper">
    <g:render template="/main/templates/today/today" model="[current: weather_results.current, hourlies: weather_results.todayHourlyList, city: weather_results.city,
                                                             percent: weather_results.halfDayPercent, topCities: weather_results.topCities]"/>
    <g:render template="/main/templates/forecast/delimiter" model="[count: weather_results.forecast.size(), cityName: cityName]"/>
    <g:render template="/main/templates/forecast/core" model="[forecast: weather_results.forecast, todayMaxDay: weather_results.todayMaxDay, todayMinNight: weather_results.todayMinNight]"/>
    <g:render template="/main/templates/forecast/mob" model="[forecast: weather_results.forecast]"/>
    <g:render template="/main/templates/footer_banner"/>
    %{--<g:render template="/main/templates/footer"/>--}%
</div>
</body>
</html>