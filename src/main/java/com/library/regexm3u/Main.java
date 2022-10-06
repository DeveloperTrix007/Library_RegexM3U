package com.library.regexm3u;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        JSONObject object = new JSONObject();
        JSONArray ja = new JSONArray();

        ArrayList list = new ArrayList();





        String texto = "#EXTINF: -1 tvg-logo='https://upload.wikimedia.org/wikipedia/commons/f/fe/CARTOON_NETWORK_logo.png' tvg-name='globo' tvg-link='http://cdn.tvwebplay.top/live/teste123/teste123/101.ts' group-title='Desenhos', Cartoon\n" +
                "http://cdn.tvwebplay.top/live/teste123/teste123/101.ts\n" +
                "#EXTINF:-1 tvg-id=\"\" tvg-logo=\"https://minhalista-files.nyc3.digitaloceanspaces.com/iptv-list.jpg\" group-title=\"Futebol Ao Vivo\",Jogos Ao Vivo 5\n" +
                "http://aovivo.futeboltv.com:8081/live/15/chunks.m3u8?LISTASGLAU\n"+
                "#EXTINF: -1 tvg-logo='https://upload.wikimedia.org/wikipedia/commons/f/fe/CARTOON_NETWORK_logo.pnh' tvg-name='Sbt' tvg-link='http://cdn.tvwebplay.top/live/teste123/teste123/101.ts' group-title='Desenhos', Cartoon\\n\" +\n" +
                "http://cdn.tvwebplay.top/live/teste123/teste123/101.ts";


        Matcher list_found = Pattern.compile("#EXTINF:.*\\n*.*").matcher(texto);


        //"(tvg-logo=.?.*?)[|']"




        //Matcher tvg_name_count = Pattern.compile("tvg-name=['|\"].*?['!\"]").matcher(texto);


        //Matcher tvg_logo_count = Pattern.compile("tvg-logo=['|\"].*?['!\"]").matcher(list_found.group());






        while (list_found.find()){

            Matcher tvg_logo_count = Pattern.compile("tvg-logo=['|\"].*?['!\"]").matcher(list_found.group());

            if(tvg_logo_count.find()){
                //get logo texto
                String logo = tvg_logo_count.group()
                        .replaceAll("tvg-logo=['\"]","")
                        .replaceAll("['\"]","");

                System.out.println(logo);




            }





            Matcher tvg_name_count_option1 = Pattern.compile("tvg-name=['|\"].*?['!\"]").matcher(list_found.group());
            Matcher tvg_name_count_option2 = Pattern.compile(",.*").matcher(list_found.group());


            if(tvg_name_count_option1.find()){
                String name = tvg_name_count_option1.group()

                        .replaceAll("tvg-name=['\"]","")
                        .replaceAll("['\"]","");



                System.out.println(name);

            }else  if(tvg_name_count_option2.find()){




                System.out.println(tvg_name_count_option2.group().replaceAll(",","").trim());


            }





            Matcher t = Pattern.compile("\\n(http|https).*").matcher(list_found.group());

            if(t.find()) {

                System.out.println(t.group().trim());

            }








        }










    }
}