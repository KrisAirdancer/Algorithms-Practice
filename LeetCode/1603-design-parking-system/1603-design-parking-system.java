class ParkingSystem
{
    private int small;
    private int medium;
    private int big;

    public ParkingSystem(int big, int medium, int small)
    {
        this.small = small;
        this.medium = medium;
        this.big = big;
    }
    
    public boolean addCar(int carType)
    {
        switch (carType)
        {
            case 1: // big
                if (big > 0)
                {
                    big--;
                    return true;
                }
                else
                {
                    return false;
                }
            case 2: // medium
                if (medium > 0)
                {
                    medium--;
                    return true;
                }
                else
                {
                    return false;
                }
            case 3: // small
                if (small > 0)
                {
                    small--;
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */