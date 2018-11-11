#!/usr/bin/env bash

if [ "$1" != "" ]; then
    jflex/jflex-1.7.0/bin/jflex $1
else
    echo "Missing jflex file parameter. Example: ./compile-jflex.sh src/main/java/grammar/Sentence.jflex"
fi