public class Die
{
    private int value;
    private int numSides;
    private boolean keep;
    
    public Die(int nSides)
    {
        numSides = nSides;
        keep = false;
    }

    public int getValue(){
        return value;
    }
    
    public void roll(){
        if(!keep)
            value = (int)(Math.random() * numSides) + 1;
    }
    
    public void setKeep(boolean flag){
        keep = flag;   
    }
    
    public  boolean getKeep(){
        return keep;
    }
        
}
