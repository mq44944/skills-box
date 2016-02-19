#!/usr/bin/env bash

find . -name "*.txt" $files

for file in $files
do
	#iconv -f iso-8859-1 -t utf-8 $file
	iconv -f gbk -t utf-8 $file -o "file.new" # 中文转utf8
	mv "$file.new" $file 
done 
