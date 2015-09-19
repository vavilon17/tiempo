<%--
  Created by IntelliJ IDEA.
  User: vit
  Date: 9/19/15
  Time: 2:21 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main_tl"/>
    <title>Ooops</title>
</head>
<body>
<div class="wrapper">
    <header class="bg-1">
        <div class="container">
            <div class="header-top row">
                <a href="" class="header__logo"></a>
                <div class="header-search__icon"></div>
                <div class="header-search">
                    <div class="header-search-form">
                        <form>
                            <input data-value="search..." type="text" name="" class="header-search-form__inp" />
                            <button type="submit" class="header-search-form__btn"></button>
                        </form>
                        <div class="header-search-form-examples">
                            %{--<g:each in="${topCities}" var="topCityItem">--}%
                                %{--<a href="${createLink(controller: 'main', action: 'weather')}?cityId=${topCityItem.value}" class="header-search-form-examples__link">${topCityItem.key}</a>--}%
                            %{--</g:each>--}%
                        </div>
                    </div>
                    <div class="header-search-rezults">
                        %{--content here is loaded asynchronously--}%
                    </div>
                </div>
            </div>
            <div class="header-bottom row">
                %{--<div class="header-bottom-place">--}%
                    %{--<strong>Tiempo en ${city.printName}</strong>--}%
                    %{--${city?.region?.country?.nativeName}--}%
                %{--</div>--}%
                %{--<g:set var="mainIco" value="${UiUtils.provideIconClassBig(current.getWeatherType())}"/>--}%
                %{--<div class="header-bottom-circle">--}%
                    %{--<input value="${percent}" data-displayprevious="false" data-min="0" data-readOnly=true data-height="279" data-width="279" data-max="100" data-thickness=".05" data-bgColor="transparent" data-fgcolor="#86d1c1" class="knob tictac">--}%
                    %{--<span class="icon ${mainIco}"></span>--}%
                    %{--<span class="value"><span>${current.tempC}</span></span>--}%
                %{--</div>--}%
                %{--<div class="header-bottom-circle-mob">--}%
                    %{--<input value="${percent}" data-displayprevious="false" data-min="0" data-readOnly=true data-height="200" data-width="200" data-max="100" data-thickness=".05" data-bgColor="transparent" data-fgcolor="#86d1c1" class="knob tictac">--}%
                    %{--<span class="icon ${mainIco}"></span>--}%
                    %{--<span class="value"><span>${current.tempC}</span></span>--}%
                %{--</div>--}%
                %{--<div class="header-bottom-info">--}%
                    %{--<div class="header-bottom-info__title">CHANCE OF THE RAIN <strong>${current.rainChance}%</strong></div>--}%
                    %{--<div class="header-bottom-table">--}%
                        %{--<div class="header-bottom-table__cell">Humedad</div>--}%
                        %{--<div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>--}%
                        %{--<div class="header-bottom-table__cell">${current.hum}%</div>--}%
                    %{--</div>--}%
                    %{--<div class="header-bottom-table">--}%
                        %{--<div class="header-bottom-table__cell">Presion --}%%{--<strong>753</strong>mmHg--}%%{--</div>--}%
                        %{--<div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>--}%
                        %{--<div class="header-bottom-table__cell">${current.pres}mmHg</div>--}%
                    %{--</div>--}%
                    %{--<div class="header-bottom-table">--}%
                        %{--<div class="header-bottom-table__cell">Viento</div>--}%
                        %{--<div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>--}%
                        %{--<div class="header-bottom-table__cell">${current.windMs}<span>m/s</span></div>--}%
                    %{--</div>--}%
                %{--</div>--}%
            </div>
        </div>
    </header>
</div>
</body>
</html>