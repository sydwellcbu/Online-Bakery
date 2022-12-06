
package za.online.bean;


public class Recipe {
    private int recipeId;
    private int productId;
    private String recipeDesc;
    private String recipeInstr;

    public Recipe() {
    }

    public Recipe(int recipeId, int productId, String recipeDesc, String recipeInstr) {
        this.recipeId = recipeId;
        this.productId = productId;
        this.recipeDesc = recipeDesc;
        this.recipeInstr = recipeInstr;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getRecipeDesc() {
        return recipeDesc;
    }

    public void setRecipeDesc(String recipeDesc) {
        this.recipeDesc = recipeDesc;
    }

    public String getRecipeInstr() {
        return recipeInstr;
    }

    public void setRecipeInstr(String recipeInstr) {
        this.recipeInstr = recipeInstr;
    }

    @Override
    public String toString() {
        return "Recipe{" + "recipeId=" + recipeId + ", productId=" + productId + ", recipeDesc=" + recipeDesc + ", recipeInstr=" + recipeInstr + '}';
    }
    
    
}
