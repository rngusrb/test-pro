package thminiproject.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import thminiproject.domain.PointUpdated;
import thminiproject.포인트관리Application;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private Long point;

    private String userType;

    private SubscriptionType subscriptionType;

    private Date pointsDeadline;

    @PostPersist
    public void onPostPersist() {
        PointUpdated pointUpdated = new PointUpdated(this);
        pointUpdated.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = 포인트관리Application.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    //<<< Clean Arch / Port Method
    public void registPoint(RegistPointCommand registPointCommand) {
        //implement business logic here:

        PointRegistered pointRegistered = new PointRegistered(this);
        pointRegistered.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void usePoint(UsePointCommand usePointCommand) {
        //implement business logic here:

        PointUsed pointUsed = new PointUsed(this);
        pointUsed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void expirePoint(ExpirePointCommand expirePointCommand) {
        //implement business logic here:

        PointExpired pointExpired = new PointExpired(this);
        pointExpired.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
