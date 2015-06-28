<b style="font-size: 24px;">${day.date}</b>
<br>
Min: ${day.minC} C
<br>
Max: ${day.maxC} C
<table style="width: 700px;">
    <tr>
        <th>Time</th>
        <th>Temperature, C</th>
        <th>Humidity, %</th>
        <th>Pressure, millibars</th>
        <th>Precipations, mm</th>
        <th>Wind, m/sec</th>
    </tr>
    <g:each in="${day.hours}" var="hourly">
        <g:render template="hourly_block" model="[hourly: hourly]"/>
    </g:each>
</table>
<br>
<br>
