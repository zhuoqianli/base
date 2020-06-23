package test;

import test.TestInterface;

public class TestInterfaceImpl implements TestInterface {

    @Override
    public void say() {
        System.out.println("woshisay");
    }

    @Override
    public String write(String name) {
        return name;
    }
}
