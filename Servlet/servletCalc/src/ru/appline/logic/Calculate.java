package ru.appline.logic;

public class Calculate {

    public double resu;

    private int a;

    private int b;

    private String math;

    public Calculate(int a, int b, String math) {
        this.a = a;
        this.b = b;
        this.math = math;
    }

    public double plus(int a, int b, String math) {
        double result;

        result = a + b;

        return result;
    }

    public double mines(int a, int b, String math) {
        double result;

        result = a - b;

        return result;
    }

    public double multi(int a, int b, String math) {
        double result;

        result = a * b;

        return result;
    }

    public double devision(int a, int b, String math) {
        double result;

        result = (double) a / b;

        return result;
    }

    public double resu(double res){
        double result = res;
        return result;
    }
}
