package jp.co.unirita.procon.command;

import jp.co.unirita.procon.exception.AssebleException;
import jp.co.unirita.procon.result.Result;

public interface Command {
	public Result execute(String args[]) throws AssebleException;
}
