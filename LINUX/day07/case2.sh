#1/bin/sh
echo "is studying funny? (yes / no)"
read answer
case $answer in
	yes|y|Y|Yes|YES)
		echo "good"
		echo "goooooood";;
	[nN][oO])
		echo "too bad";;
	*)
		echo "pla enter yes or no"
		exit 1;;
esac
exit 0
