package najah;

import java.util.HashMap;
import java.util.Map;

public class ProgramService {
    private Map<String, Program> programMap = new HashMap<>();

    // Save a new program
    public void saveProgram(Program program) {
        programMap.put(program.getTitle(), program);
    }

    // Get program details
    public Program getProgram(String title) {
        return programMap.get(title);
    }

    // Update program
    public void updateProgram(String title, Program updatedProgram) {
        if (programMap.containsKey(title)) {
            programMap.put(title, updatedProgram);
        }
    }

    // Delete program
    public boolean deleteProgram(String title) {
        if (programMap.containsKey(title)) {
            programMap.remove(title);
            return true;
        }
        return false;
    }


}