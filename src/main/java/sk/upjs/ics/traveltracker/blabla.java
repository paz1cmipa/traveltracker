/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.traveltracker;

import java.util.*;

public class blabla {
      public List<String> dajVsetkyKrajiny(){
        String[] lokaly = Locale.getISOCountries();
        List<String> krajiny = new ArrayList<String>();
        for (String kodKrajiny: lokaly){
            Locale lokal = new Locale ("",kodKrajiny);
            krajiny.add(lokal.getDisplayCountry());
        }
        
        return krajiny;
      }
        

    public static void main(String[] args){
        blabla test = new blabla();
        List<String> krajiny = test.dajVsetkyKrajiny();
        for (int i= 0; i<krajiny.size(); i++){
            System.out.println(krajiny.get(i));
        }
}
}
