/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package read.html.tags;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
/**
 *
 * @author Pasindu
 */
public class ReadHtmlTags {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String url = "https://www.nlb.lk/English/results/mahajana-sampatha";
            Document doc = (Document) Jsoup.connect(url).get();
            Element table = doc.select("table").get(0);
            Elements rows = table.select("tr");
            
            for (int i = 1; i < rows.size(); i++) { 
                Element row = rows.get(i);
                Elements cols = row.select("td");
                System.out.println("Draw No: "+ cols.get(0).getElementsByTag("b").text());
                System.out.println("Date: "+ cols.get(0).text().substring(5));
                
                Element result = cols.get(1);
                Elements numbers = result.getElementsByTag("li");
                for(Element num: numbers){
                    System.out.print(num.text()+" ");

                }
                System.out.println();
                System.out.println();

                
            }

        } catch (Exception e) {
        }
        
    }
    
}
