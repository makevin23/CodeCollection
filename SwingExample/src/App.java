import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

public class App {

    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Bowling");
        // Setting the width and height of frame
        frame.setSize(630, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /*
         * 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        Border blackline = BorderFactory.createLineBorder(Color.black);

        // 创建 JLabel
        // JLabel frame1 = new JLabel("1", SwingConstants.CENTER);
        /*
         * 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */

        JLabel[] tryScores = new JLabel[10];
        JLabel[] frameScores = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            JLabel frameNumber = new JLabel(Integer.toString(i+1), SwingConstants.CENTER);
            int x = 20 + i * 60;
            frameNumber.setBounds(x, 10, 40, 40);
            frameNumber.setBorder(blackline);
            frameNumber.setBackground(Color.GREEN);
            frameNumber.setFont(new Font("Serif", Font.PLAIN, 14));
            panel.add(frameNumber);

            tryScores[i] = new JLabel("/", SwingConstants.CENTER);
            tryScores[i].setBounds(x, 60, 40, 40);
            tryScores[i].setBorder(blackline);
            panel.add(tryScores[i]);

            frameScores[i] = new JLabel("0", SwingConstants.CENTER);
            frameScores[i].setBounds(x, 110,40,40);
            frameScores[i].setBorder(blackline);
            panel.add(frameScores[i]);

        }

        /*
         * 创建文本域用于用户输入
         */
        // JTextField userText = new JTextField(20);
        // userText.setBounds(100,20,165,25);
        // panel.add(userText);

        // 输入密码的文本域
        // JLabel passwordLabel = new JLabel("Password:");
        // passwordLabel.setBounds(10,50,80,25);
        // panel.add(passwordLabel);

        /*
         * 这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        // JPasswordField passwordText = new JPasswordField(20);
        // passwordText.setBounds(100,50,165,25);
        // panel.add(passwordText);

        // 创建登录按钮
        // JButton loginButton = new JButton("login");
        // loginButton.setBounds(10, 80, 80, 25);
        // panel.add(loginButton);
    }

}