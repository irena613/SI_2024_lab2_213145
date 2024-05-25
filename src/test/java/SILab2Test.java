import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testEveryBranch() {

        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!", exception.getMessage()); //allItems = null;

        Item cookie = new Item(null, null, 100, 0.3F);
        assertTrue(SILab2.checkCart(Collections.singletonList(cookie), 100));
        assertEquals("unknown", cookie.getName()); //name == null; no barcode

        Item cookie2 = new Item("cookie2", "@", 350, 0.3F);
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Collections.singletonList(cookie2), 100));
        assertEquals("Invalid character in item barcode!", exception.getMessage()); //incorrect barcode

        Item cookie3 = new Item("cookie3", "0613", 350, 0.3F);
        assertTrue(SILab2.checkCart(Collections.singletonList(cookie3), 250)); //sum <= payment == true

        Item cookie4 = new Item("cookie4", "613", 350, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie4), 300)); //sum <= payment == false
    }

    @Test
    void testMultipleCondition() {

        //P = item.getPrice() > 300
        //D = item.getDiscount() > 0
        //B = item.getBarcode().charAt(0)== '0'

        //P=T D=T B=T
        Item cookie1 = new Item("cookie1", "0613", 350, 0.3F);
        assertTrue(SILab2.checkCart(Collections.singletonList(cookie1), 250));

        //P=T D=T B=F
        Item cookie2 = new Item("cookie2", "613", 350, 0.3F);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie2), 100));

        //P=T D=F B=T
        Item cookie3 = new Item("cookie3", "0613", 350, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie3), 100));

        //P=T D=F B=F
        Item cookie4 = new Item("cookie4", "613", 350, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie4), 100));

        //P=F D=T B=T
        Item cookie5 = new Item("cookie5", "0613", 250, 0.3F);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie5), 100));

        //P=F D=T B=F
        Item cookie6 = new Item("cookie6", "613", 250, 0.3F);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie6), 100));

        //P=F D=F B=T
        Item cookie7 = new Item("cookie7", "0613", 250, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie7), 100));

        //P=F D=F B=F
        Item cookie8 = new Item("cookie8", "0613", 250, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie8), 100));

    }
}
