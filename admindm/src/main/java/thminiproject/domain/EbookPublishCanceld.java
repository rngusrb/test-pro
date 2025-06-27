package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class EbookPublishCanceld extends AbstractEvent {

    private Long id;

    public EbookPublishCanceld(Admin aggregate) {
        super(aggregate);
    }

    public EbookPublishCanceld() {
        super();
    }
}
//>>> DDD / Domain Event
