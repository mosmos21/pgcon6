package jp.co.unirita.procon.command;

import java.util.ArrayList;
import java.util.List;

import jp.co.unirita.procon.exception.AssebleException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public abstract class Command {
	
	private final int line;
	private List<Result> errorResultList;
	
	public Command(int line) {
		this.line = line;
		this.errorResultList = new ArrayList<>();
	}
	
	public int getLine() {
		return this.line;
	}
	
	public Result execute(String args[]) throws AssebleException {
		this.check(args);
		if(0 < errorResultList.size()) {
			throw new AssebleException(errorResultList);
		}
		return this.eval(args);
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
		return errorResultList.size() == 0;
	}
	
	public int getErrorResultSize() {
		return this.errorResultList.size();
	}
	
	public void addErrorResult(int resultCode) {
		errorResultList.add(new Result(this.line, this.getCommandString(), resultCode));
	}
	
	public abstract String getCommandString();
	public abstract void check(String[] args);
	public abstract Result eval(String[] args) throws AssebleException;
}
