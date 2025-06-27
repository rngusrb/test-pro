package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorModified extends AbstractEvent {

    private Long authorId;
    private String authorName;
    private String authorInfo;

    public AuthorModified(Author aggregate) {
        super(aggregate);
    }

    public AuthorModified() {
        super();
    }
}
//>>> DDD / Domain Event
