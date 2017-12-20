/*package com.atul.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.httpBasic().and()
			.authorizeRequests()
				.antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
				.anyRequest().authenticated()
				.and()
			.csrf().disable();
				//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		// @formatter:on
	
		
		  http.
	        authorizeRequests().
	        // antMatchers("/api/**").      // if you want a more explicit mapping here
	        // regexMatchers("^/login.*").  // use regular expression to match request path
	        anyRequest().
	        authenticated().
	        and().
	        httpBasic().and().
	        sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
	        csrf().disable();
	
	
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
	
	

}
*/
package com.atul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.atul.security.RESTAuthenticationSuccessHandler;



@Configuration
@EnableWebSecurity
@ComponentScan({"com.atul.security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
	
    @Autowired
    private UserDetailsService userDetailsService;
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
	        .authorizeRequests()
	        .antMatchers(HttpMethod.OPTIONS,"/*").permitAll()
	        .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().successHandler(authenticationSuccessHandler)
	        .and()
	        .csrf().disable();
	        //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}*/
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
	        .authorizeRequests()
	        .antMatchers(HttpMethod.OPTIONS,"/*").permitAll()
	        .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic()
	        .and()
	        .csrf().disable();
	        //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	

	/*@Autowired
	public void configureGlobalAuth(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("atul").password("atul").roles("USER");		 
	}*/

	 @Autowired
	 public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	 }
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}
	*/
}

