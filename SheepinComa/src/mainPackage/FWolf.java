package mainPackage;

import javax.swing.ImageIcon;

/*偽羊のクラス*/
public class FWolf extends Animal{
	private static final long serialVersionUID = 1L;
	
	//設定
	protected void prepareImageAndScoreAndVoice() {
		super.image1 = new ImageIcon(getClass().getClassLoader().getResource("fwolf01.png")).getImage();
		super.image2 = new ImageIcon(getClass().getClassLoader().getResource("fwolf02.png")).getImage();
		super.score = -200;
		super.escapeTime = 200;
		//super.voicekey = "メェー";
	};
	
}