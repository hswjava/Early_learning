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
            suggestLabel = new JLabel("晚上吃啥:     ");
        } else {
            suggestLabel = new JLabel("中午吃啥:     ");
        }
        foodText = new JTextArea("            ");
        foodText.setSize(50,30);
        foodText.setTabSize(100);
        updateButton = new JButton("只能点一次哦");
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
        JButton finalUpdateButton = updateButton;
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int i = random.nextInt(choicesList.size());
                finalFoodText.setText(choicesList.get(i));
				finalUpdateButton.setEnabled(false);
            }
        });
       
        frame.setSize(600, 300);
        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void setList(List choicesList) {
       choicesList.add("肯德基");
       choicesList.add("麻辣烫烫");
       choicesList.add("牛肉粉丝拌饭！");
       choicesList.add("沙拉");
       choicesList.add("炒菜");
       choicesList.add("米线");
       choicesList.add("啥也不吃？？");
//       choicesList.add("外卖");
//       choicesList.add("广西米粉");
    }


}
