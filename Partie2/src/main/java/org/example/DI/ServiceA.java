package org.example.DI;

public class ServiceA {
    ServiceB a;
    int b;

    public ServiceA() {
    }

    public ServiceA(ServiceB a, int b) {
        this.a = a;
        this.b = b;
    }

    public ServiceB getA() {
        return a;
    }

    public void setA(ServiceB a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
