package jp.co.unirita.procon.core;

import jp.co.unirita.procon.result.Result;

public class Display {
	
	public static void printResult(Result result) {
		if(result == null) {
			return;
		}
		if(result.isSuccess()) {
			printSuccessMessage(result);
		} else {
			printErrorMessage(result);
		}
	}

	private static void printErrorMessage(Result result) {
		System.out.printf("L%04d E%02d%02d %s\n", result.getRow(), result.getResultCode(), result.getSubCode(), result.getMessage());
	}

	private static void printSuccessMessage(Result result) {
		System.out.printf("L%04d I%02d%02d %s\n", result.getRow(), result.getResultCode(), result.getSubCode(), result.getMessage());
	}

	public static void printMessage(String message) {
		System.out.println("[MESSAGE] " + message);
	}
}
