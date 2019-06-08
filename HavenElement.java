public abstract class HavenElement{
    private String naam;

    HavenElement(String naam){
        this.naam = naam;
    }

    public String getNaam(){
        return naam;
    }
}