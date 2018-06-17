package jp.co.unirita.procon.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.exception.CommandExecException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;
import jp.co.unirita.procon.result.ResultUtil;
import jp.co.unirita.procon.result.error.CommandError;

public class Assembler {

	private static Assembler assembler = null;

	public static long run(InputStream is) {
		long start = System.currentTimeMillis();
		long end = start;
		if (assembler == null) {
			assembler = new Assembler();
		}
		try {
			end = assembler.eval(assembler.load(is));
		} catch (CommandExecException e) {
			for (Result result : e.getResultList()) {
				Display.printErrorMessage(result.getResultCode(), result.getHeader(), result.getBody());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return end - start;
	}
	
	private Assembler () {
	}

	private List<String[]> load(InputStream is) throws CommandExecException, IOException {		
		List<String[]> list = new ArrayList<>();
		State state = State.NONE;

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		String[] cmdArr = null;
		int row = 0;
		while ((line = br.readLine()) != null) {
			++row;
			line = line.trim();
			if (isBrankOrComment(line)) {
				cmdArr = new String[] { line };
			} else {
				cmdArr = line.split("[\\s]+");
				cmdArr[0] = cmdArr[0].toUpperCase();
				state = getNextState(row, state, cmdArr[0]);
			}
			list.add(cmdArr);
		}
		br.close();
		
		if (state != State.ED) {
			throw new CommandExecException(new Result(row, "", ResultCode.PCON_E_003));
		}
		return list;
	}

	private long eval(List<String[]> cmdList) {
		for (int row = 1; row <= cmdList.size(); ++row) {
			String[] cmdArr = cmdList.get(row - 1);
			if (isBrankOrComment(cmdArr[0])) {
				continue;
			}
			String cmd = cmdArr[0];
			String[] args = Arrays.copyOfRange(cmdArr, 1, cmdArr.length);
			try {
				Class<?> clazz = Class.forName("jp.co.unirita.procon.command.impl.Command" + cmd);
				Command command = (Command) clazz.getConstructor(int.class).newInstance(row);
				Result success = command.execute(args);
				Display.printSuccessMessage(success.getHeader(), success.getBody());
			} catch (ClassNotFoundException e) {
				Display.printErrorMessage(ResultCode.PCON_E_000, row + "çsñ⁄", ResultUtil.getResultMessage(ResultCode.PCON_E_000));
			} catch (CommandExecException e) {
				for (Result result : e.getResultList()) {
					Display.printErrorMessage(result.getResultCode(), result.getHeader(), result.getBody());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return System.currentTimeMillis();
	}

	private boolean isBrankOrComment(String line) {
		return line.equals("") || line.startsWith("#");
	}

	private State getNextState(int row, State state, String command) throws CommandExecException {
		if (state == State.NONE) {
			if (command.equals("ST")) {
				state = State.ST;
			} else {
				throw new CommandExecException(new CommandError(row, command, ResultCode.PCON_E_004));
			}
		} else if (state == State.ST) {
			state = command.equals("ED") ? State.ED : State.COMMAND;
		} else if (state == State.COMMAND) {
			if (command.equals("ED")) {
				state = State.ED;
			}
		} else if (state == State.ED) {
			throw new CommandExecException(new CommandError(row, command, ResultCode.PCON_E_005));
		}
		return state;
	}
}
