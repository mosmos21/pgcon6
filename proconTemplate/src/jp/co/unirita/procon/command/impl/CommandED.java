package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.exception.AssebleException;
import jp.co.unirita.procon.result.Result;

public class CommandED extends Command {
	
	public CommandED(int line) {
		super(line);
	}

	@Override
	public String getCommandString() {
		return "ED";
	}

	@Override
	public Result check(String[] args){
		// ����0�Ȃ̂œ��Ƀ`�F�b�N�Ȃ�
		return super.success();
	}

	@Override
	public Result eval(String[] args) throws AssebleException {
		return super.success("ED�R�}���h�����s���܂���");
	}

}
