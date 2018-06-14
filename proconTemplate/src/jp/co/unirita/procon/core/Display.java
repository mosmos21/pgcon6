package jp.co.unirita.procon.core;

public class Display {

	public static void printErrorMessage(int resultCode, String header, String body) {
		System.out.printf("ERR%03d [%s] %s\n", resultCode, header, body);
	}

	public static void printSuccessMessage(String header, String body) {
		System.out.printf("OK [%s] %s\n", header, body);
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
