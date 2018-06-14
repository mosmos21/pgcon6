@echo off

SET JAR_FILE=procon.jar
SET IN_DIR=input
SET OUT_DIR=output

IF NOT EXIST "%IN_DIR%\\" (
	echo 入力フォルダが存在しません。処理を終了します。
	GOTO END
)

IF NOT EXIST "%OUT_DIR%\\" (
	echo 出力フォルダが存在しません。フォルダを作成します。
	mkdir %OUT_DIR%
)

FOR %%f IN (%IN_DIR%\*.txt) DO (
	echo %%~nfでテストを実行します
	java -jar procon.jar < %%f > %OUT_DIR%\%%~nf.txt
)

:END
