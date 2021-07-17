package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Type;

public class TypeDao {

    private Connection connection; 
    private BrandDao brandDao;
    private final String GET_BRAND_QUERY = "SELECT * FROM cars";
    private final String GET_BRAND_BY_ID_QUERY = "SELECT * FROM cars WHERE car_id = ?";
    private final String CREATE_NEW_BRAND_QUERY = "INSERT INTO cars(brand_name) VALUES(?)";
    private final String DELETE_BRAND_BY_ID_QUERY = "DELETE FROM cars WHERE car_id = ?";
    
    
    public TypeDao() {
        connection = DBConnection.getConnection();
        brandDao = new BrandDao();
    }

    public List<Type> getType() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_BRAND_QUERY).executeQuery();
        List<Type> types = new ArrayList<Type>();

        while (rs.next()) {
            types.add(populateType(rs.getInt(1), rs.getString(2)));
        }
        return types;
    }
    public Type getTypeById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_BRAND_BY_ID_QUERY);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return populateType(rs.getInt(1), rs.getString(2));
    }
    
    public void createNewBrand (String brandName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(CREATE_NEW_BRAND_QUERY);
        ps.setString(1, brandName);
        ps.executeUpdate();
    }

    public void deleteBrandByCarId(int carId) throws SQLException {
        brandDao.deleteBrandByCarId(carId);
        PreparedStatement ps = connection.prepareStatement(DELETE_BRAND_BY_ID_QUERY);
        ps.setInt(1, carId);
        ps.executeUpdate();
    }

    private Type populateType(int id, String name) throws SQLException {
        return new Type(id, name, brandDao.getBrandsByTypeId(id));
    }

}
