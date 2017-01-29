package au.gov.nla;

import javax.persistence.*;

/**
 * Created by mark on 22/1/17.
 */
@Entity
public class Book {

    public Book() {
    }

    public Book(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Lender lender;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void loanTo(Lender lender) {
        this.lender = lender;
    }

    private String title;

    private String isbn;

    private String author;


}
