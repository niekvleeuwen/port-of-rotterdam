public class Wall extends Storage{
    private int maxContainers = 5; //there is room for 5 containers

    Wall(String name, int maxContainers){
        super(name); 
        this.maxContainers = maxContainers;
    }

    public void add(Container container){
        containers.add(container);
        System.out.println(getName() + " heeft nu " + containers.size() + " containers");
    }

    public void delete(Container container){
        containers.remove(container);
    }

    public int getMaxContainers(){
        return maxContainers;
    }
}