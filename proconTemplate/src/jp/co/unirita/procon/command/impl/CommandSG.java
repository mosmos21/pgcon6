package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.result.Result;

public class CommandSG extends AbstractCommand {

	public CommandSG(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "sg";
	}
	
	@Override
	protected int getCommandCode() {
		return 3;
	}

	@Override
	protected void check(String[] args) {
		int digit = String.valueOf(Memory.list.size()).length();
		String cmdString = this.getCommandName() + " " + String.join(" ", args);
		int subCode = 0;
		if(args.length < 1) {
			subCode |= 1;
		} else {
			try {
				if(digit < args[0].length()) {
					throw new Exception();
				}
				int idx = Integer.parseInt(args[0]);
				if(idx < 0 ||  digit < idx) {
					throw new Exception();
				}
			}catch (Exception e) {
				subCode |= 1;
			}
		}
		if(0 < subCode) {
			addCheckError(subCode, cmdString);
		}
	}

	@Override
	protected Result eval(String[] args) {
		int digit = String.valueOf(Memory.list.size()).length();
		long idx = Long.parseLong(args[0]);
		int value = Memory.list.get(idx);
		return super.success(String.format("%0" + digit + "d %s", idx, value));
	}

}
