package jp.co.unirita.procon.command.impl;

import java.util.List;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.core.Result;

public class CommandMG extends AbstractCommand {
	
	public CommandMG(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "mg";
	}
	
	@Override
	protected int getCommandNumber() {
		return 6;
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
		return subCode;
	}

	@Override
	protected Result eval(String[] args) {
		long arg1 = Long.parseLong(args[0]);
		long arg2 = Long.parseLong(args[1]);
		List<Integer> list = Memory.list.get(Math.min(arg1, arg2), Math.max(arg1,  arg2));
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%0" + String.valueOf(Memory.list.size()).length() + "d", Math.min(arg1, arg2)));
		for(Integer val : list) {
			sb.append(' ').append(val == null ? "--" : String.format("%02d", val));
		}
		return super.success(sb.toString());
	}

}
