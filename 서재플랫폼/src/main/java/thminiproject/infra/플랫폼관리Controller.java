package thminiproject.infra;
import thminiproject.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/플랫폼관리")
@Transactional
public class 플랫폼관리Controller {
    @Autowired
    플랫폼관리Repository 플랫폼관리Repository;

    @RequestMapping(value = "/플랫폼관리/requestbestseller",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public 플랫폼관리 requestBestseller(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /플랫폼관리/requestBestseller  called #####");
            플랫폼관리 플랫폼관리 = new 플랫폼관리();
            플랫폼관리.requestBestseller();
            플랫폼관리Repository.save(플랫폼관리);
            return 플랫폼관리;
    }
}
//>>> Clean Arch / Inbound Adaptor
