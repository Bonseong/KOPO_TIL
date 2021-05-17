#!/bin/sh
echo "enter the password"
read mypass
while [ $mypass != "1234" ]
do
	echo "incorrect, plz enter the correct passwd"
	read mypass
done
echo "pass"
exit 0
