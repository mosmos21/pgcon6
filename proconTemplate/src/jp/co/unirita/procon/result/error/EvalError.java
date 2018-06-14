package jp.co.unirita.procon.result.error;

import jp.co.unirita.procon.result.Result;

public class EvalError extends Result{

	public EvalError(int row, String command, int resultCode) {
		super(row, command, resultCode);
	}
}
