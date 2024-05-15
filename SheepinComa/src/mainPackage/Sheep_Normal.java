package mainPackage;

import javax.swing.ImageIcon;

/*通常の羊のクラス*/
public class Sheep_Normal extends Animal{
	private static final long serialVersionUID = 1L;
	
	Animal animal;
	//設定
	protected void prepareImageAndScoreAndVoice() {
		super.image1 = new ImageIcon(getClass().getClassLoader().getResource("sheep_run01.png")).getImage();
		super.image2 = new ImageIcon(getClass().getClassLoader().getResource("sheep_run02.png")).getImage();
		super.score = 100;
		super.escapeTime = 200;
		//super.voicekey = "メェー";
		
	};
	//prepareComponents();を参考としてコメント化し残して置く
	/*public void prepareComponents() {
		
	}
	//画像の描画（反転処理を含む）
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2D = (Graphics2D) g;
			if(xVelocity >= 0) {
				g2D.drawImage(image1, 0, 0, image1.getWidth(null),image.getHeight(null),null);
			}else {
				g2D.drawImage(image2, image2.getWidth(null), 0, -image.getWidth(null),image.getHeight(null),null);
			}
		}*/
}