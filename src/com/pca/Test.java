package com.pca;
import Jama.Matrix;
import java.io.*;
import java.util.*;

public class Test
{
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
//		Pca test=new Pca();
//	
//		String a=new String();
//	    String b=new String();
//	    String c=new String();
//	    Vector v=new Vector();
//	    int  row=0;//数据源矩阵的行
//	    int col=0;//列
//	    File f=new File("JiangWei.txt");
//	    FileReader in=new FileReader(f);
//	    BufferedReader br = new BufferedReader(in);
//	    br.mark((int)f.length()+1);//在文档开头设mark
//	    //求二维数据的行和列
//	    while(br.read()!=-1)
//	    {
//	    	row++;//确定行数
//	    	br.readLine();//readLine()是一个很有用的方法
//	    }
//	    br.reset();//回到文档开头mark
//	    a=br.readLine();
//	    StringTokenizer wordString=new StringTokenizer(a);
//	    while(wordString.hasMoreTokens())
//	    {
//	       v.add(wordString.nextToken(","));//StringTokenizer类的nextToken()方法可以读入单个字符串，去掉“，”
//	    }
//	    col=v.size();//确定列数
//	   //将文本文件中的数组读入存于double数组source
//        double[][] RawData=new double[row][col];//定义读入数据存放的数组
//        br.reset();//回到文档开头mark
//        for(int i=0;(c=br.readLine())!=null;i++)
//        {                     		  
//        	String[]input=c.split(",");
// 		    for(int j=0;j<input.length;j++)
// 		    {
// 		    	RawData[i][j]=Double.valueOf(input[j]).doubleValue();
// 		    }
//
//        }
//        in.close();	
//	
//		for(int i=0;i<RawData.length;i++){
//			for(int j=0;j<RawData[0].length;j++){
//				System.out.print(RawData[i][j]+" ");
//			}
//			System.out.println();
//		}
//		//标准化的数据
//		double[][] Standard=test.Standardlizer(RawData);
//		double[][] Assosiation=test.CoefficientOfAssociation(Standard);
//		int n=RawData.length;
//		int p=RawData[0].length;
//		for(int i=0;i<p;i++){
//			for(int j=0;j<p;j++){
//				System.out.print(Assosiation[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		double[][] FlagValue=test.FlagValue(Assosiation);
//		
//		for(int i=0;i<p;i++){
//			for(int j=0;j<p;j++){
//				System.out.print(FlagValue[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		double[][] FlagVector=test.FlagVector(Assosiation);
//		for(int i=0;i<p;i++){
//			for(int j=0;j<p;j++){
//				System.out.print(FlagVector[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		int[] xuan=test.SelectPrincipalComponent(FlagValue);
//		for(int i=0;i<xuan.length;i++){
//			
//			System.out.print(xuan[i]+" ");
//		
//		}
//		System.out.println();
//		double[][] result=test.PrincipalComponent(FlagVector, xuan);
//		for(int i=0;i<p;i++){
//			for(int j=0;j<xuan.length;j++){
//				System.out.print(result[i][j]+" ");
//			}
//			System.out.println();
//		}
//		Matrix A=new Matrix(RawData);
//		Matrix B=new Matrix(result);
//		Matrix C=A.times(B);//矩阵相乘
//		C.print(4, 2);//public void print(int w,int d)//4是列宽，2是数字小数点后的位数
//		/*double[][] D=C.getArray();
//		double[] E=new double[RawData.length];
//		for(int i=0;i<D.length;i++){
//			double temp=0;
//			for(int j=0;j<D[0].length;j++){
//				temp+=D[i][j];
//			}
//			E[i]=temp;
//		}
//		System.out.println();
//		for(int i=0;i<D.length;i++){		
//				System.out.println(E[i]);
//		}
//		*/
		
	}
}
