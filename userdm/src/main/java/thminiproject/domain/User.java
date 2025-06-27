package thminiproject.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import thminiproject.UserdmApplication;
import thminiproject.domain.PointRequested;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userid;

    private String userType;

    @ElementCollection
    private List<String> wishlist;

    @ElementCollection
    private List<Reviews> reviews;

    private String subscriptionStatus;

    @PostPersist
    public void onPostPersist() {
        PointRequested pointRequested = new PointRequested(this);
        pointRequested.publishAfterCommit();
    }

    public static UserRepository repository() {
        UserRepository userRepository = UserdmApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }

    //<<< Clean Arch / Port Method
    public void registerUser() {
        //implement business logic here:

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        thminiproject.external.Point point = new thminiproject.external.Point();
        // mappings goes here
        UserdmApplication.applicationContext
            .getBean(thminiproject.external.PointService.class)
            .registPoint(point);

        UserRegistered userRegistered = new UserRegistered(this);
        userRegistered.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void bookSubscribeRequest() {
        //implement business logic here:

        BookSubscribeRequested bookSubscribeRequested = new BookSubscribeRequested(
            this
        );
        bookSubscribeRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void writeReview() {
        //implement business logic here:

        ReviewWritten reviewWritten = new ReviewWritten(this);
        reviewWritten.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void addBookToWishlist() {
        //implement business logic here:

        BookWishlisted bookWishlisted = new BookWishlisted(this);
        bookWishlisted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void subscribeMonthlyPlan() {
        //implement business logic here:

        MonthlyPlanSubscribed monthlyPlanSubscribed = new MonthlyPlanSubscribed(
            this
        );
        monthlyPlanSubscribed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
