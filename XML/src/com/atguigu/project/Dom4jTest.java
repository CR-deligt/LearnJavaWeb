package com.atguigu.project;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("src/books.xml");

        System.out.println(document);
    }
    @Test
    public void test2() throws DocumentException {
        //读文件
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        //通过document对象获取根元素
        Element rootElement = document.getRootElement();
        //通过根元素获得book标签对象
        //element() elements()都是通过标签名查找子元素,前者返回一个，后者返回多个
        List<Element> books= rootElement.elements("book");
        //遍历，处理每个book标签转换为book类
        for(Element book:books){
            //System.out.println(book.asXML());

            Element nameElement = book.element("name");
            //用getText()获取标签文本内容
            String nameElementText = nameElement.getText();
            //System.out.println(nameElementText);

            //直接获取指定标签名内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");

            String snValue = book.attributeValue("sn");

            System.out.println(new book(snValue,nameElementText,authorText,Double.parseDouble(priceText)));
        }
    }

}
