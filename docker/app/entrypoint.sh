#!/bin/bash

if [ "$1" = "run" ]; then
  exec make -f Makefile.native run
fi