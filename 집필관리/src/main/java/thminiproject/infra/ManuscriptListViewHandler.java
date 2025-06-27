package thminiproject.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import thminiproject.config.kafka.KafkaProcessor;
import thminiproject.domain.*;

@Service
public class ManuscriptListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ManuscriptListRepository manuscriptListRepository;
    //>>> DDD / CQRS
}
