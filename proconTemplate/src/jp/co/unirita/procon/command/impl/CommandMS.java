package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.result.Result;

public class CommandMS extends AbstractCommand {
	
	Memory memory = Memory.getInstance();

	public CommandMS(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "ms";
	}
	
	@Override
	protected int getCommandCode() {
		return 4;
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
		
		if(args.length < 2) {
			subCode |= 2;
		} else {
			try {
				if(memory.getMaxDigit() < args[1].length()) {
					throw new Exception();
				}
				int idx = Integer.parseInt(args[1]);
				if(idx < 0 ||  memory.getMaxSize() < idx) {
					throw new Exception();
				}
			}catch (Exception e) {
				subCode |= 2;
			}
		}
		
		if(args.length < 3) {
			subCode |= 4;
		} else {
			try {
				if(2 < args[2].length()) {
					throw new Exception();
				}
				int num = Integer.parseInt(args[2]);
				if(num < 0 || 99 < num) {
					throw new Exception();
				}
			}catch (Exception e) {
				subCode |= 4;
			}
		}
		if(0 < subCode) {
			addCheckError(subCode, cmdString);
		}
	}

	@Override
	protected Result eval(String[] args) {
		int arg1 = Integer.parseInt(args[0]);
		int arg2 = Integer.parseInt(args[1]);
		int value = Integer.parseInt(args[2]);
		memory.resetValue(Math.min(arg1, arg2), Math.max(arg1, arg2), value);
		return null;
	}

}
