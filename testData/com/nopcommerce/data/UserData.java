package com.nopcommerce.data;

import utilities.DataUtil;

public class UserData {

	public static class Register {
		private static DataUtil data = DataUtil.getDataUtil();
		public static String firstName = data.getFirstName();
		public static String lastName = data.getLastName();
		public static String emailAddress = data.getEmailAddress();
		public static String password = data.getPassword();
	}

	public static class Login {

	}

	public static class Address {

	}

	public static class MyAccount {

	}

	public static class Invoice {

	}

}
