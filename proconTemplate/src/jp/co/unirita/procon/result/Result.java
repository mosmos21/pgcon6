package jp.co.unirita.procon.result;

public class Result {

	private int row;
	private String command;
	private int resultCode;
	private int subCode;
	private String message;

	public Result(int row, String command, int resultCode, int subCode) {
		this(row, command, resultCode, subCode, "");
	}

	public Result(int row, String command, int resultCode, int subCode, String message) {
		this.row = row;
		this.command = command;
		this.resultCode = resultCode;
		this.subCode = subCode;
		this.message = message;
	}

	public boolean isSuccess() {
		return this.subCode == 0;
	}
	
	public int getRow() {
		return this.row;
	}

	public String getCommandName() {
		return this.command;
	}

	public int getResultCode() {
		return this.resultCode;
	}
	
	public int getSubCode() {
		return this.subCode;
	}

	public String getMessage() {
		return this.message;
	}
}
