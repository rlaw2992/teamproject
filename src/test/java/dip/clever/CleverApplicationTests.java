package dip.clever;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dip.clever.web.Option;

@SpringBootTest
class CleverApplicationTests {

	@Test
	void option() {
		Option opt = new Option();
		System.out.println(opt.name);
	}
}
