package social;
import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotPose;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sotatalk.TextToSpeechSota;

public class Control8 {
	static final String TAG = "Control8";
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
							new Short[]{2,-894,-4,896,6,-127,-166,-4}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,500));
			CRobotUtil.wait(500);


			String file = TextToSpeechSota.getTTSFile((String)"次はラボにおけるそーしゃるラーニング支援です．研究知共有・継承を実現するためには，研究活動において生み出される研究知を、意識的に表現・蓄積することが重要です．また，表現された研究知がラボにとって有用なのか、メンバー間で吟味する必要があります．しかし，",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)21700);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1315,-780,-5,-194,73,-286,-9,-6}
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
			file = TextToSpeechSota.getTTSFile((String)"蓄積される情報が多種多様かつ膨大にナルほど，必要な情報や知識を探索する負担が増し，結局共有されずに埋もれるという問題がありました．",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)9000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{2,-894,-4,896,6,-127,-166,-4}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
				}
			CRobotUtil.wait((int)2000);

	//サーボモータのトルクオフ
			CRobotUtil.Log(TAG, "Servo Off");
			motion.ServoOff();
		}
	}
}
