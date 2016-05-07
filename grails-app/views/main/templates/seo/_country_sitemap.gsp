<%@ page contentType="text/xml;charset=UTF-8" %>
<g:set var="step" value="${1/cityUrls.size()}"/>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
    <g:each in="${cityUrls}" var="cityUrl" status="i">
        <url>
            <loc>${baseUrl}/weather/${cityUrl}</loc>
            <changefreq>daily</changefreq>
            <priority>${1 - i*step}</priority>
        </url>
    </g:each>
</urlset>