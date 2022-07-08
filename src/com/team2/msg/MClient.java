package com.team2.msg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MClient extends JFrame {

	private static final long serialVersionUID = 7231189399337160321L;
	
	TopPanel tp;
	SidePanel sp;
	String basePath = new File("").getAbsolutePath();

	void init(){
		setTitle("nate");
		setSize(616, 899);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTopPanel();
		setSidePanel();
		setVisible(true);
	}
	
	void setTopPanel() {
		this.tp = new TopPanel(this);
		tp.init();
		add(tp);
	}
	
	void setSidePanel() {
		this.sp = new SidePanel(this);
		sp.init();
		add(sp);
	}
	
	Image returnImg(String path, int size1, int size2) {
		path = basePath + path;
		Image img = null;
		try {
			BufferedImage bufferedImage = null;
			try {
				bufferedImage = ImageIO.read(new File(path));
			} catch (Exception e) {
			}
			img = bufferedImage.getScaledInstance(size1, size2, Image.SCALE_DEFAULT);
		} catch (Exception ex) {
			//System.out.println(ex);
		}
		return img;
	}
	
	public static void main(String[] args) {
		new MClient().init();
	}

}

class SidePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = -7425208015039263564L;
	String basePath;
	JButton menuBtn;
	
	MClient mc;
	SidePanel(MClient mc){
		this.mc = mc;
		this.basePath = mc.basePath;
	}
	
	void init() {
		setVisible(true);
		setBounds(0, 80, 80, 780);
		setLayout(null);
		setBackground(new Color(61, 71, 96));
		setMenuIcons();
	}
	
	void setMenuIcons() {
		menuBtn = new JButton(new ImageIcon(basePath + "/src/img/menu-icon.png"));
		menuBtn.setBounds(15, 705, 50, 50);
		menuBtn.setBorderPainted(false);
		menuBtn.setContentAreaFilled(false);
		menuBtn.setBackground(new Color(61, 71, 96, 255));
		menuBtn.addMouseListener(this);
		//menuBtn.addActionListener(e ->{});
		add(menuBtn);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


class TopPanel extends JPanel {

	private static final long serialVersionUID = -4631653087150898814L;
	String basePath;
	
	MClient mc;
	TopPanel(MClient mc){
		this.mc = mc;
		this.basePath = mc.basePath;
	}
	
	void init() {
		setVisible(true);
		//setBackground(Color.black);
		setBounds(0, 0, 600, 120);
		setLayout(null);
		setLogoLabel();
		setTopLabel();
	}
	
	void setLogoLabel() {
		JLabel logoLabel = new JLabel(new ImageIcon(basePath + "/src/img/nate-icon.png"));
		logoLabel.setBounds(0, 0, 80, 120);
		logoLabel.setBackground(new Color(87, 94, 118));
		logoLabel.setOpaque(true);
		add(logoLabel);
	}
	
	void setTopLabel() {
		JLabel topLabel = new JLabel(new ImageIcon(basePath + "/src/img/adImage.png"));
		topLabel.setBounds(80, 0, 520, 120);
		add(topLabel);
	}
	
	
}
