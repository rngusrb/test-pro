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
    PublishingRepository publishingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PublishRequested'"
    )
    public void wheneverPublishRequested_Publish(
        @Payload PublishRequested publishRequested
    ) {
        PublishRequested event = publishRequested;
        System.out.println(
            "\n\n##### listener Publish : " + publishRequested + "\n\n"
        );

        // Sample Logic //
        Publishing.publish(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
