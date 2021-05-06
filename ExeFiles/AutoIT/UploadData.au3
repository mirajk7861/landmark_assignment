WinWait("[CLASS:#32770]","",15)
ControlFocus("Choose File to Upload","","Edit1")
Sleep(2000);
ControlSetText("Choose File to Upload","","Edit1",$CmdLine[1])
Sleep(2000);
Send('{ENTER}')