package thminiproject.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import thminiproject.config.kafka.KafkaProcessor;
import thminiproject.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    플랫폼관리Repository 플랫폼관리Repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AuthorRegistrationRequested'"
    )
    public void wheneverAuthorRegistrationRequested_AuthorRegistrationRequest(
        @Payload AuthorRegistrationRequested authorRegistrationRequested
    ) {
        AuthorRegistrationRequested event = authorRegistrationRequested;
        System.out.println(
            "\n\n##### listener AuthorRegistrationRequest : " +
            authorRegistrationRequested +
            "\n\n"
        );

        // Sample Logic //
        플랫폼관리.authorRegistrationRequest(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookSubscribeRequested'"
    )
    public void wheneverBookSubscribeRequested_CheckSubscriptionAccess(
        @Payload BookSubscribeRequested bookSubscribeRequested
    ) {
        BookSubscribeRequested event = bookSubscribeRequested;
        System.out.println(
            "\n\n##### listener CheckSubscriptionAccess : " +
            bookSubscribeRequested +
            "\n\n"
        );

        // Sample Logic //
        플랫폼관리.checkSubscriptionAccess(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Published'"
    )
    public void wheneverPublished_CheckEbookRegistration(
        @Payload Published published
    ) {
        Published event = published;
        System.out.println(
            "\n\n##### listener CheckEbookRegistration : " + published + "\n\n"
        );

        // Sample Logic //
        플랫폼관리.checkEbookRegistration(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
