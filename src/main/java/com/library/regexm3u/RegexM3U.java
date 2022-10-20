package com.library.regexm3u;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class RegexM3U {
    /**
     * Pega informaçôes da lista em jsonAray
     * @param str_texto
     * @return JsonArray
     */
    public JSONArray Getinfo(String str_texto) {

      return Compilar_TEXTO(str_texto);


    }

    /**
     * Pega informaçôes da lista em jsonAray
     * Converte aquivo txt em string
     * @param FileTXT
     * @return JsonArray
     * @throws IOException
     */
    public JSONArray Getinfo(File FileTXT) throws IOException {

        if (FileTXT.isFile()){
            String texto = FileUtils.readFileToString(FileTXT, "UTF-8");




            return   Compilar_TEXTO(texto);
        }else{
            System.out.println("Error arquivo nao existe");
            return null;
        }



    }

    /**
     * Estrair nome,logos,link,etc e converte em JsonArray
     * @param texto
     * @return JsonArray
     */
    private JSONArray Compilar_TEXTO(String texto) {


        JSONArray jsonArray = new JSONArray();






        Matcher list_found = Pattern.compile("#EXTINF:.*\\n*.*").matcher(texto);




        while (list_found.find()) {

            JSONObject object = new JSONObject();




            Matcher tvg_logo_count = Pattern.compile("tvg-logo=['|\"].*?['!\"]").matcher(list_found.group());

            if (tvg_logo_count.find()) {
                //get logo texto
                String logo = tvg_logo_count.group()
                        .replaceAll("tvg-logo=['\"]", "")
                        .replaceAll("['\"]", "");

                object.put("ss",logo);








            }else{
                object.put("logo","");
            }


            Matcher tvg_name_count_option1 = Pattern.compile("tvg-name=['|\"].*?['!\"]").matcher(list_found.group());
            Matcher tvg_name_count_option2 = Pattern.compile(",.*").matcher(list_found.group());

            if (tvg_name_count_option1.find()) {
                String name = tvg_name_count_option1.group()

                        .replaceAll("tvg-name=['\"]", "")
                        .replaceAll("['\"]", "");


                object.put("nome",name);





            } else if (tvg_name_count_option2.find()) {

                String name = tvg_name_count_option2.group().replaceAll(",", "").trim();

                object.put("nome",name);






            }else{

                    object.put("nome","");

            }


            Matcher t = Pattern.compile("\\n(http|https).*").matcher(list_found.group());

            if (t.find()) {
                String link_canal = t.group().trim();

                object.put("link",link_canal);




            }else{


                    object.put("link","kkkkkkk");


            }

            jsonArray.put(object);

        }



return jsonArray;

    }


}
