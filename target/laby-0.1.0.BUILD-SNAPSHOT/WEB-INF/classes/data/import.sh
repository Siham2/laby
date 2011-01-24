#!/bin/sh

APP_SDK_PATH=/home/matthieu/Bureau/google_appengine


$APP_SDK_PATH/appcfg.py upload_data --config_file=bulkloader.yaml --application=laby-newage  --kind=Niveau --filename=niveau.csv --url=http://laby-newage.appspot.com/remote_api -e=laborima@gmail.com
$APP_SDK_PATH/appcfg.py upload_data --config_file=bulkloader.yaml --application=laby-newage  --kind=Bonus --filename=bonus.csv --url=http://laby-newage.appspot.com/remote_api -e=laborima@gmail.com
$APP_SDK_PATH/appcfg.py upload_data --config_file=bulkloader.yaml  --application=laby-newage --kind=CaseElement --filename=cases.csv --url=http://laby-newage.appspot.com/remote_api -e=laborima@gmail.com
$APP_SDK_PATH/appcfg.py upload_data --config_file=bulkloader.yaml --application=laby-newage  --kind=Mechant --filename=mechant.csv --url=http://laby-newage.appspot.com/remote_api -e=laborima@gmail.com
$APP_SDK_PATH/appcfg.py upload_data --config_file=bulkloader.yaml --application=laby-newage  --kind=Joueur --filename=joueur.csv --url=http://laby-newage.appspot.com/remote_api -e=laborima@gmail.com


