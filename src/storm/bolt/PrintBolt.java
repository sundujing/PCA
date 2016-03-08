package storm.bolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class PrintBolt extends BaseBasicBolt {

	double[][] result;
	public static void main(String[] args) {


	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		
		result=(double[][])input.getValueByField("principal");
		try {

//			for(int i=0;i<result.length;i++){
//				for(int j=0;j<result[0].length;j++){
//					System.out.print(result[i][j]+" ");
//
//				}
//				System.out.println();
//		}
//			 ´òÓ¡Êý¾Ý

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

		declarer.declare(new Fields("mesg"));

	}

}
