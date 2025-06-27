package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BestsellerListCreated extends AbstractEvent {

    private Long id;
    private Long bookId;
    private List<String> bestseller;

    public BestsellerListCreated(Admin aggregate) {
        super(aggregate);
    }

    public BestsellerListCreated() {
        super();
    }
}
//>>> DDD / Domain Event
