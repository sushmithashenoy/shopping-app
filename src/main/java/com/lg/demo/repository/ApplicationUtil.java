package com.lg.demo.repository;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * Class for utility methods
 */
@Component
public class ApplicationUtil {
	
	/**
	 * returns a randomNumber in the defined range (minimun and maximum)
	 * @param min
	 * @param max
	 * @return
	 */
	int randomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

}
