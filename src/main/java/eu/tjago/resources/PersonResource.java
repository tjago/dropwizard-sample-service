package eu.tjago.resources;

import com.google.inject.Inject;
import eu.tjago.db.PeopleStore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    PeopleStore peopleStore;

    @Inject
    public PersonResource(PeopleStore dao) {
        this.peopleStore = dao;
    }

    @GET
    @Path("{username}")
    public Response getUser(@PathParam("username") String userName) {
        return Response
                .ok()
                .entity(peopleStore.fetchPerson(userName))
                .build();
    }
}
