
package za.online.bean;


public class IngredientsInventory {
    private int ingredientsId;
    private int availableStock;
    private int maxStock;
    private int minStock;

    public IngredientsInventory() {
    }

    public IngredientsInventory(int ingredientsId, int availableStock, int maxStock, int minStock) {
        this.ingredientsId = ingredientsId;
        this.availableStock = availableStock;
        this.maxStock = maxStock;
        this.minStock = minStock;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }

    public void setIngredientsId(int ingredientsId) {
        this.ingredientsId = ingredientsId;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    @Override
    public String toString() {
        return "IngredientsInventory{" + "ingredientsId=" + ingredientsId + ", availableStock=" + availableStock + ", maxStock=" + maxStock + ", minStock=" + minStock + '}';
    }

  
}
