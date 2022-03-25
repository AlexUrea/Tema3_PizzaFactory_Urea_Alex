package secondPart;

abstract class Command {
    public abstract void execute(Client client);

    public static void main(String[] args){
        Client client = new Client();
        CommandCapriciosa c1 = new CommandCapriciosa();
        CommandMarguerita c2 = new CommandMarguerita();
        c1.execute(client);
        c2.execute(client);
    }
}
