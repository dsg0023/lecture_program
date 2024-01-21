package history;
import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotPose;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sotatalk.TextToSpeechSota;

public class Experimental10 {
	static final String TAG = "Experimental10";
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

			String file = TextToSpeechSota.getTTSFile((String)"最後に学習支援システムの例として、",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,-544,-715,316,732,-1111,-139,-6}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1400));
			CRobotUtil.wait(1400);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,-544,-715,316,732,-1111,-139,-6}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1400));
			CRobotUtil.wait(1400);


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


			file = TextToSpeechSota.getTTSFile((String)"BUGGYシステムの紹介をして終わります．これは筆算の学習を、",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,-470,-715,459,731,-1112,-139,-6}
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
							new Short[]{-390,-343,-715,579,730,-1112,-138,-5}
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
							new Short[]{-390,-544,-715,316,732,-1111,-139,-6}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1200));
			CRobotUtil.wait(1200);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-390,-343,-715,579,730,-1112,-138,-5}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1200));
			CRobotUtil.wait(1200);


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


			file = TextToSpeechSota.getTTSFile((String)"支援するシステムで，筆算でしばしば起こる誤りを、",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-382,-765,-225,652,176,-1111,-142,-5}
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
							new Short[]{-384,661,-93,652,172,-1107,-141,-1}
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
							new Short[]{-386,348,-344,653,172,-1108,-141,-2}
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
							new Short[]{-386,348,-344,653,172,-1108,-141,-2}
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
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);


			file = TextToSpeechSota.getTTSFile((String)"指摘することができます．BUGGYシステムは，誤りを、",(int)11,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-382,-765,-225,652,176,-1111,-142,-5}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,2100));
			CRobotUtil.wait(2100);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-384,661,-93,652,172,-1107,-141,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,2100));
			CRobotUtil.wait(2100);


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


			file = TextToSpeechSota.getTTSFile((String)"指摘するために，筆算教材知識のバグモデルを持っています．これは，",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-384,661,-93,652,172,-1107,-141,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1700));
			CRobotUtil.wait(1700);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-386,348,-344,653,172,-1108,-141,-2}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1700));
			CRobotUtil.wait(1700);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-384,661,-93,652,172,-1107,-141,-1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1700));
			CRobotUtil.wait(1700);


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
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);


			file = TextToSpeechSota.getTTSFile((String)"筆算で用いられる、",(int)12,(int)13,(int)5);
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


			file = TextToSpeechSota.getTTSFile((String)"誤った知識をバグ知識として、",(int)12,(int)13,(int)5);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

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
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1200));
			CRobotUtil.wait(1200);
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
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1200));
			CRobotUtil.wait(1200);


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


			file = TextToSpeechSota.getTTSFile((String)"モデル化したものです．",(int)12,(int)13,(int)5);
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
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1800));
			CRobotUtil.wait(1800);


			//サーボモータのトルクオフ
			CRobotUtil.Log(TAG, "Servo Off");
			motion.ServoOff();
		}
	}
}
