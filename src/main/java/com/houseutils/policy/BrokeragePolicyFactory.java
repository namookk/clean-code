package com.houseutils.policy;

import com.houseutils.constants.ActionType;
import com.houseutils.exception.ErrorCode;
import com.houseutils.exception.HouseUtilsException;

/**
 * @author namookk
 */
public class BrokeragePolicyFactory {
    private static final RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy();
    private static final PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();

    public static BrokeragePolicy of(ActionType actionType){
        switch (actionType) {
            case RENT:
                return rentBrokeragePolicy;
            case PURCHASE:
                return purchaseBrokeragePolicy;
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 actionType애 대한 정책이 존재하지 않습니다.");
        }
    }
}
