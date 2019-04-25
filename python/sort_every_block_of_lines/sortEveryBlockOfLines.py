#! /usr/bin/env python

import os
import csv
import sys
import cx_Oracle

def help():
  print "sortEveryBlockOfLines"
  print "---"
  print "Sort every block of lines separated by emtpy lines and start again until EOF is reached."
  print " "
  print "hosted at http://github.com/estuardolh"

if (len(sys.argv) > 1):
  a_file = open(sys.argv[1])
  
  output_text = ""
  
  a_block_of_lines = ""
  for a_line in a_file:
    if(len(a_line) == 1 and a_line[0] == '\n'):
      # sort block of lines
      a_a_file = os.popen('echo "'+a_block_of_lines+'" | sort')
      wow = a_a_file.read()
      output_text += '\n\n'+wow
      a_block_of_lines = ''
    else:
      #print a_line
      a_block_of_lines += a_line
  
  # sort block of lines / last time
  a_a_file = os.popen('echo "'+a_block_of_lines+'" | sort')
  wow = a_a_file.read()
  output_text += wow+'\n'
  
  a_file.close()
  
  # write new line
  text_file = open(sys.argv[1]+".out", "w")
  text_file.write(output_text)
  text_file.close()
else:
  help()
