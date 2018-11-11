#!/usr/bin/env bash

PARAM="src/main/java/grammar/"

./cup-compile.sh $PARAM
./jflex-compile.sh $PARAM