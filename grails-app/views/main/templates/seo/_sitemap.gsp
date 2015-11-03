<%@ page contentType="text/xml;charset=UTF-8" %>
<sitemapindex xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
    <g:each in="${com.tiempo.CacheService.ACTIVE_COUNTRY_CODES}" var="countryCode">
        <sitemap>
            <loc>${grailsApplication.config.baseDomain}/sitemap-${countryCode}-weather.xml</loc>
        </sitemap>
    </g:each>
</sitemapindex>

