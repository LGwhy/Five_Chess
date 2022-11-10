package wuziqi;

import java.awt.Color;
 
public class Chess extends Object implements FiveChess{
	int coloum,row;
	Color color;
	
	public Chess(int coloum,int row,Color color) {
		this.coloum=coloum;
		this.row=row;
		this.color=color;
	}
}
