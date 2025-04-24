package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() throws Exception {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test single add happy case")
    void testAddSingleItemAndGetTotalCost() {
        cart.addItem("Laptop", 1000.0);
        assertEquals(1000.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test adding multiple to get total cost")
    void testAddMultipleItemsAndGetTotalCost() {
        cart.addItem("Shirt", 25.0);
        cart.addItem("Pants", 45.0);
        cart.addItem("Shoes", 60.0);
        assertEquals(130.0, cart.getTotalCost());
    }
    
    @Test
    @DisplayName("Test adding item with 0 price")
    void testAddItemWithZeroPrice() {
        cart.addItem("FreeItem", 0.0);
        assertEquals(0.0, cart.getTotalCost());
    }
    
    @Test
    @DisplayName("Test applyDiscountCode SAVE10 discount code")
    void testApplySave10Discount() {
        cart.addItem("Headphones", 200.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(180.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test applyDiscountCode SAVE20 code")
    void testApplySave20Discount() {
        cart.addItem("Keyboard", 50.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(40.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test applyDiscountCode with invalid code")
    void testApplyInvalidDiscountCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("rbhewabgin");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

    @Test
    @DisplayName("Test add with negative price")
    void testAddItemWithNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Book", -15.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test getTotalCost with no items")
    void testGetTotalCostWithNoItems() {
        assertEquals(0.0, cart.getTotalCost());
    }


    @Test
    @DisplayName("Test getDiscountPercentage with valid applied code")
    void testGetDiscountPercentageAfterApplyingCode() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

}