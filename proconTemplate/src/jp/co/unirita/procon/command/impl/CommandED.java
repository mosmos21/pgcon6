package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.cache.CommandLogCache;
import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.core.Listner;
import jp.co.unirita.procon.exception.AssebleException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class CommandED extends Command {
	
	public CommandED(Listner listner, int line) {
		super(listner, line);
	}

	@Override
	public String getCommandString() {
		return "ED";
	}

	@Override
	public Result check(String[] args) throws AssebleException {
		if(CommandLogCache.getLastEvalLine("ST") == -1) {
			throw new AssebleException(super.error(ResultCode.PCON_E_004));
		}
		return super.success();
	}

	@Override
	public Result eval(String[] args) throws AssebleException {
		System.out.println("EDコマンドを実行したよ！");
		return super.success();
	}

}
