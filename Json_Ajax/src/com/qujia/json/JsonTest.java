package com.qujia.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qujia.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    @Test
    //Javabean和json相互转换
    public void Test1(){
        Person person = new Person(1,"曲佳");
        Gson gson = new Gson();
        
        //toJson()把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        //fromJson()把json字符串转化回Java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);

    }
    //List和json相互转换
    @Test
    public void Test2(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"曲佳1"));
        personList.add(new Person(2,"曲佳2"));

        Gson gson = new Gson();

        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);
        //json转换成list时，要写一个ListType类，调用getType()得到集合的参数Type
        List<Person> list = gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }
    @Test
    //Map和json相互转换
    public void Test3(){
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(1,"曲佳1"));
        personMap.put(2,new Person(2,"曲佳2"));
        Gson gson = new Gson();
        //map集合转化为Json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);
        //Json字符串->map集合(跟list同理)
//        HashMap<Integer,Person> map = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        //为了不会产生太多没有用的类，可以不另写一个，而采用匿名内部类（你无法在别的地方使用这个类）
        /*
            new 实现接口（）
            {
                //匿名内部类类体部分
            }
            或
            new 父类构造器（实参列表）
            {
              //匿名内部类类体部分
            }
        */
        HashMap<Integer,Person> map = gson.fromJson(personMapJsonString, new TypeToken<ArrayList<Person>>(){}.getType());
        System.out.println(map);
        Person person = map.get(1);//map按key找value
        System.out.println(person);

    }
}
