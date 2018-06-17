package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class CommandXX extends AbstractCommand {

	public CommandXX(int line, String[] args) {
		super(line, args);
	}

	@Override
	protected String getCommandName() {
		return "XX";
	}

	@Override
	protected void check(String[] args) {
		// ��1������0��1���Ɖ��肷��
		if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
			super.addCheckError(1, ResultCode.PCON_E_002);
		}
		// ��2������2��3���Ɖ��肷��
		if (args.length < 2 || (!args[1].equals("2") && !args[1].equals("3"))) {
			super.addCheckError(2, ResultCode.PCON_E_003);
		}
	}

	@Override
	protected Result eval(String[] args) {
		return super.success("XX�R�}���h�����s���܂���");
	}

}
