package jp.co.unirita.procon.command;

import jp.co.unirita.procon.exception.CommandExecException;
import jp.co.unirita.procon.result.Result;

public interface Command {
	public Result execute() throws CommandExecException;
}
