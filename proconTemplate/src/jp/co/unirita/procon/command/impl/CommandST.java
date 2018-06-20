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
	protected int getCommandCode() {
		return 0;
	}

	@Override
	protected void check(String[] args) {
		String cmdString = this.getCommandName() + " " + String.join(" ", args);
		// åÖêîéwíË 10^12Ç‹Ç≈
		if(args.length < 1) {
			addCheckError(1, cmdString);
		} else {
			try {
				long digit = Long.parseLong(args[0]);
				if(1000000000000L < digit) {
					throw new Exception();
				}
			}catch (Exception e) {
				addCheckError(1, cmdString);
			}
		}
	}

	@Override
	protected Result eval(String[] args) {
		int size = Integer.parseInt(args[0]);
		if(size == 7) {
			Memory.list = new SmallList<>();
		} else {
			Memory.list = new LargeList<>();
		}
		return null;
	}
}
