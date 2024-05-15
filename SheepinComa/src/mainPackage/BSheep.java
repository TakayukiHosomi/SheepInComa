package mainPackage;

import javax.swing.ImageIcon;

/*通常の羊のクラス*/
public class BSheep extends Animal{
	private static final long serialVersionUID = 1L;
	
	//設定
	protected void prepareImageAndScoreAndVoice() {
		super.image1 = new ImageIcon(getClass().getClassLoader().getResource("bsheep_run01.png")).getImage();
		super.image2 = new ImageIcon(getClass().getClassLoader().getResource("bsheep_run02.png")).getImage();
		super.score = 200;
		super.escapeTime = 200;
		//super.voicekey = "メェー";
	};
	
}