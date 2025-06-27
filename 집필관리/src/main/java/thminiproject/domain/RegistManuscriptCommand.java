package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegistManuscriptCommand {

    private String title;
    private String authorName;
    private Date date;
    private String content;
    private String type;
}
