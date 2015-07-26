<header class="bg-1">
    <div class="container">
        <div class="header-top row">
            <a href="" class="header__logo"></a>
            <div class="header-search__icon"></div>
            <div class="header-search">
                <div class="header-search-form">
                    <form action="#">
                        <input data-value="search..." type="text" name="" class="header-search-form__inp" />
                        <button type="submit" class="header-search-form__btn"></button>
                    </form>
                    <div class="header-search-form-examples">
                        <a href="" class="header-search-form-examples__link">Santiago de Chile</a>
                        <a href="" class="header-search-form-examples__link">Atacama</a>
                        <a href="" class="header-search-form-examples__link">Valparaíso</a>
                    </div>
                </div>
                <div class="header-search-rezults">
                    %{--<div class="header-search-rezults__value">Presion in Chillie manana</div>
                    <div class="header-search-rezults__value">Chillie Humedad</div>
                    <div class="header-search-rezults__value">Presion in Chillie</div>--}%
                </div>
            </div>
        </div>
        <div class="header-bottom row">
            <div class="header-bottom-place">
                <strong>Tiempo en ${city.printName}</strong>
                ${city?.region?.country?.nativeName}
            </div>
            <div class="header-bottom-circle">
                <input value="${percent}" data-displayprevious="false" data-min="0" data-readOnly=true data-height="279" data-width="279" data-max="100" data-thickness=".05" data-bgColor="transparent" data-fgcolor="#86d1c1" class="knob tictac">
                <span class="icon icon_1"></span>
                <span class="value"><span>${current.tempC}</span></span>
            </div>
            <div class="header-bottom-circle-mob">
                <input value="${percent}" data-displayprevious="false" data-min="0" data-readOnly=true data-height="200" data-width="200" data-max="100" data-thickness=".05" data-bgColor="transparent" data-fgcolor="#86d1c1" class="knob tictac">
                <span class="icon icon_1"></span>
                <span class="value"><span>${current.tempC}</span></span>
            </div>
            <div class="header-bottom-info">
                <div class="header-bottom-info__title">CHANCE OF THE RAIN <strong>${current.rainChance}%</strong></div>
                <div class="header-bottom-table">
                    <div class="header-bottom-table__cell">Humedad</div>
                    <div class="header-bottom-table__cell header-bottom-table__cell_dotts"></div>
                    <div class="header-bottom-table__cell">${current.hum}%</div>
                </div>
                <div class="header-bottom-table">
                    <div class="header-bottom-table__cell">Presion %{--<strong>753</strong>mmHg--}%</div>
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
    %{--<div class="mainslider">
        <div class="container">
            <div class="mainslider-block">
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_1"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_2"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_3"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_4"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_5"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_6"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_7"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_8"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_9"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
                <div class="mainslider-item">
                    <div class="mainslider-item__hour">1am</div>
                    <div class="mainslider-item__icon icon_10"></div>
                    <div class="mainslider-item__value"><span>15</span></div>
                </div>
            </div>
        </div>
    </div>--}%
</header>