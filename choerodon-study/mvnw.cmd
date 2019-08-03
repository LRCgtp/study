@REM--
--------------------------------------------------------------------------
        @REM
Licensed
to
the
Apache
Software
Foundation(ASF)
under
one
@REMor
more
contributor
license
agreements.See
the
NOTICE
file
@REMdistributed
with this work
for additional information
@REMregarding
copyright
ownership.The
ASF
licenses
this
file
@REMto
you
under
the
Apache
License, Version
2.0(the
@REM"License")
;you
may
not

use

this
file
except in compliance
@REMwith
the
License.You
may
obtain
a
copy
of
the
License
at
@REM@
REM
https://www.apache.org/licenses/LICENSE-2.0
        @REM
@REMUnless
required
by
applicable
law
or
agreed
to in writing,
        @REM
software
distributed
under
the
License is distributed
on
an
@REM"AS IS"
BASIS, WITHOUT
WARRANTIES
OR
CONDITIONS
OF
ANY
@REMKIND,
either
express
or
implied.See
the
License
for the
    @REM
specific
language
governing
permissions
and
limitations
@REMunder
the
License.@REM--
--------------------------------------------------------------------------

        @REM--
--------------------------------------------------------------------------
        @REM
Maven2
Start
Up
Batch
script
@REM@
REM
Required
ENV
vars:
        @REM
JAVA_HOME - location
of
a
JDK
home
dir
@REM@
REM
Optional
ENV
vars
@REMM2_HOME
-location
of
maven2
's installed home dir
@REMMAVEN_BATCH_ECHO
-set
to
'on'
to
enable
the
echoing
of
the
batch
commands
@REMMAVEN_BATCH_PAUSE
-set
to
'on'
to
wait
for a key
stroke
before
ending
@REMMAVEN_OPTS
-parameters
passed
to
the
Java
VM
when
running
Maven
@REMe.
g.to
debug
Maven
itself,

use

@REMset
MAVEN_OPTS = -Xdebug - Xrunjdwp
:
transport = dt_socket, server = y, suspend = y, address = 8000
@REMMAVEN_SKIP_RC
-flag
to
disable
loading
of
mavenrc
files
@REM--
--------------------------------------------------------------------------

        @REM
Begin
all
REM
lines
with '@' in case
MAVEN_BATCH_ECHO is 'on'
@echooff
@REMset
title
of
command
window
title % 0
@REMenable
echoing
my
setting
MAVEN_BATCH_ECHO
to
'on'
@
if "%MAVEN_BATCH_ECHO%" == "on"  echo % MAVEN_BATCH_ECHO %

@REM
set % HOME % to
equivalent
of
$HOME
if "%HOME%" == ""(set "HOME=%HOMEDRIVE%%HOMEPATH%"
)

@REMExecute
a
user
defined
script
before
this
one
if not "%MAVEN_SKIP_RC%" == ""
goto skipRcPre
@REMcheck
for pre script, once
with legacy.bat ending
and
once
with .
cmd
ending
if exist "%HOME%\mavenrc_pre.bat"
call
"%HOME%\mavenrc_pre.bat"
if exist "%HOME%\mavenrc_pre.cmd"
call
"%HOME%\mavenrc_pre.cmd"
:
skipRcPre

@setlocalset
ERROR_CODE = 0

@REMTo
isolate
internal variables
from
possible
post
scripts, we

use

another
setlocal
@setlocal@
REM === = START
VALIDATION === =
if not "%JAVA_HOME%" == ""
goto OkJHome

echo.echo
Error: JAVA_HOME
not
found in your
environment. > & 2
echo
Please
set
the
JAVA_HOME
variable in your
environment
to
match
the > & 2
echo
location
of
your
Java
installation. > & 2
echo.goto
error

        :OkJHome
if exist "%JAVA_HOME%\bin\java.exe"
goto init

echo.echo
Error: JAVA_HOME is set
to
an
invalid
directory. > & 2
echo
JAVA_HOME = "%JAVA_HOME%" > & 2
echo
Please
set
the
JAVA_HOME
variable in your
environment
to
match
the > & 2
echo
location
of
your
Java
installation. > & 2
echo.goto
error

@REM===
= END
VALIDATION === =

:
init

