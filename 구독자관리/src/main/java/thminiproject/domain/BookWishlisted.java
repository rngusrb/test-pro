package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookWishlisted extends AbstractEvent {

    private Long id;
    private String userid;
    private List<String> wishlist;

    public BookWishlisted(User aggregate) {
        super(aggregate);
    }

    public BookWishlisted() {
        super();
    }
}
//>>> DDD / Domain Event
