package secondPart;


import secondPart.pizza.Pizza;

public class Client {
    static PizzaFactory pizzaFactory;

    public Client(){};

    public Client(PizzaFactory pizzaFactory){
        this.pizzaFactory = pizzaFactory;
        this.pizzaFactory.attachObserver(this);
    }

    public static void receiveUpdate(){
        System.out.println("State = " + pizzaFactory.getState());
    }

    public static void main(String[] args){
        pizzaFactory = PizzaFactory.instance();
        Client client = new Client(pizzaFactory);
    }

    public void Capriciosa(){
        System.out.println("Client ordered a capriciosa");
       // pizzaFactory.setState(1);
    }

    public void Marguerita(){
        System.out.println("Client ordered a Marguerita");
       // pizzaFactory.setState(2);
    }

}

class CommandCapriciosa extends Command{
    public void execute(Client client){
        client.Capriciosa();
    }

}

class CommandMarguerita extends Command{
    public void execute(Client client){
        client.Marguerita();
    }
}