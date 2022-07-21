package com.aristos_propiedades.aristos_propiedades;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.aristos_propiedades.aristos_propiedades.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class AristosConfig extends WebSecurityConfigurerAdapter  {
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }
    //Realiza la encriptacion de la contraseña
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider aProvider = new DaoAuthenticationProvider();
        aProvider.setUserDetailsService((userDetailsService()));
        aProvider.setPasswordEncoder(passwordEncoder());

        return aProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }
    //Permite la configuracion de los permisos de seguridad del sistema
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .antMatchers("/", "/index","/assets/{filename:.+}").permitAll()
        .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
        .and()
            .logout()
            .permitAll();
        http.cors().and().csrf().disable();
    }
}
