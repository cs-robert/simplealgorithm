package com.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAsynTreadXunlei {
	public static void main(String argv[]) {
		
		AtomicInteger synObj = new AtomicInteger(0);
		
		TestPrint a = new TestPrint(synObj, "A", 0);
		TestPrint b = new TestPrint(synObj, "B", 1);
		TestPrint c = new TestPrint(synObj, "C", 2);
		
		a.start();
		b.start();
		c.start();
	}
}

class TestPrint extends Thread {
	
	private AtomicInteger synObj;
	private String name;
	private int flag;
	
	private int count = 0;
	
	public TestPrint(AtomicInteger synObj, String name, int flag) {
		this.synObj = synObj;
		this.name = name;
		this.flag = flag;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (synObj) {
				if (synObj.get() % 3 == flag) {
					synObj.set(synObj.get() + 1);
					System.out.println(name+synObj.get());
					count++;
					synObj.notifyAll();
					if (count == 10) {
						break;
					}
				} else {
					try {
						synObj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}