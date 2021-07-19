<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список цветов</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/json2html/2.1.0/json2html.min.js"></script>
</head>
<body>
<section>

    Выбор: <span class="out"></span>

    <hr>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Цвет</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</section>

<script>

    <jsp:useBean id="jsonItems" scope="request" type="java.lang.String"/>
    let items = '${jsonItems}';

    let template = {
        '<>': 'tr',
        'html': [
            {'<>': 'td', 'html': "\${number}"},
            {'<>': 'td', 'class': 'show-my-value', 'html': "\${name}"}
        ]
    };

    $('table tbody').json2html(items, template);

    $('.show-my-value').click(function () {
        let color = $(this).text().replace(/\s+/g, '');
        let tdArr = $(this).parent().children("td").toArray();
        let showStr = tdArr.map(e => e.innerText).join(",");
        $('span.out').text(showStr).css('background-color', color);
    })


</script>

</body>
</html>
