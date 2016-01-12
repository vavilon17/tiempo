<%@ page import="com.util.UiUtils"%>
<header class="bg-1">
    <div class="container">
        <div class="header-top row">
            <a href="" class="header__logo"></a>
            <div class="header-search__icon"></div>
            <div class="header-search">
                <div class="header-search-form">
                    %{--<form>--}%
                        <input data-value="buscar..." type="text" name="" class="header-search-form__inp" />
                        <button type="button" class="header-search-form__btn"></button>
                    %{--</form>--}%
                    <div class="header-search-form-examples">
                        <g:each in="${topCities}" var="topCityItem">
                            <a href="${createLink(controller: 'main', action: 'weather')}/${topCityItem.value}" class="header-search-form-examples__link">${topCityItem.key}</a>
                        </g:each>
                    </div>
                </div>
                <div class="header-search-rezults">
                    %{--content here is loaded asynchronously--}%
                </div>
            </div>
        </div>
        <div class="header-bottom row">
            <div class="header-bottom-place">
                <h1>Clima en ${city.printName}</h1>
                ${city.country.nativeName}, ${city.region.nativeName}
            </div>
            <g:set var="mainIco" value="${UiUtils.provideIconClassBig(current.getWeatherType())}"/>
            <div class="header-bottom-circle">
                <input value="${percent}" data-displayprevious="false" data-min="0" data-readOnly=true data-height="279" data-width="279" data-max="100" data-thickness=".05" data-bgColor="transparent" data-fgcolor="#86d1c1" class="knob tictac">
                <span class="icon ${mainIco}"></span>
                <span class="value"><span>${current.tempC}</span></span>
            </div>
            <div class="header-bottom-circle-mob">
                <input value="${percent}" data-displayprevious="false" data-min="0" data-readOnly=true data-height="200" data-width="200" data-max="100" data-thickness=".05" data-bgColor="transparent" data-fgcolor="#86d1c1" class="knob tictac">
                <span class="icon ${mainIco}"></span>
                <span class="value"><span>${current.tempC}</span></span>
            </div>
            <div class="header-bottom-info">
                <div class="header-bottom-info__title">PROBABILIDAD Precipitación <strong>${current.rainChance}%</strong></div>
                <div class="header-bottom-table">
                    <div class="header-bottom-table__cell">Humedad</div>
                    <div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>
                    <div class="header-bottom-table__cell">${current.hum}%</div>
                </div>
                <div class="header-bottom-table">
                    <div class="header-bottom-table__cell">Presión</div>
                    <div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>
                    <div class="header-bottom-table__cell">${current.pres}mmHg</div>
                </div>
                <div class="header-bottom-table">
                    <div class="header-bottom-table__cell">Viento</div>
                    <div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>
                    <div class="header-bottom-table__cell">${current.windMs}<span>m/s</span></div>
                </div>
            </div>
        </div>
    </div>

    <div class="mainslider">
        <div class="container">
            <div class="mainslider-block">
                <g:each in="${hourlies}" var="hourly">
                    <div class="mainslider-item">
                        <div class="mainslider-item__hour">${hourly.time}</div>
                        <div class="mainslider-item__icon ${UiUtils.provideIconClassSmall(hourly.getWeatherType())}"></div>
                        <div class="mainslider-item__value"><span>${hourly.tempC}</span></div>
                    </div>
                </g:each>
            </div>
        </div>
    </div>
</header>