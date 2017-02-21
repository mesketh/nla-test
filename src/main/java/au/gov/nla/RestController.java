package au.gov.nla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Set;

/**
 * {@link RestController} to service ajax requests on lender identifiers to retrieve their
 * corresponding books on loan.
 *
 * Created by mark on 22/1/17.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    LenderRepository lenderRepository;

    @Autowired
    BookRepository bookRepository;


    /**
     * GET restful service to return books for a given lender id
     * @param lenderId
     * @return
     */
    @RequestMapping(path = "/booksFor", method = RequestMethod.GET)
    public Set<Book> getBooksForLender(@RequestParam(value = "lenderId") long lenderId) {

        Lender matchingLender = lenderRepository.findOne(lenderId);
        if (matchingLender != null) {
            return matchingLender.getBooksOnLoan();
        } else {
            return Collections.EMPTY_SET;
        }

    }

    @PostConstruct
    private void seedDatabase() {

        Lender lender = new Lender("Mark Hesketh", "mark@mark.com", "0444 444 444");
        Lender lender2 = new Lender("Renee Hesketh", "ren@ren.com", "0444 444 555");
        Book book = new Book("Tale of Two Cities", "111111111", "Charles Dickens");
        Book book2 = new Book("1984", "1111111222", "George Orwell");
        Book book3 = new Book("Jungle Book", "223334444", "Rudyard Kipling");
        lender.borrow(book);
        lender.borrow(book2);
        lender2.borrow(book3);
        lenderRepository.save(lender);
        lenderRepository.save(lender2);
        bookRepository.save(book);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }

}
