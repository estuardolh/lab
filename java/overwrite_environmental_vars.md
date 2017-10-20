overwrite env vars
---

- On windows when a java is installed, a default jre is associated with any jar file even windows environmental variables are setted correctly(JRE_HOME, JAVA_HOME, append to PATH) so is necesary to overwrite env vars on CMD before run a jar file(java -jar <jar file>.jar)
 
```
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_121\
set path=C:\Program Files\Java\jdk1.8.0_121\bin;%path%
``` 

