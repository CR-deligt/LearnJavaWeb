package com.atguigu.project;



public class book {
    private String sn;
    private String name;
    private String author;
    private Double price;
    //快捷键alt+insert添加构造函数

    @Override
    public String toString() {
        return "book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public book(String sn, String name, String author, Double price) {
        this.sn = sn;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
