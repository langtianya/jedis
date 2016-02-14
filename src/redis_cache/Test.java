package redis_cache;

import java.util.Collection;
import java.util.List;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) {
	      //连接本地的 Redis 服务
	      Jedis jedis = new Jedis("localhost");
	      System.out.println("Connection to server sucessfully");
	      //查看服	务是否运行
	      System.out.println("Server is running: "+jedis.ping());
	      
	      
	      //设置 redis 字符串数据
	      jedis.set("w3ckey", "Redis tutorial");
	     // 获取存储的数据并输出
	     System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
	     
	     
	     //存储数据到列表中
	      jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");
	     // 获取存储的数据并输出
	     List<String> list = jedis.lrange("tutorial-list", 0 ,1);
	     for(int i=0; i<list.size(); i++) {
	       System.out.println("Stored string in redis list:: "+list.get(i));
	     }
	     
	     
	  // 获取数据并输出
	     Collection<String> keys = jedis.keys("*");
	     for (String key : keys) {
	    	 if ("string".equals(jedis.type(key))){
	    		 System.out.println("L)st of stored keys:: "+key+"===："+jedis.get(key));
			}else if ("list".equals(jedis.type(key))){
				List<String> list1 = jedis.lrange("tutorial-list", 0 ,5);
			     for(int i=0; i<list.size(); i++) {
			    	 System.out.println("List of stored keys:: "+key+"===："+list1.get(i));
			     }
			}
	    	 
		}
	     
	 }
}
