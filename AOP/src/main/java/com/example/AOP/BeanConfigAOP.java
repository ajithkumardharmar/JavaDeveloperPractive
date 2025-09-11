package com.example.AOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAspectJAutoProxy
@EnableScheduling
@ComponentScan(basePackages = "com.example")
public class BeanConfigAOP {
	
	@Bean(initMethod = "init",destroyMethod = "cleanup"  )
	public BS6Engine bs6Engine() {
		return new BS6Engine("default");
	}
	
	
//	@Bean Bean name: petrolEngine
//	public BS6Engine petrolEngine() {
//		return new BS6Engine("petrol");
//	}
	/* Bean used  bean name define to call or component use to bean name set then call*/
//	@Primary
//	@Bean        //Bean name: dieselEngine
//	public BS6Engine dieselEngine() {
//		return new BS6Engine("diesel");
//	}

}
