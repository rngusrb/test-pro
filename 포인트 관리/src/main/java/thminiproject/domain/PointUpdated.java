package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointUpdated extends AbstractEvent {

    private Long userId;
    private Long point;
    private Date pointsDeadline;

    public PointUpdated(Point aggregate) {
        super(aggregate);
    }

    public PointUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
