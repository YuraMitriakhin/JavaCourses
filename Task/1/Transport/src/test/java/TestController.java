import com.gmail.yuramitryahin.controller.Controller;
import com.gmail.yuramitryahin.controller.CreateCarriage;
import com.gmail.yuramitryahin.model.Model;
import com.gmail.yuramitryahin.model.WrongInputException;
import com.gmail.yuramitryahin.model.entity.CarriageComfort;
import com.gmail.yuramitryahin.model.entity.PassengerCarriage;
import com.gmail.yuramitryahin.view.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.gmail.yuramitryahin.RegularProperties.NUM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestController {
    List<PassengerCarriage> list;
    List<PassengerCarriage> sortList;
    Controller controller;
    CreateCarriage createCarriage;

    @Before
    public void initialization(){
        list = new ArrayList<>();
        sortList = new ArrayList<>();
        controller = new Controller( new Model(), new View());
        createCarriage = new CreateCarriage(new View(), new Scanner(System.in));
    }

    @Test
    public void testSortCarriage(){
        addElementToList();
        list = controller.sort(list);
        for (int i=0; i<list.size(); i++) {
            Assert.assertTrue(list.get(i).getIDTransport()==sortList.get(i).getIDTransport());
        }

    }
    private void addElementToList(){
        sortList.add(new PassengerCarriage(3349564, "blue", 7000, 60, 80, CarriageComfort.COMPARTMENT));
        sortList.add(new PassengerCarriage(3349768, "blue", 6800, 40, 55, CarriageComfort.LUXURY));
        sortList.add(new PassengerCarriage(3345261, "green", 5500, 35, 0, CarriageComfort.RESTAURANT));

        for (int i=sortList.size()-1; i>=0; i--) {
            list.add(sortList.get(i));
        }
    }

    @Test(expected = WrongInputException.class)
    public void testRegular() throws WrongInputException {
       createCarriage.checkInputLine("123s", NUM);
    }

}
