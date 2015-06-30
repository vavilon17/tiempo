<g:if test="${day}">
    <b style="font-size: 24px;">${day.date.format("yyyy-MM-dd")}</b>
    <br>
    Min: ${day.minC} C
    <br>
    Max: ${day.maxC} C
    <table style="width: 700px;">
        <tr>
            <th>Time</th>
            <th>Temperature, C</th>
            <th>Rain chance, %</th>
            <th>Cloud cover, %</th>
            <th>Humidity, %</th>
            <th>Pressure, millibars</th>
            <th>Precipitations, mm</th>
            <th>Wind, m/sec</th>
        </tr>
        <g:each in="${day.hours}" var="hourly">
            <g:render template="hourly_block" model="[hourly: hourly]"/>
        </g:each>
    </table>
    <br>
    <br>
</g:if>
<g:else>
    No forecast found
</g:else>

