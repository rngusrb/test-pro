package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointUsed extends AbstractEvent {

    private Long userId;
    private Long point;
    private Date pointsDeadline;

    public PointUsed(Point aggregate) {
        super(aggregate);
    }

    public PointUsed() {
        super();
    }
}
//>>> DDD / Domain Event
