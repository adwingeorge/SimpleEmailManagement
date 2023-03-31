package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength =10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive firstname and lastname
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("email created:" + this.firstName + " "+ this.lastName);

        // call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: "+ this.department);


        //call a method that returns a random password

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("your password is: " +this.password);

        //combine elements to generate email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+ companySuffix;
        System.out.println("your email is " + email);


    }
    //ask for the department
     private String setDepartment(){
         System.out.print("Department codes \n1 For Sales\n2 For Development\n3 For Accounting \n0 For None\n Enter Deparment Code");
         Scanner in = new Scanner(System.in);
         int depChoice = in.nextInt();

         if (depChoice==1) {return "sales";}
         else if (depChoice==2) {return "development";}
         else if (depChoice==3) {return "accounting";}
         else {return ""; }


     }

    //generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@$#%!";
        char[] password = new char[length];
        for(int i = 0; i<length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }
    //set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    // set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    // change password
    public void changePassword(String Password){
        this.password = password;


    }

    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail ;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " "+lastName+
                "COMPANY EMAIL: " + email+
                "MAILBOX CAPACITY: " + mailboxCapacity;


    }


}
