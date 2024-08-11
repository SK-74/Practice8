package com.practice8.service;

import org.springframework.stereotype.Service;

@Service
public class JudgeService {

	public String makeMessage(int val) {
		String message = val + "は、";
		
		boolean result = over100(val);
		if(result) {
			message += "100より大きい数字でした";
		}else {
			message += "100以下の数字でした";
		}
		
		return message;
	}

	private boolean over100(int val) {
		boolean result = false;
		if(val > 100) {
			result = true;
		}
		return result;
	}
}
