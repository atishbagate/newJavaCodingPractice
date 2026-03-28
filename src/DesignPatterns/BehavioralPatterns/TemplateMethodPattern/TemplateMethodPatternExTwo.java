package DesignPatterns.BehavioralPatterns.TemplateMethodPattern;
abstract class buildHouse{
    public final void buildHome(){
        basement();
        wallAndWindows();
        Roof();
        Furniture();
        System.out.println("House build successfully");
    }
//    fixed steps
    private void basement(){
        System.out.println("basement created.");
    }
    protected abstract void wallAndWindows();
    protected abstract void Roof();

    //    hook : optional
    protected void Furniture() {

    }
}
class cementHouse extends  buildHouse {
    @Override
    protected void wallAndWindows() {
        System.out.println("Building cement walls and glass windows.");
    }

    @Override
    protected void Roof() {
        System.out.println("Building concrete roof.");
    }

    @Override
    protected void Furniture() {
        System.out.println("Adding wooden furniture.");
    }
}
class tent extends  buildHouse {
    @Override
    protected void wallAndWindows() {
        System.out.println("Setting up cloth walls and mesh windows.");
    }

    @Override
    protected void Roof() {
        System.out.println("Setting up waterproof tarp roof.");
    }
    protected  void Furniture() {
        System.out.println("Adding basic cooking furniture.");
    }
}

public class TemplateMethodPatternExTwo {
    public static void main(String[] args) {

        buildHouse house = new cementHouse();
        house.buildHome();
        System.out.println("----------------");
        buildHouse house2 = new tent();
        house2.buildHome();
    }
}
