package example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


            Product laptop = new Product(1, "Laptop", 10, 5350);

            Field Id = Product.class.getDeclaredField("m_id");
            Field Name = Product.class.getDeclaredField("m_name");
            Field Stock = Product.class.getDeclaredField("m_stock");
            Field Price = Product.class.getDeclaredField("m_price");

            Id.setAccessible(true);
            Name.setAccessible(true);
            Stock.setAccessible(true);
            Price.setAccessible(true);

            int id = (int)Id.get(laptop);
            String name = (String)Name.get(laptop);
            int stock = (int)Stock.get(laptop);
            int price = (int)Price.get(laptop);

            System.out.printf("ID : %d%nName : %s%nStock : %d%nPrice : %d%n", id, name, stock, price);

            Id.setAccessible(false);
            Name.setAccessible(false);
            Stock.setAccessible(false);
            Price.setAccessible(false);

    }
}

class Product {

    private int m_id;
    private String m_name;
    private int m_stock;
    private int m_price;

    public Product()
    {

    }

    public Product(int id, String name)
    {
        this(id, name, 0, 0);
    }

    public Product(int id, String name, int stock)
    {
        this(id, name, stock, 0);
    }

    public Product(int id, String name, int stock, int price)
    {
        m_id = id;
        m_name = name;
        m_stock = stock;
        m_price = price;
    }

}


