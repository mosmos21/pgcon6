package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.exception.AssebleException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class CommandST extends Command {

	public CommandST(int line) {
		super(line);
	}
	
	@Override
	public String getCommandString() {
		return "ST";
	}

	@Override
	public Result check(String[] args) {
		// 第一引数が0か1だと仮定する
		if(args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
			super.addErrorResult(ResultCode.PCON_E_002);
		}
		return super.isSuccess() ? super.success() : super.error();
	}
	
	@Override
	public Result eval(String[] args) throws AssebleException {
		return super.success("STコマンドを実行しました");
	}

	

}
