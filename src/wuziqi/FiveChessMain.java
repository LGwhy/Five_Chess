package wuziqi;

import java.awt.BorderLayout;   //边界布局管理器
import java.awt.Color;          //颜色
import java.awt.Dimension;      //尺寸
import java.awt.FlowLayout;     //布局管理器
import java.awt.Graphics;       //绘制几何图形
 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 
public class FiveChessMain extends JPanel implements FiveChess {
 
 
	public static void main(String[] args) {
		FiveChessMain gm = new FiveChessMain();
		gm.initUI();
	}
 
	public void initUI() {
		JFrame frame = new JFrame("五子棋");
		frame.setSize(780, 635);     //整个界面的长和宽
		frame.setDefaultCloseOperation(3);    //使用System exit（）方法退出程序
		frame.setLocationRelativeTo(null);    //将窗口置于屏幕中央
		frame.setResizable(false);            //false表示生成的窗口不能被用户改变大小，只能通过开发者管理
		frame.setLayout(new BorderLayout());  //设置布局为边框布局
 
		// 设置棋盘面板的背景颜色
		this.setBackground(Color.orange);
		// 将棋盘面板添加到窗体的中间部分
		frame.add(this, BorderLayout.CENTER);
 
		// 实例化JPanel面板对象，作为东边放置按钮的面板
		JPanel eastPanel = new JPanel();
		// 设置东边面板的布局方式为流式布局居中对齐
		eastPanel.setLayout(new FlowLayout());
		// 设置面板容器组件的宽度和高度
		eastPanel.setPreferredSize(new Dimension(150, 0));
 
		// 实例化单选按钮分组对象
		ButtonGroup bg = new ButtonGroup();
 
		// 实例化事件处理类的对象，然后将棋盘面板作为参数传递到GobangListener类的对象中
		FiveChessListenner gl = new FiveChessListenner(this, array);
 
		// 定义数组，存储组件上要显示的文字信息
		String[] array = { "开始新游戏", "悔 棋", "认 输", "对战模式：", "人人模式", "人机模式" };
		for (int i = 0; i < array.length; i++) {
			if (i < 3) {
				JButton button = new JButton(array[i]);
				button.setPreferredSize(new Dimension(140, 80));    //设置界面东边控制按钮的大小
				eastPanel.add(button);      //将控制按钮添加到界面的东边
				button.addActionListener(gl);   //按下按钮就会调用gl的方法，实现按钮对应功能
			} else if (i == 3) {
				JLabel label = new JLabel(array[i]);   //用于显示文字，表示不可单击（即“对战模式”字样）
				eastPanel.add(label);
			} else {
				JRadioButton button = new JRadioButton(array[i]);
				button.setSelected(false);       //表示选项只能二选一，人人或人机
				bg.add(button);
				eastPanel.add(button);
				button.addActionListener(gl);
			}
		}
 
		// 将eastPanel添加到窗体上的东边
		frame.add(eastPanel, BorderLayout.WEST);
		frame.setVisible(true);
	}
 
 
	private ArrayList<Chess> array = new ArrayList<Chess>();
 
	//重绘棋盘，使棋盘从一开始就一直存在
	public void paint(Graphics g) {
		super.paint(g);
		// System.out.println(">>>");
		for (int i = 0; i < coloum; i++) {
			g.drawLine(X, Y + size * i, X + size * (coloum - 1), Y + size * i);// 横线 //格子40
			g.drawLine(X + size * i, Y, X + size * i, Y + size * (coloum - 1));// 竖线 //格子40
		}
 
		for (int i = 0; i < array.getSize(); i++) {
			Chess e = array.get(i);
			g.setColor(e.color);
			g.fillOval(X + e.coloum * size - size / 2, Y + e.row * size - size / 2, size, size);
		}
	}
 
}
