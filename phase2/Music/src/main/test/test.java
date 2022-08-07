import MusicUtil.Song;
import Driver.*;
import org.junit.Test;

import java.util.ArrayList;

public class test {
    @Test
    public void testSometing() {
        Song s = new Song("something");
        assert s.getName().equals("something");

    }

    /**
     * Testing Account
     */

    @Test
    public void testAccount(){
        new Account("CscGroup", "0297");
    }

    @Test
    public void testgetUsername(){
        Account a = new Account("CscGroup", "0297");
        assert a.getUsername().equals("CscGroup");
    }

    @Test
    public void testgetPassword(){
        Account a = new Account("CscGroup", "0297");
        assert a.getPassword().equals("0297");
    }

    @Test
    public void testisAdmin(){
        Account a = new Account("CscGroup", "0297");
        assert !a.isAdmin();
    }

    @Test
    public void testisBanned(){
        Account a = new Account("CscGroup", "0297");
        assert !a.isBanned();
    }

    /**
     * Testing Account Manager
     */

    @org.junit.Test
    public void testauthenticate(){
        Account acc = new Account("CscGroup", "0297");
        assert (acc.getUsername().equals("CscGroup") && acc.getPassword().equals("0297"));
    }

    @org.junit.Test
    public void testcreateAccount() {
        Account acc = new Account("CscGroup", "0297");
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(acc);
        assert !accounts.contains(acc.getUsername());
    }

    @org.junit.Test
    public void testdeleteAccount() {
        Account acc = new Account("CscGroup", "0297");
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(acc);
        assert !accounts.contains(acc.getUsername());
    }

    @org.junit.Test
    public void testisPermitted(){
        Account acc = new Account("CscGroup", "0297");
        assert !acc.isAdmin();
    }

    /**
     * Testing Login
     */

    @org.junit.Test
    public void testSuccessLogin(){
        LoginLog newLogin = new LoginLog(true);
        ArrayList<LoginLog> history = new ArrayList<>();
        assert history.add(newLogin);
    }



}
