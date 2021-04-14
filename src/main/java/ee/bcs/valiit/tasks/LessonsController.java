package ee.bcs.valiit.tasks;

import ee.bcs.valiit.lessons.Employee;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LessonsController {
    public List<Employee> employeeList = new ArrayList<>();



    /*
    1. @RestController lisada klassi ette. See defineerib Springile, et tegemist on veebiaplikatsiooniga.
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

    URL: localhost:8080/
     */


    //LESSON 1

    //URL: localhost:8080/minLesson1/?one=5&two=7
    @GetMapping("minLesson1")
    public int minLesson1(@RequestParam("one") int a, @RequestParam("two") int b) {
        return Lesson1.min(a, b);
    }

    //URL: localhost:8080/maxLesson1/?one=5&two=7
    @GetMapping("maxLesson1")
    public int maxLesson1(@RequestParam("one") int a, @RequestParam("two") int b) {
        return Lesson1.max(a, b);
    }

    //URL: localhost:8080/absolute/?abs=8
    @GetMapping("absolute")
    public int abs(@RequestParam("abs") int x) {
        return Lesson1.abs(x);
    }

    //URL: localhost:8080/isiteven/?number=8
    @GetMapping("isiteven")
    public boolean isEven(@RequestParam("number") int x) {
        return Lesson1.isEven(x);
    }

    //URL: localhost:8080/minimum/?a=2&b=5&c=8
    @GetMapping("minimum")
    public int minimLesson1(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.min3(a, b, c);
    }

    //URL: localhost:8080/maximum/?a=8&b=1&c=200
    @GetMapping("maximum")
    public int maximLesson1(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.max3(a, b, c);
    }


    //LESSON 2

    //URL: localhost:8080/reverse/{array}
    @GetMapping("reverse/{array}")
    public int[] reverseArray(@PathVariable("array") int[] array) {
        return Lesson2.reverseArray(array);
    }

    //URL: localhost:8080/even/{numberarray}
    @GetMapping("even/{numberarray}")
    public int[] evenNumbers(@PathVariable("numberarray") int number) {
        return Lesson2.evenNumbers(number);
    }

    //URL: localhost:8080/min/{array}
    @GetMapping("min/{array}")
    public int min(@PathVariable("array") int[] array) {
        return Lesson2.min(array);
    }

    //URL: localhost:8080/max/{array}
    @GetMapping("max/{array}")
    public int max(@PathVariable("array") int[] array) {
        return Lesson2.max(array);
    }


    //URL: localhost:8080/sum/{sumarray}
    @GetMapping("sum/{sumarray}")
    public int sum(@PathVariable("sumarray") int[] array) {
        return Lesson2.sum(array);
    }

    //URL: localhost:8080/sequence3/?param1=10&param2=20
    @GetMapping("sequence3")
    public int sequence3(@RequestParam("param1") int a, @RequestParam("param2") int b) {
        return Lesson2.sequence3n(a, b);
    }


    //LESSON 2B


    //URL: localhost:8080/exercise1/?number=5
    @GetMapping("exercise1")
    public int exercise1(@RequestParam("number") int x) {
        return Lesson2b.exercise1(x);
    }

    //URL: localhost:8080/sample
    @GetMapping("sample")
    public int[] sampleArray() {
        return Lesson2b.sampleArray();
    }

    //URL: localhost:8080/generate/?x=10
    @GetMapping("generate")
    public int[] generateArray(@RequestParam("number") int x) {
        return Lesson2b.generateArray(x);
    }

    //URL: localhost:8080/decreasingarray/?a=-5
    @GetMapping("decreasingarray")
    public int[] decreasing(@RequestParam("number") int a) {
        return Lesson2b.decreasingArray(a);
    }

    //URL: localhost:8080/yl3/{array}
    @GetMapping("yl3/{array}")
    public int[] yl3(@PathVariable("array") int n) {
        return Lesson2b.yl3(n);
    }


    //LESSON 2C


    // localhost:8080/factorial/?number=10
    @GetMapping("nextelement/{element}")
    public int nextElement(@PathVariable("element") int a){
        return Lesson2c.nextElement(a);
    }

    // localhost:8080/sequencelength/{get}
    @GetMapping("sequencelength/{get}")
    public int getSequenceLength(@PathVariable("get") int b){
        return Lesson2c.getSeqLength(b);
    }

    // localhost:8080/sequence3n/?one=5&two=8
    @GetMapping("sequence3n")
    public int sequence3n(@RequestParam("one") int a, @RequestParam("two") int b){
        return Lesson2c.sequence3n(a,b);
    }


    //LESSON 3


    // localhost:8080/factorial/?number=10
    @GetMapping("factorial")
    public int factorial(@RequestParam("number") int y) {
        return Lesson3.factorial(y);
    }

    //URL: localhost:8080/reversethestring/{word}
    @GetMapping("reversethestring/{word}")
    public String reverseString(@PathVariable("word") String m){
        return Lesson3.reverseString(m);
    }

    //URL: localhost:8080/isitprime/?number=10
    @GetMapping("isitprime")
    public boolean isPrime(@RequestParam("number") int p){
        return Lesson3.isPrime(p);
    }

    //URL: localhost:8080/sortthe/{array}
    @GetMapping("sortthe/{array}")
    public int[] sort(@PathVariable("array") int[] xyz){
        return Lesson3.sort(xyz);
    }

    //URL: localhost:8080/fibon/even/?number=12
    @GetMapping("fibon/even")
    public int evenFibo(@RequestParam("number") int f){
        return Lesson3.evenFibonacci(f);
    }

    //URL: localhost:8080/morse/{codetext}
    @GetMapping("morse/{codetext}")
    public String morse(@PathVariable("codetext") String text){
        return Lesson3.morseCode(text);
    }

    //14.04.2021

    //Näide, kuidas sisestada objekti rohkem infot (arraylist):
    //URL: localhost:8080/test/employeelist
    @GetMapping("test/employeelist")
    public List<Employee> test(){
        Employee employee = new Employee();
        employee.setName("Mari Mets");
        employee.setAddress("Tehnika 44, Tallinn");
        Employee employee1 = new Employee();
        employee1.setName("Sven Soo");
        employee1.setAddress("Lai 125, Tallinn");
        /*
        Mitmeid objekte saab lisada arraylisti abil
        Luua arraylist, lisada sinna objektid ning muuta meetodi tagastusttüüp listiks (List<Employee>)
         */

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        employeeList.add(employee1);
        return employeeList;
    }


    //Näide, kuidas sisestada objekti infot ühe kaupa:
    //URL: localhost:8080/test1/employee
    /*
    @GetMapping("test1/employee")

    public Employee test1(){
        Employee employee = new Employee();
        employee.setName("Triin Tuul");
        employee.setAddress("Aia 5, Narva");
        return employee;
    }

    @PostMapping("test1/employee")
    public Employee testPost(@RequestBody Employee employee){
        System.out.println(employee.getAddress());
        return employee;
    }
    */

    //URL: http://localhost:8080/employees
    @GetMapping("employees")
    public List<Employee> toGet(){
        return employeeList;
    }

    //URL: http://localhost:8080/employees/{id}
    @GetMapping("employees/{id}")
    public Employee toGetId(@PathVariable("id") int id){
        return employeeList.get(id);
    }

    //URL: http://localhost:8080/employees
    @PostMapping("employees")
    public void toAdd(@RequestBody Employee employee){
        employeeList.add(employee);
    }

    //URL: http://localhost:8080/employees/{id}
    @PutMapping("employees/{id}")
    public void toReplace(@PathVariable("id") int id, @RequestBody Employee employee){
        employeeList.set(id, employee);
    }

    //URL: http://localhost:8080/employees/{id}
    @DeleteMapping("employees/{id}")
    public void toDelete(@PathVariable("id") int id){
        employeeList.remove(id);
    }


}
