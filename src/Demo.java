import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        String ac = "6082001";
      try {
//          DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("resources//Account_No.txt", false)));
//dataOutputStream.writeInt(6082001);
//dataOutputStream.close();

          File file=new File("resources//Account_No.txt");
          FileWriter fw=new FileWriter(file.getAbsoluteFile());
          BufferedWriter bw=new BufferedWriter(fw);
          bw.write(ac);
          bw.close();



      }catch (FileNotFoundException f){
          f.getStackTrace();
      }

    }
}
