package storm.bolt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;




import com.pca.Pca;

import Jama.Matrix;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
public class PcaBolt implements IRichBolt{
	private OutputCollector collector;
	private int col = 117;
	private int k=3;
	private double[][] result=new double[col][k];
	
	@Override
	public void cleanup() {
		
		
	}

	@Override
	public void execute(Tuple input) {
		String line;
		boolean flag=true;
		//int row=16;
		
        if(input.getFields().contains("col")){
			
			col=(Integer) input.getValue(1);
			
		}
      //  System.out.println("--col--"+col);
        if(input.getFields().contains("k")){
			
			k=(Integer) input.getValue(2);
			
		}
      //  System.out.println("k--"+k);
		double[][] rdata =new double[1][col];
	
		//double[][] RawData=new double[row][col];//定义读入数据存放的数组
		if(input.getFields().contains("readlog"))
		{//如果输入识别标志为readlog，进行如下处理
		//	RawData = (double[][]) input.getValueByField("readlog");	
			line = input.getString(0);
			String[] str = line.split("\t");
			for(int i=0;i<col;i++)
			{
				rdata[0][i]=Double.valueOf(str[i]).doubleValue();
			//	System.out.print("rdata[0][i]"+rdata[0][i]);
			}
			
		}
		if(input.getFields().contains("principal")){//如果输入识别标志为principal，进行如下处理
			result = (double[][]) input.getValueByField("principal");
			
		}
		
//		for(int i=0;i<col;i++)
//		{
//			for(int j=0;j<k;j++)
//			{
//				System.out.print("result[i][j]"+result[i][j]);
//				
//			}
//		}
		
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<k;j++)
			{
				if(result[i][j]!=0)
					{
					flag=false;	
					break;
					}
			}
		}
		if(flag==false)
		{
		Matrix A=new Matrix(rdata);
		System.out.println("--Matrix A--");	
		for(int i=0;i<col;i++)
		{
			System.out.print(rdata[0][i]+" ");;
		}
		System.out.println();
		Matrix B=new Matrix(result);
		System.out.println("--Matrix B--");
		for(int i=0;i<result.length;i++)
		{
			for(int j=0;j<result[0].length;j++)
			{
				System.out.print(result[i][j]+" ");

			}
			System.out.println("");
		}
		Matrix C=A.times(B);//矩阵相乘
		System.out.println("--Matrix C--");	
		C.print(4, 2);//4是列宽，2是数字小数点后的位数
		}
	}

	@Override
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		System.out.println("PcaBolt	--	Start!");
		this.collector = collector;
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("pca"));
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
