package eu.tjago.resources;

import com.google.inject.Inject;
import eu.tjago.api.Person;
import eu.tjago.db.PeopleStore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    PeopleStore peopleStore;

    @Inject
    public PersonResource(PeopleStore dao) {
        this.peopleStore = dao;
    }

    @GET
    public Person getUser(@PathParam("username") String userName) {
        return peopleStore.fetchPerson(userName);
    }


}
