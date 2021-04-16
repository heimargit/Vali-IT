package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //1. @RestController lisada klassi ette. See defineerib Springile, et tegemist on veebiaplikatsiooniga.
public class DemoController {

    /*
    2. loo uus meetod
    3. lisada meetodi sisse info, mida tahad veebis näha
    4. @GetMapping("aadress") lisada meetodi ette:
                Sulgudesse lisada veebi sisetatav aadress, mis lisatakse "localhost:8080" järele.
                Nt sisestad veebi "localhost:8080/sample/hello-world"

    5. Lisame meetodile parameetri (nt String name)
    6. Lisame meetodi ()-desse @Pathvariable(nt: "nameInUrl"), mille abil saame urlist välja lugeda nime (name), mille sisestame URLi
    7. @GetMapping ()-desse lisame juurde sama sõna, mille PathVar sulgudesse eelnevalt lisasime, nt: /{nameInUrl}
    8. Lisame meetodi ()-desse @RequestParam("action") ja parameetri String actionOne
    9. Võime lisada ka rohkem RequestParameetreid (vaata näidet all olevast meetodist)
     */

// URL: http://localhost:8080/sample/hello-world/Margit?action=Hei&action2=Goodbye!
    //@GetMapping("sample/hello-world/{nameInUrl}")
    public String demoApplication(@PathVariable("nameInUrl") String name, @RequestParam("action") String actionOne, @RequestParam("action2") String actionTwo){
        return actionOne + " " +  "It's me, "+ name + "! "+ actionTwo;
    }


    //Make a REST service to query n-th element of Fibonacci sequence
    // URL: http://localhost:8080/fibonacci/?n=5
    @GetMapping("fibonacci")
    public int fibonacci(@RequestParam("n") int n){
        return Lesson2.fibonacci(n);


    }

}
