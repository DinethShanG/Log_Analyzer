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

            if(file.length()!=0)// checking empty file
            { lastAccesstime=reader.nextLine();
            }
            else{
                System.out.println("No any error in the Log file");
            }

        }catch (IOException e){
            System.out.println("error :"+e);
        }

        return lastAccesstime;
    }
}
