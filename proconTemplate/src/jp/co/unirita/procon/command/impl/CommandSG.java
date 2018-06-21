package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.core.Result;

public class CommandSG extends AbstractCommand {

	public CommandSG(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "sg";
	}
	
	@Override
	protected int getCommandNumber() {
		return 3;
	}

	@Override
	protected int check(String[] args) {
		int subCode = 0;
		if(!super.checkArgIdx(args, 0)) {
			subCode |= 1;
		}
		return subCode;
	}

	@Override
	protected Result eval(String[] args) {
		int digit = String.valueOf(Memory.list.size()).length();
		long idx = Long.parseLong(args[0]);
		int value = Memory.list.get(idx);
		return super.success(String.format("%0" + digit + "d %s", idx, value));
	}

}
