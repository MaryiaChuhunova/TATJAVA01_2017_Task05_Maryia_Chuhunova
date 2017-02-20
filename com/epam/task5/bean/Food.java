package bean;

/**
 * Created by Maria on 19.02.2017.
 */
public class Food {

    private int id;
    private String photo;
    private String title;
    private String description;
    private String portion;
    private String price;

    public Food() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoto(String url) {
        this.photo = url;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPortion(String portion) {
        this.portion = portion;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPortion() {
        return portion;
    }

    public String getPrice() {
        return price;
    }
}
