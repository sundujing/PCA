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
//	    int  row=0;//����Դ�������
//	    int col=0;//��
//	    File f=new File("JiangWei.txt");
//	    FileReader in=new FileReader(f);
//	    BufferedReader br = new BufferedReader(in);
//	    br.mark((int)f.length()+1);//���ĵ���ͷ��mark
//	    //���ά���ݵ��к���
//	    while(br.read()!=-1)
//	    {
//	    	row++;//ȷ������
//	    	br.readLine();//readLine()��һ�������õķ���
//	    }
//	    br.reset();//�ص��ĵ���ͷmark
//	    a=br.readLine();
//	    StringTokenizer wordString=new StringTokenizer(a);
//	    while(wordString.hasMoreTokens())
//	    {
//	       v.add(wordString.nextToken(","));//StringTokenizer���nextToken()�������Զ��뵥���ַ�����ȥ��������
//	    }
//	    col=v.size();//ȷ������
//	   //���ı��ļ��е�����������double����source
//        double[][] RawData=new double[row][col];//����������ݴ�ŵ�����
//        br.reset();//�ص��ĵ���ͷmark
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
//		//��׼��������
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
//		Matrix C=A.times(B);//�������
//		C.print(4, 2);//public void print(int w,int d)//4���п�2������С������λ��
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
