package eu.tjago.resources;


import com.codahale.metrics.annotation.Timed;
import eu.tjago.api.Fruit;
import eu.tjago.core.FruitStore;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    public List<Fruit> getAll() {
        return fruitStore.getAll();
    }

    @POST
    @Path("/insert")
    @Timed
    public  void insert(Fruit fruit) {
        fruitStore.add(fruit);
    }
}
