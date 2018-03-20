package eu.tjago;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class RestModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    @Named("template")
    public String provideTemplate(RestConfiguration configuration) {
        return configuration.getTemplate();
    }

    @Provides
    @Named("defaultName")
    public String provideDefaultName(RestConfiguration configuration) {
        return configuration.getDefaultName();
    }
}
