package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointExpired extends AbstractEvent {

    private Long userId;
    private Long point;
    private Date pointsDeadline;

    public PointExpired(Point aggregate) {
        super(aggregate);
    }

    public PointExpired() {
        super();
    }
}
//>>> DDD / Domain Event
