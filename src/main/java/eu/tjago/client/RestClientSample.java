package eu.tjago.client;

import com.google.common.collect.ImmutableMultimap;
import eu.tjago.api.Person;
import io.dropwizard.servlets.tasks.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.PrintWriter;

public class RestClientSample extends Task {

    Logger logger = LoggerFactory.getLogger(RestClientSample.class);

    private static final String REST_URI = "http://localhost:8080/person";
    private Client client = ClientBuilder.newClient();

    protected RestClientSample() {
        super("fetchConan");
    }

    public Person getJsonEmployee() {
        return client
                .target(REST_URI)
                .path("/Conan")
                .request(MediaType.APPLICATION_JSON)
                .get(Person.class);
    }

    @Override
    public void execute(ImmutableMultimap<String, String> immutableMultimap, PrintWriter printWriter) throws Exception {
        logger.info("Hello from Rest client");
        logger.info("Fetched Person email: " + getJsonEmployee().getEmail());
    }
}
