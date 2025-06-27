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
    AdminRepository adminRepository;

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
        Admin.authorRegistrationRequest(event);
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
        Admin.checkSubscriptionAccess(event);
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
        Admin.checkEbookRegistration(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
