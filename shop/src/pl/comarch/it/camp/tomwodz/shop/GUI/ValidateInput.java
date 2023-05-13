package pl.comarch.it.camp.tomwodz.shop.GUI;

public class ValidateInput {

    public static boolean validateName(String name){
        return name.matches("[A-Z][a-zA-Z]*");
    }
}
