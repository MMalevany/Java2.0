import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.Collections;

public class EnglishText {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("file.txt");
        Set<String> Set = new HashSet<>();
        List<String> list = new ArrayList<>();
        String line;
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((line = bufferReader.readLine()) != null) {
            list.add(line);
        }
        bufferReader.close();
        System.out.println(list);
        Set.addAll(Arrays.asList(list.toString().toLowerCase().replaceAll("\\[|\\.]", "").split(" |, |\\. ")));
        List<String> list1 = new ArrayList<>(Set);
        Collections.sort(list1);
        System.out.println(list1);
        FileWriter fw = new FileWriter("out_file.txt");
        for (String str: list1) {
            fw.write(str);
            fw.write('\n');
        }
        fw.close();
    }
}
