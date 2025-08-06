package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
//	@Test(dependsOnMethods = {"test2","test3"})
	@Test(dependsOnGroups = {"sanity.*"})
	public void test1() {
		System.out.println("This is test 1");
	}
	
	@Test(groups = {"sanity1"})
	public void test2() {
		System.out.println("This is test 2");
	}
	
	@Test(groups = {"sanity2"})
	public void test3() {
		System.out.println("This is test 3");
	}


}
