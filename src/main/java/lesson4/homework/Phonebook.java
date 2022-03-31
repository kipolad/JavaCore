/**
 * Created by Yulya Telysheva
 */
package lesson4.homework;

import java.util.HashMap;

public class Phonebook {
    private HashMap<String, String> phoneNum = new HashMap<>();

    public HashMap<String, String> getPhoneNum() {
        return phoneNum;
    }

    public void addPhoneNum(String phoneNum, String surname) {
        if (phoneNum.length() > 0 && phoneNum.length() < 12) {
            this.getPhoneNum().put(phoneNum, surname);
        }
    }

    void getPhone(String surname) {
        if (this.getPhoneNum().containsValue(surname)) {
            System.out.println(surname);
            for (String phone : this.getPhoneNum().keySet()) {
                if (this.getPhoneNum().get(phone).equals(surname)) {
                    System.out.println(phone);
                }
            }
        } else {
            System.out.println("Фамилии " + surname + " нет в телефонной книге");
        }
    }

    public static void main(String[] args) {
        Phonebook myPhoneBook = new Phonebook();
        myPhoneBook.addPhoneNum("12457893423", "Кирилов");
        myPhoneBook.addPhoneNum("12312567", "Макаронкин");
        myPhoneBook.addPhoneNum("8834567", "Котиков");
        myPhoneBook.addPhoneNum("188874567", "Кутькина");
        myPhoneBook.addPhoneNum("1234501067", "Кирилов");

        myPhoneBook.getPhone("Кирилов");
        myPhoneBook.getPhone("Кусь");


    }
}
