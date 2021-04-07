package com.seminario.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/oauth/token", "/oauth/autorize**", "/publica").permitAll()
            .antMatchers(HttpMethod.GET, "/api/articulo/**","/api/tipo-articulo/**","/api/proveedor/**").permitAll()
            .antMatchers(HttpMethod.POST, "/api/articulo/**","/api/articulo/**","/api/proveedor/**","/api/persona/**","/api/viaticos/**").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.PUT, "/api/articulo/**","/api/articulo/**","/api/proveedor/**","/api/persona/**","/api/buzon/**","/api/venta/**","/api/viaticos/**").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/api/articulo/**","/api/articulo/**","/api/proveedor/**","/api/persona/**","/api/buzon/**","/api/venta/**","/api/viaticos/**").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.GET, "/api/persona/listar-persona","/api/buzon/list","/api/venta/get-ventas","/api/viaticos/obtener-viaticos").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.POST, "/api/buzon/**").permitAll()
            .antMatchers(HttpMethod.POST, "/api/venta/**").hasAnyAuthority("VENDEDOR","CAJERO")
            .and().authorizeRequests().and().cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
                new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;

    }

}
