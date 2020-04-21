package model;

import javax.security.auth.login.LoginException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class GeneratorParol {
    private int maxlength;
    private char []parol;
    String my;
    private char []rusmal=new char[]{'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    private char []rusbig=new char[]{'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
    private char []engmal=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private char []engbig=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private char []simvol=new char[]{'#',')','(','_','!','?','/'};
    private char []numbers=new char[]{'0','1','2','3','4','5','6','7','8','9'};


    private char[] izmRusMal = {'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'а', 'б', 'в', 'г'};
    private char[] izmRusBig = {'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'А', 'Б', 'В', 'Г'};
    private char[] izmEngMal = {'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd'};
    private char[] izmEngBig = {'E', 'F', 'G', 'H', 'I', 'G', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D'};
    private Random random=new Random();

    public GeneratorParol( int maxlength) {
        this.maxlength = maxlength;
        parol=new char[maxlength];
    }

    public void FilterRusMal(int maxlength){
            for(int i=0;i<parol.length;i++){
                if (parol[i]=='\u0000') {
                parol[i]=rusmal[random.nextInt(rusmal.length-1)];
            } }
        for (int i = 0; i < maxlength/2; i++) {
           parol[random.nextInt(parol.length - 1)] = rusmal[random.nextInt(rusmal.length - 1)];
        }
    }

    public void FilterRusBig(int maxlength){
        for(int i=0;i<parol.length;i++){
            if (parol[i]=='\u0000') {
                parol[i]=rusbig[random.nextInt(rusbig.length-1)];
            } }
        for (int i = 0; i < maxlength/2; i++) {
            parol[random.nextInt(parol.length - 1)] = rusbig[random.nextInt(rusmal.length - 1)];
        }
    }

    public void FilterEngBig(int maxlength){
        for(int i=0;i<parol.length;i++){
            if (parol[i]=='\u0000') {
                parol[i]=engbig[random.nextInt(engbig.length-1)];
            } }
        for (int i = 0; i < maxlength/2; i++) {
            parol[random.nextInt(parol.length - 1)] = engbig[random.nextInt(engbig.length - 1)];
        }

    }

    public void FilterEngMal(int maxlength){
        for(int i=0;i<parol.length;i++){
            if (parol[i]=='\u0000') {
                parol[i]=engmal[random.nextInt(engmal.length-1)];
            } }
        for (int i = 0; i < maxlength/2; i++) {
            parol[random.nextInt(parol.length - 1)] = engmal[random.nextInt(engmal.length - 1)];
        }


    }

    public void FilterNumber(int maxlength){
        for(int i=0;i<parol.length;i++){
            if (parol[i]=='\u0000') {
                parol[i]=numbers[random.nextInt(numbers.length-1)];
            } }
        for (int i = 0; i < maxlength/2; i++) {
            parol[random.nextInt(parol.length - 1)] = numbers[random.nextInt(numbers.length - 1)];
        }
    }

    public void FilterSimvol(int maxlength){
        for(int i=0;i<parol.length;i++){
            if (parol[i]=='\u0000') {
                parol[i]=simvol[random.nextInt(simvol.length-1)];
            } }
        for (int i = 0; i < maxlength/2; i++) {
            parol[random.nextInt(parol.length - 1)] = simvol[random.nextInt(simvol.length - 1)];
        }
    }

    public String parol(){
        my="";
        for (int i = 0; i < parol.length; i++)
            my += parol[i];
        return my;
    }


    public String caesar(String str){
        char []slovo=str.toCharArray();
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);

            for(int j=0;j<rusmal.length;j++){
            if(str.charAt(i)==rusmal[j]){slovo[i]=izmRusMal[i]; }}

            for(int j=0;j<rusbig.length;j++){
            if(c==rusbig[j]){slovo[i]=izmRusBig[i]; }}

            for(int j=0;j<engmal.length;j++){
            if(c==engmal[j]){slovo[i]=izmEngMal[i]; }}

            for(int j=0;j<engbig.length;j++){
            if(c==engbig[j]){slovo[i]=izmEngBig[i]; }}
        }
        String str1=new String(slovo);
        return str1;
    }

    public String MD5(String str) throws LoginException, NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(str.getBytes());
        StringBuilder builder=new StringBuilder();
        for(byte b:bytes){
            builder.append(String.format("%02X",b));
        }
        String s=new String(builder);
        return s ;
    }

}
