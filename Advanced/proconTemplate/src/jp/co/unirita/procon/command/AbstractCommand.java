package jp.co.unirita.procon.command;

import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.core.Result;
import jp.co.unirita.procon.exception.CommandExecException;

public abstract class AbstractCommand implements Command {

	private final int row;
	private String commandLine;

	public AbstractCommand(int row) {
		this.row = row;
		commandLine = this.getCommandName();
	}

	@Override
	public Result execute(String[] args) throws CommandExecException {
		commandLine += " " + String.join(" ", args);
		int subCode = this.check(args);
		if (0 < subCode) {
			throw new CommandExecException(new Result(this.row, this.getCommandName(), this.getCommandNumber(), subCode, commandLine));
		}
		Result evalResult = this.eval(args);
		if (evalResult != null && !evalResult.isSuccess()) {
			throw new CommandExecException(evalResult);
		}
		return evalResult;
	}

	protected Result success() {
		return new Result(this.row, this.getCommandName(), 0, 0);
	}

	protected Result success(String message) {
		return new Result(this.row, this.getCommandName(), this.getCommandNumber(), 0, message);
	}
	
	protected boolean checkArgIdx(String[] args, int ordinal) {
		int digit = String.valueOf(Memory.list.size()).length();
		if(args.length < ordinal) {
			return false;
		}
		if(digit < args[ordinal].length()) {
			return false;
		}
		long value = Long.parseLong(args[ordinal]);
		return 0 <= value && value < Memory.list.size();
	}
	
	protected boolean checkArgValue(String[] args, int ordinal) {
		if(args.length < ordinal) {
			return false;
		}
		if(2 < args[ordinal].length()) {
			return false;
		}
		long value = Long.parseLong(args[ordinal]);
		return 0 <= value && value <= 99;
	}

	protected abstract String getCommandName();
	
	protected abstract int getCommandNumber();

	protected abstract int check(String[] args);

	protected abstract Result eval(String[] args);
}
