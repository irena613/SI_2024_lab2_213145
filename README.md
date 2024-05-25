# Irena Latinovska, 213145

###  Control Flow Graph

Фотографија од control flow graph-ot 

![Lab2](https://github.com/irena613/SI_2024_lab2_213145/assets/163119884/eb93b90c-ac5f-4adf-a190-61384c359568)


### Цикломатска комплексност

Цикломатската комплексност на овој код е 10, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.

### Тест случаи според критериумот  Every Branch 

![Lab2-brojcinja](https://github.com/irena613/SI_2024_lab2_213145/assets/163119884/06db34cb-f03d-4a81-b697-b94b78987d00)


Бројот на тест случаи кои се потребни за да се постигне Every Branch критериумот е 5. Во овој случај тест примерите кои јас ги имам се следните:
    
    
    1. allItems = null;    
    Кој ја опфаќа гранката 1-2(според погоре обележаниот граф)

    2. Item(null, null, 100, 0.3)
    Со овој тест случај се опфатени гранките:
    (1-3), (3-4), (4-5), (5-7), (7-8), (8-9), (9-10)
    
    3.Item(cookie, @, 350, 0.3)
    Со овој тест случај се опфатени гранките:
    (1-2), (1-3), (3-4), (4-5), (5-7), (7-8), (7-9), (9-11), (11-12), (12-14), (14-15), (15-17)

    4. Item(cookie, 0613, 350, 0.3) payment=250
    Со овој тест случај се опфатени гранките:
    (1-2), (1-3), (3-4), (4-5), (4-6), (5-7), (6-23), (7-8), (7-9), (9-11), (11-12), (12-13), (12-14), (13-19), (14-15), (15-16), (16-11),(19-20), (20-21), (22-4)

    5. Item(cookie, 613, 350, 0) payment=300
    (1-2), (1-3), (3-4), (4-5), (4-6), (5-7), (6-24), (7-8), (7-9), (9-11), (11-12), (12-13), (12-14), (13-18), (14-15), (15-16), (16-11),(18-20), (20-22), (21-22), (22-4)

### Објаснување на напишаните unit tests

Петото барање од задачата беше да се направи Multiple Condition критериум за условот if (item.getPrice() > 300 && item.getDiscount() > 0 &&item.getBarcode().charAt(0)== '0'). За да го направиме тоа потребни ни се 8 unit тестови со кои ќе покриеме се бикејќи имаме 8 разнични комбинации. Со 8те тестови наведено подоле се поминува секоја можна комбинација.

    P = item.getPrice() > 300
    D = item.getDiscount() > 0
    В = item.getBarcode().charAt(0)== '0'


        //P=T D=T B=T  ова е кога сите услови се исполнети
        Item cookie1 = new Item("cookie1", "0613", 350, 0.3F);
        assertTrue(SILab2.checkCart(Collections.singletonList(cookie1), 250));

        //P=T D=T B=F овој тест случај е за кога условот за баркодот не е исполнет
        Item cookie2 = new Item("cookie2", "613", 350, 0.3F);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie2), 100));

        //P=T D=F B=T овој тест случај е за кога условот за попустот не е исполнет
        Item cookie3 = new Item("cookie3", "0613", 350, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie3), 100));

        //P=T D=F B=F овој тест случај е за кога условот за попустотт и условот за баркодо не е исполнет
        Item cookie4 = new Item("cookie4", "613", 350, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie4), 100));

        //P=F D=T B=T овој тест случај е за кога условот за цената не е исполнет
        Item cookie5 = new Item("cookie5", "0613", 250, 0.3F);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie5), 100));

        //P=F D=T B=F овој тест случај е за кога условот за цената и условот за баркодо не е исполнет
        Item cookie6 = new Item("cookie6", "613", 250, 0.3F);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie6), 100));

        //P=F D=F B=T овој тест случај е за кога условот за цената и условот за попустот не е исполнет
        Item cookie7 = new Item("cookie7", "0613", 250, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie7), 100));

        //P=F D=F B=F ова е кога ниеден услов не е исполнет
        Item cookie8 = new Item("cookie8", "613", 250, 0);
        assertFalse(SILab2.checkCart(Collections.singletonList(cookie8), 100));

Тука се искористени тест случај со 1 со assertTrue и седум тест случаи со assertFalse бидејќи станува збор за AND услов во кој што мора сите услови да се исполнат мора да бидат точни за да биде исполнет.
