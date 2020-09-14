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
		this.nameLabel = new JLabel("Name:");
		this.skinLabel = new JLabel("Skin:");
		this.nameText = new JTextArea("            ");
		this.skinText = new JTextArea("            ");
		this.updateButton = new JButton("�齱");
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
		this.nameList.add("�̻�����");
		this.nameList.add("�̻�����");
		this.nameList.add("���ƽ�");
		this.nameList.add("�ޱ���ľ");
		this.nameList.add("skpskp");
		this.nameList.add("�¾��θ�.avi");
		
		this.skinList = new ArrayList<String>();
		this.skinList.add("δ��սʿ EZ");
		this.skinList.add("�������� ����˿");
		this.skinList.add("�Ⱥ�֮�� ��");
		this.skinList.add("����ţ�� ����");
		this.skinList.add("����ħӰ ������˹");
		this.skinList.add("�Ա ŵ����˹");
		this.skinList.add("������ʿ ����");
		this.skinList.add("Դ�ƻ� ����");
		this.skinList.add("�������� ������˹");
		this.skinList.add("Դ�ƻ� �� ¬����");

	}
}
