package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.result.Result;

public class CommandSG extends AbstractCommand {
	
	Memory memory = Memory.getInstance();

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
		String cmdString = this.getCommandName() + " " + String.join(" ", args);
		int subCode = 0;
		if(args.length < 1) {
			subCode |= 1;
		} else {
			try {
				if(memory.getMaxDigit() < args[0].length()) {
					throw new Exception();
				}
				int idx = Integer.parseInt(args[0]);
				if(idx < 0 ||  memory.getMaxSize() < idx) {
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
		int idx = Integer.parseInt(args[0]);
		String value = memory.getValue(idx);
		return super.success(String.format("%0" + memory.getMaxDigit() + "d %s", idx, value));
	}

}
