package jp.co.unirita.procon.command;

import java.util.ArrayList;
import java.util.List;


import jp.co.unirita.procon.exception.CommandExecException;
import jp.co.unirita.procon.result.Result;

public abstract class AbstractCommand implements Command {

	private final int row;
	private List<Result> checkErrorResultList;
	private List<Result> evalErrorResultList;

	public AbstractCommand(int row) {
		this.row = row;
		this.checkErrorResultList = new ArrayList<>();
		this.evalErrorResultList = new ArrayList<>();
	}

	@Override
	public Result execute(String[] args) throws CommandExecException {
//		System.out.println(Arrays.toString(args));
		this.check(args);
		if (0 < checkErrorResultList.size()) {
			throw new CommandExecException(checkErrorResultList);
		}
		Result evalResult = this.eval(args);
		if (evalResult != null && !evalResult.isSuccess()) {
			throw new CommandExecException(evalErrorResultList);
		}
		return evalResult;
	}

	protected Result success() {
		return new Result(this.row, this.getCommandName(), 0, 0);
	}

	protected Result success(String message) {
		return new Result(this.row, this.getCommandName(), this.getCommandCode(), 0, message);
	}

	protected Result error(int subCode, String message) {
		return new Result(this.row, this.getCommandName(), this.getCommandCode(), subCode, message);
	}

	protected void addCheckError(int subCode, String message) {
		checkErrorResultList.add(new Result(this.row, this.getCommandName(), this.getCommandCode(), subCode, message));
	}

	protected void addEvalError(int subcode, String message) {
		evalErrorResultList.add(new Result(this.row, this.getCommandName(), this.getCommandCode(), subcode, message));
	}

	protected abstract String getCommandName();
	
	protected abstract int getCommandCode();

	protected abstract void check(String[] args);

	protected abstract Result eval(String[] args);
}
