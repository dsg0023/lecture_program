package history;
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


			String file = TextToSpeechSota.getTTSFile((String)"そして，このMYCINをベースとして，",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)2000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1181,-794,-13,-459,61,-279,-270,-10}
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
			file = TextToSpeechSota.getTTSFile((String)"診断法の教授を行う",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)1800);

			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
				}
			file = TextToSpeechSota.getTTSFile((String)"ガイドンという学習支援システムの設計や開発がクランシーによって行われました．クランシーはこのガイドンの設計を通して，MYCINのif thenルールだけ教えても，医学生の育成には不十分である，",(int)11,(int)1,(int)11);
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
			CRobotUtil.wait((int)13800);


			file = TextToSpeechSota.getTTSFile((String)"つまり，　if-thenが成立している原理を教える必要があることに気づき，MYCINの知識ベースをさらに発展させて医療診断に必要となる知識を構築し，ガイドンをシステム化、しました．これをきっかけに学習者にとってよりわかりやすい教授法や学習の仕方を追求する学問として",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)21000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1181,-794,-13,846,61,-746,50,-8}
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
			file = TextToSpeechSota.getTTSFile((String)"学習工学",(int)9,(int)5,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)1200);

			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
				}
			file = TextToSpeechSota.getTTSFile((String)"が誕生しました．",(int)11,(int)1,(int)11);
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
			CRobotUtil.wait((int)2000);

	//サーボモータのトルクオフ
			CRobotUtil.Log(TAG, "Servo Off");
			motion.ServoOff();
		}
	}
}
