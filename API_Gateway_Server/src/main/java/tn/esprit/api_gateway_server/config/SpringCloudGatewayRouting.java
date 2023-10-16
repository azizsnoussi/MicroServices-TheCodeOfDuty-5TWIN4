package tn.esprit.api_gateway_server.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ProjContractServices", r -> r.path("/projects/**", "/contracts/**")
                        .uri("http://localhost:8088/")
                )
                .build();
    }
}
