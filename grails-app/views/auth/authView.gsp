<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <meta name="layout" content="empty">
</head>
<body>
<g:form controller="auth" action="login" method="POST">
    <g:hiddenField name="pass" value=""/>
</g:form>
<script>
    var pass = prompt("${flash.message ?: ''} Please, enter password", '');
    if (pass == null) {
        window.location = "${createLink(controller: 'main')}";
    } else {
        document.getElementsByName('pass').item(0).value = pass;
        document.getElementsByTagName('form').item(0).submit();
    }
</script>
</body>
</html>