package org.easyarch.alpaca.serializer;

import org.easyarch.alpaca.serializer.component.bean.Person;
import org.easyarch.alpaca.serializer.component.bean.User;
import org.easyarch.alpaca.serializer.dp.Serializer;
import org.easyarch.alpaca.serializer.dp.HessianSerializer;
import org.easyarch.alpaca.transport.util.JSONUtil;
import org.easyarch.alpaca.serializer.dp.JavaSerializer;
import org.easyarch.alpaca.serializer.dp.ProtostuffSerializer;
import org.junit.Test;

import java.text.NumberFormat;

/**
 * Description :
 * Created by xingtianyu on 16-12-2
 * 下午11:54
 */

public class SerialTest {

    @Test
    public void testSerial() throws Exception {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        StringBuffer key = new StringBuffer();
        for (int index = 0;index<1000;index++){
            key.append("1000");
        }
        user1.set(key.toString());
        user2.set(key.toString());
        user3.set(key.toString());
        user4.set(key.toString());
        Class.forName(ProtostuffSerializer.class.getName());
//        System.out.println(user);
//        user.setPassword("12345690123");
        Serializer<User> javaSerializer = new JavaSerializer<>();
        Serializer<User> protostuffSerializer = new ProtostuffSerializer<User>();
        Serializer<User> hessianSerialiser = new HessianSerializer<>();
        long nano = System.nanoTime();
        byte []data = javaSerializer.serialize(user1);
        System.out.println("java nanotime:   "+(System.nanoTime() - nano));

        nano = System.nanoTime();
        byte[] json = JSONUtil.pojo2Bytes(user2);
        System.out.println("json nanotime:   "+(System.nanoTime() - nano));

        nano = System.nanoTime();
        byte[] bytes = protostuffSerializer.serialize(user3);
        System.out.println("proto nanotime:  "+(System.nanoTime() - nano));

        nano = System.nanoTime();
        byte[] hbytes = hessianSerialiser.serialize(user4);
        System.out.println("hessain nanotime:"+(System.nanoTime() - nano));
        System.out.println("-------------------------");

        System.out.println("java length -->   "+data.length);
        System.out.println("json length -->   "+json.length);
        System.out.println("proto length -->  "+bytes.length);
        System.out.println("hessian length -->"+hbytes.length);
//        System.out.println("protobuf length-->"+person.toByteArray().length);
//        User u = hessianSerialiser.deserialize(bytes,User.class);
//        System.out.println("user-->"+u);
//        System.out.println(JSONUtil.bytes2Pojo(json,User.class));

//        System.out.println(javaSerializer.deserialize(data,User.class));
        System.out.println(user1);
    }

    @Test
    public void testSerial2() throws ClassNotFoundException {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        StringBuffer key = new StringBuffer();
        for (int index = 0;index<10;index++){
            key.append("13652179825");
        }
        p1.setId("13652179825");
        p1.setPassword("13652179825");
        p1.setUsername("13652179825");

        p2.setPassword("13652179825");
        p2.setUsername("13652179825");
        p2.setId("13652179825");

        p3.setPassword("13652179825");
        p3.setUsername("13652179825");
        p3.setId("13652179825");

        p4.setId("13652179825");
        p4.setPassword("13652179825");
        p4.setUsername("13652179825");
        Class.forName(ProtostuffSerializer.class.getName());
        Serializer<Person> javaSerializer = new JavaSerializer<>();
        Serializer<Person> protostuffSerializer = new ProtostuffSerializer<>();
        Serializer<Person> hessianSerialiser = new HessianSerializer<>();
        long nano = System.nanoTime();
        byte []data = javaSerializer.serialize(p1);
        System.out.println("java nanotime:   "+(System.nanoTime() - nano));

        nano = System.nanoTime();
        byte[] json = JSONUtil.pojo2Bytes(p2);
        System.out.println("json nanotime:   "+(System.nanoTime() - nano));

        nano = System.nanoTime();
        byte[] bytes = protostuffSerializer.serialize(p3);
        System.out.println("proto nanotime:  "+(System.nanoTime() - nano));

        nano = System.nanoTime();
        byte[] hbytes = hessianSerialiser.serialize(p4);
        System.out.println("hessain nanotime:"+(System.nanoTime() - nano));
        System.out.println("-------------------------");

        System.out.println("java length -->   "+data.length);
        System.out.println("json length -->   "+json.length);
        System.out.println("proto length -->  "+bytes.length);
        System.out.println("hessian length -->"+hbytes.length);
//        System.out.println("protobuf length-->"+person.toByteArray().length);
    }

    @Test
    public void calculate(){
        System.out.println("hessian    "+percent(180f-119f,180f)+" better than origin");
        System.out.println("json       "+percent(180f-69f,180f)+" better than origin");
        System.out.println("protostuff "+percent(180f-33f,180f)+" better than origin");
        System.out.println("json       "+percent(119f-69f,119f)+" better than hessian");
        System.out.println("protostuff "+percent(119f-33f,119f)+" better than hessian");
        System.out.println("protostuff "+percent(69f-33f,69f)+" better than json");
    }

    public String percent(float front,float back){
        NumberFormat nt = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);
        return nt.format(front/back);
    }
}
