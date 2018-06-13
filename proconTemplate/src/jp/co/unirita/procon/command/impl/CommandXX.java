package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class CommandXX extends Command {
	
	public CommandXX(int line) {
		super(line);
	}
	
	@Override
	public String getCommandString() {
		return "XX";
	}

	@Override
	public void check(String[] args) {
		// ��1������0��1���Ɖ��肷��
		if(args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
			super.addCheckError(ResultCode.PCON_E_002);
		}
		// ��2������2��3���Ɖ��肷��
		if(args.length < 2 || (!args[1].equals("2") && !args[1].equals("3"))) {
			super.addCheckError(ResultCode.PCON_E_003);
		}
	}

	@Override
	public Result eval(String[] args){
		return super.success("XX�R�}���h�����s���܂���");
	}

}
