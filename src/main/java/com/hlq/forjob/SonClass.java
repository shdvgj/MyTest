package com.hlq.forjob;

public class SonClass extends FatherClass{
	
	public SonClass(int i) {
		super(1);
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		SonClass sonClass = new SonClass(1);
	}
}
