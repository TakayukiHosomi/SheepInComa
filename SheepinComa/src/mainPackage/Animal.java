package mainPackage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.Timer;

/*動物用抽象クラス
そのままインスタンス化できない
捕まえたときの画像、スコアなどをサブクラスで具象化する*/

public abstract class Animal extends JLabel{
	private static final long serialVersionUID = 1L;
	Image image1;	//100×100の画像を指定
	Image image2;
	public int score;		//捕獲時の特典
	Timer timer = null;	//その個体の動きの制御用
	int escapeTime = 500; //時間経過で消える用
	//座標と速度
	int x;
	int y;
	int xVelocity;
	int yVelocity;
	
	//コンストラクタ
	public Animal() {
		x = new java.util.Random().nextInt(600);
		y = new java.util.Random().nextInt(300);
		
		do {
			xVelocity = -5 + new java.util.Random().nextInt(11);
			yVelocity = -5 + new java.util.Random().nextInt(11);
		}while(xVelocity == 0 || yVelocity == 0);
		this.prepareImageAndScoreAndVoice();
		this.setBounds(x,y,image1.getWidth(null),image1.getHeight(null));
		this.setBounds(x,y,image2.getWidth(null),image2.getHeight(null));
		}
	//設定(子クラスで必ず設定すること）
	protected abstract void prepareImageAndScoreAndVoice();
	
	//画像の描画（反転処理を含む）
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		if(xVelocity >= 0) {
			g2D.drawImage(image1,0,0,image1.getWidth(null),image1.getHeight(null),null);
		}else {
			g2D.drawImage(image2,0,0,image2.getWidth(null),image2.getHeight(null),null);
		}
	}
}
