%{--<g:each in="${cities}" var="city">--}%
    %{--<div class="header-search-rezults__value">--}%
        %{--<a href="${createLink(controller: 'main', action: 'weather')}?cityId=${city.id}">${com.data.CachedDataStore.CITY_REPRESENTATIONS.get(city.id)}</a>--}%
    %{--</div>--}%
%{--</g:each>--}%

<g:each in="${cityUrlParts}" var="cityUrlPart">
    <div class="header-search-rezults__value">
        <a href="${createLink(controller: 'main', action: 'weather')}/${cityUrlPart}">${com.data.CachedDataStore.CITY_REPRESENTATIONS.get(cityUrlPart)}</a>
    </div>
</g:each>