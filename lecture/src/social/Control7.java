package social;
import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotPose;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sotatalk.TextToSpeechSota;

public class Control7 {
	static final String TAG = "Control7";
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


			String file = TextToSpeechSota.getTTSFile((String)"まずは、クラスルームにおける、そーしゃるラーニング支援です．ここでは講義活性化の支援のシステムについて紹介します．講義活性化を実現するためには，",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)11000);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1192,-787,-5,-464,67,-282,-270,-9}
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
			file = TextToSpeechSota.getTTSFile((String)"講義中に学生の意見や疑問を収集してクラスルーム全体で蓄積・共有するためのソーシャルメディアが必要となります．そこで大石らの研究では，",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)7000);
			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
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
			CRobotUtil.Log(TAG, "play:" + motion.play(pose,500));
			CRobotUtil.wait(500);
			CRobotUtil.wait((int)3300);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1192,-787,-4,-301,68,-283,-134,-8}
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
			file = TextToSpeechSota.getTTSFile((String)"Twitter",(int)9,(int)5,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)800);

			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
				}
			file = TextToSpeechSota.getTTSFile((String)"を活用して講義の活性化を図るシステムを開発しました．これは講義中の講義活性化支援を行なっており，学習者のツイートの内容を，意見，質問や回答，同意や非同意にタイプ分けして学習理解度を推定します．そして講師は推定された理解度をリアルタイムに把握できるので，それに応じて",(int)11,(int)1,(int)11);
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
			CRobotUtil.wait((int)21900);
			pose = new CRobotPose();
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{-1192,-787,-6,-64,66,-286,50,3}
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
			file = TextToSpeechSota.getTTSFile((String)"講義の展開を変更したり質問に答えることで講義の活性化を図ることができます．",(int)11,(int)1,(int)11);
			if(file!=null){
				if(cplay != null){
					cplay.stop();
				}
				cplay = CPlayWave.PlayWave(file,false);
			}

			CRobotUtil.wait((int)3000);
			try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec("./chgvol.sh down 2");
				p.waitFor(); // プロセス終了を待つ
	            p.destroy(); // プロセスを完全終了
			} catch (Exception e) {
				e.printStackTrace();
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
			CRobotUtil.wait((int)3000);

	//サーボモータのトルクオフ
			CRobotUtil.Log(TAG, "Servo Off");
			motion.ServoOff();
		}
	}
}
