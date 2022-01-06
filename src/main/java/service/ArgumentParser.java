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

    /**
     * Parse args into a Graph
     *
     * @param args
     */
    public ArgumentParser(String[] args) {

        this.argumentGraph = new HashMap<>();
        int numberOfArguments = args.length;
        int j;
        int i;

        List<String> tmp;
        for (i = 0; i < numberOfArguments; i++) {
            if (args[i].contains("-")) {
                j = i + 1;
                tmp = new LinkedList<>();
                while (j < numberOfArguments && !args[j].contains("-")) {
                    tmp.add(args[j]);
                    j++;
                }
                this.argumentGraph.put(args[i], tmp);
            }
        }
    }

    /**
     *
     * @return true if arguments contain the flag "--config"
     */
    public boolean hasConfigFlag() {
        return argumentGraph.containsKey("--config");
    }

    /**
     *
     * @return filename and path of a custom config.properties file
     */
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

    /**
     * @return true if arguments contain the flag "--bl" or "--backuplist" or
     * "-bl"
     */
    public boolean isBackupListsRequest() {
        return argumentGraph.containsKey("--bl") || argumentGraph.containsKey("--backuplist") || argumentGraph.containsKey("-bl");
    }

    /**
     * @return true if arguments contain the flag "--h" or "--help" or "-h" or
     * "--?" or "-?"
     */
    public boolean isHelpRequest() {
        return argumentGraph.containsKey("--h") || argumentGraph.containsKey("--help") || argumentGraph.containsKey("-h") || argumentGraph.containsKey("-?") || argumentGraph.containsKey("--?");
    }

    /**
     *
     * @return true if arguments contain the flag "--list" or "-list" or "-l"
     */
    public boolean isListsRequest() {
        return argumentGraph.containsKey("--list") || argumentGraph.containsKey("--l") || argumentGraph.containsKey("-list");
    }

    /**
     *
     * @return true if arguments contain the flag "--version" or "-v" or "--v"
     */
    public boolean isVersionRequest() {
        return argumentGraph.containsKey("--v") || argumentGraph.containsKey("--version") || argumentGraph.containsKey("-v");
    }

    /**
     *
     * @return true if arguments contain the flag "--all" or "-a" or "--a"
     */
    public boolean isRunAllDatabaseBackupsRequest() {
        return argumentGraph.containsKey("--a") || argumentGraph.containsKey("--all") || argumentGraph.containsKey("-a");
    }

    @Override
    public String toString() {
        return argumentGraph.toString();
    }
}
