package jp.co.unirita.procon.command;

import jp.co.unirita.procon.core.Result;
import jp.co.unirita.procon.exception.CommandExecException;

public interface Command {
	public Result execute(String[] args) throws CommandExecException;
}
