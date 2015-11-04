<%@ page import="com.util.UiUtils" %>
<div class="tempoblockmob">
    <div class="container">
        <g:each in="${forecast}" var="forecastDay" status="i">
            <div class="tempoblockmob-element">
                <div class="tempoblockmob-element-title row">
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_1">${i == 0 ? 'Manana' : UiUtils.dayOfWeekFullName(forecastDay.date)}</div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_2">
                        <div class="tempoblockmob-element-column_icon ${UiUtils.provideIconClassForecastDay(forecastDay.avgDayWeatherType)}"></div>
                    </div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_3"><span>${forecastDay.minC}..${forecastDay.maxC}</span></div>
                </div>
                <div class="tempoblockmob-element-block">
                    <div class="tempoblockmob-element-block-title row">
                        <div class="tempoblockmob-element-block-title__name">${UiUtils.dayOfWeekFullName(forecastDay.date)}</div>
                        <div class="tempoblockmob-element-block-title__data"><strong>${UiUtils.dayOfMonth(forecastDay.date)}</strong> ${UiUtils.monthShort(forecastDay.date)}</div>
                    </div>
                    <g:each in="${forecastDay.hours}" var="hour">
                        <div class="tempoblockmob-element-block-element row">
                            <div class="tempoblockmob-element-block-element-left">
                                <div class="tempoblockmob-element-block-element-left__hour">${hour.time}</div>
                                <div class="tempoblockmob-element-block-element-left__icon ${UiUtils.provideIconClassSmall(hour.getWeatherType())}"></div>
                                <div class="tempoblockmob-element-block-element-left__value"><span>${hour.tempC}</span></div>
                            </div>
                            <div class="tempoblockmob-element-block-element-right">
                                <p>Presión <strong>${hour.pres}</strong>mmHg</p>
                                <p>Humedad <strong>${hour.hum}%</strong></p>
                                <p>Viento <strong>${hour.windMs}</strong>m/s</p>
                            </div>
                        </div>
                    </g:each>
                </div>
            </div>
        </g:each>
    </div>
</div>