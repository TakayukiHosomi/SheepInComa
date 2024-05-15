package mainPackage;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuBar extends JPanel{
	private static final long serialVersionUID = 1L;
	public int score = 0;
	//コンポーネント
	JButton homeButton;
	JLabel homeLabel;
	JLabel scoreLabel;
	//JProgressBar timeLimitBar;
	//Animal animal = new Sheep_Normal();エラー回避用
	
	//リスナー
	HomeButtonListener homeButtonListener;
	
	//コンストラクタ
	public MenuBar(){
		this.setPreferredSize(new Dimension(100,40));
		this.setBackground(Color.red);
		this.setLayout(null);
	}
	
	public void prepareComponents() {
		
		//ホームボタン
		homeButton = new JButton();
		homeButton.setBounds(5,5,80,30);
		homeButton.setText("HOME");
		homeButton.setFocusable(false);
		homeButtonListener = new HomeButtonListener();
		homeButton.addActionListener(homeButtonListener);
		
		//ラベル
		homeLabel = new JLabel("← click this button or press 'h' to home");
		homeLabel.setBounds(100,5,250,30);
		//homeLabel.setBorder(BorderFactory.createEtchedBorder(3,Color.black,Color.white));
		scoreLabel = new JLabel("SCORE :" + score);
		scoreLabel.setBounds(350,5,100,30);
		
		
		/*//プログレスバー
		timeLimitBar = new JProgressBar();
		timeLimitBar.setBounds(500,5,200,30);
		timeLimitBar.setForeground(Color.red);
		timeLimitBar.setFont(new Font("MV Boli",Font.BOLD,25));
		timeLimitBar.setStringPainted(true);*/
		
		//設置
		this.add(homeButton);
		this.add(homeLabel);
		//this.add(timeLimitBar);
		this.add(scoreLabel);
	}
	public void updateScore(Animal animal) {
		score += animal.score;
		scoreLabel.setText("SCORE :" + score);
	}
	
	public void reverseUpdateScore(Animal animal) {
		score -= animal.score;
		scoreLabel.setText("SCORE :" + score);
	}
	
	public void resetScore() {
		this.score = 0;
	}
	
		//内部クラス
		private class HomeButtonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);	
			}
		}
	}		
