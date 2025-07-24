public abstract class Animal {
    private String name;
    private Integer age;
    private String genre;
    public Animal(String name, Integer age, String genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
     public abstract void hunt() ;
        //System.out.println( " el animal esta casando.");

     public abstract void makeNoise(); 
           // System.out.println("El animal esta haciendo ruido");
        
    
    public void happybirthday() {
        //System.out.println("Happy birthday " + name + "! You are now " + age + " years old.");
        age++;
    }

}
