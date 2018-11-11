#!/usr/bin/env bash

WD=$PWD

if [ "$1" != "" ]; then
    cd $1
    for i in $(ls | grep *.cup); do
        echo $i
        COMMAND="java -jar $WD/libs/java-cup-11b.jar -interface -parser Parser $i"
        eval $COMMAND
    done
else
    echo "Missing cup files enclosing directory. Example: ./cup-compile.sh src/main/java/grammar/"
fi