package jp.co.unirita.procon.exception;

import jp.co.unirita.procon.core.Result;

public class CommandExecException extends Exception {

	private static final long serialVersionUID = 1L;
	Result result;

	public CommandExecException(Result result) {
		this.result = result;
	}

	public Result getResult () {
		return this.result;
	}
}
