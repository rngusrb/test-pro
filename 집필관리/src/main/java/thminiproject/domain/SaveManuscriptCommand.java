package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SaveManuscriptCommand {

    private String content;
    private Long manuscriptId;
}
