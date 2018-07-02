import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    List<String> words = new ArrayList<>();

    public void readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String textLine = bufferedReader.readLine();

            while ((textLine = bufferedReader.readLine()) != null) {

                words.add(textLine);
            }
        } finally {
            bufferedReader.close();
        }
    }

    public void showWordsContainsFraze(String cont){

     int temp = 0;

        for(int i = 0; i<words.size(); i++)
        if(words.get(i).contains(cont)){
            System.out.println(words.get(i));
            temp++;
        }

        System.out.println("Słów z taką literą jest: "+temp);
    }

    public void showWordsContainsLetters(String letters, int wordLenght){
        int count = 0;
        int temp = 0;
        List<String> lettersList = new ArrayList<>();

        String letter;
        for(int i = 0; i<letters.length(); i++){
            letter = Character.toString(letters.charAt(i));
            lettersList.add(letter);

        }
        for(int i=0; i<words.size();i++) {
            temp = 0;
            for(int j = 0; j<lettersList.size();j++)
             if(words.get(i).contains(lettersList.get(j))){
                temp++;
                if((temp == lettersList.size() && words.get(i).length()==wordLenght)
                        ||temp == lettersList.size() && wordLenght==0){
                    System.out.println(words.get(i));
                    count++;
                }
             }
        }
        System.out.println("Te litery zawiera "+count+" słów");
    }




    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Dokumenty_Kasia\\slowa.txt";

        Dictionary dic = new Dictionary();

        dic.readFile(filePath);

      //  dic.showWordsContainsFraze("ruda");
        dic.showWordsContainsLetters("kot", 3);


    }
}
