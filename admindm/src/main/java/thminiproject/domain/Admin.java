package thminiproject.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import thminiproject.AdmindmApplication;
import thminiproject.domain.AuthorApproved;
import thminiproject.domain.AuthorRejected;
import thminiproject.domain.BookAccessDenied;
import thminiproject.domain.BookAccessGranted;
import thminiproject.domain.CategoryUpdated;
import thminiproject.domain.EBookPublished;
import thminiproject.domain.EbookPublishCanceld;

@Entity
@Table(name = "Admin_table")
@Data
//<<< DDD / Aggregate Root
public class Admin {

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

    public static AdminRepository repository() {
        AdminRepository adminRepository = AdmindmApplication.applicationContext.getBean(
            AdminRepository.class
        );
        return adminRepository;
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
        Admin admin = new Admin();
        repository().save(admin);

        AuthorApproved authorApproved = new AuthorApproved(admin);
        authorApproved.publishAfterCommit();
        AuthorRejected authorRejected = new AuthorRejected(admin);
        authorRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(authorRegistrationRequested.get???()).ifPresent(admin->{
            
            admin // do something
            repository().save(admin);

            AuthorApproved authorApproved = new AuthorApproved(admin);
            authorApproved.publishAfterCommit();
            AuthorRejected authorRejected = new AuthorRejected(admin);
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
        Admin admin = new Admin();
        repository().save(admin);

        BookAccessGranted bookAccessGranted = new BookAccessGranted(admin);
        bookAccessGranted.publishAfterCommit();
        BookAccessDenied bookAccessDenied = new BookAccessDenied(admin);
        bookAccessDenied.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(bookSubscribeRequested.get???()).ifPresent(admin->{
            
            admin // do something
            repository().save(admin);

            BookAccessGranted bookAccessGranted = new BookAccessGranted(admin);
            bookAccessGranted.publishAfterCommit();
            BookAccessDenied bookAccessDenied = new BookAccessDenied(admin);
            bookAccessDenied.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void checkEbookRegistration(Published published) {
        //implement business logic here:

        /** Example 1:  new item 
        Admin admin = new Admin();
        repository().save(admin);

        EbookPublishCanceld ebookPublishCanceld = new EbookPublishCanceld(admin);
        ebookPublishCanceld.publishAfterCommit();
        EBookPublished eBookPublished = new EBookPublished(admin);
        eBookPublished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(published.get???()).ifPresent(admin->{
            
            admin // do something
            repository().save(admin);

            EbookPublishCanceld ebookPublishCanceld = new EbookPublishCanceld(admin);
            ebookPublishCanceld.publishAfterCommit();
            EBookPublished eBookPublished = new EBookPublished(admin);
            eBookPublished.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
