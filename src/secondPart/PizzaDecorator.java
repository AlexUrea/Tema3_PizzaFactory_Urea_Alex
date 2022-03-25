package secondPart;

import secondPart.pizza.Pizza;

public class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
