package org.easyarch.alpaca.serializer;

import org.easyarch.alpaca.serializer.component.bean.Person;
import org.easyarch.alpaca.serializer.dp.HessianSerializer;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 下午3:59
 */

public class CalculateTest {

    public static void main(String[] args) {
        HessianSerializer<Person> hessianSerializer = new HessianSerializer<>();
        Person p = new Person();
        p.setId("123456");
        p.setUsername("xingtianyu");
        p.setPassword("1221212");
        byte[] bytes = hessianSerializer.serialize(p);
        Person person = hessianSerializer.deserialize(bytes,Person.class);
        System.out.println(person);
    }
}
