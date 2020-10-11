@echo off
IF %1.==. GOTO Blank
IF "%1"=="-help" GOTO Help
IF "%1"=="-ready" GOTO Ready
IF "%1"=="-run" GOTO Run
ECHO Error
GOTO End

:Blank
	ECHO Missing arguments. Enter -help for a list of commands and their usage.
GOTO End

:Help
	ECHO Flags:
	ECHO     -help ------------------------- Prints this message.
	ECHO     -ready [argument] --------------- Runs specified file.
	ECHO         Argument options:
	ECHO             module.csvol ---- Places module.csvol in CSVOL directory
	ECHO     -run [argument] --------------- Runs specified file.
	ECHO         Argument options:
	ECHO             main ------------------ Runs default CSVOL file (main.csvol)
	ECHO             repl ------------------ Runs CSVOL repl (terminal input)
	ECHO             example_file.csvol ---- Runs example_file.csvol
GOTO End

:Ready
	SET original_dir=%cd%
	IF %2.==. GOTO Blank
	IF EXIST "%~2" (type "%2" >> %~dp0%2 && cd %original_dir% && GOTO End) 
	ECHO %2 does not exist.
GOTO End

:Run
	SET original_dir=%cd%
	IF %2.==. GOTO Blank
	IF "%~2"=="main" (javac %~dp0*.java && cd %~dp0 && java -cp %~dp0 Main && cd %original_dir% && GOTO End)
	IF "%~2"=="repl" (break> %~dp0main.csvol && javac %~dp0*.java && cd %~dp0 && java -cp %~dp0 Main && cd %original_dir% && GOTO End)
	IF EXIST "%~2" (break> %~dp0main.csvol && type "%2" >> %~dp0main.csvol && javac %~dp0*.java && cd %~dp0 && java -cp %~dp0 Main && cd %original_dir% && GOTO End) 
	ECHO %2 does not exist.
GOTO End

:End