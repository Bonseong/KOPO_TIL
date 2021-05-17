#!/bin/sh
sum(){
	echo `expr $1 + $2`
}
echo "10 plus 20"
sum 10 20
exit 0
