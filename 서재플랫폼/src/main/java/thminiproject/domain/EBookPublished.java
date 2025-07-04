package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class EBookPublished extends AbstractEvent {

    private Long id;

    public EBookPublished(플랫폼관리 aggregate) {
        super(aggregate);
    }

    public EBookPublished() {
        super();
    }
}
//>>> DDD / Domain Event
