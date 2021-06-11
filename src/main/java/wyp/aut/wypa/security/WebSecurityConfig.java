package wyp.aut.wypa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import wyp.aut.wypa.security.services.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    private UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http.authorizeRequests()
                .antMatchers("/employeePanel").hasAnyAuthority("ROLE_EMPLOYEE")
                .antMatchers("/adminPanel").hasAnyAuthority("ROLE_USER")
                .antMatchers("/clientPanel").hasAnyAuthority("ROLE_USER")
                .and()
                .formLogin();
       /* http.authorizeRequests()
              .antMatchers("/adminPanel").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/adminPanel/**").hasAnyAuthority("ROLE_ADMIN")
                .and()
                .formLogin();*/
    }
}
