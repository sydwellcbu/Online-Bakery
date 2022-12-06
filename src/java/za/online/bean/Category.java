package za.online.bean;

public class Category {

    private int categoryId;
    private String categoryName;
    private String categoryPic;
    private boolean active;

    public Category() {
        this("", "", true);
    }

    public Category(String categoryName, String categoryPic) {
        this(categoryName, categoryPic, true);
    }

    public Category(String categoryName, String categoryPic, boolean active) {
        this.categoryName = categoryName;
        this.categoryPic = categoryPic;
        this.active = active;
    }
    //----------------------------------------------------------
    public Category(int categoryId , String categoryName, String categoryPic, boolean active) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.categoryPic = categoryPic;
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryPic() {
        return categoryPic;
    }

    public void setCategoryPic(String categoryPic) {
        this.categoryPic = categoryPic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CategoryImpl{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryPic=" + categoryPic + '}';
    }

}
