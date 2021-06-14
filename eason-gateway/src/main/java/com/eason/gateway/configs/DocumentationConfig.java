//package com.eason.gateway.configs;
//
//import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author colin
// */
//@Configuration
//@Primary
//public class DocumentationConfig implements SwaggerResourcesProvider {
//    private final RouteLocator routeLocator;
//
//    public DocumentationConfig(RouteLocator routeLocator) {
//        this.routeLocator = routeLocator;
//    }
//
//    @Override
//    public List<SwaggerResource> get() {
//        return routeLocator.getRoutes().stream().map(route ->
//                swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "1.0"))
//                .collect(Collectors.toList());
//
////        return asList(
////                swaggerResource("Base接口","/base/v2/api-docs", "1.0"),
////                swaggerResource("Management接口","/management/v2/api-docs", "1.0")
////        );
//    }
//
//    private SwaggerResource swaggerResource(String name, String location, String version) {
//        SwaggerResource swaggerResource = new SwaggerResource();
//        swaggerResource.setName(name);
//        swaggerResource.setLocation(location);
//        swaggerResource.setSwaggerVersion(version);
//
//        return swaggerResource;
//    }
//}
