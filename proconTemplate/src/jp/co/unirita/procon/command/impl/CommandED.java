package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.core.Memory;
import jp.co.unirita.procon.result.Result;

public class CommandED extends AbstractCommand {
	
	public CommandED(int row) {
		super(row);
	}

	@Override
	protected String getCommandName() {
		return "ed";
	}
	
	@Override
	protected int getCommandCode() {
		return 7;
	}

	@Override
	protected void check(String[] args){
		// ����0�Ȃ̂œ��Ƀ`�F�b�N�Ȃ�
	}

	@Override
	protected Result eval(String[] args){
		return super.success(String.valueOf(Memory.list.count()));
	}

}
