package javaOOP.knowledge;

import org.openqa.selenium.WebDriver;

public abstract class Topic_03_Abstract_Class_Method {
	
	// This is a template to other inheritant classes implement its methods
	// and abstract is a non access modifier
	public abstract String getBrowserName();
	public abstract WebDriver getBrowserDriver(String browserName);
}
