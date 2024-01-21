package history;
import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotPose;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sotatalk.TextToSpeechSota;

public class Experimental4 {
	static final String TAG = "Experimental4";
	public static void main(String[] args) {
		CRobotUtil.Log(TAG, "Start " + TAG);

		CPlayWave cplay = null;
		CRobotPose pose;
		//VSMDと通信ソケット・メモリアクセス用クラス
		CRobotMem mem = new CRobotMem();
		//Sota用モーション制御クラス
		CSotaMotion motion = new CSotaMotion(mem);

		if(mem.Connect()){
			//Sota仕様にVSMDを初期化
			motion.InitRobot_Sota();

			CRobotUtil.Log(TAG, "Rev. " + mem.FirmwareRev.get());

			//サーボモータを現在位置でトルクOnにする
			CRobotUtil.Log(TAG, "Servo On");
			motion.ServoOn();

			String file = TextToSpeechSota.getTTSFile((String)"人工知能の、",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-3,-561,-655,281,778,-879,50,8}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,700));
			CRobotUtil.wait(700);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-3,-561,-655,281,778,-879,50,8}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,700));
			CRobotUtil.wait(700);


			file = TextToSpeechSota.getTTSFile((String)"あのー",(int)7,(int)10,(int)3);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{0,-905,-166,-583,270,991,35,1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1500));
			CRobotUtil.wait(1500);


			file = TextToSpeechSota.getTTSFile((String)"起源は1956年より昔になります．この時代は、",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-623,-703,459,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-464,-702,626,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-623,-703,459,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,900));
			CRobotUtil.wait(900);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-464,-702,626,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,900));
			CRobotUtil.wait(900);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-389,-755,-227,648,177,-1106,-148,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,900));
			CRobotUtil.wait(900);


			file = TextToSpeechSota.getTTSFile((String)"えーっと",(int)7,(int)10,(int)3);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-14,-715,-634,722,641,5,50,7}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,2000));
			CRobotUtil.wait(2000);


			file = TextToSpeechSota.getTTSFile((String)"機械による計算が可能となり，コンピュータが開発されると，",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-389,-755,-227,648,177,-1106,-148,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1300));
			CRobotUtil.wait(1300);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-389,-755,-227,648,177,-1106,-148,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1300));
			CRobotUtil.wait(1300);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-389,-755,-227,648,177,-1106,-148,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1300));
			CRobotUtil.wait(1300);


			file = TextToSpeechSota.getTTSFile((String)"あのー",(int)7,(int)10,(int)3);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{0,-905,-166,-583,270,991,35,1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);


			file = TextToSpeechSota.getTTSFile((String)"今まで哲学・数学・論理学・",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-623,-703,459,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,900));
			CRobotUtil.wait(900);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-464,-702,626,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,900));
			CRobotUtil.wait(900);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-623,-703,459,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,900));
			CRobotUtil.wait(900);


			file = TextToSpeechSota.getTTSFile((String)"えーっと",(int)7,(int)10,(int)3);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-14,-715,-634,722,641,5,50,7}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1500));
			CRobotUtil.wait(1500);


			file = TextToSpeechSota.getTTSFile((String)"心理学などの分野で論じられていた「人間の知的活動を行う機械」を作る試みが、",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,346,-273,647,177,-1236,-150,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,618,-168,648,177,-1236,-150,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,346,-273,647,177,-1236,-150,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,618,-168,648,177,-1236,-150,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,346,-273,647,177,-1236,-150,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1100));
			CRobotUtil.wait(1100);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,618,-168,648,177,-1236,-150,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1100));
			CRobotUtil.wait(1100);


			file = TextToSpeechSota.getTTSFile((String)"あのー",(int)7,(int)10,(int)3);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{0,-905,-166,-583,270,991,35,1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1500));
			CRobotUtil.wait(1500);


			file = TextToSpeechSota.getTTSFile((String)"開始します．そして，",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-389,-755,-227,648,177,-1106,-148,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-389,-755,-227,648,177,-1106,-148,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);


			file = TextToSpeechSota.getTTSFile((String)"あのー",(int)7,(int)10,(int)3);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{0,-905,-166,-583,270,991,35,1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,2000));
			CRobotUtil.wait(2000);


			file = TextToSpeechSota.getTTSFile((String)"1956年，マッカーシーらが発起人となった ダートマス会議という研究発表会で，この研究分野がArtificial Intelligenceつまり人工知能と呼ばれるようになりました．",(int)13,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-389,-755,-227,648,177,-1106,-148,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,2000));
			CRobotUtil.wait(2000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-389,-755,-227,648,177,-1106,-148,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,2000));
			CRobotUtil.wait(2000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1073,-899,-3,-197,66,-324,-123,-2}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1073,-899,-3,-197,66,-324,-123,-2}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,2000));
			CRobotUtil.wait(2000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-623,-703,459,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-464,-702,626,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-623,-703,459,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-464,-702,626,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-623,-703,459,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-4,-464,-702,626,845,4,50,9}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);


			//サーボモータのトルクオフ
			CRobotUtil.Log(TAG, "Servo Off");
			motion.ServoOff();
		}
	}
}
