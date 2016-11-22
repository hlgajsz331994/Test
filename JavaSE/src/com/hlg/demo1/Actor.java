package com.hlg.demo1;

public class Actor {
	public void start(Person... a){
		for(Person  b:a){
			b.sayHi();
		}
	}
	public Actor(Person... a){
		
	}
}
