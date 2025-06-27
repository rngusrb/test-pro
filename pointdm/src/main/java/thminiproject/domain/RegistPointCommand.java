package thminiproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegistPointCommand {

    private Long point;
    private String userType;
    private SubscriptionType subscriptionType;
}
