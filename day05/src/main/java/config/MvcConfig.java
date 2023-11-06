package config;

import commons.Utils;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@Import(DbConfig.class)
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(memberOnlyInterceptor())
                .addPathPatterns("/mypage/**");     //마이페이지에 접근 못하게 하는거
        registry.addInterceptor(commonInterceptor())
                .addPathPatterns(("/**"));

    }

    @Bean
    public CommonInterceptor commonInterceptor (){
        return new CommonInterceptor();


    }


    @Bean
    public MemberOnlyInterceptor memberOnlyInterceptor (){
        return new MemberOnlyInterceptor();      //마이페이지

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");

        registry.addViewController("/mypage/**")
                .setViewName("member/mypage");
    }

    @Autowired
    private ApplicationContext ctx ;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(ctx);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false); //변경사항있을때 바로 바뀔수 있게 해주는거
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);  //EL식도 번역가능하게 해준다
        templateEngine.addDialect(new Java8TimeDialect()); //
        templateEngine.addDialect(new LayoutDialect()); //
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setContentType("text/html");  // 알아서 헤더에 page 추가해줌 jsp
        resolver.setCharacterEncoding("utf-8"); // 알아서 UTF도 추가해줌 jsp
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {  //다 적용이 된다~~
        registry.viewResolver(thymeleafViewResolver());
    }

    @Bean
    public MessageSource messageSource (){
        ResourceBundleMessageSource ms =new ResourceBundleMessageSource();

        ms.setBasenames("messages.commons");
        ms.setDefaultEncoding("UTF-8");

        return ms;
    }
    @Bean
    public Utils utils(){
        return new Utils();
    }



 }

