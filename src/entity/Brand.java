package entity;

public class Brand {
    private int brandId;
    private String model;
    private String type;

    public Brand(int brandId, String model, String type) {
        this.brandId = brandId;
        this.model = model;
        this.type = type;
    }

    public int getBrandId() {
        return brandId;
    }
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
