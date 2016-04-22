#!/usr/bin/env bash

jars="./jars/"
path="../JAVAEE2/"
echo "from ${path} to ${jars}"

files=`find ${path}  -name "*.jar"`

for file in $files
do
    echo "cp ${file} ${jars}"
	cp ${file} ${jars}
done 
