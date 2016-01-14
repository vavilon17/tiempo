Tiempolatin sitemap/robots test cases:

1. MAIN_DOMAIN/robots.txt disallows indexing from MAIN_DOMAIN
2. MAIN_DOMAIN/sitemap.xml -> 404
3. SUBDOMAIN/robots.txt allows indexing
4. SUBDOMAIN/sitemap.xml -> list of urls SUBDOMAIN/xxx

Countries:
Argentina (AR - ar) - 25.5
Colombia (CO - co) - 23.6
Venezuela (VE - ve) - 15.6
Peru (PE - pe) - 11.7
Chile (CL - cl) - 11.4
Ecuador (EC - ec) - 6.2
Bolivia (BO - bo) - 4.1
Paraguay (PY py) - 2.4
Uruguay (UY - uy) 1.9


Add country:
- get data from geonames
- create country in DB, set the limit
- import into BD cities and regions
- add subdomain on imena
- add appropriate section in nginx settings
- check robots.txt/sitemap.xml (do not forget to change Config.groovy)

Geonames countries - http://download.geonames.org/export/dump/
Geonames regions - http://download.geonames.org/export/dump/admin1CodesASCII.txt
Geonames info - http://download.geonames.org/export/dump/readme.txt
List of timezones - https://en.wikipedia.org/wiki/List_of_tz_database_time_zones