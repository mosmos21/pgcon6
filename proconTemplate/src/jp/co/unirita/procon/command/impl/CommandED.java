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
	public void check(String[] args){
		// ����0�Ȃ̂œ��Ƀ`�F�b�N�Ȃ�
	}

	@Override
	public Result eval(String[] args){
		return super.success("ED�R�}���h�����s���܂���");
	}

}
