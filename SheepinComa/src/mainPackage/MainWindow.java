package mainPackage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	ScreenMode screenMode = ScreenMode.GAME;
	
	final int WIDTH = 800;
	final int HEIGHT = 600;
	
	CardLayout layout = new CardLayout();
	
	TitlePanel titlePanel;
	GamePanel gamePanel;
	MenuBar menuBar;
	
	MainWindow(){
		this.setTitle("SheepInComa");
		//ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(null));
		//this.setIconImage(icon.getImage());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.green);
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void preparePanels(){
		
		titlePanel = new TitlePanel();
		this.add(titlePanel,"タイトル画面");
		gamePanel = new GamePanel();
		this.add(gamePanel,"ゲーム画面");
		menuBar = new MenuBar();
		this.add(menuBar,"メニューバー");
		this.pack();
	}
	
	public void prepareComponents() {
			this.titlePanel.prepareComponents();
			this.gamePanel.prepareComponents();
		}
	
	public void setFrontScreenAndFocus(ScreenMode s) {
		screenMode = s;
		
		switch(screenMode) {
		case TITLE:
			layout.show(this.getContentPane(),"タイトル画面");
			titlePanel.requestFocus();
			gamePanel.resetGame();
			break;
		case GAME:
			layout.show(this.getContentPane(),"ゲーム画面");
			gamePanel.requestFocus();
			break;
		}
	}
	
}