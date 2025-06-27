package thminiproject.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class UsePointCommand {

    private Long point;
    private String userType;
    private SubscriptionType subscriptionType;
}
