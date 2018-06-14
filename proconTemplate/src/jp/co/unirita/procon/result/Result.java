package jp.co.unirita.procon.result;

public class Result {

	private int row;
	private String command;
	private int resultCode;
	private String message;

	public Result(int row, String command, int resultCode) {
		this(row, command, resultCode, ResultUtil.getResultMessage(resultCode));
	}

	public Result(int row, String command, int resultCode, String message) {
		this.row = row;
		this.command = command;
		this.resultCode = resultCode;
		this.message = message;
	}

	public boolean isSuccess() {
		return this.resultCode == ResultCode.PCON_I_000;
	}

	public String getCommandName() {
		return this.command;
	}

	public int getResultCode() {
		return this.resultCode;
	}

	public String getHeader() {
		return row + "çsñ⁄";
	}

	public String getBody() {
		return message;
	}
}
