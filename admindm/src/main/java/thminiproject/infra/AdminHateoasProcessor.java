package thminiproject.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import thminiproject.domain.*;

@Component
public class AdminHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Admin>> {

    @Override
    public EntityModel<Admin> process(EntityModel<Admin> model) {
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
