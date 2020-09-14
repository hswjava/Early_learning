package TestRandom;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author: create by hsw
 * @description: TestRandom
 * @date:2020/6/11
 **/
public class EatWhat {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel suggestLabel = null;
        JTextArea foodText = null;
        List<String> choicesList = new ArrayList<>();
        JButton updateButton = null;
        if(new Date().getHours()>15) {
            suggestLabel = new JLabel("���ϳ�ɶ:     ");
        } else {
            suggestLabel = new JLabel("�����ɶ:     ");
        }
        foodText = new JTextArea("            ");
        foodText.setSize(50,30);
        foodText.setTabSize(100);
        updateButton = new JButton("bingo");
        updateButton.setSize(20,20);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(suggestLabel);
        panel.add(foodText);
        panel.add(updateButton);
//        frame.setResizable(false);
        frame.add(panel);
        setList(choicesList);
        JTextArea finalFoodText = foodText;
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int i = random.nextInt(choicesList.size());
                finalFoodText.setText(choicesList.get(i));
//				updateButton.setEnabled(false);
            }
        });
       
        frame.setSize(600, 300);
        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void setList(List choicesList) {
       choicesList.add("������");
       choicesList.add("���з�");
       choicesList.add("����");
       choicesList.add("�����");
       choicesList.add("����");
       choicesList.add("��Ԫ��");
       choicesList.add("�󵱵�");
       choicesList.add("����");
       choicesList.add("�����׷�");
    }
}
