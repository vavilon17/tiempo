<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:layoutTitle default="TiempoLatin"/></title>
    <asset:stylesheet href="tl_style.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta charset="UTF-8"/>
    <g:layoutHead/>
</head>
<body>
<g:render template="/main/templates/config"/>
<g:layoutBody/>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<asset:javascript src="slick.min.js"/>
<asset:javascript src="jquery.knob.js"/>
<asset:javascript src="jquery.nicescroll.js"/>
<asset:javascript src="script.js"/>
</body>
</html>
