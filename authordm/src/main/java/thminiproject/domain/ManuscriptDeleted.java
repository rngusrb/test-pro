package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ManuscriptDeleted extends AbstractEvent {

    private Long id;
    private Long manuscriptId;
    private Date deletedAt;

    public ManuscriptDeleted(Author aggregate) {
        super(aggregate);
    }

    public ManuscriptDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
