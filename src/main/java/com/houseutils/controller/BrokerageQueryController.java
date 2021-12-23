package com.houseutils.controller;

import com.houseutils.constants.ActionType;
import com.houseutils.policy.BrokeragePolicy;
import com.houseutils.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price){

        //TODO: 중개수수료 계산하는 로직
//        if(actionType == ActionType.PURCHASE) {
//            PurchaseBrokeragePolicy policy = new PurchaseBrokeragePolicy();
//            return policy.calculate(price);
//        }
//        if(actionType == ActionType.RENT) {
//            RentBrokeragePolicy policy = new RentBrokeragePolicy();
//            return policy.calculate(price);
//        }

        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}
