package strategyifelse.better;

public class Programmer {

    private final Program program;

    public Programmer(Program program) {
        this.program = program;
    }

    public void codingStrategy(){
        program.coding();
    }
}
