/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shady
 */
public final class ArgumentParser {

    private Map<String, List<String>> argumentGraph;

    public ArgumentParser(String[] args) {

        this.argumentGraph = new HashMap<>();
        int numberOfArguments = args.length;
        int j;
        int i;

        List<String> tmp;
        for (i = 0; i < numberOfArguments; i++) {
            if (args[i].contains("-")) {
                //System.out.println("trattino");
                j = i + 1;
                tmp = new LinkedList<>();
                while (j < numberOfArguments && !args[j].contains("-")) {
                    tmp.add(args[j]);
                    j++;
                }
                this.argumentGraph.put(args[i], tmp);
            }
            //System.out.println(args[i]);
        }

    }

    public String getConfigFilePath() {
        return this.argumentGraph.get("--config").get(0);
    }

    public List<String> getDbList() {
        return argumentGraph.get("--bl");
    }
    
    @Override
    public String toString(){
        return this.argumentGraph.toString();
    }
}
