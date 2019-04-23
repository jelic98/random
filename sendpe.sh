#!/bin/bash

RCVR_NAME="Lazar Jelić"
RCVR_CITY="Kruševac"
RCVR_STRE="Vasilija Velikog"
RCVR_NUMB="5"
RCVR_APRT="13"
RCVR_ZIPC="37000"
RCVR_PHON="0614437010"
ORDR_NUMB="1298"
ORDR_PRCE="1248.00"
ORDR_NOTE="Napomenica"
ORDR_CTNT="čarapice"
ORDR_WGHT="0.100"
SNDR_ACC1="165"
SNDR_ACC2="1760310000948"
SNDR_ACC3="16"

PAUSE=5

LANG_X=55
LANG_Y=250

SEND_X=120
SEND_Y=350

TYPE_X=55
TYPE_Y=400

NAME_X=55
NAME_Y=250

CITY_X=55
CITY_Y=350

CITY_SLCT_X=200
CITY_SLCT_Y=420

STRE_X=55
STRE_Y=450

STRE_SLCT_X=200
STRE_SLCT_Y=520

NUMB_X=55
NUMB_Y=550

APRT_X=600
APRT_Y=550

ZIPC_X=55
ZIPC_Y=650

PHON_X=55
PHON_Y=750

POST_X=600
POST_Y=950

VALE_X=5
VALE_Y=550

PRCE_X=55
PRCE_Y=600

PYMT_X=55
PYMT_Y=800

ACNT_X=250
ACNT_Y=950

ONUM_X=600
ONUM_Y=1000

CTNT_X=55
CTNT_Y=800

WGHT_X=55
WGHT_Y=900

NOTE_X=55
NOTE_Y=1050

CONF_X=600
CONF_Y=1200

SCRL_PAGE=900

KEY_ENT=66
KEY_DEL=67

IME_DFLT="com.google.android.inputmethod.latin/com.android.inputmethod.latin.LatinIME"
IME_SPEC="com.android.adbkeyboard/.AdbIME"


# Entering UTF characters needs following library
# https://github.com/senzhk/ADBKeyBoard
typespec() { adb shell am broadcast -a ADB_INPUT_B64 --es msg `echo $1 | base64` ; }

clear

adb shell ime set $IME_SPEC

adb shell am force-stop rs.assecosee.pttandroidapp
adb shell am start -n rs.assecosee.pttandroidapp/.MainActivity

adb shell settings put system pointer_location 1

adb shell input tap $LANG_X $LANG_Y
adb shell input tap $SEND_X $SEND_Y
adb shell input tap $TYPE_X $TYPE_Y

adb shell input swipe 0 $SCRL_PAGE 0 0 500

adb shell input tap $NAME_X $NAME_Y
typespec "$RCVR_NAME"
adb shell input keyevent $KEY_DEL

adb shell input tap $CITY_X $CITY_Y
typespec "$RCVR_CITY"
adb shell input keyevent $KEY_DEL
sleep $PAUSE
adb shell input tap $CITY_SLCT_X $CITY_SLCT_Y

adb shell input tap $STRE_X $STRE_Y
typespec "$RCVR_STRE"
adb shell input keyevent $KEY_DEL
#sleep $PAUSE
#adb shell input tap $STRE_SLCT_X $STRE_SLCT_Y

adb shell input tap $NUMB_X $NUMB_Y
typespec "$RCVR_NUMB"
adb shell input keyevent $KEY_DEL

adb shell input tap $APRT_X $APRT_Y
typespec "$RCVR_APRT"
adb shell input keyevent $KEY_DEL

adb shell input tap $ZIPC_X $ZIPC_Y
typespec "$RCVR_ZIPC"

adb shell input tap $PHON_X $PHON_Y
typespec "$RCVR_PHON"

adb shell input tap $POST_X $POST_Y

adb shell input swipe 0 $SCRL_PAGE 0 0 500

adb shell input tap $VALE_X $VALE_Y
adb shell input text "$ORDR_PRCE"

adb shell input tap $PRCE_X $PRCE_Y
adb shell input text "$ORDR_PRCE"

adb shell input tap $PYMT_X $PYMT_Y

adb shell input tap $ACNT_X $ACNT_Y
adb shell input text "$SNDR_ACC1"

adb shell input keyevent $KEY_ENT
adb shell input text "$SNDR_ACC2"

adb shell input keyevent $KEY_ENT
adb shell input text "$SNDR_ACC3"

adb shell input tap $ONUM_X $ONUM_Y
adb shell input text "$ORDR_NUMB"

adb shell input swipe 0 $SCRL_PAGE 0 0 500

adb shell input tap $CTNT_X $CTNT_Y
typespec "$ORDR_CTNT"
adb shell input keyevent $KEY_DEL

adb shell input tap $WGHT_X $WGHT_Y
adb shell input text "$ORDR_WGHT"

adb shell input tap $NOTE_X $NOTE_Y
typespec "$ORDR_NOTE"
adb shell input keyevent $KEY_DEL

adb shell input tap $CONF_X $CONF_Y

adb shell settings put system pointer_location 0

adb shell ime set $IME_DFLT
