package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.result.Result;

public class CommandMG extends AbstractCommand {
	
	Memory memory = Memory.getInstance();
	
	public CommandMG(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "mg";
	}
	
	@Override
	protected int getCommandCode() {
		return 6;
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
		if(0 < subCode) {
			addCheckError(subCode, cmdString);
		}
	}

	@Override
	protected Result eval(String[] args) {
		int arg1 = Integer.parseInt(args[0]);
		int arg2 = Integer.parseInt(args[1]);
		int[] arr = memory.getValues(Math.min(arg1, arg2), Math.max(arg1,  arg2));
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%0" + memory.getMaxDigit() + "d", Math.min(arg1, arg2)));
		for(int i = 0; i < arr.length; i++) {
			sb.append(' ').append(arr[i] == Memory.UNDEFINED ? "--" : String.format("%02d", arr[i]));
		}
		return super.success(sb.toString());
	}

}
