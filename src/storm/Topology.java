package storm;



import storm.bolt.PcaBolt;
import storm.bolt.PrincipalBolt;
import storm.bolt.PrintBolt;
import storm.spout.ReadLogSpout;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;

public class Topology {
	/**
	 * @param args
	 */
	// ʵ����TopologyBuilder�ࡣ
	private static TopologyBuilder builder = new TopologyBuilder();

	public static void main(String[] args) throws InterruptedException,
			AlreadyAliveException, InvalidTopologyException {
		// TODO Auto-generated method stub
		Config config = new Config();

		// �����緢�ڵ㲢���䲢�������ò�����������Ƹö����ڼ�Ⱥ�е��߳�����

		builder.setSpout("readlog", new ReadLogSpout(), 1);
		// �������ݴ���ڵ㲢���䲢������ָ���ýڵ�����緢�ڵ�Ĳ���Ϊ�����ʽ��
		
		//����FPGrowth�ڵ�
		builder.setBolt("principal", new PrincipalBolt(), 3)
				.shuffleGrouping("readlog");
		
		builder.setBolt("pca", new PcaBolt(),2)
		.shuffleGrouping("readlog").shuffleGrouping("principal");

		//����print��������ڵ�
		builder.setBolt("print", new PrintBolt(), 3).shuffleGrouping(
					"pca"); 		
		

		config.setDebug(false);

		if (args != null && args.length > 0) {
			config.setNumWorkers(1);
			StormSubmitter.submitTopology(args[0], config,
					builder.createTopology());
		} else {
			// �����Ǳ���ģʽ�����е��������롣
			config.setMaxTaskParallelism(1);
			LocalCluster cluster = new LocalCluster();
			cluster.submitTopology("simple", config, builder.createTopology());
		}

	}

}