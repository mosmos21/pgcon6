package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.core.Result;

public class CommandSR extends AbstractCommand {
	
	public CommandSR(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "sr";
	}
	
	@Override
	protected int getCommandNumber() {
		return 2;
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
		Memory.list.remove(Long.parseLong(args[0]));
		return null;
	}

}
