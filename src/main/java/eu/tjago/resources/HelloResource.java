package eu.tjago.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import eu.tjago.api.Saying;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.valuehandling.UnwrapValidatedValue;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    @Inject
    public HelloResource(@Named("template") String template, @Named("defaultName") String defaultName) {
        //logger.info("Creating a new HelloWorldResource!");
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") @UnwrapValidatedValue @NotEmpty Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
