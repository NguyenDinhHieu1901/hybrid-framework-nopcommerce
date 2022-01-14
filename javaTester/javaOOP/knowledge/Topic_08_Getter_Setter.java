package javaOOP.knowledge;

public class Topic_08_Getter_Setter {
	private String playerName;
	private int playerAge;
	private long playerAmountAccount;
	private int playerPhoneNumber;

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		if (playerName == null || playerName.isEmpty() || playerName.isBlank()) {
			throw new IllegalArgumentException("Player name must not empty!");
		}
		this.playerName = playerName;
	}

	public void setPlayerAge(int playerAge) {
		if (playerAge < 15 || playerAge > 70) {
			throw new IllegalArgumentException("Player age is invalid!");
		}
		this.playerAge = playerAge;
	}

	public int getPlayerAge() {
		return playerAge;
	}

	public long getPlayerAmountAccount() {
		return playerAmountAccount;
	}

	public void setPlayerAmountAccount(long playerAmountAccount) {
		if (playerAmountAccount < 0) {
			throw new IllegalArgumentException("Number is invalid!");
		}
		this.playerAmountAccount = playerAmountAccount;
	}

	public int getPlayerPhoneNumber() {
		return playerPhoneNumber;
	}

	public void setPlayerPhoneNumber(int playerPhoneNumber) {
		if (!String.valueOf(playerPhoneNumber).startsWith("1")) {
			throw new IllegalArgumentException("Phone number must be start with 090 - 092 - 039!");
		} else if (String.valueOf(playerPhoneNumber).length() < 10 || String.valueOf(playerPhoneNumber).length() > 11) {
			throw new IllegalArgumentException("Length of phone number must be 10 or 11 digits");
		} else {
			this.playerPhoneNumber = playerPhoneNumber;
		}
	}

	public void showPlayerInfo() {
		System.out.println(getPlayerName());
		System.out.println(getPlayerAge());
		System.out.println(getPlayerAmountAccount());
		System.out.println(getPlayerPhoneNumber());
	}
}
