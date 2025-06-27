package thminiproject.domain;

import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

@Data
@ToString
public class AuthorRegistrationRequested extends AbstractEvent {

    private Long authorId;
    private String authorName;
    private String authorInfo;
    private String authorPortfolio;
}
