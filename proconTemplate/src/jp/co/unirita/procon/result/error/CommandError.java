package jp.co.unirita.procon.result.error;

import jp.co.unirita.procon.result.Result;

public class CommandError extends Result{

	public CommandError(int row, String command, int resultCode) {
		super(row, command, resultCode);
	}
}
