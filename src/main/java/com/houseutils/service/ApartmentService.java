package com.houseutils.service;

import com.houseutils.exception.ErrorCode;
import com.houseutils.exception.HouseUtilsException;
import com.houseutils.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author namookk
 */
@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId).orElseThrow(
                () -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND)
        ).getPrice();
    }
}
