package test;

import service.RainMangerService;

public class TestDeleteById {
    public static void main(String[] args) {
        RainMangerService service = new RainMangerService();
        int i = service.deleteById("14");
        System.out.println(i);
    }
}
