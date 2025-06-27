package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewWritten extends AbstractEvent {

    private Long id;
    private String userid;
    private List<Reviews> reviews;

    public ReviewWritten(User aggregate) {
        super(aggregate);
    }

    public ReviewWritten() {
        super();
    }
}
//>>> DDD / Domain Event
