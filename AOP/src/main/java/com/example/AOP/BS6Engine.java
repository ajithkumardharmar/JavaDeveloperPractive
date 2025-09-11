package com.example.AOP;



public class BS6Engine {
		private String engineType ;
	    public BS6Engine(String engineType) {
	    	this.engineType = engineType;
	        System.out.println("⚙️ BS6Engine Object Created..."+engineType);
	    }

	    public void init() {
	        System.out.println("✅ BS6Engine is ready to use...");
	    }

	    public void cleanup() {
	        System.out.println("❌ BS6Engine is shutting down...");
	    }
	    
	    public void start() {
	        System.out.println("🔧 " + engineType + " Engine started...");
	    }

}
