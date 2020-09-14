package TestRandom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class test {
    public static void main(String[] args) {

        JFrame frame = new JFrame("百度原生");

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField url = new JTextField("url");
        url.setBounds(100,20,165,25);

        JTextField key = new JTextField("key");
        key.setBounds(100,50,165,25);

        JButton submit = new JButton("submit");
        submit.setBounds(10, 80, 80, 25);

        JTextField result = new JTextField("result");
        result.setBounds(100,110,165,25);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(url);
        panel.add(key);
        panel.add(submit);
        panel.add(result);

        frame.add(panel);

        frame.setVisible(true);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                String str = url.getText().replace("{{ATYPE}}","activate");
                str = str.replace("{{AVALUE}}","0");
                String url_key=str +key.getText();
                String test = MD5(url_key);
                String finalUrl = str + "&sign=" +test;


                result.setText(finalUrl);
                System.out.println("final:"+finalUrl);

                System.out.println("触发了事件");
            }
        });

    }

    public static String MD5(String a) {
        //定义一个字节数组

        byte[] secretBytes = null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(a.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }

        return md5code;
    }
}


