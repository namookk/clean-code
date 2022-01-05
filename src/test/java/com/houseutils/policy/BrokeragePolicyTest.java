package com.houseutils.policy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author namookk
 */
class BrokeragePolicyTest {

    PurchaseBrokeragePolicy purchaseBrokeragePolicy;
    RentBrokeragePolicy rentBrokeragePolicy;

    @BeforeEach
    public void beforeEach(){
        purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
        rentBrokeragePolicy = new RentBrokeragePolicy();
    }

    @Test
    public void testPurchaseBrokeragePolicy(){
        //given
        Long price = 30_000_000L;

        //when
        Long result = purchaseBrokeragePolicy.calculate(price);

        //then
        assertEquals(result, 180_000L);
    }

    @Test
    public void testPurchaseBrokeragePolicySection(){
        assertEquals(purchaseBrokeragePolicy.calculate(30_000_000L), 180_000L);
        assertEquals(purchaseBrokeragePolicy.calculate(100_000_000L), 500_000L);
        assertEquals(purchaseBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        assertEquals(purchaseBrokeragePolicy.calculate(800_000_000L), 4_000_000L);
        assertEquals(purchaseBrokeragePolicy.calculate(1_000_000_000L), 9_000_000L);
    }

    @Test
    public void testRentBrokeragePolicySection(){
        assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 150_000L);
        assertEquals(rentBrokeragePolicy.calculate(100_000_000L), 300_000L);
        assertEquals(rentBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        assertEquals(rentBrokeragePolicy.calculate(800_000_000L), 6_400_000L);
        assertEquals(rentBrokeragePolicy.calculate(1_000_000_000L), 8_000_000L);
    }
}