package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorRejected extends AbstractEvent {

    private Long id;

    public AuthorRejected(플랫폼관리 aggregate) {
        super(aggregate);
    }

    public AuthorRejected() {
        super();
    }
}
//>>> DDD / Domain Event
