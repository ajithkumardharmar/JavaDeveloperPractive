package com.example.SpringFrameworkDemo;
//just test for singleton  not for spring
public class SingletonExample {
	
	private static SingletonExample singletonExample = null;
	
	private SingletonExample() {
		
	}
	
	public static synchronized SingletonExample getInstance() {
		if(singletonExample==null) {
			singletonExample = new SingletonExample();
		}
		return singletonExample;
	}
	
	public static void  getInfo() {
		System.out.println(" Singleton Object is running");
	}

}
