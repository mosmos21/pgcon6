package jp.co.unirita.procon.command;

import java.util.ArrayList;
import java.util.List;

import jp.co.unirita.procon.exception.CommandExecException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public abstract class AbstractCommand implements Command {

	private final int line;
	private List<Result> checkErrorResultList;
	private List<Result> evalErrorResultList;

	public AbstractCommand(int line) {
		this.line = line;
		this.checkErrorResultList = new ArrayList<>();
		this.evalErrorResultList = new ArrayList<>();
	}

	@Override
	public Result execute(String args[]) throws CommandExecException {
		this.check(args);
		if (0 < checkErrorResultList.size()) {
			throw new CommandExecException(checkErrorResultList);
		}
		Result evalResult = this.eval(args);
		if (!evalResult.isSuccess()) {
			throw new CommandExecException(evalErrorResultList);
		}
		return evalResult;
	}

	protected Result success() {
		return new Result(this.line, this.getCommandString(), ResultCode.PCON_I_000);
	}

	protected Result success(String message) {
		return new Result(this.line, this.getCommandString(), ResultCode.PCON_I_000, message);
	}

	protected Result error() {
		return new Result(this.line, this.getCommandString(), ResultCode.PCON_E_001);
	}

	protected void addCheckError(int resultCode) {
		checkErrorResultList.add(new Result(this.line, this.getCommandString(), resultCode));
	}

	protected void addEvalError(int resultCode) {
		evalErrorResultList.add(new Result(this.line, this.getCommandString(), resultCode));
	}

	protected abstract String getCommandString();

	protected abstract void check(String[] args);

	protected abstract Result eval(String[] args);
}
