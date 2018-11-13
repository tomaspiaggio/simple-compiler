package instruction;

import java.util.HashMap;

public interface IfInstructionI extends Instruction {
    public void run(HashMap<String, Object> hm);
}
