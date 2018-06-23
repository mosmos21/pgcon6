package jp.co.unirita.procon.core;

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
		System.out.printf("L%04d E%02d%02d %s\n", result.getRow(), result.getCommandNumber(), result.getSubCode(), result.getResult());
	}

	private static void printSuccessMessage(Result result) {
		System.out.printf("L%04d I%02d%02d %s\n", result.getRow(), result.getCommandNumber(), result.getSubCode(), result.getResult());
	}
}
