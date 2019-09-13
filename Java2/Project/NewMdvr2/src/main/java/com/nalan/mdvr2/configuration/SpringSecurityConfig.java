package com.nalan.mdvr2.configuration;


import com.nalan.mdvr2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置忽略的静态文件
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()//使用默认登录验证
        // 配置对根路径放行，其他请求拦截，对logout放行，允许表单校验，禁用CSRF
/*        http.authorizeRequests()//对请求授权
                .antMatchers("/").permitAll()
                .anyRequest()//任何请求
                .authenticated()//都需要身份认证
                .and().logout().permitAll()
                .and().formLogin();//表单登录*/
/*        http.formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/login.html")
                .permitAll()
                .anyRequest()
                .authenticated();*/
//        http.formLogin().loginPage("/login.html");
//        http.csrf().disable();
        http
                .authorizeRequests()
//                    .antMatchers("/login*").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/error/logError")
                    .permitAll();
    }


}
