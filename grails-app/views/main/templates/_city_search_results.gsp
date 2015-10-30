<%@ page import="com.tiempo.CacheService" %>
<g:each in="${cityUrlParts}" var="cityUrlPart">
    <div class="header-search-rezults__value">
        <a href="${createLink(controller: 'main', action: 'weather')}/${cityUrlPart}">${CacheService.CITY_REPRESENTATIONS.get(cityUrlPart)}</a>
    </div>
</g:each>