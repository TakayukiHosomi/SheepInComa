package mainPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FieldPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	Color backgroundColor = Color.GREEN;
	
	Animal animal;
	MenuBar menuBar;
	
	Circle circle;
	Hole hole;
	
	Timer timer,timer2;
	
	
	public FieldPanel(){
		this.setLayout(null);
		this.setBackground(backgroundColor);
		AutoAnimalGenerate autoAnimalGenerate = new AutoAnimalGenerate();
		timer2 = new Timer(2000,autoAnimalGenerate);
		timer2.start();
	}
	
	
	
	protected void prepareComponents(){
		circle = new Circle();
		circle.setLocation(600,250);
		this.add(circle);
		hole = new Hole();
		hole.setLocation(0,250);
		this.add(hole);
		generateAnimal(animal);
	}
	
	//にリスナーを付けてからパネルに貼るメソッド
		public void generateAnimal(Animal a) {
			int r =  new java.util.Random().nextInt(1000);
			
			Animal animal;
			if(r < 600) {
				animal = new Sheep_Normal();
			}else if(r < 600+200){
				animal = new BSheep();
			}else if(r <600+200+150) {
				animal = new Wolf();
			}else{
				animal = new FWolf();
			}
			new DDListener(animal);
			AnimalActionListener animalListener = new AnimalActionListener(animal);
			animal.timer = new Timer(10,animalListener);
			this.add(animal);
			animal.timer.start();
		
			
		}
		
	private class AnimalActionListener implements ActionListener{
		//貼り付け先を保持する
		private Animal animal;
		
		public AnimalActionListener(Animal a) {
			animal = a;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(animal.x>Main.mainWindow.getWidth() - animal.getWidth() || animal.x<0) {
					animal.xVelocity = animal.xVelocity*(-1);
			}
			animal.x = animal.x + animal.xVelocity;
			if(animal.y > Main.mainWindow.getHeight() - animal.getHeight() || animal.y<0) {
					animal.yVelocity = animal.yVelocity*(-1);
			}
			animal.y = animal.y + animal.yVelocity;
			animal.setLocation(animal.x,animal.y);
			animal.repaint();
		}
	}
	
	private class AutoAnimalGenerate implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			generateAnimal(animal);
		}
	}
	

	private class DDListener extends MouseAdapter{
		//貼り付け先を保持する
		private int dx;
		private int dy;
		private Animal animal;
		
		//内部クラスのコンストラクタ
		DDListener(Animal a) {
			//引数としてadd先のコンポーネントを指定しておく
			animal = a;
			animal.addMouseListener(this);
			animal.addMouseMotionListener(this);
		}
		
		public void mousePressed(MouseEvent e) {
			//押さえたところからラベルの左上の差をとっておく
			dx = e.getXOnScreen() - animal.getX();
			dy = e.getYOnScreen() - animal.getY(); 
		}
		
		public void mouseDragged(MouseEvent e) {
			//マウスの座標からラベルの左上の座標を取得する
			int x = e.getXOnScreen() - dx;
			int y = e.getYOnScreen() - dy;
			if(x < Main.mainWindow.getWidth() - animal.getWidth()-5 && x > 5) {animal.x = x;}
			if(y < Main.mainWindow.getHeight() - animal.getHeight()-5 && y > 5) {animal.y = y;}
			animal.setLocation(animal.x,animal.y);
		}
		
		public void mouseReleased(MouseEvent e) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			int px = (int) circle.getLocationOnScreen().getX();
			int py = (int) circle.getLocationOnScreen().getY();
			int hpx = (int) hole.getLocationOnScreen().getX();
			int hpy = (int) hole.getLocationOnScreen().getY();
			int ph = circle.getHeight();
			int pw = circle.getWidth();
			int hph = hole.getHeight();
			int hpw = hole.getWidth();
			if((px < x)&&(x < px + pw)&&(py < y)&&(y < py + ph)) {
				animal.setVisible(false);
				GamePanel gamePanel = (GamePanel) getParent();
				menuBar = gamePanel.menuBar;
				menuBar.updateScore(animal);
				//generateAnimal(animal);//重くなるので一旦停止
				
				// 再描画要求

				//repaint();
				}else if((hpx < x)&&(x < hpx + hpw)&&(hpy < y)&&(y < hpy + hph)) {
					animal.setVisible(false);
					GamePanel gamePanel = (GamePanel) getParent();
					menuBar = gamePanel.menuBar;
					menuBar.reverseUpdateScore(animal);
				}
		}
		}
	}	
