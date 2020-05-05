package designpatterns.strategy;

/**
 * We could have used composition to create instance variable for strategies but we should avoid that as we want the specific strategy to be applied for a particular task. Same
 * is followed in Collections.sort() and Arrays.sort() method that take comparator as argument.
 * Strategy Pattern is very similar to State Pattern. One of the difference is that Context contains state as instance variable and there can be multiple tasks whose
 * implementation can be dependent on the state whereas in strategy pattern strategy is passed as argument to the method and context object doesn’t have any variable to store it.
 * Strategy pattern is useful when we have multiple algorithms for specific task and we want our application to be flexible to chose any of the algorithm at runtime for specific
 * task.
 */
public class Payment {

    public void pay(PaymentHandler paymentHandler, int amount) {
        paymentHandler.pay(amount);
    }
}

interface PaymentHandler {
    void pay(int amount);
}

class CreditCardHandler implements PaymentHandler {

    @Override
    public void pay(int amount) {

    }
}

class BankHandler implements PaymentHandler {

    @Override
    public void pay(int amount) {

    }
}

class Test {
    public void test() {
        Payment payment = new Payment();
        payment.pay(new CreditCardHandler(), 39);
    }
}