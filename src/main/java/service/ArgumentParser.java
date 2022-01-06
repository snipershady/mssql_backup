
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

    private final Map<String, List<String>> argumentGraph;

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

    public boolean hasConfigFlag() {
        return argumentGraph.containsKey("--config");
    }

    public String getConfigFilePath() {
        return argumentGraph.containsKey("--config") ? argumentGraph.get("--config").get(0) : null;
    }

    /**
     *
     * @return List of String with list of databases name
     */
    public List<String> getDbList() {
        if (argumentGraph.containsKey("--bl")) {
            return argumentGraph.get("--bl");
        }

        if (argumentGraph.containsKey("--backuplist")) {
            return argumentGraph.get("--backuplist");
        }

        if (argumentGraph.containsKey("-bl")) {
            return argumentGraph.get("-bl");
        }

        return null;
    }

    public boolean isBackupListsRequest() {
        return argumentGraph.containsKey("--bl") || argumentGraph.containsKey("--backuplist") || argumentGraph.containsKey("-bl");
    }

    public boolean isHelpRequest() {
        return argumentGraph.containsKey("--h") || argumentGraph.containsKey("--help") || argumentGraph.containsKey("-h") || argumentGraph.containsKey("-?") || argumentGraph.containsKey("--?");
    }

    public boolean isListsRequest() {
        return argumentGraph.containsKey("--list") || argumentGraph.containsKey("--l") || argumentGraph.containsKey("-list");
    }

    public boolean isVersionRequest() {
        return argumentGraph.containsKey("--v") || argumentGraph.containsKey("--version") || argumentGraph.containsKey("-v");
    }

    public boolean isRunAllDatabaseBackupsRequest() {
        return argumentGraph.containsKey("--a") || argumentGraph.containsKey("--all") || argumentGraph.containsKey("-a");
    }

    @Override
    public String toString() {
        return argumentGraph.toString();
    }
}
