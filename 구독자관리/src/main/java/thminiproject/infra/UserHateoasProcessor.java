package thminiproject.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import thminiproject.domain.*;

@Component
public class UserHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<User>> {

    @Override
    public EntityModel<User> process(EntityModel<User> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/registeruser")
                .withRel("registeruser")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/booksubscriberequest"
                )
                .withRel("booksubscriberequest")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/writereview")
                .withRel("writereview")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/addbooktowishlist"
                )
                .withRel("addbooktowishlist")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/subscribemonthlyplan"
                )
                .withRel("subscribemonthlyplan")
        );

        return model;
    }
}
