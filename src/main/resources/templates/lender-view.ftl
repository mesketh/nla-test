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
<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">Lenders of books</div>
    <div class="panel-body">Click on the lender to see their current loans...</div>

    <!-- Lender list -->
    <#items as lender>
        <ul class="list-group">
            <div id="div-lender-${lender.id}">
                <button type="button" class="list-group-item"
                        onclick="loadBooksForLender(${lender.id})">${lender.name}</button>
                <div id="book-table" style="display:none">
                    <table>
                        <thead>
                        <tr>
                            <td>Title</td>
                            <td>Author</td>
                            <td>ISBN</td>
                        </tr>
                        </thead>
                        <tbody id="lender-loans">
                        <!-- empty body - populated via ajax upon lender list item button being pressed -->
                        </tbody>

                    </table>
                </div>
            </div>
        </ul>
    </#items>
</div>
<#else>
<p>No Lenders found.
</#list>

</body>

</html>