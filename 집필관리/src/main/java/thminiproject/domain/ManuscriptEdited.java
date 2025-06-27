package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ManuscriptEdited extends AbstractEvent {

    private Long id;
    private Long manuscriptId;
    private String modifiedFields;
    private Date editedAt;

    public ManuscriptEdited(원고 aggregate) {
        super(aggregate);
    }

    public ManuscriptEdited() {
        super();
    }
}
//>>> DDD / Domain Event
