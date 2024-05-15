package mainPackage;

import javax.swing.ImageIcon;

/*狼のクラス*/
public class Wolf extends Animal{
	private static final long serialVersionUID = 1L;
	
	//設定
	protected void prepareImageAndScoreAndVoice() {
		super.image1 = new ImageIcon(getClass().getClassLoader().getResource("wolf01.png")).getImage();
		super.image2 = new ImageIcon(getClass().getClassLoader().getResource("wolf02.png")).getImage();
		super.score = -100;
		super.escapeTime = 200;
		//super.voicekey = "メェー";
	};
	
}