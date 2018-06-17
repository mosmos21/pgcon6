package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class CommandXX extends AbstractCommand {

	public CommandXX(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "XX";
	}

	@Override
	protected void check(String[] args) {
		// 第1引数が0か1だと仮定する
		if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
			super.addCheckError(1, ResultCode.PCON_E_008);
		}
		// 第2引数が2か3だと仮定する
		if (args.length < 2 || (!args[1].equals("2") && !args[1].equals("3"))) {
			super.addCheckError(2, ResultCode.PCON_E_009);
		}
	}

	@Override
	protected Result eval(String[] args) {
		return super.success("XXコマンドを実行しました");
	}

}
