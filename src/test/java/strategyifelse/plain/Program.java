package strategyifelse.plain;

import java.util.Objects;

public class Program {

    public void coding(String language){
        if(Objects.equals("Java", language)){
            System.out.println("I'm writing Java code.");
        }else if(Objects.equals("Python", language)){
            System.out.println("I'm writing Python code.");
        }else if(Objects.equals("Scala", language)) {
            System.out.println("I'm writing Scala code.");
        }else if(Objects.equals("JavaScrip", language)) {
            System.out.println("I'm writing JavaScrip code.");
        }else if(Objects.equals("Shell", language)) {
            System.out.println("I'm writing Shell code.");
        }else if(Objects.equals("Php", language)) {
            System.out.println("I'm writing Php code.");
        }else if(Objects.equals("C#", language)) {
            System.out.println("I'm writing C# code.");
        }else if(Objects.equals("C", language)) {
            System.out.println("I'm writing C code.");
        }else if(Objects.equals("C++", language)) {
            System.out.println("I'm writing C++ code.");
        }else if(Objects.equals("Basic", language)) {
            System.out.println("I'm writing Basic code.");
        }else if(Objects.equals("Perl", language)) {
            System.out.println("I'm writing Perl code.");
        }else if(Objects.equals("SQL", language)) {
            System.out.println("I'm writing SQL code.");
        }else if(Objects.equals("MATLAB", language)) {
            System.out.println("I'm writing MATLAB code.");
        }else if(Objects.equals("Scratch", language)) {
            System.out.println("I'm writing Scratch code.");
        }else if(Objects.equals("Go", language)) {
            System.out.println("I'm writing Go code.");
        }else if(Objects.equals("Fortran", language)) {
            System.out.println("I'm writing Fortran code.");
        }else if(Objects.equals("Ruby", language)) {
            System.out.println("I'm writing Ruby code.");
        }else if(Objects.equals("Swift", language)) {
            System.out.println("I'm writing Swift code.");
        }else if(Objects.equals("Rust", language)) {
            System.out.println("I'm writing Rust code.");
        }else if(Objects.equals("Lua", language)) {
            System.out.println("I'm writing Lua code.");
        }else if(Objects.equals("Pascal", language)) {
            System.out.println("I'm writing Pascal code.");
        }else if(Objects.equals("Erlang", language)) {
            System.out.println("I'm writing Erlang code.");
        }else if(Objects.equals("Pascal", language)) {
            System.out.println("I'm writing Pascal code.");
        }else if(Objects.equals("a new language", language)) {
            System.out.println("I'm writing a new language code.");
        }
        else{
            System.out.println("Language not supported.");
        }
    }
}