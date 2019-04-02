echo off

set arg1="%1"
set arg2="%2"

del "%arg1%.obj"
del "%arg1%.exe"

C:\BC5\BIN\bcc32.exe "%arg1%.cpp"

copy "%arg2%.obj" "%arg1%.obj"

pause

C:\BC5\BIN\bcc32.exe "%arg1%.obj"
copy "%arg2%.exe" "%arg1%.exe"

pause

"%arg2%.exe"
