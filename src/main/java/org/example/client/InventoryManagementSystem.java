package org.example.client;

import org.example.dto.ProductDto;
import org.example.entity.Product;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;

import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Product");
        System.out.println("2. Display All Products");
        System.out.println("3. Find a specific product");
        //....

        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                createProduct(scanner);
                break;

            case 2:
                displayAllProducts();
                break;

            case 3:
                findProductById(scanner);
                break;

            case 4:
                notifyLowStock(scanner);
                break;
        }
    }

    public static void createProduct(Scanner sc){
        System.out.println("Ju lutem fusni emrin e producktit");
        String name = sc.next();
        System.out.println("Ju lutem fusni cmimin e producktit");
        Double price = sc.nextDouble();
        System.out.println("Ju lutem fusni descr e producktit");
        String description = sc.next();
        System.out.println("Ju lutem fusni sasine e producktit");
        Integer quantity = sc.nextInt();
        System.out.println("Ju lutem fusni categorine e producktit");
        Long category = sc.nextLong();

        ProductDto productDto =  new ProductDto();
        productDto.setPrice(price);
        productDto.setDescription(description);
        productDto.setName(name);
        productDto.setQuantity(quantity);
        productDto.setCategoryId(category);

        ProductService productService = new ProductServiceImpl();
        productService.createProduct(productDto);


    }

    public static void displayAllProducts(){

    }
    public static void findProductById(Scanner scanner){
        System.out.println("Ju lutem fusni id e producktit");
        long id = scanner.nextLong();

        ProductService productService = new ProductServiceImpl();
        Product product = productService.findOne(id);
        System.out.println(product);
    }

    public  static void notifyLowStock(Scanner scanner){
        System.out.println("Vendosni limitin e stock-ut:");
        int limitStock = scanner.nextInt();
        if (limitStock)
    }
}

