package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.cache.CommandLogCache;
import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.core.Listner;
import jp.co.unirita.procon.exception.AssebleException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class CommandXX extends Command {
	
	public CommandXX(Listner listner, int line) {
		super(listner, line);
	}
	
	@Override
	public String getCommandString() {
		return "XX";
	}

	@Override
	public Result check(String[] args) throws AssebleException {
		if(CommandLogCache.getLastEvalLine("ST") == -1) {
			throw new AssebleException(super.error(ResultCode.PCON_E_004));
		}
		if(args.length < 2) {
			throw new AssebleException(super.error(ResultCode.PCON_E_001));
		}
		return super.success();
	}

	@Override
	public Result eval(String[] args) throws AssebleException {
		System.out.println("XXコマンドを実行したよ！");
		return super.success();
	}

}
