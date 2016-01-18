package xyz.hollysys.spring.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import xyz.hollysys.spring.async.config.AppConfig;
import xyz.hollysys.spring.async.model.User;
import xyz.hollysys.spring.async.service.GitHubLookupService;

public class AppMain {
	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		GitHubLookupService service = (GitHubLookupService) context.getBean("gitHubLookupService");
		
		try {
			Future<User> user  = service.findUser("njkfei");
			System.out.println(user.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}