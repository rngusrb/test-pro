package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookAccessDenied extends AbstractEvent {

    private Long id;

    public BookAccessDenied(Admin aggregate) {
        super(aggregate);
    }

    public BookAccessDenied() {
        super();
    }
}
//>>> DDD / Domain Event
