package eu.tjago.resources;


import com.codahale.metrics.annotation.Timed;
import eu.tjago.api.Fruit;
import eu.tjago.core.FruitStore;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
public class FruitsResource {

    FruitStore fruitStore;

    @Inject
    public FruitsResource(FruitStore fruitStore) {
        this.fruitStore = fruitStore;
    }

    @GET
    @Path("/all")
    @Timed
    public Response getAll() {
        return Response.ok().entity(fruitStore.getAll()).build();
    }

    @POST
    @Path("/insert")
    @Timed
    public Response insert(Fruit fruit, @Context UriInfo uriInfo) {
        fruitStore.add(fruit);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(fruit.getName());
        return Response.created(uriBuilder.build()).build();
    }
}
