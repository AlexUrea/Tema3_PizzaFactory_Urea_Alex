package secondPart;


import secondPart.enms.PizzaType;
import secondPart.enms.Topping;
import secondPart.pizza.*;

import java.util.Observer;

public class PizzaFactory {

    static PizzaFactory pizzaFactory;
    public static void main(String[] args){
        pizzaFactory = PizzaFactory.instance();
        Client client = new Client(pizzaFactory);
        pizzaFactory.setState(1);

        CommandCapriciosa c1 = new CommandCapriciosa();
        CommandMarguerita c2 = new CommandMarguerita();
        c1.execute(client);
        c2.execute(client);

    }
    
    private static PizzaFactory uniqueInstance;
    PizzaType pizzaTypes;
    Topping toppingTypes;
    public Client observer;
    private int state;

    private PizzaFactory() {

    }

    //Singleton:

    public static PizzaFactory instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PizzaFactory();
        }
        return uniqueInstance;
    }

    public Pizza createPizza(PizzaType type) {
        switch (type) {
            case CAPRICIOSA:
                return new Capriciosa();
            case PROSCIUTTO_FUNGHI:
                return new ProsciuttoFunghi();
            case QUATRO_STAGIONI:
                return new QuatroStagioni();
            case MARGUERITA:
                return new Marguerita();
        }
        return null;
    }

    //Observer Subject

    public void setState(int state) {
        this.state = state;
        notifyObserver();
    }

    public int getState(){
        return this.state;
    }

    public void notifyObserver() {
        observer.receiveUpdate();
    }

    public void attachObserver(Client observer) {
        this.observer = observer;

    }
}



