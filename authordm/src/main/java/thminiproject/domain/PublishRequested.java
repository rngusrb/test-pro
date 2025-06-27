package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PublishRequested extends AbstractEvent {

    private Long id;
    private String manuscriptId;
    private String authorNAme;
    private Date requestedAt;
    private Double status;

    public PublishRequested(Author aggregate) {
        super(aggregate);
    }

    public PublishRequested() {
        super();
    }
}
//>>> DDD / Domain Event
