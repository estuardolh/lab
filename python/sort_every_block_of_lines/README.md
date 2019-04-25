# sort every block of lines
---
  USAGE: ./sortEveryBlockOfLines.py <INPUT FILE PATH>

  It writes a file text <INPUT FILE PATH>.out with each 'group of lines' sorted.
  Where 'group of lines' are contiguous lines of a text file separated by empty lines.

  Tested in:
    Ubuntu 18.04 bionic
    bash 4.4.19
    Python 2.7.15rc1

  example:

Input.txt
```
a
block
here
of lines



another
block
here
of lines



also
another block
here
(of lines)
there is

end ok
```

Input.txt.out:
```
a
block
here
of lines



another
block
here
of lines



also
another block
here
(of lines)
there is

end ok
```
