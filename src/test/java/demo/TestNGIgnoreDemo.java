package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class TestNGIgnoreDemo {

	@Test
	public void test1() {
		System.out.println("Im inside test 1");

	}
	@Test
	public void test2() {
		System.out.println("Im inside test 2");

	}
}
