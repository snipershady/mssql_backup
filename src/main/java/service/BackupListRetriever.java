
package service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shady
 */
public class BackupListRetriever {

    private ArgumentParser ap;

    public BackupListRetriever(ArgumentParser ap) {
        this.ap = ap;
    }

    public List<String> getDbList() throws IOException {

        if (!this.ap.getDbList().isEmpty()) {
            return ap.getDbList();
        }

        PropertiesParser pp = new PropertiesParser();

        if (!pp.getDbListCsv().isBlank()) {
            return csvToList(pp.getDbListCsv());
        }
        return new LinkedList<>();

    }

    private List<String> csvToList(String csv) {
        List<String> ll = new LinkedList<>();
        String[] split = csv.split(",");
        for (short i = 0; i < split.length; i++) {
            System.out.println(split[i].trim());
            ll.add(split[i].trim());
        }
        return ll;

    }
}
