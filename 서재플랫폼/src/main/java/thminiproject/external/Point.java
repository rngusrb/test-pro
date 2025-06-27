package thminiproject.external;

import java.util.Date;
import lombok.Data;

@Data
public class Point {

    private Long userId;
    private Long point;
    private String userType;
    private Object subscriptionType;
    private Date pointsDeadline;
}
