<%@ page import="com.util.DataUtils" %>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
<g:if test="${weather}">
    <h3>Weather in ${weather.city.fullRepresentation}</h3>
    <h4>Local time: ${weather.localDt.toLocalTime().toString(com.util.DataUtils.hhmm_dt_formatter)}</h4>
    <h4>Weather got from the spot: ${weather.current.time}</h4>
    Temperature: ${weather.current.tempC} C
    <br>
    Rain chance: ${weather.current.rainChance}%
    <br>
    Cloud cover: ${weather.current.cloud}%
    <br>
    Humidity: ${weather.current.hum}%
    <br>
    Pressure: ${weather.current.pres} millibars
    <br>
    Precipitations, ${weather.current.precip}mm
    <br>
    Wind: ${weather.current.windMs} m/sec
    <br>
    <br>
    <h3>Forecast:</h3>
    <g:each in="${weather.forecast}" var="day">
        <g:render template="day_block" model="[day: day]"/>
    </g:each>
</g:if>
<g:else>
    Not found
</g:else>