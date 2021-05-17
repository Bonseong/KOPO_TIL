#!/bin/sh
$a = friday
if [ "$a" = "sunday" ]
then
	echo "today is sunday"
elif [ "$a" = "friday "]
then
	echo "today is friday"
else
	echo "today is weekend"
fi
exit 0
