package test.retail.retailstore.bean;

import java.io.Serializable;

/**
 * Created by robimolte on 19/04/2017.
 */

public class SingleItem implements Serializable {

    private String name;
    private int cost;
    private String category;
    private String image;


    public SingleItem(String name, String category, int cost, String image) {
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.image = image;
    }

    public SingleItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}