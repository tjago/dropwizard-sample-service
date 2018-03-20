package eu.tjago.core;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import eu.tjago.api.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class FruitStore {

    private List<Fruit> fruitList = new ArrayList();

    @Inject
    public FruitStore() {
        fruitList.add(new Fruit("Banana",5));
        fruitList.add(new Fruit("Orange", 11));
    }

    public void add(final Fruit fruit) {
        Optional<Fruit> existingFruit = fruitList.stream()
                .filter(s -> s.getName().equalsIgnoreCase(fruit.getName()))
                .findFirst();

        if (existingFruit.isPresent()) {
            existingFruit.get().setQuantity(existingFruit.get().getQuantity() + fruit.getQuantity());
        } else {
            fruitList.add(fruit);
        }
    }

    public void remove(Fruit fruit) {
        fruitList.stream()
                .filter(s -> s.equals(fruit))
                .findFirst()
                .ifPresent(s -> fruitList.remove(fruit));
    }

    public void update(Fruit oldFruit, Fruit newFruit) {
        fruitList.stream()
                .filter(s -> s.getName().equals(oldFruit.getName()))
                .findFirst()
                .ifPresent(s -> s.setName(newFruit.getName()));
    }

    public List<Fruit> getAll() {
        return fruitList;
    }

}
