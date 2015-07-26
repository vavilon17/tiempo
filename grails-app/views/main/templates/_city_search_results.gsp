<g:each in="${cities}" var="city">
    %{--<div class="header-search-rezults__value" id="c-${city.id}">${city.getFullRepresentation()}</div>--}%
    <div class="header-search-rezults__value"><a href="${createLink(controller: 'main', action: 'weather')}?cityId=${city.id}">${city.getFullRepresentation()}</a></div>
</g:each>