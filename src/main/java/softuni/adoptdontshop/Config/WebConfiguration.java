package softuni.adoptdontshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import softuni.adoptdontshop.Web.interceptor.StatsInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final StatsInterceptor statsInterceptor;
    private final LocaleChangeInterceptor changeInterceptor;

    public WebConfiguration(StatsInterceptor statsInterceptor, LocaleChangeInterceptor changeInterceptor) {
        this.statsInterceptor = statsInterceptor;
        this.changeInterceptor = changeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statsInterceptor);
        registry.addInterceptor(changeInterceptor);
    }


}
