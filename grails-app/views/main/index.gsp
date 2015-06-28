<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main_custom"/>
    <title></title>
</head>
<body>

Choose city: <g:select name="city" from="${com.tiempo.last.City.list()}" optionKey="id" optionValue="lookupTitle"/>

<button name="show" onclick="showWeatherV2();">Show</button>
<br>
<div id="weather_results">

</div>
<script>
    function showWeather() {
        var city = document.getElementsByName('cities')[0].value;
        var ajax = new XMLHttpRequest();
        ajax.open("GET", "${createLink(controller: 'main', action: 'weather')}?city=" + city, true);
        ajax.onreadystatechange = function() {
            if (ajax.readyState == 4 && ajax.status == 200) {
                document.getElementById('weather_results').innerHTML = ajax.responseText;
            }
        };
        ajax.send();
    };

    function showWeatherV2() {
        var cityId = document.getElementById('city').value;
        var ajax = new XMLHttpRequest();
        ajax.open("GET", "${createLink(controller: 'main', action: 'weatherResults')}?cityId=" + cityId, true);
        ajax.onreadystatechange = function() {
            if (ajax.readyState == 4 && ajax.status == 200) {
                document.getElementById('weather_results').innerHTML = ajax.responseText;
            }
        };
        ajax.send();
    };
</script>
</body>
</html>