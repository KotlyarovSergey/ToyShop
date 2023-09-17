import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrizesQueue {
    // String fileName;
    Path filePath;
    Queue<Toy> queue;
    public PrizesQueue(String fileName) {
        // this.fileName = fileName;
        filePath = Paths.get(fileName);
        prepareFile();
        this.queue = new LinkedList<>();
    }

    private void prepareFile(){
        if(Files.exists(filePath)){
            try{
                Files.delete(filePath);
            }catch(IOException e){
                System.out.println("Error! File prizes queue not create!");
            }
        }
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println("Error! File prizes queue not create!");
        }
        
    }

    public void add(Toy toy){
        queue.add(toy);
    }

    public int size(){
        return queue.size();
    }

    public void give(){
        Toy toy;
        if((toy = queue.poll()) != null){
            // System.out.println(toy.getName());
            File file = filePath.toFile();
            
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                BufferedWriter bWriter = new BufferedWriter(fileWriter);
                bWriter.write(toy.getName());
                bWriter.write("\n");
                bWriter.flush();
            } catch (IOException e) {
                System.out.println("Error! Prize don't write in file!");
            }
        }
    }
}
