package entities;

public class Item {
    private String name;
    private  String imagePath;

    public Item(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
