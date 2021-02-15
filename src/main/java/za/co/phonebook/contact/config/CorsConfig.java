package za.co.phonebook.contact.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;
@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {


        @Value("#{'${allowed.origins}'.split(',')}")
        private List<String> rawOrigins;

        @Override
        protected void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedOrigins(getOrigin())
                    .allowedMethods("POST", "GET", "OPTIONS")
                    .allowCredentials(false)
                    .maxAge(-1);
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");

            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }

        public String[] getOrigin() {
            int size = rawOrigins.size();
            String[] originArray = new String[size];
            return rawOrigins.toArray(originArray);
        }
}
