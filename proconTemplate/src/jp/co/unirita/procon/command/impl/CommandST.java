package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class CommandST extends AbstractCommand {

	public CommandST(int line, String[] args) {
		super(line, args);
	}

	@Override
	protected String getCommandName() {
		return "ST";
	}

	@Override
	protected void check(String[] args) {
		// ��������0��1���Ɖ��肷��
		if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
			super.addCheckError(1, ResultCode.PCON_E_002);
		}
	}

	@Override
	protected Result eval(String[] args) {
		return super.success("ST�R�}���h�����s���܂���");
	}

}
