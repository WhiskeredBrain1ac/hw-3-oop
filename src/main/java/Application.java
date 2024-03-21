import animal.CreateAnimalServiceImpl;

public class Application {
    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
        service.create("Cat", 2);
    }

}