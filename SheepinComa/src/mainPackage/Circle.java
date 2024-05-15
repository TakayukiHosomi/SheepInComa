package mainPackage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//囲いのラベル
public class Circle extends JLabel{
	private static final long serialVersionUID = 1L;
	//フィールド
	ImageIcon image;
	//int x = 650;
	//int y = 375;
	//コンストラクタ
	public Circle(){
		//画像の設定
		image = new ImageIcon(getClass().getClassLoader().getResource("circle.png"));
		//sheepImage2 = new ImageIcon(getClass().getClassLoader().getResource("sheep_run02.png")).getImage();
		//貼り付け先の位置とラベルサイズを設定（画像サイズにあわせたサイズ）
		this.setSize(300,375);
		this.setIcon(image);
		this.setText("↓ DROP HERE");
		this.setHorizontalTextPosition(CENTER);
		this.setVerticalTextPosition(TOP);
		//位置設定
		//this.setLocation(x,y);
	}
}