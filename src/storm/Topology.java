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
	// 实例化TopologyBuilder类。
	private static TopologyBuilder builder = new TopologyBuilder();

	public static void main(String[] args) throws InterruptedException,
			AlreadyAliveException, InvalidTopologyException {
		// TODO Auto-generated method stub
		Config config = new Config();

		// 设置喷发节点并分配并发数，该并发数将会控制该对象在集群中的线程数。

		builder.setSpout("readlog", new ReadLogSpout(), 1);
		// 设置数据处理节点并分配并发数。指定该节点接收喷发节点的策略为随机方式。
		
		//创建FPGrowth节点
		builder.setBolt("principal", new PrincipalBolt(), 3)
				.shuffleGrouping("readlog");
		
		builder.setBolt("pca", new PcaBolt(),2)
		.shuffleGrouping("readlog").shuffleGrouping("principal");

		//创建print数据输出节点
		builder.setBolt("print", new PrintBolt(), 3).shuffleGrouping(
					"pca"); 		
		

		config.setDebug(false);

		if (args != null && args.length > 0) {
			config.setNumWorkers(1);
			StormSubmitter.submitTopology(args[0], config,
					builder.createTopology());
		} else {
			// 这里是本地模式下运行的启动代码。
			config.setMaxTaskParallelism(1);
			LocalCluster cluster = new LocalCluster();
			cluster.submitTopology("simple", config, builder.createTopology());
		}

	}

}