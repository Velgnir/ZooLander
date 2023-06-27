package com.example.login;

import java.util.Scanner;

import java.io.*;
public interface Using {
    /**
     The viewer class is a serializable nested class that represents a basic user

     with login credentials and power level.
     */
    class viewer implements Serializable{
        protected String login;
        protected String password;
       protected int POWER;
        protected String plan;

        public viewer(String login, String password, int power) {
            this.login = login;
            this.password = password;
            this.POWER= power;
            /**

             Constructor for creating a new viewer with the given login, password, and
             power level.
             '@'param login The viewer's login ID
             '@'param password The viewer's password
             '@'param power The viewer's power level
             */
        }
        public int IsPowerFull() {
            return this.POWER;
        }
    }
    /**

     Returns the viewer's power level.
     '@'return An integer representing the viewer's power level
     */
    //using nested classes and interfaces - внутрішні класи в інтерфейсі Using
    class User extends viewer implements Serializable {
        /**

         The User class is a serializable nested class that extends the viewer class

         and provides methods for setting and retrieving a user's plan.
         */
        /**

         Constructor for creating a new User with the given login, password, and power
         level.
         '@'param login The User's login ID
         '@'param password The User's password
         '@'param power The User's power level
         */
        public User(String login,String password, int power) {
            super(login,password,power);
        }


        public void setPlan(String plans) throws IOException, ClassNotFoundException {
            FileInputStream fileIn = new FileInputStream("USERS/" + login + ".ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            User Me = (User) objectIn.readObject();


            FileOutputStream myObj = new FileOutputStream("USERS/" + login + ".ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(myObj);

            Me.plan = plans;
            objectOut.writeObject(Me);
/**
 Sets the User's plan to the given value and saves the updated User object to a

 file.

 '@'param plans A string representing the User's plan

 '@'throws IOException if there is an error accessing the file

 '@'throws ClassNotFoundException if the User object cannot be read from the file
 */



        }

        public String getPlan() throws IOException, ClassNotFoundException {
            FileInputStream fileIn = new FileInputStream("USERS/" + login + ".ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            User Me = (User) objectIn.readObject();
            return Me.plan;
        }
/**
 Retrieves the User's plan from the saved User object in the file.
 '@'return A string representing the User's plan
 '@'throws IOException if there is an error accessing the file
 '@'throws ClassNotFoundException if the User object cannot be read from the file
 */
    }

    class ADMIN extends User implements Serializable{
        //private boolean POWER = true;
        /**
         This class represents an administrator user and inherits from the User class.

         It provides methods for signing up, signing in, and deleting users, as well as

         a constructor that initializes an administrator user.
         */
        /**

         Constructor for an administrator user, which calls the superclass constructor.
         '@'param login the login name of the user
         '@'param password the password of the user
         '@'param power the level of access power of the user
         */
        public ADMIN(String login, String password, int power) {
            super(login,password, power);
        }

        public static void delete(String user) {
            System.out.println("USERS/" + user + ".ser");
            File tobeDeleted = new File("USERS/" + user + ".ser");
            tobeDeleted.delete();
        }
        /**

         Deletes a user file by their login name.
         '@'param user the login name of the user whose file is to be deleted
         */
    }
    default public ADMIN sign_in_as_admin(String log, String pass) throws IOException, ClassNotFoundException {

        File check = new File("USERS/" + log + ".ser");
        if(check.exists()){
            FileInputStream fileIn = new FileInputStream("USERS/" + log + ".ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ADMIN Me = (ADMIN) objectIn.readObject();
            if(pass.equals(Me.password)){

                return Me;
            }
/**

 Signs in as an administrator user, by checking if the user file exists and

 comparing the given password with the stored password.

 '@'param log the login name of the user to sign in as an administrator

 '@'param pass the password of the user to sign in as an administrator

 '@'return the administrator user object if the sign-in was successful, or null otherwise

 '@'throws IOException if there was an error reading the user file

 '@'throws ClassNotFoundException if the user file contains a class that cannot be found
 */
        }


        return null;
    }
    default public boolean sign_up(String log, String pass) throws IOException {


            File check = new File("USERS/" + log + ".ser");
            if (!check.exists()) {
                FileOutputStream myObj = new FileOutputStream("USERS/" + log + ".ser");
                ObjectOutputStream objectOut = new ObjectOutputStream(myObj);

               User person = new User(log,pass, 1);
                objectOut.writeObject(person);




            } else{
                return false;
            }


        return true;
    }
    /**

     Signs up a new user, by creating a new user file with the given login name and password.

     '@'param log the login name of the user to sign up

     '@'param pass the password of the user to sign up

     '@'return true if the sign-up was successful, or false if the user file already exists

     '@'throws IOException if there was an error creating the user file
     */
    default public User sign_in(String log, String pass) throws IOException, ClassNotFoundException {

        File check = new File("USERS/" + log + ".ser");
        if(check.exists()){
            FileInputStream fileIn = new FileInputStream("USERS/" + log + ".ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            User Me = (User) objectIn.readObject();
            if(pass.equals(Me.password)){

                return Me;
            }

        }


        return null;
    }
/**

 Signs in a user, by checking if the user file exists and comparing the given password with the stored password.

 '@'param log the login name of the user to sign in

 '@'param pass the password of the user to sign in

 '@'return the user object if the sign-in was successful, or null otherwise

 '@'throws IOException if there was an error reading the user file

 '@'throws ClassNotFoundException if the user file contains a class that cannot be found
 */
}