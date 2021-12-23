package javaBasic;

import org.testng.annotations.Test;

public class Topic_09_Break_Continue {
	
	@Test
	public void TC_01_Continue() {
		String[] browserName = {"chrome", "firefox", "edge", "ie", "coc coc", "safari"};
		
		for (String browser : browserName) {
			if (browser.equals("ie")) {
				continue;
			}
			System.out.println(browser);
		}
	}
	
	@Test
	public void TC_02_Break() {
		String[] browserName = {"chrome", "firefox", "edge", "ie", "coc coc", "safari"};
		
		for (String browser: browserName) {
			if(browser.equals("coc coc")) {
				break;
			}
			
			System.out.println(browser);
		}
	}

}
