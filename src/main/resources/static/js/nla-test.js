/**
 *
 * RESTful ajax function for loading books for a given lender identifier.
 *
 * Created by mark on 29/1/17.
 */

function loadBooksForLender(lenderId) {

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

            var divId = "#div-lender-" + lenderId;
            var divParent = $(divId);

            /** display the book table showing all books */
            $(divParent).find("#book-table").show("slow");

            /** add a row for the book details from the lenders on loan books data */
            $(divParent).find("#lender-loans").append($("<tr>").append($("<td>").text(json[idx].title).append($("</td>"))).append($("<td>").append(json[idx].author).append($("</td>"))).append($("<td>").append(json[idx].isbn).append($("</td>"))).append($("</tr>")));

            /** Singleshot show books - disable button */
            $(divParent).find("button").prop('disabled', true);
        });
    });
}


