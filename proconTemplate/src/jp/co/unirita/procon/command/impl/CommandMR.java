package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.core.Result;

public class CommandMR extends AbstractCommand {

	public CommandMR(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "mr";
	}
	
	@Override
	protected int getCommandNumber() {
		return 5;
	}

	@Override
	protected int check(String[] args) {
		int subCode = 0;
		if(!super.checkArgIdx(args, 0)) {
			subCode |= 1;
		}
		if(!super.checkArgIdx(args, 1)) {
			subCode |= 2;
		}
		return subCode;
	}

	@Override
	protected Result eval(String[] args) {
		long arg1 = Long.parseLong(args[0]);
		long arg2 = Long.parseLong(args[1]);
		Memory.list.remove(Math.min(arg1, arg2), Math.max(arg1, arg2));
		return null;
	}

}
