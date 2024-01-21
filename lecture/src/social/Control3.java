package social;
import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotPose;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sotatalk.TextToSpeechSota;

public class Control3 {
	static final String TAG = "Control3";
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


			String file = TextToSpeechSota.getTTSFile((String)"Webが活用できる昨今では，知っていることはさほど重要ではありません．知識を使って問題を解決すること，特に、周りと協調しながら解決することが重要視されています．また，学習者個人の学びに加えて，ソーシャルな文脈における周囲とのインタラクションを通して学ぶことが必要不可欠です．こうしたソーシャルな文脈での学習は、",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,true);
			}



			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh up 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
				}
			file = TextToSpeechSota.getTTSFile((String)"そーしゃるラーニング",(int)9,(int)5,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1193,-787,-4,-103,66,-288,12,3}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,255,0,0,255,0,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1000));
			CRobotUtil.wait(1000);
			CRobotUtil.wait((int)500);

			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
			}
			file = TextToSpeechSota.getTTSFile((String)"と、呼ばれています．",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,true);
			}



			file = TextToSpeechSota.getTTSFile((String)"学校教育でも，",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

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
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,1500));
			CRobotUtil.wait(1500);


			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh up 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
				}
			file = TextToSpeechSota.getTTSFile((String)"個人に対する知識伝達だけでなく，協調的な学習などが実施され",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1193,-787,-5,60,66,-282,50,4}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,255,0,0,255,0,0}
							);
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,700));
			CRobotUtil.wait(700);
			CRobotUtil.wait((int)5000);

			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
			}
			file = TextToSpeechSota.getTTSFile((String)"ソーシャルな文脈で学ぶスキルの習得に力点が置かれるようになってきています．",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

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
			CRobotUtil.wait((int)5000);

	//サーボモータのトルクオフ
			CRobotUtil.Log(TAG, "Servo Off");
			motion.ServoOff();
		}
	}
}
