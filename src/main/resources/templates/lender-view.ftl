<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>NLA Technical Test</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <script src="/js/nla-test.js"></script>
</head>


<body>


<#list lenders>
<div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">Lenders of books</div>
    <div class="panel-body">Click on the lender to see their current loans...

        <!-- Lender list -->
        <div class="list-group">
            <#items as lender>
                <div id="div-lender-${lender.id}" class="list-group-item">
                    <button class="btn btn-primary" type="button"
                            onclick="loadBooksForLender(${lender.id})">${lender.name}
                        <span class="badge">${lender.booksOnLoanCount}</span></button>
                    <div id="book-table" style="display:none">
                        <table class="table table-condensed">
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
            </#items>
        </div>
    </div>
<#else>
    <p>No Lenders found.
</div>
</#list>

</body>

</html>