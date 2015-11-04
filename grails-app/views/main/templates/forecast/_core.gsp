<%@ page import="com.util.DataUtils; com.util.UiUtils" %>
<div class="tempoblock">
    <div class="container">
        <div class="tempoblock-row row graph">
            <g:hiddenField name="todayMaxDay" value="${todayMaxDay}"/>
            <g:hiddenField name="todayMinNight" value="${todayMinNight}"/>
            <g:each in="${forecast}" var="forecastDay" status="i">
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>${UiUtils.dayOfWeekShortName(forecastDay.date)}</strong> ${DataUtils.ddMM.format(forecastDay.date)}</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_1">
                        <g:if test="${i == 0}">
                            <div class="tempoblock-element__linefirst dayFirstLine"></div>
                        </g:if>
                        <g:if test="${i < forecast.size() - 1}">
                            <div class="tempoblock-element__line_new"></div>
                        </g:if>
                        <div class="tempoblock-element__value"><span class="tempC maxDayTempC">${forecastDay.maxDayTempC}</span></div>
                        <div class="tempoblock-element__icon ${UiUtils.provideIconClassForecastDay(forecastDay.avgDayWeatherType)}"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_1">
                        <g:if test="${i == 0}">
                            <div class="tempoblock-element__linefirst nightFirstLine"></div>
                        </g:if>
                        <g:if test="${i < forecast.size() - 1}">
                            <div class="tempoblock-element__line_new night"></div>
                        </g:if>
                        <div class="tempoblock-element__value"><span class="tempC minNightTempC">${forecastDay.minNightTempC}</span></div>
                        <div class="tempoblock-element__icon ${UiUtils.provideIconClassForecastNight(forecastDay.avgNightWeatherType)}"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presión</div>
                            <div class="tempoblock-footer-table__cell"><strong>${forecastDay.maxPressure}</strong>mmHg</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Humedad</div>
                            <div class="tempoblock-footer-table__cell"><strong>${forecastDay.maxHumidity}%</strong></div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Viento</div>
                            <div class="tempoblock-footer-table__cell"><strong>${forecastDay.maxWindMs}</strong>m/s</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Precipitación</div>
                            <div class="tempoblock-footer-table__cell"><strong>${Math.round(forecastDay.sumPrecipMm * 10)/10}</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Probab. de lluvia</div>
                            <div class="tempoblock-footer-table__cell"><strong>${forecastDay.maxRainChance}%</strong></div>
                        </div>
                    </div>
                </div>
            </g:each>
        </div>
    </div>
</div>