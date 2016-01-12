<%@ page contentType="text/plain;charset=UTF-8" %>User-agent: *
<g:if test="${!isSubDomain}">Disallow: /sitemap.xml</g:if>
Disallow: /admin/
Disallow: /auth/
Disallow: /main/search