package thminiproject.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thminiproject.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/points")
@Transactional
public class PointController {

    @Autowired
    PointRepository pointRepository;

    @RequestMapping(
        value = "/points/registpoint",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Point registPoint(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RegistPointCommand registPointCommand
    ) throws Exception {
        System.out.println("##### /point/registPoint  called #####");
        Point point = new Point();
        point.registPoint(registPointCommand);
        pointRepository.save(point);
        return point;
    }

    @RequestMapping(
        value = "/points/usepoint",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Point usePoint(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UsePointCommand usePointCommand
    ) throws Exception {
        System.out.println("##### /point/usePoint  called #####");
        Point point = new Point();
        point.usePoint(usePointCommand);
        pointRepository.save(point);
        return point;
    }

    @RequestMapping(
        value = "/points/expirepoint",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Point expirePoint(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ExpirePointCommand expirePointCommand
    ) throws Exception {
        System.out.println("##### /point/expirePoint  called #####");
        Point point = new Point();
        point.expirePoint(expirePointCommand);
        pointRepository.save(point);
        return point;
    }
}
//>>> Clean Arch / Inbound Adaptor
