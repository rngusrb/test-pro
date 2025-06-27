package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ManuscriptRegisted extends AbstractEvent {

    private Long id;
    private Long manuscriptId;
    private String title;
    private String authorName;
    private String date;
    private String type;
    private String content;
    private Double status;

    public ManuscriptRegisted(Author aggregate) {
        super(aggregate);
    }

    public ManuscriptRegisted() {
        super();
    }
}
//>>> DDD / Domain Event
