package Driver;

import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

/**
 * Account manager implements functions to manipulate account
 * including create/update/delete/active account, authenticate user etc
 *
 * @author Ben Li, Jennifer Xi, Robert Zhao
 * @version 2.0
 * @since 2022-07-10
 */

public class AccountManager {
    /**
     * An ArrayList containing all accounts
     */
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    /**
     * An account designated to be the active account
     */
    private static Account activeUser;
    /**
     * Login history for account
     */
    private LoginHistory history = new LoginHistory();

    /**
     * Constructor of AccountManager, creates list of all accounts
     *
     * @param path file path
     * @throws FileNotFoundException file input not found
     */
    public AccountManager(String path) throws FileNotFoundException{
        Scanner scanner = new Scanner(new FileInputStream(path));
        String[] line;
        Account acc;

        while(scanner.hasNextLine()){
            line = scanner.nextLine().split(",");
//            acc = new other.Account(info[0], info[1]);
//            if(info[2].equals("true")){
//                acc.setBanned(true);
//            }
            if(line[3].equals("true")){
                createAdminAccount(line[0], line[1]);
            }
            else{
                createAccount(line[0], line[1]);
            }
        }
        scanner.close();
    }

    /**
     * Authenticates an active account for successful login if username and password is correct
     *
     * @param username username of account
     * @param password password of account
     * @return true if password and username is correct, false if not
     */
    public boolean authenticate(String username, String password) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                activeUser = acc;
                history.addEvent(username, true);
                return true;

            }
        }
        if(accounts.contains(getAccountByUsername(username))){
            history.addEvent(username, false);
        }
        return false;
    }

    private static Account newAccount(String username, String password, Boolean isAdmin) {
        Account acc = new Account(username, password);
        acc.setAdminStatus(isAdmin);
        return acc;
    }

    /**
     * This function is to create an account by name and password    *
     * @param username username of new account
     * @param password password of new account
     * @return true if the list of all accounts does not contain new account, false otherwise
     */
    public boolean createAccount(String username, String password) {
        if (accounts.contains(getAccountByUsername(username))) {
            return false;
        } else {
            accounts.add(newAccount(username, password, false));
            history.createUser(username);
            return true;
        }
    }

    /**
     * Creates new Admin account
     *
     * @param username username of new Admin account
     * @param password password of new Admin account
     * @return true if current list of all accounts does not contain new account and new account is Admin
     */

    public boolean createAdminAccount(String username, String password) {
        if (accounts.contains(getAccountByUsername(username))) {
            return false;
        } else {
            accounts.add(newAccount(username, password, true));
            history.createUser(username);
            return true;
        }
    }

    /**
     * Deletes non-Admin accounts
     *
     * @param username username of account to be deleted
     * @return true if Admin account deletes non-Admin account
     */
    public boolean deleteAccount(String username) {
        if(!accounts.contains(getAccountByUsername(username))){
            return false;
        }
        if (isPermitted() && !getAccountByUsername(username).isAdmin()) {
            accounts.remove(getAccountByUsername(username));
            return true;
        }
        return false;
    }

    /**
     * Temporarily bans non-Admin accounts
     *
     * @param username username of account to be banned
     */
    public void banAccount(String username) {
        if (isPermitted() && !getAccountByUsername(username).isAdmin()) {
            getAccountByUsername(username).setBanned(true);
        }
    }

    /**
     * Allows only Admin accounts to execute Admin responsibilities
     *
     * @return true if active account is Admin
     */
    public boolean isPermitted() {
        return activeUser.isAdmin();
    }

    /**
     * Gets username of active user
     *
     * @return username of active account
     */
    public String getActiveUser() {
        return activeUser.getUsername();
    }

    /**
     * Gets an account by its username
     *
     * @param username username of target account
     * @return Account
     */
    public Account getAccountByUsername(String username) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Set an active account
     *
     * @param username username of active account
     */
    public void setActiveUser(String username) {
        activeUser = getAccountByUsername(username);
    }

    /**
     * Gets login history of account
     *
     * @param username username of account
     * @return string of user history
     */
    public String getUserLoginHistory(String username) {
        StringBuilder userHistory = new StringBuilder();
        ArrayList<LoginLog> events = (ArrayList<LoginLog>) history.getHistory(username);
        for (LoginLog e : events) {
            userHistory.append(e.toString());
            userHistory.append("\n");
        }
        userHistory.deleteCharAt(userHistory.length()-1);
        return userHistory.toString();
    }

    /**
     * Updates log of each account
     *
     * @param filePath
     * @throws IOException
     */
    public void updateLog(String filePath) throws IOException {
        PrintWriter oos = new PrintWriter(filePath);
        for(Account acc : accounts){
            oos.print(acc.getUsername()+","+acc.getPassword()+","+acc.isBanned()+","+acc.isAdmin()+"\n");
        }
        oos.close();
    }
}
