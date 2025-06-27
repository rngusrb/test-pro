package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointRegistered extends AbstractEvent {

    private SubscriptionType subscriptionType;
    private Long userId;
    private Long point;
    private String userType;

    public PointRegistered(Point aggregate) {
        super(aggregate);
    }

    public PointRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
