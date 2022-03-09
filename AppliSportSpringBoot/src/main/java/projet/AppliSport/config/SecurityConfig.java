package projet.AppliSport.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {


		// @formatter:off
		http.antMatcher("/**")
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
			.antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
			.antMatchers(HttpMethod.GET ,"/api/user/**").hasAnyAuthority("Utilisateur","Admin", "Club")
			.antMatchers("/api/user/**").hasAnyAuthority("Utilisateur","Admin")
			.antMatchers(HttpMethod.GET ,"/api/sport/**").hasAnyAuthority("Utilisateur","Admin", "Club")
			.antMatchers("/api/sport/**").hasAnyAuthority("Admin")
			.antMatchers(HttpMethod.GET ,"/api/profil/**").hasAnyAuthority("Utilisateur","Admin", "Club")
			.antMatchers("/api/profil/**").hasAnyAuthority("Utilisateur","Admin")
			.antMatchers(HttpMethod.GET ,"/api/interet/**").hasAnyAuthority("Utilisateur","Admin", "Club")
			.antMatchers("/api/interet/**").hasAnyAuthority("Utilisateur","Admin")
			.antMatchers("/api/evenement-utilisateur/**").hasAnyAuthority("Utilisateur", "Admin", "Club")
			.antMatchers(HttpMethod.GET ,"/api/evenement/**").hasAnyAuthority("Utilisateur", "Admin", "Club")
			.antMatchers("/api/evenement/**").hasAnyAuthority("Admin", "Club")
			.antMatchers("/api/equipe-utilisateur/**").hasAnyAuthority("Utilisateur", "Admin", "Club")
			.antMatchers(HttpMethod.GET ,"/api/equipe/**").hasAnyAuthority("Utilisateur", "Admin", "Club")
			.antMatchers("/api/equipe/**").hasAnyAuthority("Admin", "Club")
			.antMatchers("/api/club-utilisateur/**").hasAnyAuthority("Utilisateur", "Admin", "Club")
			.antMatchers(HttpMethod.GET ,"/api/club/**").hasAnyAuthority("Utilisateur","Admin", "Club")
			.antMatchers("/api/club/**").hasAnyAuthority("Admin", "Club")
			.antMatchers(HttpMethod.GET ,"/api/caracteristique/**").hasAnyAuthority("Utilisateur","Admin", "Club")
			.antMatchers("/api/caracteristique/**").hasAnyAuthority("Utilisateur", "Admin")
			.antMatchers("/api/auth/**").permitAll()
			.antMatchers("/api/compte/**").permitAll()
			.anyRequest().authenticated()
		.and()
			.httpBasic();
	
		// @formatter:on

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// @formatter:off
		auth.userDetailsService(userDetailsService);

		// @formatter:on

	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
