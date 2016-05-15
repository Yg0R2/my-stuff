open() {
	type="portal"
	if [ "$2" = "plugins" ]; then
		type="plugins"
		elif [ "$2" = "bundle" ]; then
			type="bundle"
		elif [ "$2" = "dm" ]; then
			type="dm"
	fi

	if [ -z $1 ]; then
		#cd /l/liferay-deprecated-ee/
		cd /l/liferay-deprecated-test/
		elif [ "$1" == "dm" ]; then
			cd /l/data-manipulator-portlet/
		elif [ "$1" == "fp" ]; then
			cd /l/liferay-fix-pack-builder-ee
		elif [ "$1" == "j" ]; then
			cd /l/liferay-jenkins-ee
		elif [ "$1" == "mc" ]; then
			cd ~/AppData/Roaming/.minecraft/1.7.10/
		elif [ "$1" == "pt" ]; then
			cd /l/liferay-patching-tool-ee
		elif [ "$type" == "bundle" ]; then
			cd /l/$type/$1/tomcat-*/
		else
			cd /l/$type/liferay-$type-ee-$1/
	fi
}
alias op=open

createDB() {
	db=${1}
	if [ -z ${1} ]; then
		db="";
	fi

	mysql -u root -pliferay -e "drop database if exists lportal_${db};create database lportal_${db} character set utf8; "
}
alias cdb=createDB

