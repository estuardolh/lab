#!/bin/bash

grep --color -rnw '.' -e $1 | less
