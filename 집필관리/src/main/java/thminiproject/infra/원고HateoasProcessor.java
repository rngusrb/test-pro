package thminiproject.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import thminiproject.domain.*;

@Component
public class 원고HateoasProcessor
    implements RepresentationModelProcessor<EntityModel<원고>> {

    @Override
    public EntityModel<원고> process(EntityModel<원고> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/registmanuscript"
                )
                .withRel("registmanuscript")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/requestpublish")
                .withRel("requestpublish")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/editmanuscript")
                .withRel("editmanuscript")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/deletemanuscript"
                )
                .withRel("deletemanuscript")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/savemanuscript")
                .withRel("savemanuscript")
        );

        return model;
    }
}
