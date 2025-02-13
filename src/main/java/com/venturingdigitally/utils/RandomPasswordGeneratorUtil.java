package com.venturingdigitally.utils;

import java.security.SecureRandom;
import com.venturingdigitally.constants.AppConstants;

public class RandomPasswordGeneratorUtil {

	public static String generatePassword() {
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			password.append(AppConstants.RANDOM_STRING.charAt(random.nextInt(AppConstants.RANDOM_STRING.length())));
		}
		return password.toString();
	}

}
