import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.loose.fis.sre.model.User;

public class UserTest {
    @Test
    public void getUsernameTest(){
        User u = new User("username", "password", "address", "phoneNumber", "role");
        Assertions.assertEquals("username", u.getUsername());
    }

    @Test
    public void getPasswordTest(){
        User u = new User("username", "password", "address", "phoneNumber", "role");
        Assertions.assertEquals("password", u.getPassword());
    }

    @Test
    public void getAddressTest(){
        User u = new User("username", "password", "address", "phoneNumber", "role");
        Assertions.assertEquals("address", u.getAddress());
    }

    @Test
    public void getPhoneNumberTest(){
        User u = new User("username", "password", "address", "phoneNumber", "role");
        Assertions.assertEquals("phoneNumber", u.getPhoneNumber());
    }

    @Test
    public void getRoleTest(){
        User u = new User("username", "password", "address", "phoneNumber", "role");
        Assertions.assertEquals("role", u.getRole());
    }

    @Test
    public void setUsernameTest() {
        User u = new User();
        String s = "username";
        u.setUsername(s);
        Assertions.assertEquals(s, u.getUsername());
    }

    @Test
    public void setPasswordTest() {
        User u = new User();
        String s = "password";
        u.setPassword(s);
        Assertions.assertEquals(s, u.getPassword());
    }

    @Test
    public void setAddressTest() {
        User u = new User();
        String s = "address";
        u.setAddress(s);
        Assertions.assertEquals(s, u.getAddress());
    }

    @Test
    public void setPhoneNumberTest() {
        User u = new User();
        String s = "phoneNumber";
        u.setPhoneNumber(s);
        Assertions.assertEquals(s, u.getPhoneNumber());
    }

    @Test
    public void setRoleTest() {
        User u = new User();
        String s = "role";
        u.setRole(s);
        Assertions.assertEquals(s, u.getRole());
    }

    @Test
    public void equalsTest1() {
        User u1 = new User();
        User u2 = new User();
        Assertions.assertEquals(true, u1.equals(u2));
    }

    @Test
    public void equalsTest2() {
        User u1 = new User("username1", "password1", "address1", "phoneNumber1", "role1");
        User u2 = new User("username2", "password2", "address2", "phoneNumber2", "role2");
        Assertions.assertEquals(false, u1.equals(u2));
    }

    @Test
    public void hashCodeTest1() {
        User u = new User("username", "password", "address", "phoneNumber", "role");
        Assertions.assertEquals(664807758 ,u.hashCode());
    }

    @Test
    public void hashCodeTest2() {
        User u = new User();
        Assertions.assertEquals(0 ,u.hashCode());
    }


}
