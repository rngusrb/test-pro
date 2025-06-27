package thminiproject.domain;

import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

@Data
@ToString
public class BookSubscribeRequested extends AbstractEvent {

    private Long id;
    private String userid;
    private String subscriptionStatus;
}
