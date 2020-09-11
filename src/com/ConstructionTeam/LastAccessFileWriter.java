package com.ConstructionTeam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.ConstructionTeam.Main.LASTACCESSFILENAME;

public class LastAccessFileWriter {

    public void createFile(){

       try {
           File lastAccess=new File(LASTACCESSFILENAME);
           if(lastAccess.createNewFile()){
           System.out.println("Successfully created the file");
           }

       }catch (IOException e){
        System.out.println("An error"+e);
       }
    }

    public void writeFile(String timeStamp){
        createFile();
        try{
            FileWriter lastAccessWriter=new FileWriter(LASTACCESSFILENAME);
            lastAccessWriter.write(timeStamp);
            lastAccessWriter.close();

            System.out.println("Successfully wrote to the file");

        }catch (IOException e){
            System.out.println("An error :"+e);
        }

        }


    }

