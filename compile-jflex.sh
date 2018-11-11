#!/usr/bin/env bash

if [ "$1" != "" ]; then
    WD=$PWD
    cd $1
    for i in $(ls | grep *.flex); do
        echo $i
        COMMAND="$WD/jflex/jflex-1.7.0/bin/jflex"
        eval $COMMAND $i
    done
    mv *.java $WD/src/main/java/
else
    echo "Missing jflex files enclosing directory. Example: ./compile-jflex.sh src/main/java/grammar/"
fi