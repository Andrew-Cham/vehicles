package entity;
import java.util.List;

public class Type {
    
    private int typeId;
    private String name;
    private List<Brand> brands;

    public Type(int typeId, String name, List<Brand> brands) {
        this.typeId = typeId;
        this.name = name;
        this.brands = brands;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Brand> getBrands() {
        return brands;
    }
    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }
}
