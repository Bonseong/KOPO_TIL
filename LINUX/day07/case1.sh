#1/bin/sh
case "$1" in
	start)
		echo "start";;
	stop)
		echo "stop";;
	restart)
		echo "restart";;
	*)
		echo "dont know";;
esac
exit 0
