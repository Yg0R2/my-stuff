function build {
	if [[ "$1" == "-test" ]]; then
		MAVE_ARGS=""
	elif [[ "$1" == "-ba" ]]; then
		docker_login

		MAVE_ARGS="-Dmaven.test.skip=true -Dskip.checkstyle=true -Dcheckstyle.skip=true -DskipCheckstyle=true -Dpmd.skip=true -Djacoco.skip -DskipPiTest -Pbuild-local"
	else
		MAVE_ARGS="-Dmaven.test.skip=true -Dskip.checkstyle=true -Dcheckstyle.skip=true -DskipCheckstyle=true -Dpmd.skip=true -Djacoco.skip -DskipPiTest"
	fi

	mvn clean install ${MAVE_ARGS} ${@:2}
}

function debug {
	mvn -Dmaven.surefire.debug="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -Xnoagent -Djava.compiler=NONE" $@
}

function docker_clean {
	# Delete all containers
	docker rm -f $(docker ps -a -q)
	# Delete all images
	docker rmi -f $(docker images -q)
}

function docker_login {
	~/.aws/ecr_docker_login.sh
}

function dockerMvn {
	if [[ -z $* ]]; then
		MVN_COMMAND="clean install"
	else
		MVN_COMMAND=$*
	fi

	start cmd //k "docker run -it --rm -v c:\\Users\\Tibor_Kovacs1\\.m2\\:/root/.m2/repository/ -v %CD%:/opt/maven -w /opt/maven maven:3.2-jdk-8 mvn ${MVN_COMMAND}"
}

function gradlew {
	# It is working with JDK only, but ther stuffs require JRE

	GRADLE_COMMAND="gradlew $*"

	#CURRENT_JAVA_HOME=${JAVA_HOME}

	#export JAVA_HOME=/w/Java/jdk

	cmd //k ${GRADLE_COMMAND} '&&' exit

	#export JAVA_HOME=${CURRENT_JAVA_HOME}
}

function op {
	PROPERTIES_FILE=/w/projects/repos.properties

	PROJECT_LOCATION=`cat ${PROPERTIES_FILE} | grep "^$1=" | cut -d'=' -f2`

	# DEFAULT
	if [[ -z $1 ]]; then
		EXTRA_FOLDER=""
    
	elif [[ ! -z ${PROJECT_LOCATION} ]]; then
		EXTRA_FOLDER=${PROJECT_LOCATION}
    
	# ELSE
	else 
		EXTRA_FOLDER=${1}
	fi
    
	echo "Open project: /w/projects/${PROJECT_LOCATION}"
	cd /w/projects/${EXTRA_FOLDER}
}

function run {
	if [[ -z $1 ]]; then
		echo "Missing application parameter [-ba]"
		return 1
	fi

	VERSION="dev.0"
	if [[ ! -z $2 ]]; then
		VERSION="$2"
	fi

	/w/projects/HCom/Checkout/CheckoutTools/local_environment/local_env.sh start-app ${1:1} $1-version "${VERSION}" -no-stub
}

function syncAll {
	ORIGINAL_PWD=$(pwd)

	. /w/projects/repos.properties

	for project in $(echo $PROJECT_NAMES | sed -e "s/,/ /g"); do
		printf "\n\n"
		op ${project}
    
		syncRepository
	done;

	cd "${ORIGINAL_PWD}"
}

function syncRepository {
	CURRENT_REPOSITORY=$(basename `git rev-parse --show-toplevel`)

	if [[ "${CURRENT_REPOSITORY}" == "BookingEmailRequestProcessorService" ]]; then
		BRANCHES="master feature/development"
	else
		BRANCHES="master"
	fi

	for updateBranch in ${BRANCHES}; do
		echo 'Updating '${updateBranch}' branch.'

		currentBranch=$(git branch | grep \\* | cut -d ' ' -f2-)

		if [[ ${currentBranch} == ${updateBranch} ]]; then
			echo "---> git pull upstream ${updateBranch}"
			git pull upstream ${updateBranch}
		else
			echo "---> git fetch upstream ${currentBranch}"
			echo "---> You have to rebase manually!"
			git fetch upstream ${currentBranch}

			echo "---> git fetch upstream ${updateBranch}:${updateBranch}"
			git fetch upstream ${updateBranch}:${updateBranch}
		fi

		echo "git push origin ${updateBranch}:${updateBranch}"
		git push origin ${updateBranch}:${updateBranch}
	done
}
