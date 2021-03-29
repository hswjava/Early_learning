package TestRandom;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestRandomFrame extends JFrame {
	private JLabel nameLabel = null;
	private JLabel skinLabel = null;
	private JTextArea nameText = null;
	private JTextArea skinText = null;
	private List<String> nameList = null;
	private List<String> skinList = null;
	private JButton updateButton = null;

	TestRandomFrame() {
		this.nameLabel = new JLabel("今天:");
		this.skinLabel = new JLabel("请客吃:");
		this.nameText = new JTextArea("            ");
		this.skinText = new JTextArea("            ");
		this.updateButton = new JButton("suprise");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(this.nameLabel);
		panel.add(this.nameText);
		panel.add(new Label("    "));
		panel.add(this.skinLabel);
		panel.add(this.skinText);
		panel.add(this.updateButton);
		this.setResizable(false);
		this.setContentPane(panel);
		this.setList();
		this.updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				int i = random.nextInt(nameList.size());
				int j = random.nextInt(skinList.size());
				TestRandomFrame.this.nameText.setText(TestRandomFrame.this.nameList.get(i));
				TestRandomFrame.this.skinText.setText(TestRandomFrame.this.skinList.get(j));
//				updateButton.setEnabled(false);
			}
		});
	}

	public static void main(String[] args) {
		TestRandomFrame frame = new TestRandomFrame();
		frame.setSize(600, 300);
		frame.setVisible(true);
	}
	
	public void setList() {
		this.nameList = new ArrayList<String>();
		this.nameList.add("Frank");
		this.nameList.add("萌萌子");
		this.nameList.add("反麦劳派-灭顶师太（板烧堡除外");
		this.nameList.add("不常联系的sunrui");

		
		this.skinList = new ArrayList<String>();
		this.skinList.add("大螃蟹");
		this.skinList.add("小酥肉");
		this.skinList.add("金元宝");
//		this.skinList.add("西部牛仔 亚索");
//		this.skinList.add("西部魔影 德莱厄斯");
//		this.skinList.add("宇航员 诺提勒斯");
//		this.skinList.add("屠龙勇士 赵信");
//		this.skinList.add("源计划 联合");
//		this.skinList.add("灌篮高手 德莱厄斯");
//		this.skinList.add("源计划 雷 卢锡安");

	}
}
