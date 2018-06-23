package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.core.Result;

public class CommandSS extends AbstractCommand {

	public CommandSS(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "ss";
	}

	@Override
	protected int getCommandNumber() {
		return 1;
	}

	@Override
	protected int check(String[] args) {
		int subCode = 0;
		if (!super.checkArgIdx(args, 0)) {
			subCode |= 1;
		}

		if (!checkArgValue(args, 1)) {
			subCode |= 2;
		}
		return subCode;
	}

	@Override
	protected Result eval(String[] args) {
		Memory.list.add(Long.parseLong(args[0]), Integer.parseInt(args[1]));
		return null;
	}

}
