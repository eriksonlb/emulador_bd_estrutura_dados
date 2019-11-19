package emulador_bd.domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterCollection {
    private static final long serialVersionUID = 1L;

    public List<Person> addPerson(List<Person> personList, Person person) {
        personList.add(person);
        System.out.println("O elemento '" + person + "' foi inserido na lista com sucesso.");
        return personList;
    }

    public List<Person> editPerson(List<Person> personList, Integer id, Person person) {
        if (isValid(personList, id)) {
            System.out.println("A pessoa editada foi: " + personList.get(id));

            personList.get(id).setName(person.getName());
            personList.get(id).setGender(person.getGender());
            personList.get(id).setAddress(person.getAddressList());

            System.out.println("O novo valor agora é: " + personList.get(id));
            return personList;
        } else {
            System.out.println("O ID inserido não pertence a lista de pessoas.");
            return null;
        }
    }

    public List<Person> removePerson(List<Person> personList, int id) {
        List<Person> newList = new ArrayList<>();
        if (isValid(personList, id)) {
            for (int i = 0; i <= personList.size() - 1; i++) {
                if (personList.get(i) != personList.get(id)) {
                    newList.add(personList.get(i));
                }
            }
        } else {
            System.out.println("O valor do indice desejado não existe na lista!");
            return null;
        }
        System.out.println("Lista original: " + personList);
        System.out.println("Nova lista sem o elemento: " + newList);
        return newList;
    }

    public Person printPerson(List<Person> personList, Integer id) {
        System.out.println("Imprimindo a pessoa no indice: " + id);
        if (isValid(personList, id)) {
            System.out.println(personList.get(id));
            return personList.get(id);
        } else {
            System.out.println("O ID inserido não pertence a lista de pessoas.");
            return null;
        }
    }

    public void writeToFile(String FILEPATH, List<Person> personList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        System.out.println("Gravando no arquivo...");
        objectOutputStream.writeObject(personList);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.println("O arquivo foi gravado com sucesso!");
    }

    @SuppressWarnings("unchecked")
    public List<Person> readFromFile(String FILEPATH) throws ClassNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(FILEPATH);
        if (!checkEmptyFile(FILEPATH)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println("Lendo do arquivo...");

            List<Person> aux = (ArrayList<Person>) objectInputStream.readObject();

            fileInputStream.close();

            return aux;
        } else {
            System.out.println("O arquivo está vazio!");
            fileInputStream.close();
            return null;
        }
    }

    private boolean isValid(List<Person> personList, Integer id) {
        return id >= 0 && id < personList.size();
    }

    private boolean checkEmptyFile(String FILEPATH) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILEPATH);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (EOFException e) {
            fileInputStream.close();
            return true;
        }
        objectInputStream.close();
        fileInputStream.close();;
        return false;
    }
}