@REMFind
the
project
base
dir, i.e.the
directory
that
contains
the
folder
".mvn".@REM
Fallback
to
current
working
directory
if not found.set
MAVEN_PROJECTBASEDIR =
%
MAVEN_BASEDIR %
IF
NOT
"%MAVEN_PROJECTBASEDIR%" == ""
goto endDetectBaseDir

set
EXEC_DIR =
%
CD %
set
WDIR =
%
EXEC_DIR %
:
findBaseDir
IF
EXIST
"%WDIR%"\.
mvn
goto baseDirFound
cd..
        IF
"%WDIR%" == "%CD%"
goto baseDirNotFound
set
WDIR =
%
CD %
goto
findBaseDir

        :baseDirFound
set
MAVEN_PROJECTBASEDIR =
%
WDIR %
cd
"%EXEC_DIR%"
goto endDetectBaseDir

:
baseDirNotFound
set
MAVEN_PROJECTBASEDIR =
%
EXEC_DIR %
cd
"%EXEC_DIR%"

:
endDetectBaseDir

IF
NOT
EXIST
"%MAVEN_PROJECTBASEDIR%\.mvn\jvm.config"
goto endReadAdditionalConfig

@setlocalEnableExtensions
EnableDelayedExpansion
for /F "usebackq delims=" %%a in ("%MAVEN_PROJECTBASEDIR%\.mvn\jvm.config") do set JVM_CONFIG_MAVEN_PROPS=!JVM_CONFIG_MAVEN_PROPS! %%a
    @endlocal & set
JVM_CONFIG_MAVEN_PROPS =
%
JVM_CONFIG_MAVEN_PROPS %

:
endReadAdditionalConfig

SET
MAVEN_JAVA_EXE = "%JAVA_HOME%\bin\java.exe"
set
WRAPPER_JAR = "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
set
WRAPPER_LAUNCHER = org.apache.maven.wrapper.MavenWrapperMain

set
DOWNLOAD_URL = "https://repo.maven.apache.org/maven2/io/takari/maven-wrapper/0.4.2/maven-wrapper-0.4.2.jar"
FOR / F
"tokens=1,2 delims==" % % A
IN( % MAVEN_PROJECTBASEDIR %\.
mvn\wrapper\maven - wrapper.properties
)
DO(
        IF
"%%A" == "wrapperUrl"
SET
DOWNLOAD_URL =
%%
B
)

@REMExtension
to
allow
automatically
downloading
the
maven - wrapper.jar
from
Maven - central
@REMThis
allows
using
the
maven
wrapper in projects
that
prohibit
checking in binary
data.if
exist % WRAPPER_JAR % (
        echo
Found % WRAPPER_JAR %
) else
(
        echo
Couldn
't find %WRAPPER_JAR%, downloading it ...
echo
Downloading
from: %
DOWNLOAD_URL %
powershell - Command
"(New-Object Net.WebClient).DownloadFile('%DOWNLOAD_URL%', '%WRAPPER_JAR%')"
echo
Finished
downloading % WRAPPER_JAR %
)
@REMEnd
of
extension

% MAVEN_JAVA_EXE % % JVM_CONFIG_MAVEN_PROPS % % MAVEN_OPTS % % MAVEN_DEBUG_OPTS % -classpath % WRAPPER_JAR % "-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%" % WRAPPER_LAUNCHER % % MAVEN_CONFIG % % *
if ERRORLEVEL 1
goto error
goto end

:
error
set
ERROR_CODE = 1

:
end
@endlocal&
set
ERROR_CODE =
%
ERROR_CODE %

if not "%MAVEN_SKIP_RC%" == ""
goto skipRcPost
@REMcheck
for post script, once
with legacy.bat ending
and
once
with .
cmd
ending
if exist "%HOME%\mavenrc_post.bat"
call
"%HOME%\mavenrc_post.bat"
if exist "%HOME%\mavenrc_post.cmd"
call
"%HOME%\mavenrc_post.cmd"
:
skipRcPost

@REMpause
the
script
if MAVEN_BATCH_PAUSE is set to
'on'
if "%MAVEN_BATCH_PAUSE%" == "on" pause

if "%MAVEN_TERMINATE_CMD%" == "on" exit % ERROR_CODE %

exit / B % ERROR_CODE %
