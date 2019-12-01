package lukuvinkkikirjasto;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
  
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    //All cors-requests allowed at the moment. Could be restricted
    //to just frontend address.
    registry.addMapping("/**");
  }
}