package thminiproject.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import thminiproject.domain.*;

@Component
public class 플랫폼관리HateoasProcessor
    implements RepresentationModelProcessor<EntityModel<플랫폼관리>> {

    @Override
    public EntityModel<플랫폼관리> process(EntityModel<플랫폼관리> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/requestbestseller"
                )
                .withRel("requestbestseller")
        );

        return model;
    }
}
