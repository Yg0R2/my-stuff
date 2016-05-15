#!/bin/bash

function op() {
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

	cd /d/Workspace/$DIR
}

function ant() {
	EXTRAS=""

	if [[ "$1" = "-amp" ]]; then
		shift

		EXTRAS="-Dalfresco.scripts.amp.dir=d:/Workspace/amp -Dalfresco.build-template.dir=\${alfresco.scripts.amp.dir}/masterbuild -Djslint.enabled=false"
	fi

	cmd /k module load msjava/oraclejdk/1.8.0_66 '&' module load ossjava/ant/1.9.4 '&' ant ${EXTRAS} $* '&' exit
}
