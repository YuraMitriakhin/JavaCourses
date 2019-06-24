package com.gmail.yuramitryhin;

public interface RegularProperties {
    String enName = "^[A-Za-z]{2,10}$";
    String uaName = "^[А-ЩЬЮЯҐІЇЄа-щьюяґіїє]{2,10}$";
    String login = "^[A-Za-z0-9_]{4,10}";
    String mail = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String number = "^[+]?\\d{10,14}$";
    String address_idex = "^[0-9]{5}$";
    String address_city = "^[А-ЩЬЮЯҐІЇЄа-щьюяґіїє]{2,20}$";
    String address_street = "[А-ЩЬЮЯҐІЇЄа-щьюяґіїє-]{2,20}";
    String address_number_house = "^[0-9]{1,3}[/]?[0-9]?$";
    String address_number_flat= "^[0-9]{1,4}$";
    String date = "^[0-2]\\d|3[01]\\.(0\\d|1[012]\\.(\\d{4})$";
}
