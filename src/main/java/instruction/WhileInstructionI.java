package instruction;

import java.util.HashMap;

public interface WhileInstructionI extends SimpleInstruction {
    public void run(HashMap<String, Object> hm);
}