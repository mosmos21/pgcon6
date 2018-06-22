package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.core.Result;

public class CommandMS extends AbstractCommand {

	public CommandMS(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "ms";
	}
	
	@Override
	protected int getCommandNumber() {
		return 4;
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
		if(!super.checkArgValue(args, 2)) {
			subCode |= 4;
		}
		return subCode;
	}

	@Override
	protected Result eval(String[] args) {
		long arg1 = Long.parseLong(args[0]);
		long arg2 = Long.parseLong(args[1]);
		int value = Integer.parseInt(args[2]);
		Memory.list.add(Math.min(arg1, arg2), Math.max(arg1, arg2), value);
		return null;
	}

}
