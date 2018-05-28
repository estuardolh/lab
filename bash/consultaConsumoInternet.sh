#!/bin/bash

wget http://internet.tigo.com.gt/webpackagesnew.jsp && cat webpackagesnew.jsp | grep -E '"percent"|"total"' --color && rm webpackagesnew.jsp
