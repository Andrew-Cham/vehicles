package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.TypeDao;
import entity.Brand;
import entity.Type;

public class Menu {

    private TypeDao typeDao = new TypeDao();
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
        "Show Brands", 
        "Show a Brand", 
        "Create Brand", 
        "Delete Brand");
    
    public void start() {
        String selection = "";

        do {
            printMenu();
            selection = scanner.nextLine();

            try {
                if(selection.equals("1")) {
                    showBrands();
                } else if (selection.equals("2")) {
                    showBrand();
                } else if (selection.equals("3")) {
                    createBrand();
                } else if (selection.equals("4")) {
                    deleteBrand();
                } 
            } catch (SQLException e) {
                e.printStackTrace();
            }


            System.out.println("Press enter to continue...");
            scanner.nextLine();
        } while(!selection.equals("-1"));
    }
    private void printMenu() {
        System.out.println("Select an option:\n-------------");
        for(int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ") " + options.get(i));
        }
    }
    private void showBrands() throws SQLException {
        List<Type> types = typeDao.getType();
        for(Type type : types) {
            System.out.println(type.getTypeId() + ": " + type.getName());
        }
    }
    private void showBrand() throws SQLException {
        System.out.println("Enter Brand id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Type type = typeDao.getTypeById(id);
        System.out.println(type.getTypeId() + ": " +type.getName());
        for(Brand brand : type.getBrands()) {
            System.out.println("\tBrandId: " + brand.getBrandId() + "-Name: " + brand.getModel() + " " + brand.getType());
        }
    }
    private void createBrand() throws SQLException {
        System.out.println("Enter new brand: ");
        String brandName = scanner.nextLine();
        typeDao.createNewBrand(brandName);
    }
    private void deleteBrand() throws SQLException {
        System.out.print("Enter brand Id to delete: ");
        int carId = Integer.parseInt(scanner.nextLine());
        typeDao.deleteBrandByCarId(carId);
    }
}
