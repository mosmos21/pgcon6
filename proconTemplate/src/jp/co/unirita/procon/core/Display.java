package jp.co.unirita.procon.core;

import jp.co.unirita.procon.result.Result;

public class Display {
	
	public static void printResult(Result result) {
		if(result.isSuccess()) {
			printSuccessMessage(result);
		} else {
			printErrorMessage(result);
		}
	}

	private static void printErrorMessage(Result result) {
		System.out.printf("ERR%03d [%s] %s\n", result.getResultCode(), result.getHeader(), result.getBody());
	}

	private static void printSuccessMessage(Result result) {
		System.out.printf("OK [%s] %s\n", result.getHeader(), result.getBody());
	}

	public static void printMessage(String message) {
		System.out.println("[MESSAGE] " + message);
	}
}
