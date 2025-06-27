package thminiproject.domain;

import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

@Data
@ToString
public class PublishRequested extends AbstractEvent {

    private Long id;
    private String manuscriptId;
    private String authorNAme;
    private Date requestedAt;
    private Double status;
}
