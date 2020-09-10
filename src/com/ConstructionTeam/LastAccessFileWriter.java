package com.ConstructionTeam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LastAccessFileWriter {

    public final String LASTACCESSFILE="last access.txt";


    private void createFile(){

       try {
           File lastAccess=new File(LASTACCESSFILE);
           lastAccess.createNewFile();
           System.out.println("Successfully created the file");

       }catch (IOException e){
        System.out.println("An error"+e);
       }
    }

    public void writeFile(String timeStamp){
        createFile();
        try{
            FileWriter lastAccessWriter=new FileWriter(LASTACCESSFILE);
            lastAccessWriter.write(timeStamp);
            lastAccessWriter.close();

            System.out.println("Successfully wrote to the file");

        }catch (IOException e){
            System.out.println("An error :"+e);
        }

        }


    }

