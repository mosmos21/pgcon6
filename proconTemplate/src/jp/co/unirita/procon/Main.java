package jp.co.unirita.procon;

import jp.co.unirita.procon.core.Assembler;

public class Main {
	public static void main(String[] args) {
		long time = Assembler.run(System.in);
		System.err.print("ÀsŠÔ: " + time + " ms");
	}
}
