@echo off

SET JAR_FILE=procon.jar
SET IN_DIR=input
SET OUT_DIR=output

IF NOT EXIST "%IN_DIR%\\" (
	echo ���̓t�H���_�����݂��܂���B�������I�����܂��B
	GOTO END
)

IF NOT EXIST "%OUT_DIR%\\" (
	echo �o�̓t�H���_�����݂��܂���B�t�H���_���쐬���܂��B
	mkdir %OUT_DIR%
)

FOR %%f IN (%IN_DIR%\*.txt) DO (
	echo %%~nf�Ńe�X�g�����s���܂�
	java -jar procon.jar < %%f > %OUT_DIR%\%%~nf.txt
)

:END
