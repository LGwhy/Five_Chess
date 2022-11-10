package wuziqi;

import java.awt.BorderLayout;   //�߽粼�ֹ�����
import java.awt.Color;          //��ɫ
import java.awt.Dimension;      //�ߴ�
import java.awt.FlowLayout;     //���ֹ�����
import java.awt.Graphics;       //���Ƽ���ͼ��
 
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
		JFrame frame = new JFrame("������");
		frame.setSize(780, 635);     //��������ĳ��Ϳ�
		frame.setDefaultCloseOperation(3);    //ʹ��System exit���������˳�����
		frame.setLocationRelativeTo(null);    //������������Ļ����
		frame.setResizable(false);            //false��ʾ���ɵĴ��ڲ��ܱ��û��ı��С��ֻ��ͨ�������߹���
		frame.setLayout(new BorderLayout());  //���ò���Ϊ�߿򲼾�
 
		// �����������ı�����ɫ
		this.setBackground(Color.orange);
		// �����������ӵ�������м䲿��
		frame.add(this, BorderLayout.CENTER);
 
		// ʵ����JPanel��������Ϊ���߷��ð�ť�����
		JPanel eastPanel = new JPanel();
		// ���ö������Ĳ��ַ�ʽΪ��ʽ���־��ж���
		eastPanel.setLayout(new FlowLayout());
		// ���������������Ŀ�Ⱥ͸߶�
		eastPanel.setPreferredSize(new Dimension(150, 0));
 
		// ʵ������ѡ��ť�������
		ButtonGroup bg = new ButtonGroup();
 
		// ʵ�����¼�������Ķ���Ȼ�����������Ϊ�������ݵ�GobangListener��Ķ�����
		FiveChessListenner gl = new FiveChessListenner(this, array);
 
		// �������飬�洢�����Ҫ��ʾ��������Ϣ
		String[] array = { "��ʼ����Ϸ", "�� ��", "�� ��", "��սģʽ��", "����ģʽ", "�˻�ģʽ" };
		for (int i = 0; i < array.length; i++) {
			if (i < 3) {
				JButton button = new JButton(array[i]);
				button.setPreferredSize(new Dimension(140, 80));    //���ý��涫�߿��ư�ť�Ĵ�С
				eastPanel.add(button);      //�����ư�ť��ӵ�����Ķ���
				button.addActionListener(gl);   //���°�ť�ͻ����gl�ķ�����ʵ�ְ�ť��Ӧ����
			} else if (i == 3) {
				JLabel label = new JLabel(array[i]);   //������ʾ���֣���ʾ���ɵ�����������սģʽ��������
				eastPanel.add(label);
			} else {
				JRadioButton button = new JRadioButton(array[i]);
				button.setSelected(false);       //��ʾѡ��ֻ�ܶ�ѡһ�����˻��˻�
				bg.add(button);
				eastPanel.add(button);
				button.addActionListener(gl);
			}
		}
 
		// ��eastPanel��ӵ������ϵĶ���
		frame.add(eastPanel, BorderLayout.WEST);
		frame.setVisible(true);
	}
 
 
	private ArrayList<Chess> array = new ArrayList<Chess>();
 
	//�ػ����̣�ʹ���̴�һ��ʼ��һֱ����
	public void paint(Graphics g) {
		super.paint(g);
		// System.out.println(">>>");
		for (int i = 0; i < coloum; i++) {
			g.drawLine(X, Y + size * i, X + size * (coloum - 1), Y + size * i);// ���� //����40
			g.drawLine(X + size * i, Y, X + size * i, Y + size * (coloum - 1));// ���� //����40
		}
 
		for (int i = 0; i < array.getSize(); i++) {
			Chess e = array.get(i);
			g.setColor(e.color);
			g.fillOval(X + e.coloum * size - size / 2, Y + e.row * size - size / 2, size, size);
		}
	}
 
}
