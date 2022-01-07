package com.houseutils.policy;

import com.houseutils.exception.ErrorCode;
import com.houseutils.exception.HouseUtilsException;

import java.util.List;

/**
 * @author namookk
 */
public interface BrokeragePolicy {
    List<BrokerageRule> getRules();

    default Long calculate(Long price){
        //TODO: 가격을 받아서 중개수수료를 계산한다.

        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessThen())
                .findFirst()
                .orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));

        //BrokerageRule rule = createBrokerageRule(price);

        return brokerageRule.calcMaxBrokerage(price);
    }
}
