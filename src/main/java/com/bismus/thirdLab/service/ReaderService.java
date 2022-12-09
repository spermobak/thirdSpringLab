package com.bismus.thirdLab.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Service
@Component
public class ReaderService {

    private final Scanner scanner;

    public ReaderService(InputStream is){
        this.scanner = new Scanner(is);
    }

    public int readID(){
        if (scanner.hasNextInt()){
            return Integer.parseInt(scanner.nextLine());
        } else throw new IllegalArgumentException();
    }

    public String readWord(){
        if (scanner.hasNext()){
            if (!isNumb(scanner.next())){
                return scanner.nextLine().strip();
            } else throw new IllegalArgumentException();
        } else throw new NoSuchElementException();
    }


    private static boolean isNumb(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
