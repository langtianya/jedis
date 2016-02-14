package redis_cache;

import java.util.Collection;
import java.util.List;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) {
	      //���ӱ��ص� Redis ����
	      Jedis jedis = new Jedis("localhost");
	      System.out.println("Connection to server sucessfully");
	      //�鿴��	���Ƿ�����
	      System.out.println("Server is running: "+jedis.ping());
	      
	      
	      //���� redis �ַ�������
	      jedis.set("w3ckey", "Redis tutorial");
	     // ��ȡ�洢�����ݲ����
	     System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
	     
	     
	     //�洢���ݵ��б���
	      jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");
	     // ��ȡ�洢�����ݲ����
	     List<String> list = jedis.lrange("tutorial-list", 0 ,1);
	     for(int i=0; i<list.size(); i++) {
	       System.out.println("Stored string in redis list:: "+list.get(i));
	     }
	     
	     
	  // ��ȡ���ݲ����
	     Collection<String> keys = jedis.keys("*");
	     for (String key : keys) {
	    	 if ("string".equals(jedis.type(key))){
	    		 System.out.println("L)st of stored keys:: "+key+"===��"+jedis.get(key));
			}else if ("list".equals(jedis.type(key))){
				List<String> list1 = jedis.lrange("tutorial-list", 0 ,5);
			     for(int i=0; i<list.size(); i++) {
			    	 System.out.println("List of stored keys:: "+key+"===��"+list1.get(i));
			     }
			}
	    	 
		}
	     
	 }
}
