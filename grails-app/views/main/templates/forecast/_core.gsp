<%@ page import="com.util.DataUtils; com.util.UiUtils" %>
<div class="tempoblock">
    <div class="container">
        <div class="tempoblock-row row graph">
            <g:each in="${forecast}" var="forecastDay">
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>${UiUtils.dayOfWeekShortName(forecastDay.date)}</strong> ${DataUtils.ddMM.format(forecastDay.date)}</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_1">
                        <div class="tempoblock-element__linefirst"></div>
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span class="maxDayTempC">${forecastDay.maxDayTempC}</span></div>
                        <div class="tempoblock-element__icon ${UiUtils.provideIconClassForecastDay(forecastDay.avgDayWeatherType)}"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_1">
                        <div class="tempoblock-element__linefirst"></div>
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span class="minNightTempC">${forecastDay.minNightTempC}</span></div>
                        <div class="tempoblock-element__icon ${UiUtils.provideIconClassForecastNight(forecastDay.avgNightWeatherType)}"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presion</div>
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
                            <div class="tempoblock-footer-table__cell">Precipitation</div>
                            <div class="tempoblock-footer-table__cell"><strong>${forecastDay.sumPrecipMm}</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Chance of the rain</div>
                            <div class="tempoblock-footer-table__cell"><strong>${forecastDay.maxRainChance}%</strong></div>
                        </div>
                    </div>
                </div>
            </g:each>
        </div>
    </div>
</div>