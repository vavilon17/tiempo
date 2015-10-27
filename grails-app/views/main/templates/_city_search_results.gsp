%{--<g:each in="${cities}" var="city">--}%
    %{--<div class="header-search-rezults__value">--}%
        %{--<a href="${createLink(controller: 'main', action: 'weather')}?cityId=${city.id}">${com.data.CachedDataStore.CITY_REPRESENTATIONS.get(city.id)}</a>--}%
    %{--</div>--}%
%{--</g:each>--}%

<g:each in="${cityIds}" var="cityId">
    <div class="header-search-rezults__value">
        <a href="${createLink(controller: 'main', action: 'weather')}?cityId=${cityId}">${com.data.CachedDataStore.CITY_REPRESENTATIONS.get(cityId)}</a>
    </div>
</g:each>