createPortalFull() {
	actualPWD=$(pwd)
	ver=${1};
	baseR2=/r/Releases/EE/portal
	baseDir=/l/bundles
	baseDirWin=l:/bundles

	if [ -z ${1} ]; then
		echo Usage: cP PORTAL_VERSION HOTFIX_NUMBER -DANT_PROPERTY=value
		return
	elif [ "${ver}" == "6010" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.0-liferayhungarykft.xml
		tomcatDir=tomcat-6.0.29
		tomcatZipName=liferay-portal-tomcat-6.0-ee.zip
		tomcatZip=${baseR2}/6.0.10/${tomcatZipName}
	elif [ "${ver}" == "6011" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.0-liferayhungarykft.xml
		tomcatDir=tomcat-6.0.29
		tomcatZipName=liferay-portal-tomcat-6.0-ee-sp1.zip
		tomcatZip=${baseR2}/6.0.11/${tomcatZipName}
	elif [ "${ver}" == "6012" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.0-liferayhungarykft.xml
		tomcatDir=tomcat-6.0.32
		tomcatZipName=liferay-portal-tomcat-6.0-ee-sp2-20110727.zip
		tomcatZip=${baseR2}/6.0.12/${tomcatZipName}
	elif [ "${ver}" == "6110" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.1-liferayhungarykft.xml
		tomcatDir=tomcat-7.0.25
		tomcatZipName=liferay-portal-tomcat-6.1.10-ee-ga1-20120223174854827.zip
		tomcatZip=${baseR2}/6.1.10/${tomcatZipName}
	elif [ "${ver}" == "6120" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.1-liferayhungarykft.xml
		tomcatDir=tomcat-7.0.27
		tomcatZipName=liferay-portal-tomcat-6.1.20-ee-ga2-20120731110418084.zip
		tomcatZip=${baseR2}/6.1.20/${tomcatZipName}
	elif [ "${ver}" == "6130" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.1-liferayhungarykft.xml
		tomcatDir=tomcat-7.0.40
		tomcatZipName=liferay-portal-tomcat-6.1.30-ee-ga3-20130812170130063.zip
		tomcatZip=${baseR2}/6.1.30/${tomcatZipName}
	elif [ "${ver}" == "6210" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.2ee-liferaycomliferayhungary.xml
		tomcatDir=tomcat-7.0.42
		tomcatZipName=liferay-portal-tomcat-6.2.10.1-ee-ga1-20131126141110470.zip
		tomcatZip=${baseR2}/6.2.10.1/${tomcatZipName}
	elif [ "${ver}" == "6210sp1" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.2ee-liferaycomliferayhungary.xml
		tomcatDir=tomcat-7.0.42
		tomcatZipName=liferay-portal-tomcat-6.2-ee-sp1-20140204095606875.zip
		tomcatZip=${baseR2}/6.2.10.2/${tomcatZipName}
	elif [ "${ver}" == "6210sp7" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.2ee-liferaycomliferayhungary.xml
		tomcatDir=tomcat-7.0.42
		tomcatZipName=liferay-portal-tomcat-6.2-ee-sp7-20140807114015311.zip
		tomcatZip=${baseR2}/6.2.10.8/${tomcatZipName}
	elif [ "${ver}" == "6210sp8" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.2ee-liferaycomliferayhungary.xml
		tomcatDir=tomcat-7.0.42
		tomcatZipName=liferay-portal-tomcat-6.2-ee-sp8-20140904111637931.zip
		tomcatZip=${baseR2}/6.2.10.9/${tomcatZipName}
	elif [ "${ver}" == "6210sp10" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.2ee-liferaycomliferayhungary.xml
		tomcatDir=tomcat-7.0.42
		tomcatZipName=liferay-portal-tomcat-6.2-ee-sp10-20150205153520442.zip
		tomcatZip=${baseR2}/6.2.10.11/${tomcatZipName}
	elif [ "${ver}" == "6210sp12" ]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.2ee-liferaycomliferayhungary.xml
		tomcatDir=tomcat-7.0.42
		tomcatZipName=liferay-portal-tomcat-6.2-ee-sp12-20150804162203131.zip
		tomcatZip=${baseR2}/6.2.10.13/${tomcatZipName}
	elif [[ ${ver} == 62x* ]]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.2ee-liferaycomliferayhungary.xml
		tomcatDir=tomcat-7.0.62
		tomcatZipName=
		tomcatZip=
	elif [[ ${ver} == 70x* ]]; then
		portalLicenseXML=license-portaldevelopment-developer-cluster-6.2ee-liferaycomliferayhungary.xml
		tomcatDir=tomcat-7.0.62
		tomcatZipName=
		tomcatZip=
	fi

	mkdir -p ${baseDir}/
	cd ${baseDir}/

	if [[ $2 == "" ]]
	then
		portalHomeDir=${ver}
		dbSchema=${ver//[-]/_}
	else
		portalHomeDir=${ver}-patched
		dbSchema=${ver//[-]/_}_patched
	fi

	if [ ! -d "${portalHomeDir}/${tomcatDir}" ]; then
		if [ ! -f "${tomcatZipName}" ]; then
			echo get \'${tomcatZipName}\'...

			cp ${tomcatZip} ${tomcatZipName}
		fi

		echo Unzipping bundle: \'${tomcatZipName}\' .... to \'${portalHomeDir}/\'

		#if [ "${ver}" == "6012" ] || [ "${ver}" == "6110" ] || [ "${ver}" == "6120" ]; then
		#	unzip -qq ${tomcatZipName} \*/${tomcatDir}/\* -x \*/${tomcatDir}/jre1\* -d ${baseDir}/${portalHomeDir}
		#else
			unzip -qq ${tomcatZipName} \*/${tomcatDir}/\* -d ${baseDir}/${portalHomeDir}
		#fi

		mv ${portalHomeDir}/liferay-portal-*/${tomcatDir}/ ${portalHomeDir}/
		rm -R ${portalHomeDir}/liferay-portal-*

		rm -R ${portalHomeDir}/tomcat-*/jre*/

		portalExtPath=${portalHomeDir}/${tomcatDir}/webapps/ROOT/WEB-INF/classes
		portalExtFile=${portalExtPath}/portal-ext.properties

		echo Create portal-ext.properties with DB access.
		mkdir -p ${portalExtPath}
		echo "jdbc.default.driverClassName=com.mysql.jdbc.Driver" > ${portalExtFile}
		echo "jdbc.default.url=jdbc:mysql://localhost/lportal_${dbSchema}?useUnicode=true&characterEncoding=UTF-8&useFastDataParsing=false" >> ${portalExtFile}
		echo "jdbc.default.username=root" >> ${portalExtFile}
		echo "jdbc.default.password=liferay" >> ${portalExtFile}
		echo "tunneling.servlet.shared.secret=1234567890123456" >> ${portalExtFile}
		echo "auth.verifier.TunnelingServletAuthVerifier.hosts.allowed=" >> ${portalExtFile}
		echo "tunnel.servlet.hosts.allowed=" >> ${portalExtFile}
		echo "auth.verifier.pipeline=com.liferay.portal.security.auth.TunnelingServletAuthVerifier,com.liferay.portal.security.auth.BasicAuthHeaderAutoLogin,com.liferay.portal.security.auth.DigestAuthenticationAuthVerifier,com.liferay.portal.security.auth.ParameterAutoLogin,com.liferay.portal.security.auth.PortalSessionAuthVerifier" >> ${portalExtFile}

		portalSetupWizardFile=${portalHomeDir}/portal-setup-wizard.properties

		echo Create portal-setup-wizard.properties
		echo "admin.email.from.name=Test Test" > ${portalSetupWizardFile}
		echo "liferay.home=${baseDirWin}/${portalHomeDir}" >> ${portalSetupWizardFile}
		echo "admin.email.from.address=test@liferay.com" >> ${portalSetupWizardFile}
		echo "setup.wizard.enabled=false" >> ${portalSetupWizardFile}

		mkdir -p ${portalHomeDir}/deploy/
		cp /l/bundles/licenses/${portalLicenseXML} ${portalHomeDir}/deploy/
	else
		echo The portal already exist.
	fi

	echo Create mysql database
	cdb ${dbSchema}

	if [[ ${2} != "" ]]
	then
		rm -R ${baseDir}/${portalHomeDir}/patching-tool

		unzip -qq /l/bundles/patching-tool-20-internal.zip -d ${baseDir}/${portalHomeDir}
		cd ${baseDir}/${portalHomeDir}/patching-tool

		./patching-tool.sh auto-discovery

		for fix in ${2}
		do
			./patching-tool.sh download ${fix}-${ver}
		done;
		./patching-tool.sh install -force
	fi

	cd ${baseDir}/${portalHomeDir}/${tomcatDir}/bin
	cmd //k catalina.bat start '&' exit
	cd ${actualPWD}
}
alias cP=createPortalFull

javaLinkModifie() {
	actualPWD=$(pwd)

	cd /w/Java
	rm jdk

	if [ "${1}" == "1.6" ]
	then
		cmd //k 'mklink /D jdk jdk1.6.0_45' '&' exit
	elif [ "${1}" == "1.7" ]
	then
		cmd //k 'mklink /D jdk jdk1.7.0_79' '&' exit
	else
		cmd //k 'mklink /D jdk jdk1.8.0_60' '&' exit
	fi

	cd ${actualPWD}
}
alias jlnk=javaLinkModifie

korte() {
	if [[ ${2} == "" ]] || [ -z ${1} ]; then
		echo "Use: korte PORTAL_VERSION TEST_NAME";
		return;
	fi

	mkdir -p /C/Users/KTibi/bundles/patching-tool/patches

	op

	cd builder/;ant;cd ..;
	cd test-src;ant -Davailable.portal.versions=${1};cd ..;

	for testName in ${2};do
		ant -f build-test-selenium.xml run-selenium-test -Denv.PORTAL_VERSION=${1:0:1}.${1:1:1}.${1:2:2} -Denv.TEST_NAME=${testName} ${3}
	done;
}
alias korte=korte
