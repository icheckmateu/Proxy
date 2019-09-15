package StaticProxy;

public class StaticProxy implements FoodService {

    private FoodService foodService;
    public StaticProxy(FoodService foodService){
        this.foodService = foodService;
    }
    @Override
    public void makeNoodle() {
        foodService.makeNoodle();
    }

    @Override
    public void makeChicken() {
        foodService.makeChicken();
    }
}