package vod.config;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class VodConfig {

    @Bean
    String foo(){return new String("bar");}
}
