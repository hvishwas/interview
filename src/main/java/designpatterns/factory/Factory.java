package designpatterns.factory;

public class Factory {

    public enum ProcessorEnum {
        FIRST_DATA,
        VANTIV
    }

    public Processor getProcessor(ProcessorEnum processorEnum) {
        switch (processorEnum) {
            case FIRST_DATA:
                return new FirstData();
            case VANTIV:
                return new Vantiv();
            default:
                return null;//or throw exception;
        }
    }
}

interface Processor {
    void process();
}

class FirstData implements Processor {

    @Override
    public void process() {

    }
}

class Vantiv implements Processor {

    @Override
    public void process() {

    }
}

class Test {
    public void test() {
        Factory factory = new Factory();
        factory.getProcessor(Factory.ProcessorEnum.FIRST_DATA).process();
    }
}
