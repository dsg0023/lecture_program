package history;
import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotPose;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sotatalk.TextToSpeechSota;

public class Control10 {
	static final String TAG = "Control10";
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

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-2,-898,-5,891,9,-125,-155,1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,500));
			CRobotUtil.wait(500);


			String file = TextToSpeechSota.getTTSFile((String)"最後に学習支援システムの例としてBUGGYシステムの紹介をして終わります．これは筆算の学習を支援するシステムで，筆算でしばしば起こる誤りを指摘することができます．BUGGYシステムは，誤りを指摘するために，筆算教材知識の",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)18000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1197,-794,-14,847,63,-749,-51,1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,255,0,0,255,0,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);


			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh up 2");
				p.waitFor(); // プロセス終了を待つ
				p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
				}
			file = TextToSpeechSota.getTTSFile((String)"バグモデル",(int)9,(int)5,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)1100);

			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
				}
			file = TextToSpeechSota.getTTSFile((String)"を持っています．",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-2,-898,-5,891,9,-125,-155,1}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			CRobotUtil.wait((int)200);


			file = TextToSpeechSota.getTTSFile((String)"これは，筆算で用いられる誤った知識をバグ知識としてモデル化したものです．",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,true);
			}

	//サーボモータのトルクオフ
			CRobotUtil.Log(TAG, "Servo Off");
			motion.ServoOff();
		}
	}
}
