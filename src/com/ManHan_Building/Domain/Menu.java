package com.ManHan_Building.Domain;

/**
 * javabean 和 menu表 对应
 *  id INT PRIMARY KEY AUTO_INCREMENT,
 * 	NAME VARCHAR(32) NOT NULL DEFAULT '' ,
 * 	price DOUBLE NOT NULL DEFAULT '0.0',
 * 	surplus INT NOT NULL DEFAULT '0',
 * 	TYPE VARCHAR(20) NOT NULL DEFAULT ''
 */
public class Menu {
    private Integer id;
    private String name;
    private Double price;
    private Integer surplus;
    private String type;

    @Override
    public String toString() {
        return "\t\t" + id +
                "\t\t\t" + name +
                "\t\t\t" + price +
                "\t\t\t" + surplus +
                "\t\t\t" + type ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSurplus() {
        return surplus;
    }

    public void setSurplus(Integer surplus) {
        this.surplus = surplus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Menu() {
    }

    public Menu(Integer id, String name, Double price, Integer surplus, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.surplus = surplus;
        this.type = type;
    }
}
