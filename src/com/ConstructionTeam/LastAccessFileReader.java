package com.ConstructionTeam;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.ConstructionTeam.Main.LASTACCESSFILENAME;

public class LastAccessFileReader {
    private String lastAccesstime;

    public String FileReader(){

        try {
            File file=new File(LASTACCESSFILENAME);
            Scanner reader=new Scanner(file);
            lastAccesstime=reader.nextLine();

        }catch (IOException e){
            System.out.println("error :"+e);
        }

        return lastAccesstime;
    }
}
