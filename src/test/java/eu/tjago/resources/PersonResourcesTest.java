package eu.tjago.resources;

import com.squarespace.jersey2.guice.JerseyGuiceUtils;
import eu.tjago.api.Person;
import eu.tjago.db.PeopleStore;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PersonResourcesTest {

    private static final PeopleStore dao = mock(PeopleStore.class);

    static {
        JerseyGuiceUtils.install((s, serviceLocator) -> null);
    }
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PersonResource(dao))
            .build();

    private final Person person = new Person("blah", "blah@example.com");

    @Before
    public void setup() {
        when(dao.fetchPerson(eq("blah"))).thenReturn(person);
    }

    @After
    public void tearDown(){
        // we have to reset the mock after each test because of the
        // @ClassRule, or use a @Rule as mentioned below.
        reset(dao);
    }

    @Test
    public void testGetPerson() {
        assertThat(resources.target("/person/blah").request().get(Person.class))
                .isEqualTo(person);
        verify(dao).fetchPerson("blah");
    }
}
