package app.projeto.appifoodjava.model;

public class Category {

    private String name;
    private int image;
    private int color;

    public Category(){}

    public Category(String name, int image, int color) {
        this.name = name;
        this.image = image;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
