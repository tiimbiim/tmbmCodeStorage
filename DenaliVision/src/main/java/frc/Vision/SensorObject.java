package frc.Vision;

public class SensorObject implements java.io.Serializable
{
    public static final long serialVersionUID = 2637L;

    //Variables have to match the form of the those in the json string
    private int V;
    private double H;
    private double D;

    private int Num;
    private int T;

    public SensorObject(int validFlag, double heading, double distance)
    {
        this.V = validFlag;
        this.H = heading;
        this.D = distance;

    }

    public boolean isValid()
    {
        return V == 1;
    }

    public void setValidFlag(int validFlag)
    {
        this.V = validFlag;
    }

    public double getHeading()
    {
        return this.H;
    }

    public void setHeading(double heading)
    {
        this.H = heading;
    }

    public double getDistance()
    {
        return this.D;
    }

    public void setDistance(double distance)
    {
        this.D = distance;
    }

    public int getTargetNum()
    {
        return this.Num;
    }
/*
    public int getTargetLock()
    {
        return this.T;
    }
*/
    public String toString()
    {
        return  "(V: " + V + 
                "|H: " + H + 
                "|D: " + D + 
               /* "|T: " + T +
                "|Num" + Num +
               */ ")";
    }
}