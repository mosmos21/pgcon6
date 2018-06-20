package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.result.Result;

public class CommandSS extends AbstractCommand {

	public CommandSS(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "ss";
	}
	
	@Override
	protected int getCommandCode() {
		return 1;
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
		
		if(args.length < 2) {
			subCode |= 2;
		} else {
			try {
				if(2 < args[1].length()) {
					throw new Exception();
				}
				int num = Integer.parseInt(args[1]);
				if(num < 0 || 99 < num) {
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
		Memory.list.set(Long.parseLong(args[0]), Integer.parseInt(args[1]));
		return null;
	}

}
