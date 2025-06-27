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

    public EbookPublishCanceld(플랫폼관리 aggregate) {
        super(aggregate);
    }

    public EbookPublishCanceld() {
        super();
    }
}
//>>> DDD / Domain Event
