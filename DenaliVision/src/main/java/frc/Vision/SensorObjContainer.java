package frc.Vision;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Enumeration;

public class SensorObjContainer
{
    private static final Object lock = new Object();
    
    private static volatile ConcurrentHashMap<String, SensorObject> m_chm = new ConcurrentHashMap<>();

    public static void overwriteMap(ConcurrentHashMap<String, SensorObject> chm)
    {
        synchronized(lock)
        {
            m_chm = chm;
        }
    }

    public static Enumeration<SensorObject> getElements()
    {
        synchronized(lock)
        {
            try 
            {
                return m_chm.elements();
            }
            catch (NullPointerException e)
            {
                return null;
            }
        }
    }

    public static SensorObject get(String key)
    {
        synchronized(lock)
        {
            try
            {
                return m_chm.get(key);
            }
            catch (NullPointerException e)
            {
                return null;
            }
        }
    }

    public static void update(String key, SensorObject value)
    {
        synchronized(lock)
        {
            try
            {
                m_chm.replace(key, value);
            }
            catch (NullPointerException e)
            {
                return;
            }
        }
    }
}