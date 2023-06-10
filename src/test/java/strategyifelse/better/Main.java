package strategyifelse.better;

public class Main {
    public static void main(String[] args) {
        Programmer javaProgrammer = new Programmer(
                new JavaProgram()
        );
        javaProgrammer.codingStrategy();

        Programmer pythonProgrammer = new Programmer(
                new PythonProgram()
        );
        pythonProgrammer.codingStrategy();
    }
}
