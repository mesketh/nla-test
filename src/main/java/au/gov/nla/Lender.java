package au.gov.nla;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**ø
 * Created by mark on 22/1/17.
 */
@Entity
public class Lender {

    public Lender(String name, String emailAddress, String mobileNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
    }

    public Lender() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String emailAddress;

    private String mobileNumber;

    @OneToMany(mappedBy = "lender")
    private Set<Book> booksOnLoan = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public void borrow(Book book) {
        this.booksOnLoan.add(book);
        book.loanTo(this);

    }

    public Set<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    public long getId() {
        return id;
    }
}
