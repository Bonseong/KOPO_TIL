#!/bin/sh
myFunction(){
	echo "im in function"
	return
}
echo "start program"
myFunction
echo "stop program"
exit 0
