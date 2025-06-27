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
// @RequestMapping(value="/원고")
@Transactional
public class 원고Controller {

    @Autowired
    원고Repository 원고Repository;

    @RequestMapping(
        value = "/원고/{id}/registmanuscript",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public 원고 registManuscript(
        @PathVariable(value = "id") Long id,
        @RequestBody RegistManuscriptCommand registManuscriptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /원고/registManuscript  called #####");
        Optional<원고> optional원고 = 원고Repository.findById(id);

        optional원고.orElseThrow(() -> new Exception("No Entity Found"));
        원고 원고 = optional원고.get();
        원고.registManuscript(registManuscriptCommand);

        원고Repository.save(원고);
        return 원고;
    }

    @RequestMapping(
        value = "/원고/{id}/requestpublish",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public 원고 requestPublish(
        @PathVariable(value = "id") Long id,
        @RequestBody RequestPublishCommand requestPublishCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /원고/requestPublish  called #####");
        Optional<원고> optional원고 = 원고Repository.findById(id);

        optional원고.orElseThrow(() -> new Exception("No Entity Found"));
        원고 원고 = optional원고.get();
        원고.requestPublish(requestPublishCommand);

        원고Repository.save(원고);
        return 원고;
    }

    @RequestMapping(
        value = "/원고/{id}/editmanuscript",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public 원고 editManuscript(
        @PathVariable(value = "id") Long id,
        @RequestBody EditManuscriptCommand editManuscriptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /원고/editManuscript  called #####");
        Optional<원고> optional원고 = 원고Repository.findById(id);

        optional원고.orElseThrow(() -> new Exception("No Entity Found"));
        원고 원고 = optional원고.get();
        원고.editManuscript(editManuscriptCommand);

        원고Repository.save(원고);
        return 원고;
    }

    @RequestMapping(
        value = "/원고/{id}/deletemanuscript",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public 원고 deleteManuscript(
        @PathVariable(value = "id") Long id,
        @RequestBody DeleteManuscriptCommand deleteManuscriptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /원고/deleteManuscript  called #####");
        Optional<원고> optional원고 = 원고Repository.findById(id);

        optional원고.orElseThrow(() -> new Exception("No Entity Found"));
        원고 원고 = optional원고.get();
        원고.deleteManuscript(deleteManuscriptCommand);

        원고Repository.save(원고);
        return 원고;
    }

    @RequestMapping(
        value = "/원고/{id}/savemanuscript",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public 원고 saveManuscript(
        @PathVariable(value = "id") Long id,
        @RequestBody SaveManuscriptCommand saveManuscriptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /원고/saveManuscript  called #####");
        Optional<원고> optional원고 = 원고Repository.findById(id);

        optional원고.orElseThrow(() -> new Exception("No Entity Found"));
        원고 원고 = optional원고.get();
        원고.saveManuscript(saveManuscriptCommand);

        원고Repository.save(원고);
        return 원고;
    }
}
//>>> Clean Arch / Inbound Adaptor
