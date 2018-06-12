package jp.co.unirita.procon.command;

import java.util.ArrayList;
import java.util.List;

import jp.co.unirita.procon.exception.AssebleException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public abstract class Command {
	
	private final int line;
	private List<Result> checkErrorResultList;
	private List<Result> evalErrorResultList;
	
	public Command(int line) {
		this.line = line;
		this.checkErrorResultList = new ArrayList<>();
		this.evalErrorResultList = new ArrayList<>();
	}
	
	public int getLine() {
		return this.line;
	}
	
	public Result execute(String args[]) throws AssebleException {
		this.check(args);
		if(0 < checkErrorResultList.size()) {
			throw new AssebleException(checkErrorResultList);
		}
		Result evalResult = this.eval(args);
		if(!evalResult.isSuccess()) {
			throw new AssebleException(evalErrorResultList);
		}
		return evalResult;
	}

	public Result success() {
		return new Result(this.line, this.getCommandString(), ResultCode.PCON_I_000);
	}
	
	public Result success(String message) {
		return new Result(this.line, this.getCommandString(), ResultCode.PCON_I_000, message);
	}
	
	public Result error() {
		return new Result(this.line, this.getCommandString(), ResultCode.PCON_E_001);
	}
	
	public boolean isSuccess() {
		return checkErrorResultList.size() == 0;
	}
	
	public void addCheckError(int resultCode) {
		checkErrorResultList.add(new Result(this.line, this.getCommandString(), resultCode));
	}
	
	public void addEvalError(int resultCode) {
		evalErrorResultList.add(new Result(this.line, this.getCommandString(), resultCode));
	}
	
	public abstract String getCommandString();
	public abstract void check(String[] args);
	public abstract Result eval(String[] args);
}
