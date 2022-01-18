package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {

	@Test(dependsOnGroups="sanity1")
	public void test1() {
		System.out.println("Im inside test 1");
	}
	
	@Test(groups="sanity1")
	public void test2() {
		System.out.println("Im inside test 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Im inside test 3");
	}
}
