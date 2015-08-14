<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main_tl"/>
    <title></title>
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
                        <form action="%{--http://andrikanich.guru/freelance/tiempolatin/--}%#">
                            <input data-value="search..." type="text" name="" class="header-search-form__inp">
                            <button type="submit" class="header-search-form__btn"></button>
                        </form>
                        <div class="header-search-form-examples">
                            <a href="" class="header-search-form-examples__link">Santiago de Chile</a>
                            <a href="" class="header-search-form-examples__link">Atacama</a>
                            <a href="" class="header-search-form-examples__link">Valparaíso</a>
                        </div>
                    </div>
                    <div class="header-search-rezults">
                        <div class="header-search-rezults__value">Presion in Chillie manana</div>
                        <div class="header-search-rezults__value">Chillie Humedad</div>
                        <div class="header-search-rezults__value">Presion in Chillie</div>
                    </div>
                </div>
            </div>
            <div class="header-bottom row">
                <div class="header-bottom-place">
                    <strong>Tiempo en Santiago</strong>
                    Chillie
                </div>
                <div class="header-bottom-circle">
                    <div style="display:inline;width:279px;height:279px;">
                        <canvas width="279" height="279"></canvas>
                        <input value="60" data-displayprevious="false" data-min="0" data-readonly="true" data-height="279" data-width="279" data-max="100" data-thickness=".05" data-bgcolor="transparent" data-fgcolor="#86d1c1" class="knob tictac" readonly="readonly" style="width: 143px; height: 93px; position: absolute; vertical-align: middle; margin-top: 93px; margin-left: -211px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 55px; line-height: normal; font-family: Arial; text-align: center; color: rgb(134, 209, 193); padding: 0px; -webkit-appearance: none; background: none;"></div>
                    <span class="icon icon_1"></span>
                    <span class="value"><span>15</span></span>
                </div>
                <div class="header-bottom-circle-mob">
                    <div style="display:inline;width:200px;height:200px;"><canvas width="200" height="200"></canvas><input value="60" data-displayprevious="false" data-min="0" data-readonly="true" data-height="200" data-width="200" data-max="100" data-thickness=".05" data-bgcolor="transparent" data-fgcolor="#86d1c1" class="knob tictac" readonly="readonly" style="width: 104px; height: 66px; position: absolute; vertical-align: middle; margin-top: 66px; margin-left: -152px; border: 0px; font-weight: bold; font-style: normal; font-variant: normal; font-stretch: normal; font-size: 40px; line-height: normal; font-family: Arial; text-align: center; color: rgb(134, 209, 193); padding: 0px; -webkit-appearance: none; background: none;"></div>
                    <span class="icon icon_1"></span>
                    <span class="value"><span>15</span></span>
                </div>
                <div class="header-bottom-info">
                    <div class="header-bottom-info__title">CHANCE OF THE RAIN <strong>35%</strong></div>
                    <div class="header-bottom-table">
                        <div class="header-bottom-table__cell">Humedad</div>
                        <div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>
                        <div class="header-bottom-table__cell">65%</div>
                    </div>
                    <div class="header-bottom-table">
                        <div class="header-bottom-table__cell">Presion <strong>753</strong>mmHg</div>
                        <div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>
                        <div class="header-bottom-table__cell">45%</div>
                    </div>
                    <div class="header-bottom-table">
                        <div class="header-bottom-table__cell">Viento</div>
                        <div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>
                        <div class="header-bottom-table__cell">7<span>m/s</span></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="mainslider">
            <div class="container">
                <div class="mainslider-block slick-initialized slick-slider">
                    <div class="slick-list draggable" tabindex="0"><div class="slick-track" style="opacity: 1; width: 22609px; transform: translate3d(-826px, 0px, 0px);"><div class="mainslider-item slick-slide slick-cloned" data-slick-index="-7">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_4"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="-6">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_5"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="-5">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_6"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="-4">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_7"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="-3">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_8"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="-2">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_9"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="-1">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_10"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-active" data-slick-index="0">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_1"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-active" data-slick-index="1">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_2"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-active" data-slick-index="2">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_3"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-active" data-slick-index="3">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_4"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-active" data-slick-index="4">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_5"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-active" data-slick-index="5">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_6"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-active" data-slick-index="6">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_7"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide" data-slick-index="7">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_8"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide" data-slick-index="8">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_9"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide" data-slick-index="9">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_10"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="10">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_1"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="11">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_2"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="12">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_3"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="13">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_4"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="14">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_5"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="15">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_6"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div><div class="mainslider-item slick-slide slick-cloned" data-slick-index="16">
                        <div class="mainslider-item__hour">1am</div>
                        <div class="mainslider-item__icon icon_7"></div>
                        <div class="mainslider-item__value"><span>15</span></div>
                    </div></div></div>









                    <button type="button" data-role="none" class="slick-prev" style="display: block;">Previous</button><button type="button" data-role="none" class="slick-next" style="display: block;">Next</button></div>
            </div>
        </div>
    </header>
    <div class="tempotittle">
        <div class="container">
            <div class="tempotittle-block">
                <div class="tempotittle-cell">
                    <span>Pronostico del tiempo <strong>para 7 dias</strong></span>
                </div>
            </div>
        </div>
    </div>
    <div class="tempoblock">
        <div class="container">
            <div class="tempoblock-row row">
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>Пн</strong> 03.07</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_1">
                        <div class="tempoblock-element__linefirst"></div>
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>17</span></div>
                        <div class="tempoblock-element__icon icon_1"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_1">
                        <div class="tempoblock-element__linefirst"></div>
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>17</span></div>
                        <div class="tempoblock-element__icon icon_1"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presion</div>
                            <div class="tempoblock-footer-table__cell"><strong>753</strong>mmHg</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Humedad</div>
                            <div class="tempoblock-footer-table__cell"><strong>65%</strong></div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Viento</div>
                            <div class="tempoblock-footer-table__cell"><strong>7</strong>m/s</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Precipitation</div>
                            <div class="tempoblock-footer-table__cell"><strong>12</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Chance of the rain</div>
                            <div class="tempoblock-footer-table__cell"><strong>40%</strong></div>
                        </div>
                    </div>
                </div>
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>Вт</strong> 03.07</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_2">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>21</span></div>
                        <div class="tempoblock-element__icon icon_2"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_2">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>21</span></div>
                        <div class="tempoblock-element__icon icon_2"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presion</div>
                            <div class="tempoblock-footer-table__cell"><strong>753</strong>mmHg</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Humedad</div>
                            <div class="tempoblock-footer-table__cell"><strong>65%</strong></div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Viento</div>
                            <div class="tempoblock-footer-table__cell"><strong>7</strong>m/s</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Precipitation</div>
                            <div class="tempoblock-footer-table__cell"><strong>12</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Chance of the rain</div>
                            <div class="tempoblock-footer-table__cell"><strong>40%</strong></div>
                        </div>
                    </div>
                </div>
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>Ср</strong> 03.07</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_3">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>17</span></div>
                        <div class="tempoblock-element__icon icon_3"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_3">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>17</span></div>
                        <div class="tempoblock-element__icon icon_3"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presion</div>
                            <div class="tempoblock-footer-table__cell"><strong>753</strong>mmHg</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Humedad</div>
                            <div class="tempoblock-footer-table__cell"><strong>65%</strong></div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Viento</div>
                            <div class="tempoblock-footer-table__cell"><strong>7</strong>m/s</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Precipitation</div>
                            <div class="tempoblock-footer-table__cell"><strong>12</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Chance of the rain</div>
                            <div class="tempoblock-footer-table__cell"><strong>40%</strong></div>
                        </div>
                    </div>
                </div>
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>Чт</strong> 06.07</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_4">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>18</span></div>
                        <div class="tempoblock-element__icon icon_4"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_4">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>18</span></div>
                        <div class="tempoblock-element__icon icon_4"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presion</div>
                            <div class="tempoblock-footer-table__cell"><strong>753</strong>mmHg</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Humedad</div>
                            <div class="tempoblock-footer-table__cell"><strong>65%</strong></div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Viento</div>
                            <div class="tempoblock-footer-table__cell"><strong>7</strong>m/s</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Precipitation</div>
                            <div class="tempoblock-footer-table__cell"><strong>12</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Chance of the rain</div>
                            <div class="tempoblock-footer-table__cell"><strong>40%</strong></div>
                        </div>
                    </div>
                </div>
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>Пт</strong> 06.07</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_5">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>11</span></div>
                        <div class="tempoblock-element__icon icon_5"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_5">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>11</span></div>
                        <div class="tempoblock-element__icon icon_5"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presion</div>
                            <div class="tempoblock-footer-table__cell"><strong>753</strong>mmHg</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Humedad</div>
                            <div class="tempoblock-footer-table__cell"><strong>65%</strong></div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Viento</div>
                            <div class="tempoblock-footer-table__cell"><strong>7</strong>m/s</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Precipitation</div>
                            <div class="tempoblock-footer-table__cell"><strong>12</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Chance of the rain</div>
                            <div class="tempoblock-footer-table__cell"><strong>40%</strong></div>
                        </div>
                    </div>
                </div>
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>Сб</strong> 06.07</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_6">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>10</span></div>
                        <div class="tempoblock-element__icon icon_6"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_6">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>10</span></div>
                        <div class="tempoblock-element__icon icon_6"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presion</div>
                            <div class="tempoblock-footer-table__cell"><strong>753</strong>mmHg</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Humedad</div>
                            <div class="tempoblock-footer-table__cell"><strong>65%</strong></div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Viento</div>
                            <div class="tempoblock-footer-table__cell"><strong>7</strong>m/s</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Precipitation</div>
                            <div class="tempoblock-footer-table__cell"><strong>12</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Chance of the rain</div>
                            <div class="tempoblock-footer-table__cell"><strong>40%</strong></div>
                        </div>
                    </div>
                </div>
                <div class="tempoblock-column">
                    <div class="tempoblock-data"><strong>Вс</strong> 07.07</div>
                    <div class="tempoblock-element tempoblock-element_day tempoblock-element_day_7">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>15</span></div>
                        <div class="tempoblock-element__icon icon_7"></div>
                    </div>
                    <div class="tempoblock-element tempoblock-element_night tempoblock-element_night_7">
                        <div class="tempoblock-element__line"></div>
                        <div class="tempoblock-element__value"><span>15</span></div>
                        <div class="tempoblock-element__icon icon_7"></div>
                    </div>
                    <div class="tempoblock-footer">
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Presion</div>
                            <div class="tempoblock-footer-table__cell"><strong>753</strong>mmHg</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Humedad</div>
                            <div class="tempoblock-footer-table__cell"><strong>65%</strong></div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Viento</div>
                            <div class="tempoblock-footer-table__cell"><strong>7</strong>m/s</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Precipitation</div>
                            <div class="tempoblock-footer-table__cell"><strong>12</strong>mm</div>
                        </div>
                        <div class="tempoblock-footer-table">
                            <div class="tempoblock-footer-table__cell">Chance of the rain</div>
                            <div class="tempoblock-footer-table__cell"><strong>40%</strong></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="tempoblockmob">
        <div class="container">
            <div class="tempoblockmob-element">
                <div class="tempoblockmob-element-title row">
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_1">Hoy</div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_2">
                        <div class="tempoblockmob-element-column_icon icon_1"></div>
                    </div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_3"><span>15..17</span></div>
                </div>
                <div class="tempoblockmob-element-block">
                    <div class="tempoblockmob-element-block-title row">
                        <div class="tempoblockmob-element-block-title__name">Viernes</div>
                        <div class="tempoblockmob-element-block-title__data"><strong>18</strong> sept</div>
                    </div>
                    <div class="tempoblockmob-element-block-element row">
                        <div class="tempoblockmob-element-block-element-left">
                            <div class="tempoblockmob-element-block-element-left__hour">1 am</div>
                            <div class="tempoblockmob-element-block-element-left__icon icon_1"></div>
                            <div class="tempoblockmob-element-block-element-left__value"><span>15</span></div>
                        </div>
                        <div class="tempoblockmob-element-block-element-right">
                            <p>Presion <strong>753</strong>mmHg(45%)</p>
                            <p>PHumedad <strong>65%</strong></p>
                            <p>Viento <strong>7</strong>m/s</p>
                        </div>
                    </div>
                    <div class="tempoblockmob-element-block-element row">
                        <div class="tempoblockmob-element-block-element-left">
                            <div class="tempoblockmob-element-block-element-left__hour">2 am</div>
                            <div class="tempoblockmob-element-block-element-left__icon icon_2"></div>
                            <div class="tempoblockmob-element-block-element-left__value"><span>17</span></div>
                        </div>
                        <div class="tempoblockmob-element-block-element-right">
                            <p>Presion <strong>753</strong>mmHg(45%)</p>
                            <p>PHumedad <strong>65%</strong></p>
                            <p>Viento <strong>7</strong>m/s</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tempoblockmob-element">
                <div class="tempoblockmob-element-title row">
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_1">Manana</div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_2">
                        <div class="tempoblockmob-element-column_icon icon_2"></div>
                    </div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_3"><span>15..17</span></div>
                </div>
                <div class="tempoblockmob-element-block">
                    <div class="tempoblockmob-element-block-title row">
                        <div class="tempoblockmob-element-block-title__name">Viernes</div>
                        <div class="tempoblockmob-element-block-title__data"><strong>18</strong> sept</div>
                    </div>
                    <div class="tempoblockmob-element-block-element row">
                        <div class="tempoblockmob-element-block-element-left">
                            <div class="tempoblockmob-element-block-element-left__hour">1 am</div>
                            <div class="tempoblockmob-element-block-element-left__icon icon_1"></div>
                            <div class="tempoblockmob-element-block-element-left__value"><span>15</span></div>
                        </div>
                        <div class="tempoblockmob-element-block-element-right">
                            <p>Presion <strong>753</strong>mmHg(45%)</p>
                            <p>PHumedad <strong>65%</strong></p>
                            <p>Viento <strong>7</strong>m/s</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tempoblockmob-element">
                <div class="tempoblockmob-element-title row">
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_1">Lunes</div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_2">
                        <div class="tempoblockmob-element-column_icon icon_1"></div>
                    </div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_3"><span>15..17</span></div>
                </div>
                <div class="tempoblockmob-element-block">
                    <div class="tempoblockmob-element-block-title row">
                        <div class="tempoblockmob-element-block-title__name">Viernes</div>
                        <div class="tempoblockmob-element-block-title__data"><strong>18</strong> sept</div>
                    </div>
                    <div class="tempoblockmob-element-block-element row">
                        <div class="tempoblockmob-element-block-element-left">
                            <div class="tempoblockmob-element-block-element-left__hour">1 am</div>
                            <div class="tempoblockmob-element-block-element-left__icon icon_1"></div>
                            <div class="tempoblockmob-element-block-element-left__value"><span>15</span></div>
                        </div>
                        <div class="tempoblockmob-element-block-element-right">
                            <p>Presion <strong>753</strong>mmHg(45%)</p>
                            <p>PHumedad <strong>65%</strong></p>
                            <p>Viento <strong>7</strong>m/s</p>
                        </div>
                    </div>
                    <div class="tempoblockmob-element-block-element row">
                        <div class="tempoblockmob-element-block-element-left">
                            <div class="tempoblockmob-element-block-element-left__hour">2 am</div>
                            <div class="tempoblockmob-element-block-element-left__icon icon_2"></div>
                            <div class="tempoblockmob-element-block-element-left__value"><span>17</span></div>
                        </div>
                        <div class="tempoblockmob-element-block-element-right">
                            <p>Presion <strong>753</strong>mmHg(45%)</p>
                            <p>PHumedad <strong>65%</strong></p>
                            <p>Viento <strong>7</strong>m/s</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tempoblockmob-element">
                <div class="tempoblockmob-element-title row">
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_1">Martes</div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_2">
                        <div class="tempoblockmob-element-column_icon icon_2"></div>
                    </div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_3"><span>15..17</span></div>
                </div>
                <div class="tempoblockmob-element-block">
                    <div class="tempoblockmob-element-block-title row">
                        <div class="tempoblockmob-element-block-title__name">Viernes</div>
                        <div class="tempoblockmob-element-block-title__data"><strong>18</strong> sept</div>
                    </div>
                    <div class="tempoblockmob-element-block-element row">
                        <div class="tempoblockmob-element-block-element-left">
                            <div class="tempoblockmob-element-block-element-left__hour">1 am</div>
                            <div class="tempoblockmob-element-block-element-left__icon icon_1"></div>
                            <div class="tempoblockmob-element-block-element-left__value"><span>15</span></div>
                        </div>
                        <div class="tempoblockmob-element-block-element-right">
                            <p>Presion <strong>753</strong>mmHg(45%)</p>
                            <p>PHumedad <strong>65%</strong></p>
                            <p>Viento <strong>7</strong>m/s</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tempoblockmob-element">
                <div class="tempoblockmob-element-title row">
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_1">Miercoles</div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_2">
                        <div class="tempoblockmob-element-column_icon icon_1"></div>
                    </div>
                    <div class="tempoblockmob-element-column tempoblockmob-element-column_3"><span>15..17</span></div>
                </div>
                <div class="tempoblockmob-element-block">
                    <div class="tempoblockmob-element-block-title row">
                        <div class="tempoblockmob-element-block-title__name">Viernes</div>
                        <div class="tempoblockmob-element-block-title__data"><strong>18</strong> sept</div>
                    </div>
                    <div class="tempoblockmob-element-block-element row">
                        <div class="tempoblockmob-element-block-element-left">
                            <div class="tempoblockmob-element-block-element-left__hour">1 am</div>
                            <div class="tempoblockmob-element-block-element-left__icon icon_1"></div>
                            <div class="tempoblockmob-element-block-element-left__value"><span>15</span></div>
                        </div>
                        <div class="tempoblockmob-element-block-element-right">
                            <p>Presion <strong>753</strong>mmHg(45%)</p>
                            <p>PHumedad <strong>65%</strong></p>
                            <p>Viento <strong>7</strong>m/s</p>
                        </div>
                    </div>
                    <div class="tempoblockmob-element-block-element row">
                        <div class="tempoblockmob-element-block-element-left">
                            <div class="tempoblockmob-element-block-element-left__hour">2 am</div>
                            <div class="tempoblockmob-element-block-element-left__icon icon_2"></div>
                            <div class="tempoblockmob-element-block-element-left__value"><span>17</span></div>
                        </div>
                        <div class="tempoblockmob-element-block-element-right">
                            <p>Presion <strong>753</strong>mmHg(45%)</p>
                            <p>PHumedad <strong>65%</strong></p>
                            <p>Viento <strong>7</strong>m/s</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="banner">
        <div class="container">
            %{--<a href="" class=""><img src="./Tiempolatin_files/banner.png" alt=""></a>--}%
        </div>
    </div>
    <footer>
        <div class="container">
            <a href="" class="footer__private">private page</a>
            <div class="footer-social">
                <a href="" class="footer-social__link footer-social__link_1"></a>
                <a href="" class="footer-social__link footer-social__link_2"></a>
                <a href="" class="footer-social__link footer-social__link_3"></a>
            </div>
        </div>
    </footer>
</div>
</body>
</html>