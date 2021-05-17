#!/bin/sh

echo "plz enter filename you want"
read fname
if [ -f $fname ] && [ -s $fname ] ; then
	head -5 $fname
else
	echo "theres no file or file size is zero"
fi
exit 0
