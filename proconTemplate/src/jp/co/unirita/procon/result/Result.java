package jp.co.unirita.procon.result;

public class Result {

	private int line;
	private String command;
	private int resultCode;
	private String message;

	public Result(int line, String command, int resultCode) {
		this(line, command, resultCode, ResultUtil.getResultMessage(resultCode));
	}

	public Result(int line, String command, int resultCode, String message) {
		this.line = line;
		this.command = command;
		this.resultCode = resultCode;
		this.message = message;
	}

	public boolean isSuccess() {
		return this.resultCode == ResultCode.PCON_I_000;
	}

	public int getLine() {
		return this.line;
	}

	public String getCommand() {
		return this.command;
	}

	public int getResultCode() {
		return this.resultCode;
	}

	public String getMessage() {
		return this.message;
	}
}
