package ee.bcs.valiit.lessons;

/*Make a dto object returning files name, address
Use alt + insert shortcut to generate get and set functions
Return new instance of DTO from controller and check the result
 */


public class Employee {
    private String name;
    private String address;


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
