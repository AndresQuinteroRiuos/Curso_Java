public class App {
    public static void main(String[] args) throws Exception {
        var eagle = new Eagle("Maria", 2, "hembra", "arpia");
    
        var lion = new Lion("Simba", 3, "macho", "amarillo");

        var fish = new fish("Nemo", 1, "hembra", "naranja", true);

        var Duck = new Duck("Duck", 1, "hembra", "naranja");

         eagle.fly();
         lion.hunt();
         fish.swim();
        System.out.println ("el "+eagle.getName()+" tiene " +eagle.getAge()+ " años  ");
        System.out.println ("el "+eagle.getName()+" puede poner huevos " +(eagle.CanPutEggs() ? "si" : "no"));
           
        // system.out.println ("el pez tiene " +fish.getAge()+ " años  ");
        
        lion.roar();
        lion.hunt();
        lion .happybirthday();
        System.out.println ("el "+lion.getName()+" tiene " +lion.getAge()+ " años  ");
          
         fish.swim();
         fish.hunt();
         fish.happybirthday();
        System.out.println ("el "+fish.getName()+" tiene " +fish.getAge()+ " años  ");
        System.out.println ("el "+fish.getName()+" puede poner huevos " +(fish.CanPutEggs() ? "si" : "no"));
        System.out.println ("el "+fish.getName()+"  " +(fish.CanPutEggs() ? "es de mar" : "es de rio"));

         lion.roar();

        lion.hunt();
        lion .happybirthday();
        System.out.println ("el "+lion.getName()+" tiene " +lion.getAge()+ " años  ");
          
         Duck.swim();
         Duck.fly();
         Duck.run();
         Duck.hunt();
         Duck.happybirthday();
        System.out.println ("el "+Duck.getName()+" tiene " +Duck.getAge()+ " años  ");
        System.out.println ("el "+Duck.getName()+" puede poner huevos " +(Duck.CanPutEggs() ? "si" : "no"));
        System.out.println ("el "+Duck.getName()+"  " +(Duck.CanPutEggs() ? "es de mar" : "es de rio"));
       
        canSwim animal1 = new fish("Dory", 2, "hembra", "azul", false);
        animal1.swim();
        canSwim animal2 = new Duck("Duck", 2, "hembra", "azul");
        animal2.swim();
        canfly animal3 = (canfly) animal2;
         animal3.fly();
         Animal animal4 = (Animal) animal3;
         animal4.happybirthday();
         animal4.makeNoise();

    }
}
