package appliSport;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import AppliSport.app.AppSpring;
import AppliSport.config.AppConfig;


public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
		
	}

}
