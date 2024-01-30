package com.daylog.tomatolog.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Service
public class PaginationService {

    private static final int BAR_LENGTH = 5;


    public List<Integer> getPaginationBarNumbers(int currentPageNumber, int totalPages) {
        // startNumber
        int startNumber = max(currentPageNumber - ( BAR_LENGTH / 2), 0) ;
        int endNumber = min(startNumber + BAR_LENGTH, totalPages);

        return IntStream.range(startNumber, endNumber).boxed().toList();
    }

    public int currentBarLength() {
        return BAR_LENGTH;
    }

}
