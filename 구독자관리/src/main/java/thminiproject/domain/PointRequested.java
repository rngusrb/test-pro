package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointRequested extends AbstractEvent {

    private Long id;

    public PointRequested(User aggregate) {
        super(aggregate);
    }

    public PointRequested() {
        super();
    }
}
//>>> DDD / Domain Event
