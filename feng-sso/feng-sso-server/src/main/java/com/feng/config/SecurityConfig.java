package com.feng.config;

/**
 * Created by Administrator on 2018/12/3.
 */
//@Configuration
//@EnableWebSecurity
//@EnableOAuth2Client
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
//        http
//                .cors() // 跨域支持
//                .and()
//                .antMatcher("/**") // 捕捉所有路由
//                .authorizeRequests()
//                .antMatchers("/oauth/**","/login/**", "/logout").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .logout().logoutSuccessUrl("/");
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
////        super.configure(web);
//        web.ignoring().antMatchers("/assets/**");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
////        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//        auth.authenticationProvider(authProvider());
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public FilterRegistrationBean oauth2ClientFilterRegistration(
//            OAuth2ClientContextFilter filter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(filter);
//        registration.setOrder(-100);
//        return registration;
//    }
//
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//
//}
