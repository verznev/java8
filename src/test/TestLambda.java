package test;

import main.InvoiceImpl;
import main.Mechanic;
import main.Shipment;
import main.domain.Car;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static main.InvoiceImpl.findNumbers;
import static org.junit.Assert.assertTrue;

/**
 * Created by Win7 on 1/28/2018.
 */
public class TestLambda {
    Consumer<Object> print = System.out::println;

    @Test
    public void test_Lambda_Expression() {
       Runnable r = () -> System.out.println("Hi!");
       r.run();
    }

    @Test
    public void test_LambdaMethod_Rerences_To_Static_Method() {

        Function<String, Integer> converter = Integer::parseInt;
        Integer number = converter.apply("10");
        assertTrue(10 == number);

        //**************************************************************

        // Using a method reference
        List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);
        print.accept(findNumbers(list, InvoiceImpl::isMoreThanFifty));
        print.accept(list.toString());

    }

    @Test
    public void test_Lambda_Method_Rerences_To_Instance_Method() {
        List<Shipment> shipmentList =  generateShipmentTestData();
        Shipment shipment = new Shipment();

        List<String> convertedToKilogram = shipment.calculateOnShipments(shipmentList, Shipment::convertToKilogram);
        for (String result : convertedToKilogram) {
            print.accept(result);
        }

    }

    @Test
    public void test_Lambda_Method_Rerences_To_Instance_Method_Of_An_Existing_Object() {
        Mechanic mechanic = new Mechanic();
        Car car = generateCarTestData();

        mechanic.executeFix(car, mechanic::fix);
    }

    @Test
    public void test_Lambda_Method_Reference_To_Constructor_Method() {
        // if the constructor takes no argument use Supplier interface
        Supplier<Mechanic> mechanic = Mechanic::new;
        mechanic.get();

        // else if the constructor have argument use Function interface
        Function<String, Mechanic> f = Mechanic::new;
        f.apply("MyArgument");

        // else if the constructor have 2 arguments use BiFunction interface
        BiFunction<String, String, Mechanic> f2 = Mechanic::new;
        f2.apply("MyArgument1", "MyArgument2"
        );
    }

    // TEST DATA HERE

    private List<Shipment> generateShipmentTestData() {
        List<Shipment> shipmentList = new ArrayList<>();
        Shipment s1 = new Shipment();
        s1.setPounds(200.0);
        shipmentList.add(s1);
        Shipment s2 = new Shipment();
        s2.setPounds(150.0);
        shipmentList.add(s2);

        return shipmentList;
    }

    private Car generateCarTestData() {
        Car car = new Car();
        car.setId(1112323);
        car.setColor("Black");

        return car;
    }

}
