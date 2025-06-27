package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookSubscribeRequested extends AbstractEvent {

    private Long id;
    private String userid;
    private String subscriptionStatus;

    public BookSubscribeRequested(User aggregate) {
        super(aggregate);
    }

    public BookSubscribeRequested() {
        super();
    }
}
//>>> DDD / Domain Event
