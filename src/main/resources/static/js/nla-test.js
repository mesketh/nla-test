/**
 *
 * Created by mark on 29/1/17.
 */

function loadBooksForLender(lenderId, button) {

    $.ajax({

        // The URL for the request
        url: "/booksFor",

        // The data to send (will be converted to a query string)
        data: {
            lenderId: lenderId
        },

        // Whether this is a POST or GET request
        type: "GET",

        // The type of data we expect back
        dataType: "json"

    }).success(function (json) {
        $.each(json, function (idx, book) {

            $('#row-' + lenderId).append($("<tr>").append($("<td>").text(json[idx].title + " " + json[idx].author + " " + json[idx].isbn)));
            $(button).prop('disabled', true);
        });
    });
}


