module load alfresco/devscripts
module load farm/logging/prod
module load msde/git/1.8.1
module load msde/traincli/prod
module load msjava/oraclejdk/1.8.0_77
module load ossjava/ant/1.9.4
module load perl5/core/5.10-64
module load python/core/3.4.2
module load webinfra/dws/3.3
module load webinfra/kuula/3.x-prod

function op {
	if [[ -z $1 ]]; then
		DIR=""

	elif [ "$1" = "core3" ]; then
		DIR="core3/alfresco/mod_core/master/src"

	elif [ "$1" = "core4" ]; then
		DIR="core4/alfresco/mod_core4/master/src"

	elif [ "$1" = "core5" ]; then
		DIR="core5/src/mod_core5/src"

	elif [ "$1" = "demo4" ]; then
		DIR="core4/alfresco/mod_demo4/master/src"

	elif [ "$1" = "demo5" ]; then
		DIR="core5/src/mod_demo5/src"

	elif [ "$1" = "infra" ]; then
		DIR="infra/src"

	elif [ "$1" = "instances" ]; then
		cd /var/tmp/alfdev/kovactib/instances
		return 

	elif [ "$1" = "share4" ]; then
		DIR="share4/src"

	elif [ "$1" = "share5" ]; then
		DIR="share5/src"

	elif [ "$1" = "stuff" ]; then
		DIR="stuff"

	elif [ "$1" = "tools" ]; then
		DIR="tools/src"

	else
		DIR=$1		
	fi

	cd /var/tmp/kovactib/git_repo/$DIR 
}

function ns {
	netstat -anpt 2>/dev/null | grep $1 | awk '{ print $7 }' | sed 's#/.*##' | sed ':a;N;$!ba;s/\n/ /g' | sed 's/-//g'
}

## Kuula functions

function build {
	/var/tmp/kovactib/git_repo/stuff/kuula/build.ksh $*
}

function start {
	/var/tmp/kovactib/git_repo/stuff/kuula/start.ksh $*
}

function stop {
	/var/tmp/kovactib/git_repo/stuff/kuula/stop.ksh $*
}

function restart {
	stop $*
	start $*
}
