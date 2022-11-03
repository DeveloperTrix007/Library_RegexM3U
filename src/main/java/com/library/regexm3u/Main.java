package com.library.regexm3u;

import org.json.JSONArray;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        String texto = "#EXTINF:-1 group-title=\"RADIOS\" tvg-logo=\"http://i.imgur.com/MmJBR9j.png\" tvg-name=\"gfgfghhghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhggfhfhfghgfhghghghgfhfhgta\"radio=true,RADIO Rap Nacional\n" +
                "http://192.99.150.31:8377/;";


        RegexM3U regexM3U = new RegexM3U();



       //File file =  new File("canais_from_m3u.txt");


      // JSONArray jsonArray = regexM3U.Getinfo(new File("canais_from_m3u.txt"));

      // System.out.println(jsonArray);



        System.out.println(regexM3U.Getinfo(texto));



    }


}