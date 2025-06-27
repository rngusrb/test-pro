package thminiproject.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import thminiproject.domain.*;

@Component
public class PointHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Point>> {

    @Override
    public EntityModel<Point> process(EntityModel<Point> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/registpoint")
                .withRel("registpoint")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/usepoint")
                .withRel("usepoint")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/expirepoint")
                .withRel("expirepoint")
        );

        return model;
    }
}
