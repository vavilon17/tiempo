<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
<g:if test="${forecast}">
    <g:render template="day_block" model="[day: forecast.currentDay]"/>
    <g:each in="${forecast.forecast}" var="day">
        <g:render template="day_block" model="[day: day]"/>
    </g:each>
</g:if>
<g:else>
    Not found
</g:else>