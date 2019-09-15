package StaticProxy;

public class Client {
    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy(new FoodServiceImpl());
        staticProxy.makeChicken();
    }

}