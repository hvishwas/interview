package designpatterns.builder;

public class Test {

    private int test;

    private Test(int test) {
        this.test = test;
    }

    public static class Builder {
        private int test;

        public Builder test(int test) {
            this.test = test;
            return this;
        }

        public Test build() {
            return new Test(test);
        }
    }
}

class TestClass {
    Test test = new Test.Builder().test(12).build();
}
