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

public class Assembler {

	private static Assembler assembler = null;

	public static long run(InputStream is) {
		long start = System.currentTimeMillis();
		long end = start - 1;
		if (assembler == null) {
			assembler = new Assembler();
		}
		try {
			end = assembler.eval(assembler.load(is));
		} catch (CommandExecException e) {
			e.getResultList().forEach(Display::printResult);
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return end - start;
	}
	
	private Assembler () {
	}

	private List<String[]> load(InputStream is) throws CommandExecException, IOException, Exception {		
		List<String[]> list = new ArrayList<>();

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
			}
			if(cmdArr[0].equals("ST")) {
					Class<?> clazz = Class.forName("jp.co.unirita.procon.command.impl.Command" + cmdArr[0]);
					Command command = (Command) clazz.getConstructor(int.class).newInstance(row);
					command.execute(Arrays.copyOfRange(cmdArr, 1, cmdArr.length));
			}else {
				list.add(cmdArr);
			}
		}
		br.close();
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
				Command command = (Command) clazz.getConstructor(int.class).newInstance(row + 1);
				Result success = command.execute(args);
				Display.printResult(success);
			} catch (ClassNotFoundException e) {
//				Display.printResult(new CommandError(row, cmd, ResultCode.PCON_E_000));
			} catch (CommandExecException e) {
				e.getResultList().forEach(Display::printResult);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return System.currentTimeMillis();
	}

	private boolean isBrankOrComment(String line) {
		return line.equals("") || line.startsWith("#");
	}
}
