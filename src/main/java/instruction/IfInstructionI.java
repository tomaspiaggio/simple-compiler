package instruction;

import java.util.HashMap;

public interface IfInstructionI extends SimpleInstruction {
    public void run(HashMap<String, Object> hm);
}
