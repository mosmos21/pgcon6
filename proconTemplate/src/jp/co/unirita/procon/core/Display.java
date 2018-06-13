package jp.co.unirita.procon.core;

import jp.co.unirita.procon.result.ResultUtil;

public class Display {

	public static void printErrorMessage(int resultCode, int line) {
		printErrorMessage(resultCode, line, ResultUtil.getResultMessage(resultCode));
	}

	public static void printErrorMessage(int resultCode, int line, String message) {
		System.out.printf("ERR%03d %3ds–Ú: %s\n", resultCode, line, message);
	}

	public static void printSuccessMessage(int line, String message) {
		System.out.printf("OK %3ds–Ú: %s\n", line, message);
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
