package jp.co.unirita.procon.command;

import java.util.ArrayList;
import java.util.List;

import jp.co.unirita.procon.exception.CommandExecException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;
import jp.co.unirita.procon.result.error.ArgumentError;
import jp.co.unirita.procon.result.error.CommandError;
import jp.co.unirita.procon.result.error.EvalError;

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
		return new Result(this.row, this.getCommandName(), ResultCode.PCON_I_000);
	}

	protected Result success(String message) {
		return new Result(this.row, this.getCommandName(), ResultCode.PCON_I_000, message);
	}

	protected Result error() {
		return new CommandError(this.row, this.getCommandName(), ResultCode.PCON_E_001);
	}

	protected void addCheckError(int argOrdinal, int resultCode) {
		checkErrorResultList.add(new ArgumentError(this.row, argOrdinal, this.getCommandName(), resultCode));
	}

	protected void addEvalError(int resultCode) {
		evalErrorResultList.add(new EvalError(this.row, this.getCommandName(), resultCode));
	}

	protected abstract String getCommandName();

	protected abstract void check(String[] args);

	protected abstract Result eval(String[] args);
}
