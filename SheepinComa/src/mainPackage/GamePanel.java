package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;	
	//フィールド
	int restTime;
	Timer timer;	
	//レイアウト
	BorderLayout layout = new BorderLayout();
	//コンポーネント
	public MenuBar menuBar;
	FieldPanel fieldPanel;
	
	//リスナー
	MyKeyListener myKeyListener;
	
	GamePanel(){
		this.setLayout(layout);
		this.setBackground(Color.yellow);
		//パネルの生成と設置
		menuBar = new MenuBar();
		fieldPanel = new FieldPanel();
		timer = new Timer(60000,this);
		this.add(menuBar,BorderLayout.NORTH);
		this.add(fieldPanel,BorderLayout.CENTER);
		timer.start();	
	}
	public void prepareComponents() {
		
		menuBar.prepareComponents();
		fieldPanel.prepareComponents();
		
		myKeyListener = new MyKeyListener(this);
	}
	
	public void resetGame() {
		this.fieldPanel.removeAll();
		this.fieldPanel.prepareComponents();
		this.menuBar.removeAll();
		this.menuBar.score = 0;
		this.menuBar.prepareComponents();
	}
	
	//ルール説明ダイアログ
		public void showRuleDialogue() {
			String str = "マウスを操作して制限時間内に羊を囲いへ 狼は穴へ導いてください！";
			JOptionPane.showOptionDialog(
					this,
					str,
					"ルール説明",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					new Object[] {"スタート"},
					"スタート"
					);
		}
		
		//結果を表示するダイアログ
		public void showResultDialogue(int point) {
			String str = "  ゲーム終了！    得点:"+point+"点";
			JOptionPane.showOptionDialog(
					this,
					str,
					"result",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					0
					);
		}
	
	public void actionPerformed(ActionEvent e) {
		timer.start();
		Main.mainWindow.gamePanel.showResultDialogue(menuBar.score);
		Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);
		Main.mainWindow.gamePanel.resetGame();
	}
	
	//内部クラス
	private class MyKeyListener implements KeyListener{
		//貼り付け先の保持
		JPanel panel;
		
		//コンストラクタ
		MyKeyListener(JPanel p){
			super();
			panel = p;
			panel.addKeyListener(this);
		}
		@Override
		public void keyTyped(KeyEvent e) {
			//do nothing
		}
		@Override
		public void keyReleased(KeyEvent e) {
			//do nothing
		}
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_H://Hを押したとき
				Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);
				break;
			}
		}
	}
}