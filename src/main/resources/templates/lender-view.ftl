<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>NLA Technical Test</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/nla-test.js"></script>
</head>


<body>


<#list lenders>
<table>
    <#items as lender>
        <tr id="row-${lender.id}">
            <td>
            ${lender.name}
            </td>
            <td>
            ${lender.emailAddress}
            </td>
            <td>
                <button id="button-${lender.id}" onclick="loadBooksForLender(${lender.id}, this)">Show books loaned</button>
            </td>

        </tr>

    </#items>
</table>

<#else>
<p>No Lenders found.
</#list>

</body>

</html>