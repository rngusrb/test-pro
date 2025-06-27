package thminiproject.domain;

import java.util.*;
import lombok.*;
import thminiproject.domain.*;
import thminiproject.infra.AbstractEvent;

@Data
@ToString
public class Published extends AbstractEvent {

    private Long id;
    private String authorid;
    private String summary;
    private String title;
    private String category;
    private String imagepath;
    private String contents;
}
