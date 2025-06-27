package thminiproject.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import thminiproject.domain.AuthorApproved;
import thminiproject.domain.AuthorRejected;
import thminiproject.domain.BookAccessDenied;
import thminiproject.domain.BookAccessGranted;
import thminiproject.domain.CategoryUpdated;
import thminiproject.domain.EBookPublished;
import thminiproject.domain.EbookPublishCanceld;
import thminiproject.서재플랫폼Application;

@Entity
@Table(name = "플랫폼관리_table")
@Data
//<<< DDD / Aggregate Root
public class 플랫폼관리 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long authorId;

    private Long bookId;

    private Long categoryId;

    private Boolean isSubscribed;

    private Boolean isPublished;

    @ElementCollection
    private List<String> bestseller;

    public static 플랫폼관리Repository repository() {
        플랫폼관리Repository 플랫폼관리Repository = 서재플랫폼Application.applicationContext.getBean(
            플랫폼관리Repository.class
        );
        return 플랫폼관리Repository;
    }

    //<<< Clean Arch / Port Method
    public void requestBestseller() {
        //implement business logic here:

        BestsellerListCreated bestsellerListCreated = new BestsellerListCreated(
            this
        );
        bestsellerListCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void authorRegistrationRequest(
        AuthorRegistrationRequested authorRegistrationRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        플랫폼관리 플랫폼관리 = new 플랫폼관리();
        repository().save(플랫폼관리);

        AuthorApproved authorApproved = new AuthorApproved(플랫폼관리);
        authorApproved.publishAfterCommit();
        AuthorRejected authorRejected = new AuthorRejected(플랫폼관리);
        authorRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(authorRegistrationRequested.get???()).ifPresent(플랫폼관리->{
            
            플랫폼관리 // do something
            repository().save(플랫폼관리);

            AuthorApproved authorApproved = new AuthorApproved(플랫폼관리);
            authorApproved.publishAfterCommit();
            AuthorRejected authorRejected = new AuthorRejected(플랫폼관리);
            authorRejected.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void checkSubscriptionAccess(
        BookSubscribeRequested bookSubscribeRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        플랫폼관리 플랫폼관리 = new 플랫폼관리();
        repository().save(플랫폼관리);

        BookAccessGranted bookAccessGranted = new BookAccessGranted(플랫폼관리);
        bookAccessGranted.publishAfterCommit();
        BookAccessDenied bookAccessDenied = new BookAccessDenied(플랫폼관리);
        bookAccessDenied.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(bookSubscribeRequested.get???()).ifPresent(플랫폼관리->{
            
            플랫폼관리 // do something
            repository().save(플랫폼관리);

            BookAccessGranted bookAccessGranted = new BookAccessGranted(플랫폼관리);
            bookAccessGranted.publishAfterCommit();
            BookAccessDenied bookAccessDenied = new BookAccessDenied(플랫폼관리);
            bookAccessDenied.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void checkEbookRegistration(Published published) {
        //implement business logic here:

        /** Example 1:  new item 
        플랫폼관리 플랫폼관리 = new 플랫폼관리();
        repository().save(플랫폼관리);

        EbookPublishCanceld ebookPublishCanceld = new EbookPublishCanceld(플랫폼관리);
        ebookPublishCanceld.publishAfterCommit();
        EBookPublished eBookPublished = new EBookPublished(플랫폼관리);
        eBookPublished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(published.get???()).ifPresent(플랫폼관리->{
            
            플랫폼관리 // do something
            repository().save(플랫폼관리);

            EbookPublishCanceld ebookPublishCanceld = new EbookPublishCanceld(플랫폼관리);
            ebookPublishCanceld.publishAfterCommit();
            EBookPublished eBookPublished = new EBookPublished(플랫폼관리);
            eBookPublished.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
