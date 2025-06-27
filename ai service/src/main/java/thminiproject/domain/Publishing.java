package thminiproject.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import thminiproject.AiServiceApplication;
import thminiproject.domain.Published;

@Entity
@Table(name = "Publishing_table")
@Data
//<<< DDD / Aggregate Root
public class Publishing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String summaryContent;

    private String summary;

    private String category;

    private String imagepath;

    private String contents;

    public static PublishingRepository repository() {
        PublishingRepository publishingRepository = AiServiceApplication.applicationContext.getBean(
            PublishingRepository.class
        );
        return publishingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void publish(PublishRequested publishRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        Publishing publishing = new Publishing();
        repository().save(publishing);

        Published published = new Published(publishing);
        published.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(publishRequested.get???()).ifPresent(publishing->{
            
            publishing // do something
            repository().save(publishing);

            Published published = new Published(publishing);
            published.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
