package jp.co.unirita.procon.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.exception.AssebleException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class Assembler{
	
	private static Assembler assembler = null;
	
	public static long run(InputStream is) {
		long start = System.currentTimeMillis();
		long end = start;
		if(assembler == null) {
			assembler = new Assembler();
		}
		try {
			List<String> cmdList = assembler.load(is);
			end = assembler.eval(cmdList);
		}catch (AssebleException e) {
			for(Result result : e.getResultList()) {
				Display.printErrorMessage(result.getResultCode(), result.getLine());
			}
		}
		return end - start;
	}	
	
	private List<String> load(InputStream is) throws AssebleException {
		List<String> list = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while((line = br.readLine()) != null) {
				list.add(line.trim());
				// TODO STコマンドとEDコマンドのチェック
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private long eval(List<String> cmdList) {
		for(int line = 1; line <= cmdList.size(); ++line) {
			String cmdStr = cmdList.get(line - 1);
			if(cmdStr.equals("") || cmdStr.startsWith("#")) {
				continue;
			}
			String[] ss = cmdStr.split("[\\s]+");
			String cmd = ss[0].toUpperCase();
			String[] args = Arrays.copyOfRange(ss, 1, ss.length);
			try {
				Class<?> clazz = Class.forName("jp.co.unirita.procon.command.impl.Command" + cmd);
				Command command = (Command)clazz.getConstructor(int.class).newInstance(line);
				Result success = command.execute(args);
				Display.printSuccessMessage(success.getLine(), success.getMessage());
			}catch (ClassNotFoundException e) {
				Display.printErrorMessage(ResultCode.PCON_E_000, line);
			}catch (AssebleException e) {
				for(Result result : e.getResultList()) {
					Display.printErrorMessage(result.getResultCode(), result.getLine(), result.getMessage());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return System.currentTimeMillis();
	}
}
