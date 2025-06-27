package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookAccessGranted extends AbstractEvent {

    private Long id;
    private Long userId;
    private Boolean isSubscribed;

    public BookAccessGranted(플랫폼관리 aggregate) {
        super(aggregate);
    }

    public BookAccessGranted() {
        super();
    }
}
//>>> DDD / Domain Event
