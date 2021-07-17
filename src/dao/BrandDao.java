package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Brand;

public class BrandDao {
    private Connection connection;
    private final String GET_BRANDS_BY_TYPE_ID_QUERY = "SELECT * FROM brands WHERE brand_id = ?";
    private final String DELETE_BRANDS_BY_BRAND_ID_QUERY = "DELETE FROM brands WHERE brand_id = ?";

    public BrandDao() {
        connection = DBConnection.getConnection();
    }

    public List<Brand> getBrandsByTypeId(int typeId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_BRANDS_BY_TYPE_ID_QUERY);
        ps.setInt(1, typeId);
        ResultSet rs = ps.executeQuery();
        List<Brand> brands = new ArrayList<Brand>();

        while (rs.next()) {
            brands.add(new Brand(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return brands;
    }

    public void deleteBrandByCarId(int carId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_BRANDS_BY_BRAND_ID_QUERY);
        ps.setInt(1, carId);
        ps.executeUpdate();
    }
    
}
