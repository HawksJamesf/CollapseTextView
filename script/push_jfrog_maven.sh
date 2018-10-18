#!/bin/bash

#baseurl:https://api.bintray.com/
# subproject:https://dl.bintray.com/makeyouflying
# repo:maven
# package:com.hawksjamesf.library:collapsetextview

#在travis ci中需要让`PROJECT_DIR`为xxx/CollapseTextView
PROJECT_DIR=$1
BINTRAY_USER=$2
BINTRAY_APIKEY=$3
echo -e "PROJECT_DIR:$PROJECT_DIR
BINTRAY_USER :$BINTRAY_USER BINTRAY_APIKEY:$BINTRAY_APIKEY"

VERSION_INFO_API=https://api.bintray.com/packages/makeyouflying/maven/com.hawksjamesf.library:collapsetextview/versions/_latest?attribute_values=1
REMOTE_VERSION_INFO_FILE=$PROJECT_DIR/remote_version_info.json
LOCAL_VERSION_INFO_FILE=$PROJECT_DIR/library/gradle.properties

curl $VERSION_INFO_API | python -m json.tool >> $REMOTE_VERSION_INFO_FILE

if [ ! -f "$LOCAL_VERSION_INFO_FILE" ];then
    echo "no exit local version info file:$LOCAL_VERSION_INFO_FILE"
    rm $REMOTE_VERSION_INFO_FILE
    exit 1
fi

if [ ! -f "$REMOTE_VERSION_INFO_FILE" ];then
   echo "no exit remote version info file-->$REMOTE_VERSION_INFO_FILE"
   rm $REMOTE_VERSION_INFO_FILE
   exit 1
fi

#get local version
while read line
do
    key=$(echo $line | cut -d = -f 1)
    value=$(echo $line | cut -d = -f 2)

    if [ "$key" == "VERSION_NAME" ];then
        versionName=\"$value\"
    fi
done < $LOCAL_VERSION_INFO_FILE

echo -e "local version $versionName"

while read line
do
    key=$(echo $line | cut -d : -f 1)
    value=$(echo $line | cut -d : -f 2)
   if [ "$key" == '"name"' ];then
       remoteVersionName=$(echo $value|cut -d , -f 1)
   fi
done < $REMOTE_VERSION_INFO_FILE

echo "remote version $remoteVersionName"

if [ "$versionName" == "$remoteVersionName" ];then
    echo "no new version,current version is $remoteVersionName"
    rm $REMOTE_VERSION_INFO_FILE
    exit 0
else 
    echo -e "\033[34m have new version,current version is $remoteVersionName.You will upload version:$versionName \033[0m"
    #todo test
     ./gradlew assemble/bintrayUpload -PBINTRAY_USER=$BINTRAY_USER --project-prop BINTRAY_APIKEY=$BINTRAY_APIKEY
fi

rm $REMOTE_VERSION_INFO_FILE



