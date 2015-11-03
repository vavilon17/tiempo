<%@ page contentType="text/xml;charset=UTF-8" %>
<g:set var="baseUrl" value="${grailsApplication.config.baseDomain}"/>
<g:set var="step" value="${1/cityUrls.size()}"/>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
    <url>
        <loc>${baseUrl}/</loc>
        <changefreq>daily</changefreq>
        <priority>1</priority>
    </url>
    <url>
        <loc>${baseUrl}/weather</loc>
        <changefreq>daily</changefreq>
        <priority>1</priority>
    </url>
    <g:each in="${cityUrls}" var="cityUrl" status="i">
        <url>
            <loc>${baseUrl}/weather/${cityUrl}</loc>
            <changefreq>daily</changefreq>
            <priority>${1 - i*step}</priority>
        </url>
    </g:each>
</urlset>