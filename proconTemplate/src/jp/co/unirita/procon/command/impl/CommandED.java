package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.core.Result;

public class CommandED extends AbstractCommand {
	
	public CommandED(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "ed";
	}
	
	@Override
	protected int getCommandNumber() {
		return 7;
	}

	@Override
	protected int check(String[] args){
		return 0;
	}

	@Override
	protected Result eval(String[] args){
		return super.success(String.valueOf(Memory.list.count()));
	}

}
