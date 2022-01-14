package javaOOP.knowledge;

import lombok.Getter;
import lombok.Setter;

/**
 * To using Lombok library, first we need to dowload jar file on maven repository
 * Then, we need to install plugin to Eclipse by double click to jar file and specify location of eclipse .exe
 * or we can use command line with "java -jar lombok-1.18.12.jar"
 * @author Hieu Nguyen
 *
 */
@Setter
@Getter
public class Topic_08_Getter_Setter_Lombok {
	private String playerName;
	private int playerAge;
	private long playerAmountAccount;
	private int playerPhoneNumber;
	private String carName;

	public void showPlayerInfo() {
		System.out.println(getPlayerName());
		System.out.println(getPlayerAge());
		System.out.println(getPlayerAmountAccount());
		System.out.println(getPlayerPhoneNumber());
	}
}
