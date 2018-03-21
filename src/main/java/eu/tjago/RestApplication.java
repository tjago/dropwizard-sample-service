package eu.tjago;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestApplication extends Application<RestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RestApplication().run(args);
    }

    @Override
    public String getName() {
        return "rest-app";
    }

    @Override
    public void initialize(final Bootstrap<RestConfiguration> bootstrap) {
        GuiceBundle<RestConfiguration> guiceBundle = GuiceBundle.<RestConfiguration>newBuilder()
                .addModule(new RestModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(RestConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(final RestConfiguration configuration,
                    final Environment environment) {
    }

}
