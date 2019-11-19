package emulador_bd;

import emulador_bd.domain.Address;
import emulador_bd.domain.Person;
import emulador_bd.domain.RegisterCollection;
import emulador_bd.domain.Vehicle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banco {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Variáveis utilizadas no processo
        String FILEPATH = "src//bd.txt";
        List<Person> personList = new ArrayList<>();
        RegisterCollection registerCollection = new RegisterCollection();

        // Instancia dos objetos (TAD's 1, 2 e 3)
        // TAD 1
        Person person1 = new Person("Alan de Souza", 'M');
        Person person2 = new Person("Cleyson Diego", 'M');
        Person person3 = new Person("Igor Tricarico", 'M');
        Person person4 = new Person("Mauricio Tomesani", 'M');
        Person person5 = new Person("Josivalda Perez", 'F');

        // TAD 2
        Vehicle vehicle1 = new Vehicle("JYP-7320");
        Vehicle vehicle2 = new Vehicle("JYPWS-7320");
        Vehicle vehicle3 = new Vehicle("JYP-73204");
        Vehicle vehicle4 = new Vehicle("HWU-0514");
        Vehicle vehicle5 = new Vehicle("MVN-5597");
        Vehicle vehicle6 = new Vehicle("JCN-2651");
        Vehicle vehicle7 = new Vehicle("HRR-8896");

        // TAD 3
        Address address1 = new Address("Rua das orquideas, 479, torre 4 apto 124", person1, vehicle1);
        Address address2 = new Address("Rua Doutor Luiz de Paula", person2, vehicle2);
        Address address3 = new Address("Rua Luís Braga", person3, vehicle3);
        Address address4 = new Address("Rua José Maria Ferreira", person3, vehicle4);
        Address address5 = new Address("Rua dos Girassóis", person4, vehicle5);
        Address address6 = new Address("Rua José Dias de Souza Filho", person4, vehicle6);
        Address address7 = new Address("Rua Cristiano Otoni", person5, vehicle7);

        // Realizando a interligação entre eles
        person1.getAddressList().add(address1);
        address1.getVehicleList().add(vehicle1);

        person2.getAddressList().addAll(Arrays.asList(address2, address3));
        person2.getAddressList().add(address2);

        person3.getAddressList().addAll(Arrays.asList(address3, address4));

        person4.getAddressList().addAll(Arrays.asList(address5, address6));

        person5.getAddressList().add(address7);

        // Verificando se o arquivo existe, se não existir cria
        try {
            if (registerCollection.readFromFile(FILEPATH) != null) {
                personList = registerCollection.readFromFile(FILEPATH);
            }
        } catch (FileNotFoundException e) {
            registerCollection.writeToFile(FILEPATH, new ArrayList<>());
            personList = registerCollection.readFromFile(FILEPATH);
        }

        // Adicionando as pessoas na lista
        registerCollection.addPerson(personList, person1);
        registerCollection.addPerson(personList, person2);
        registerCollection.addPerson(personList, person3);
        registerCollection.addPerson(personList, person4);

        // Mostrando a lista após aidicionar as pessoas
        System.out.println("Lista original: \n" + personList);
        System.out.println("Tamanho da lista: " + personList.size());
        System.out.println("\n\nAdicionando elemento na lista...");

        registerCollection.addPerson(personList, person5);

        System.out.println("Tamanho da lista após inserção de um elemento: " + personList.size());

        registerCollection.writeToFile(FILEPATH, personList);

        System.out.println("Lista após a inserção: \n" + personList);

        // Editar elemento na lista
        System.out.println("\n\nEditando elemento da lista: ");
        personList = registerCollection.editPerson(personList, 0, person4);
        personList = registerCollection.editPerson(personList, 3, person5);
        registerCollection.writeToFile(FILEPATH, personList);
        System.out.println("Lista após a edição: \n" + personList);

        // Mostrando um elemento da lista
        System.out.println("\n\nExibindo valor da lista: ");
        registerCollection.printPerson(personList, 0);
        registerCollection.writeToFile(FILEPATH, personList);
        System.out.println("Lista após a exibição de um valor (não deve mudar): \n" + personList);

        // Removendo elemento da lista
        System.out.println("\n\nRemovendo valor da lista: ");
        personList = registerCollection.removePerson(personList, 0);
        registerCollection.writeToFile(FILEPATH, personList);
        System.out.println("Lista após a remoção de um valor: \n" + personList);

        // Resultado final
        System.out.println("\n\nResultado final: " + personList);

    }
}
