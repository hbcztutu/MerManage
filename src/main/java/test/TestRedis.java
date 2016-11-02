package test;

import common.redis.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.util.SafeEncoder;

public class TestRedis {
  
  static JedisUtil jedisUtil= JedisUtil.getInstance();  
  public static void main(String[] args) {
    
    JedisUtil.Strings strings=jedisUtil.new Strings();  
    strings.set("nnn", "nnnn");   
    System.out.println("-----"+strings.get("nnn"));  
    Jedis jedis =  jedisUtil.getJedis();
    System.out.println( jedis.get("nnn"));
    jedis.del("nnn");
    JedisUtil.returnBrokenResource(jedis);



    
    Person p = new Person();  
    p.setId(3);  
    p.setName("测试");  
      
   strings= jedisUtil.new Strings();  
   // strings.setEx("object3".getBytes(), 30,SerializeUtil.serialize(p));  
    strings.set("object3".getBytes(),SerializeUtil.serialize(p));
    //jedis.set(SafeEncoder.encode("object1"),SerializeUtil.serialize(p));  
    byte[] personBy = strings.get(SafeEncoder.encode("object3"));  
    Person p1 = (Person) SerializeUtil.unserialize(personBy);  
    System.out.println(p1.getName());  
    
  //  jedis =  jedisUtil.getJedis();   
    jedis.del(SafeEncoder.encode("object3"));
   JedisUtil.returnBrokenResource(jedis);

  }
  
  
}
