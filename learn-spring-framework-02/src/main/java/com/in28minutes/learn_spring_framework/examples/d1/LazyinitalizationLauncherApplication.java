package com.in28minutes.learn_spring_framework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component
class ClassA {
	
} 

@Component
@Lazy
class ClassB {
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		//Logic
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Some");
	}
	
}

@Configuration
@ComponentScan
public class LazyinitalizationLauncherApplication {


	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext
					(LazyinitalizationLauncherApplication.class)) {

			System.out.println("Initialization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
			
		}
		
	}

}
