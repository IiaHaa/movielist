package s22.movielist2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import s22.movielist2.service.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http.authorizeRequests(auth -> {
			auth.antMatchers("/main/**").permitAll();
			auth.antMatchers("/editmovie/**").hasAuthority("ADMIN");
			auth.antMatchers("/addmovie/**").hasAuthority("ADMIN");
			auth.anyRequest().authenticated();
		})
				
				// tells where to go after successful login
				.formLogin().defaultSuccessUrl("/listmovies", true).and()
				// logout is permitted for all users
				.logout().permitAll().and()
				.httpBasic(Customizer.withDefaults()).build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}