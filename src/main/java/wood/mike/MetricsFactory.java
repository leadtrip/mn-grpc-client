package wood.mike;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import java.util.Collections;

@Factory
public class MetricsFactory {

    @Singleton
    MeterFilter addCommonTags(@Value("${micronaut.application.name}") String name) {
        return MeterFilter.commonTags(Collections.singletonList(Tag.of("application", name)));
    }
}