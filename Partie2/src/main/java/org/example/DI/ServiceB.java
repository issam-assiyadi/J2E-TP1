package org.example.DI;

public class ServiceB {
    int b;
    ServiceA c;

    public ServiceB() {
    }

    public ServiceB(int b, ServiceA c) {
        this.b = b;
        this.c = c;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public ServiceA getC() {
        return c;
    }

    public void setC(ServiceA c) {
        this.c = c;
    }
}
