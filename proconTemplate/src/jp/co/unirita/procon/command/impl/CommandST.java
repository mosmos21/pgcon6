package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.list.impl.LargeList;
import jp.co.unirita.procon.list.impl.SmallList;
import jp.co.unirita.procon.result.Result;

public class CommandST extends AbstractCommand {

	public CommandST(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "st";
	}

	@Override
	protected int getCommandNumber() {
		return 0;
	}

	@Override
	protected int check(String[] args) {
		int subCode = 0;
		if (args.length < 1 || (!args[0].equals("7") && !args[0].equals("12"))) {
			subCode |= 1;
		}
		return subCode;
	}

	@Override
	protected Result eval(String[] args) {
		int size = Integer.parseInt(args[0]);
		if (size == 7) {
			Memory.list = new SmallList<>();
		} else {
			Memory.list = new LargeList<>();
		}
		return null;
	}
}
