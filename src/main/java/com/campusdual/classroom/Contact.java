package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Contact implements ICallActions {
    protected String name;
    protected String surnames;
    protected String phone;

    String code;

    Contact(String name, String lastname, String phone) {
        this.name = name;
        this.surnames = lastname;
        this.phone = phone;
        this.code = String.valueOf(generateContactCode());
    }

    private String removeDiacritics(String str) {
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }

    public StringBuilder generateContactCode() {
        StringBuilder builder = new StringBuilder();
        String[] lastnames = removeDiacritics(this.surnames).split(" ");

        builder.append(removeDiacritics(this.name).toLowerCase().charAt(0));
        if (lastnames.length == 1) {
            builder.append(lastnames[0].toLowerCase());
        } else if (lastnames.length > 1) {
            builder.append(lastnames[0].toLowerCase().charAt(0));
            for (int i = 1; i < lastnames.length; i++) {
                builder.append(lastnames[i].toLowerCase());
            }
        }
        return builder;
    }

    @Override
    public void callMyNumber() {
        System.out.println("El contacto " + this.getName() + " " + this.getSurnames() + ", " + getPhone() + " se está llamando a sí mismo");
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("El contacto " + this.getName() + " " + this.getSurnames() + " esta llamando a " + number);

    }

    @Override
    public void showContactDetails() {
        System.out.println("El número de " + this.getName() + " " + this.getSurnames() + " con el code " + this.getCode() + " es " + this.getPhone());
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }


    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

}
