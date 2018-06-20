package jp.co.unirita.procon.result;

public class Result {

	private int row;
	private String command;
	private int commandNumber;
	private int subCode;
	private String result;

	public Result(int row, String command, int commandNumber, int subCode) {
		this(row, command, commandNumber, subCode, "");
	}

	public Result(int row, String command, int commandNumber, int subCode, String result) {
		this.row = row;
		this.command = command;
		this.commandNumber = commandNumber;
		this.subCode = subCode;
		this.result = result;
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

	public int getCommandNumber() {
		return this.commandNumber;
	}
	
	public int getSubCode() {
		return this.subCode;
	}

	public String getResult() {
		return this.result;
	}
}
