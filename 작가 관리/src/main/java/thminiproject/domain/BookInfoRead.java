package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookInfoRead extends AbstractEvent {

    private Long authorId;

    public BookInfoRead(Author aggregate) {
        super(aggregate);
    }

    public BookInfoRead() {
        super();
    }
}
//>>> DDD / Domain Event
