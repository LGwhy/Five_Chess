package wuziqi;

import java.awt.Color;
import java.awt.Graphics;                //����
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   //java�Դ��Ķ�������
import java.awt.event.MouseAdapter;     //java�Դ���������
import java.awt.event.MouseEvent;
import java.util.Arrays;
 
import javax.swing.JOptionPane;
 
public class FiveChessListenner extends MouseAdapter implements ActionListener,FiveChess{
 
	private FiveChessMain gm;   	// ����������
	private Graphics g;     	// ���ʶ���
	boolean cco=true;      	//��¼�º��廹�ǰ���
	boolean fff=true;     		//��¼�Ƿ��ܻ���
	boolean	ggg=true;    		//��¼�Ƿ�������
	private ArrayList<Chess> array;
	int coloum1,row1;
	int xx,yy,max;
	
	public FiveChessListenner(FiveChessMain gm,ArrayList<Chess> array) {  //��GobangMain���������ͼ�¼���ӵ�����
		this.gm = gm;
		this.array=array;
	}
	
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals("��ʼ����Ϸ")) {     //ִ���¼�Ϊ����ʼ����Ϸ��
    		for(int i=0;i<array1.length;i++) {
    			Arrays.fill(array1[i], 0);      //ʹ��Arrays.fill()����������Ԫ�����
    		}
    		cco=true;
    		fff=true;
    		ggg=true;
    		gm.addMouseListener(this);    //��������ʹ�ú�addMouseListener��������ƶ�������϶�
    		array.Reset();    //���ڲ�ָ��ָ�������еĵ�һ��Ԫ�أ������
    		gm.repaint();    //ˢ��ҳ��
		} 
    	if (e.getActionCommand().equals("����")) {    
    		if(flag[0]) {           //���˶�ս����
    			if(fff) {
    				if(array.getSize()>1) {    //ȷ���������Ѿ������ӣ����ܻ���
    					array1[coloum1][row1]=0;
    					Chess aaa=array.get(array.getSize()-2);    //������һ��
    					coloum1=aaa.coloum;
    					row1=aaa.row;
    					array.Delete();    //ɾ����Ҫ���������
    					cco=!cco;
    					gm.repaint();    //ˢ��ҳ��
    				}
    			}
    		}
    		
    		if(flag[1]) {      //�趨ֻ�����˻���սʱ���ܻ���
    			if(fff) {
    				if(cco) {
    					if(array.getSize()>2) {
    						array1[xx][yy]=0;
    						Chess aaa=array.get(array.getSize()-2);
    						coloum1=aaa.coloum;
        					row1=aaa.row;
    						array.Delete();
    						array1[coloum1][row1]=0;
    						Chess bbb=array.get(array.getSize()-2);
    						xx=bbb.coloum;
        					yy=bbb.row;
        					array.Delete();
    						gm.repaint();
    					}
    				}
    			}
    		}
    	}
    	if (e.getActionCommand().equals("����")) {
    		if(ggg) {
    			if(cco) {
    				JOptionPane.showMessageDialog(gm, "�����ʤ");   //��������䡱����ֱ����ʾ��Ϣ
    			}else {
    				JOptionPane.showMessageDialog(gm, "�����ʤ");
    			}
    			gm.removeMouseListener(this);    //���������ƶ�
    			//��ʱ����û���ӣ����ܻ��壬Ҳ��������
    			fff=false;    
    			ggg=false;
    		}
    	}
    	if (e.getActionCommand().equals("����ģʽ")) {  //ѡ�����˶�սģʽ flag[0]Ϊtrue,flag[1]Ϊfalse
    		flag[0]=true;
    		flag[1]=false;
    		for(int i=0;i<array1.length;i++) {   //ʹ��ѭ�����飬�����������
    			Arrays.fill(array1[i], 0);
    		}
    		//  ���˶�սģʽ�����Ի���Ҳ��������
    		cco=true;
    		fff=true;
    		ggg=true;
    		array.Reset();
    		gm.repaint();
    	}
    	if (e.getActionCommand().equals("�˻�ģʽ")) {  //ѡ���˻���սģʽ flag[0]Ϊfalse,flag[1]Ϊtrue
    		flag[0]=false;
    		flag[1]=true;
    		for(int i=0;i<array1.length;i++) {
    			Arrays.fill(array1[i], 0);
    		}
    		cco=true;
    		fff=true;
    		ggg=true;
    		array.Reset();
    		gm.repaint();
    	}
    }
 
	public void mouseReleased(MouseEvent e) {     //����ɿ���ʱ����еĲ���
		if(flag[0]) {  //ѡ�����˶�սģʽ���еĲ���
			if (g == null)
				g = gm.getGraphics();
			int x = e.getX();
			int y = e.getY();
			coloum1 = (x-X+size/2)/size; 
			row1 = (y-Y+size/2)/size;
			if(coloum1<coloum&&row1<row) {
				//   �ڷ�ִ��
				if(array1[coloum1][row1]==0) {
					if(cco) {
						g.setColor(Color.BLACK);
						//     ʹ��fillOval��������
						g.fillOval(X+coloum1*size-size/2, Y+row1*size-size/2, size, size);
						array1[coloum1][row1]=1;
						Chess sh=new Chess(coloum1,row1,Color.BLACK);
						array.add(sh);
					}
					//    �׷�ִ��
					else {
						g.setColor(Color.WHITE);
						g.fillOval(X+coloum1*size-size/2, Y+row1*size-size/2, size, size);
						array1[coloum1][row1]=-1;
						Chess sh=new Chess(coloum1,row1,Color.WHITE);
						array.add(sh);
					}
				//    �ж���Ӯ
					Judge jd=new Judge(coloum1,row1);
					if(jd.judge()) {
						if(cco) {
							JOptionPane.showMessageDialog(gm, "�����ʤ");
						}else {
							JOptionPane.showMessageDialog(gm, "�����ʤ");
						}
						gm.removeMouseListener(this);
						fff=false;
						ggg=false;
					}
					cco=!cco;
				
				}
				
			}
		}
		
		if(flag[1]) { //ѡ���˻���ս���еĲ���
			if (g == null)
				g = gm.getGraphics();
			if(cco) { //��cooΪtrue����������
				int x = e.getX();
				int y = e.getY();
				coloum1 = (x-X+size/2)/size; 
				row1 = (y-Y+size/2)/size;
				if(coloum1<coloum&&row1<row) {
					if(array1[coloum1][row1]==0) {
						g.setColor(Color.BLACK);
						g.fillOval(X+coloum1*size-size/2, Y+row1*size-size/2, size, size);
						array1[coloum1][row1]=1;
						Chess sh=new Chess(coloum1,row1,Color.BLACK);
						array.add(sh);
						
						Judge jd=new Judge(coloum1,row1);
						if(jd.judge()) {
							if(cco) {
								JOptionPane.showMessageDialog(gm, "�����ʤ");
							}else {
								JOptionPane.showMessageDialog(gm, "�����ʤ");
							}
							gm.removeMouseListener(this);
							fff=false;
							ggg=false;
							cco=!cco;
						}
						cco=!cco;
					
					}
					
				}
			}
			if(!cco) {  //��cooΪfalse�����������
				AIX();
			}
		}
	}
	//    AI���巽��
	public void AIX() {
		for(int i=0;i<weightArray.length;i++) {
			for(int j=0;j<weightArray[i].length;j++) {
				weightArray[i][j]=0;
			}
		}
		max=-1;
		AI.Quan();      //    AIȨֵ�㷨
		for(int i=0;i<weightArray.length;i++) {
			for(int j=0;j<weightArray[i].length;j++) {
				if(i<5&&j<5) {
					if(max<=weightArray[i][j]&&array1[i][j]==0) {
						max=weightArray[i][j];
						xx=i;yy=j;
					}
				}else {
					if(max<weightArray[i][j]&&array1[i][j]==0) {
						max=weightArray[i][j];
						xx=i;yy=j;
					}
				}
			}
		}
		if(array1[xx][yy]==0) {
			g.setColor(Color.WHITE);
			g.fillOval(X+xx*size-size/2, Y+yy*size-size/2, size, size);
			array1[xx][yy]=-1;
			Chess sh=new Chess(xx,yy,Color.WHITE);
			array.add(sh);
		
			Judge jd=new Judge(xx,yy);
			if(jd.judge()) {
				if(cco) {
					JOptionPane.showMessageDialog(gm, "�����ʤ");
				}else {
					JOptionPane.showMessageDialog(gm, "�����ʤ");
				}
				gm.removeMouseListener(this);  //�Ƴ���������ʱ�����ܶ����̽��в���
				fff=false;         //���ò��ܽ��л���
				ggg=false;         //���ò��ܽ�������
			}
			cco=!cco;
		}
	}
}