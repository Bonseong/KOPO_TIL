#!/bin/sh
while [ 1 ]; do
echo "infinite loop start (b : break, c : continue, e : exit)"
	read input
	case $input in
		b | B)
			break;;
		c | C)
			echo "contunue to while"
			continue;;
		e | E)
			echo "exit"
			exit 1;;
	esac;
done
echo "break finished"
exit 0
