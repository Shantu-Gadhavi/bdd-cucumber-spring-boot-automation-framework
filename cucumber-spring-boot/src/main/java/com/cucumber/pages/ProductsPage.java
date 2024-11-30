package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import com.cucumber.configurations.annotations.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

@LazyComponent
public class ProductsPage extends Base {

    private final By itemList = By.xpath("//div[@class='inventory_item']");
    private final By itemNames = By.xpath("//div[@class='inventory_item_label']//a");
    private final By addToCartButton = By.xpath("//div[@class='inventory_item']//button");
    private final By itemsPrices = By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_price']");
    private final By cartButton = By.xpath("//div[@id='shopping_cart_container']/a");
    private final By cartImage = By.xpath("//*[@id='shopping_cart_container']/a/span");

    private static final List<String> productCounter = new ArrayList<>();

    public void clickAddToCart(String prodName){
        productCounter.add(prodName);
        LinkedList<WebElement> prods = new LinkedList<>(driver.findElements(itemNames));
        LinkedList<WebElement> carts = new LinkedList<>(driver.findElements(addToCartButton));
        LinkedHashMap<String, WebElement> products = new LinkedHashMap<>();
        for(int i=0; i<prods.size(); i++){
            products.put(prods.get(i).getText(), carts.get(i));
        }
        for(Map.Entry<String, WebElement> entry: products.entrySet()){
            if(entry.getKey().equalsIgnoreCase(prodName)){
                entry.getValue().click();
                break;
            }
        }

    }

    public boolean verifyTheProductsAddedInCart(){
        boolean isCountCorrect;
        int prodSize = productCounter.size();
        System.out.println("Number of products added: "+prodSize);
        isCountCorrect = prodSize == getProductsCountFromCart();
        return isCountCorrect;
    }

    public int getProductsCountFromCart(){
        String noOfProds = webPageElement.getTextFromElement(driver,cartImage);
        return Integer.parseInt(noOfProds);
    }

    public void clickViewCart(){
        webButton.click(driver, cartButton);
    }

}
