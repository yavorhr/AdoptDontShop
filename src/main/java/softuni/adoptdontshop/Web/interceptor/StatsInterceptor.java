package softuni.adoptdontshop.Web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import softuni.adoptdontshop.Service.StatsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class StatsInterceptor implements HandlerInterceptor {

    private final StatsService statsService;

    public StatsInterceptor(StatsService statsService) {
        this.statsService = statsService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        statsService.onRequest();
        return true;
    }
}
