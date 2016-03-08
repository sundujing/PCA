package storm.bolt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;



import com.pca.Pca;



import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class PrincipalBolt implements IRichBolt{
	private OutputCollector collector;
	private static ArrayList<double[]> records = new ArrayList<double[]>();
	private int count=0;
	private int col=0;
	@Override
	public void cleanup() {
		
		
	}

	@Override
	public void execute(Tuple input) {
		String line = input.getString(0);
		String[] str = line.split("\t");
		int row=10;
		col=str.length;
//	    double[][] RawData=new double[row][col];//定义读入数据存放的数组
		double[] rdata =new double[col];
		
//	    LinkedList<String> litm = new LinkedList<String>();
//		for (int i = 0; i < str.length - 1; i++) {
//			litm.add(str[i].trim());
//		}
		
//		ArrayList<String> litm = new ArrayList<String>();
//		for (int i = 0; i < str.length - 1; i++) {
//			litm.add(str[i].trim());
//		}
//		
		for(int i=0;i<str.length;i++)
		{
			rdata[i]=Double.valueOf(str[i]).doubleValue();
	//		System.out.println("rdata[i]"+rdata[i]);
		}
		
//		ArrayList<String> record1 = new ArrayList<String>();
//		record1.addAll(litm);
		records.add(rdata);
		count++;
		if ((count%100)==0) {
//			LinkedList<TreeNode2> F1 = buildHeaderLink(records);
//			LinkedList<TreeNode2> orderheader = buildHeaderLink(records);
//			orderF1(orderheader);
//			System.out.println("start");
//			printF1(F1, time);
//			fpgrowth(records, null, F1, time);
//			time++;
//			time = time % 100;
	//		for(int i=0;i<10;i++)
//	        {       line=input.getString(0);  
//	        		str = line.split(",");
	        //	String[]input=line.split(",");
//	 		    for(int j=0;j<str.length;j++)
//	 		    {
//	 		    	RawData[i][j]=Double.valueOf(str[j]).doubleValue();
//	 		    }
//
//	        }
			Pca test=new Pca();
			double[][] Standard=test.Standardlizer(records);
			for(int i=0;i<row;i++)
			{
//				for(int j=0;j<col;j++)
//				{
//					System.out.println("Standard--");
//					System.out.print(Standard[i][j]+" ");
//				}
				System.out.println();
			}
			double[][] Assosiation=test.CoefficientOfAssociation(Standard);
			double[][] FlagValue=test.FlagValue(Assosiation);
			double[][] FlagVector=test.FlagVector(Assosiation);
			int[] xuan=test.SelectPrincipalComponent(FlagValue);
			double[][] result=test.PrincipalComponent(FlagVector, xuan);
			int n=row;
			int p=col;
			int k=xuan.length;
			for(int i=0;i<p;i++){
				for(int j=0;j<xuan.length;j++){
					System.out.println("principal----");
					System.out.print(result[i][j]+" ");
//					this.collector.emit(new Values(result[i][j]));
				}
				System.out.println();
		}
	//records.removeAll(litm);
		this.collector.emit(new Values(result,col,k));
		
		
		}
		
//		LinkedList<String> record1 = new LinkedList<String>();
//		record1.addAll(removeDuplicateWithOrder(litm));
//		records.add(record1);
//		time1 = str[str.length - 1];
//		if (flag == 0) {
//			t = time1;
//			flag = 1;
//		}
//		if (!t.equals(time1)) {
//			LinkedList<TreeNode2> F1 = buildHeaderLink(records);
//			LinkedList<TreeNode2> orderheader = buildHeaderLink(records);
//			orderF1(orderheader);
//			System.out.println("start");
//			printF1(F1, time);
//			fpgrowth(records, null, F1, time);
//			time++;
//			time = time % 100;
//		}
//		t = time1;
//		records =0;
		
	}

	@Override
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		System.out.println("PrincipalBolt	--	Start!");
		this.collector = collector;
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
		declarer.declare(new Fields("principal","col","k"));
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		
		return null;
	}

}
