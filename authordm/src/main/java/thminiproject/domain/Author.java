package thminiproject.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import thminiproject.AuthordmApplication;
import thminiproject.domain.AuthorDeleted;
import thminiproject.domain.AuthorModified;
import thminiproject.domain.BookInfoRead;

@Entity
@Table(name = "Author_table")
@Data
//<<< DDD / Aggregate Root
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;

    private String authorName;

    private Date craeteDate;

    private String authorInfo;

    private String authorPortfolio;

    @PostPersist
    public void onPostPersist() {
        AuthorDeleted authorDeleted = new AuthorDeleted(this);
        authorDeleted.publishAfterCommit();

        AuthorModified authorModified = new AuthorModified(this);
        authorModified.publishAfterCommit();

        BookInfoRead bookInfoRead = new BookInfoRead(this);
        bookInfoRead.publishAfterCommit();
    }

    public static AuthorRepository repository() {
        AuthorRepository authorRepository = AuthordmApplication.applicationContext.getBean(
            AuthorRepository.class
        );
        return authorRepository;
    }

    //<<< Clean Arch / Port Method
    public void registAuthor() {
        //implement business logic here:

        AuthorRegistrationRequested authorRegistrationRequested = new AuthorRegistrationRequested(
            this
        );
        authorRegistrationRequested.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
