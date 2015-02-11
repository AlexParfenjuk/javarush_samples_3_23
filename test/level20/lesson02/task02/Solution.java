package com.javarush.test.level20.lesson02.task02;



import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("user",".txt", new File("C:\\"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта
            // javaRush тут
            Calendar cal = new GregorianCalendar(1995,10,22);
            Date date = cal.getTime();
            User Alex = new User("Ololo","Trol",date,true,User.Country.UKRAINE);
            User Maria = new User("Maria","Trol",date,false,User.Country.RUSSIA);
            javaRush.users.add(Alex);
            javaRush.users.add(Maria);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush
            // и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public JavaRush() {
        }

        @Override
        public String toString() {
            return "JavaRush{" +
                    "users=" + users +
                    '}' + "\n";
        }

        @Override
        public boolean equals(Object o){
          JavaRush javaRush = (JavaRush) o;
            boolean equals = false;
           try {
               if (this.users.size() == javaRush.users.size()) {
                   for (int i = 0; i < this.users.size(); i++) {
                       if (this.users.get(i).getFirstName().equals(javaRush.users.get(i).getFirstName()))
                           equals = true;
                       else {
                           equals = false;
                           break;
                       }

                       if (this.users.get(i).getLastName().equals(javaRush.users.get(i).getLastName()))
                           equals = true;
                       else {
                           equals = false;
                           break;
                       }

                       if (this.users.get(i).getBirthDate().equals(javaRush.users.get(i).getBirthDate()))
                           equals = true;
                       else {
                           equals = false;
                           break;
                       }

                       if (this.users.get(i).isMale() == javaRush.users.get(i).isMale())
                           equals = true;
                       else {
                           equals = false;
                           break;
                       }

                       if (this.users.get(i).getCountry().equals(javaRush.users.get(i).getCountry()))
                           equals = true;
                       else {
                           equals = false;
                           break;
                       }
                   }
               } else equals = false;



           }
           catch (NullPointerException e) {
               System.out.println("NullPointerException =(");

           }
            return equals;
        }



        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (users.size() > 0) {
                printWriter.println(users.size());
                for (User user : users) {


                    String hasFirstName = user.getFirstName() != null ? "yes" : "no";
                    printWriter.println(hasFirstName);
                    if (user.getFirstName() != null )
                        printWriter.println(user.getFirstName());

                        String hasLastName = user.getLastName() != null ? "yes" : "no";
                        printWriter.println(hasLastName);
                        if (user.getLastName() != null)
                            printWriter.println(user.getLastName());

                        String hasBirthDate = user.getBirthDate() != null ? "yes" : "no";
                        printWriter.println(hasBirthDate);
                        if (user.getBirthDate() != null)
                            printWriter.println(new SimpleDateFormat("dd.MM.yyyy").format(user.getBirthDate()));


                        printWriter.println(user.isMale());


                        String hasCountry = user.getCountry() != null ? "yes" : "no";
                        printWriter.println(hasCountry);
                        if (user.getCountry() != null)
                            printWriter.println(user.getCountry());


                }
            }
            printWriter.flush();
            printWriter.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String firstName = null;
            String lastName = null;
            Date birthDate = null;
            boolean isMale = false;
            User.Country country  = null;
            users = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int size = Integer.parseInt(reader.readLine());
            //System.out.println(size);
            for(int i = 0; i < size; i++) {
                String isFNamePresent = reader.readLine();
                if (isFNamePresent.equals("yes")) {
                    firstName = reader.readLine();

                    String isLNamePresent = reader.readLine();
                    if (isLNamePresent.equals("yes"))
                        lastName = reader.readLine();

                    String isDate = reader.readLine();
                    if (isDate.equals("yes")) {
                        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
                        birthDate = ft.parse(reader.readLine());
                    }
                    String Male = reader.readLine();
                    isMale = Male.equals("true") ? true : false;


                    String hasCountry = reader.readLine();
                    if (hasCountry.equals("yes")) {
                        String cou = reader.readLine();
                        if (cou.equals("UKRAINE"))
                            country = User.Country.UKRAINE;
                        else if (cou.equals("RUSSIA"))
                            country = User.Country.RUSSIA;
                        else if (cou.equals("OTHER"))
                            country = User.Country.OTHER;
                    }
                    users.add(new User(firstName, lastName, birthDate, isMale, country));

                }
            }

        }
    }
}
