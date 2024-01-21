#!	/bin/sh
CURRENT=$(cd $(dirname /home/vstone/vstonemagic/volume/chgvol.sh) && pwd)
cd $CURRENT

#音量値テーブルの読み込み(A_VOLUME[],MAX)
. ${CURRENT}/speakerconf

#現在値がA_VOLUMEのどの番地に属するか判定する関数
searchSpkVol(){
	set `amixer -D "hw:CODEC" get Speaker | grep 'Front Left: Playback'`
	
	#スピーカーの%値を取得
	VOLUME_P=`echo $5 | cut -d"[" -f2 | cut -d"%" -f1`
	
	if [ ${VOLUME_P} -ne 100 ] ; then
		ADDRESS=0
		for i in "${A_VOLUME[@]}"
		do
			if [ ${VOLUME_P} -le ${i} ] ; then
				break
			fi
			ADDRESS=$((ADDRESS + 1))
		done
	else
		ADDRESS=$((MAX - 1))
	fi
	
	VOLUME=$((ADDRESS + 1))
}

#音量を設定する関数
setSpkVol(){
	#sotaconfに値を渡すために以下のechoは必須
	echo ${1}
	SET_VOL=$(($1 - 1))
	amixer -D "hw:CODEC" sset Speaker ${A_VOLUME[$SET_VOL]}%
}

#一個目の引数はset/up/downのいずれか．二個目の引数に数値
#メイン処理		
if [ ${1} = "set" ] ; then
	if [ ${2} -ge 1 ] && [ ${2} -le ${MAX} ] ; then
		setSpkVol ${2}
	else
		echo '[err][speakerctl]set value is invaild' 1>&2
		exit 1
	fi
	
elif [ ${1} = "up" ] ; then
	up=${2}
	searchSpkVol
	if [ ${VOLUME} -ne ${MAX} ] && [ $((VOLUME + $up)) -le ${MAX} ] && [ $((VOLUME + $up)) -ge 1 ] ; then
		setSpkVol $((VOLUME + $up))
	else
		setSpkVol ${MAX}
	fi

elif [ ${1} = "down" ] ; then
	down=${2}
	searchSpkVol
	if [ ${VOLUME} -ne 1 ] && [ $((VOLUME - $down)) -le ${MAX} ] && [ $((VOLUME - $down)) -ge 1 ]; then
		setSpkVol $((VOLUME - $down))
	else
		setSpkVol 1
	fi
	
else
	echo '[err][speakerctl]invaild command' 1>&2
	exit 1

fi
