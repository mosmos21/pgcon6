package jp.co.unirita.procon.result.error;

import jp.co.unirita.procon.result.Result;

public class ArgumentError extends Result {

	private int argOrdinal;
	
	public ArgumentError(int row, int argOrdinal, String command, int resultCode) {
		super(row, command, resultCode);
		this.argOrdinal = argOrdinal;
	}

	@Override
	public String getHeader() {
		return String.format("%s ‘æ%dƒpƒ‰ƒ[ƒ^", super.getHeader(), argOrdinal);
	}
}
