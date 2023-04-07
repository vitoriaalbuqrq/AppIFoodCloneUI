package app.projeto.appifoodjava.model;

public class Shop {
    private int logoURI;
    private String text;

    public Shop() {
    }

    public Shop(int logoURI, String text) {
        this.logoURI = logoURI;
        this.text = text;
    }

    public int getLogoURI() {
        return logoURI;
    }

    public void setLogoURI(int logoURI) {
        this.logoURI = logoURI;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
