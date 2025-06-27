package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CategoryUpdated extends AbstractEvent {

    private Long id;
    private Long categoryId;
    private String category;
    private List<String> categories;

    public CategoryUpdated(Admin aggregate) {
        super(aggregate);
    }

    public CategoryUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
