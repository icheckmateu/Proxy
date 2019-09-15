package DynamicProxy;

public class Client {
    public static void main(String[] args){
        DynamicProxy dynamicProxy=new DynamicProxy();
        FoodService foodService=(FoodService)dynamicProxy.newProxyInstance(new FoodServiceImpl());
        //UserManager userManager=new UserManagerImpl();
        foodService.makeChicken();
    }
}