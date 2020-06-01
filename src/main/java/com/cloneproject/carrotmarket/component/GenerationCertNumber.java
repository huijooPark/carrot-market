package com.cloneproject.carrotmarket.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Setter
@Component
public class GenerationCertNumber {
    private int number_len = 12;
    private final char[] randomTable =
            { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&', '*',
            '(', ')', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

    public String executeGenerate() {
        Random random = new Random(System.currentTimeMillis());
        int table_length = randomTable.length;
        StringBuffer buf = new StringBuffer();

        for(int i = 0; i < number_len; i++) {
            buf.append(randomTable[random.nextInt(table_length)]);
        }

        return buf.toString();
    }

}
