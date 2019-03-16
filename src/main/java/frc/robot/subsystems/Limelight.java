package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
//import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight extends Subsystem {

   NetworkTable table;
   NetworkTableEntry tx; 
   NetworkTableEntry ty; 
   NetworkTableEntry ta; 
   NetworkTableEntry ts; 
   NetworkTableEntry tl; 
   NetworkTableEntry tv;
   NetworkTableEntry getpipe;

    //setter dec
   NetworkTableEntry ledMode;
   NetworkTableEntry camMode;
   NetworkTableEntry pipeline;
   NetworkTableEntry stream;
   NetworkTableEntry snapshot;

   double txValue;
   double taValue;
   double distance;

   public static final int LED_DEFAULT = 0;
   public static final int LED_OFF = 1;
   public static final int LED_BLINK = 2;
   public static final int LED_ON = 3;

    public Limelight() {
       table = NetworkTableInstance.getDefault().getTable("limelight");  
       tx = table.getEntry("tx"); 
       ty = table.getEntry("ty");
       ta = table.getEntry("ta");
       ts = table.getEntry("ts");
       tl = table.getEntry("tl");
       tv = table.getEntry("tv");
       getpipe = table.getEntry("getpipe");
       ledMode = table.getEntry("ledMode");
       camMode = table.getEntry("camMode");
       pipeline = table.getEntry("pipeline");
       stream = table.getEntry("stream");
       snapshot = table.getEntry("snapshot");

        //change these values when testing.
       // mountAngle = 0;
       // mountHeight = 11;
       // targetHeight = 30;
       // 

        setCamMode(0);
       setLedMode(0);
       setPipeline(1);
       setStreamMode(0);
   }
       // setters
   /**
    * @return the tx
    */
   public double getTx() {
       if(tv.getDouble(0.0)==1) {
           txValue = tx.getDouble(txValue);
       } else {
           txValue = 0.0;
       }
      return txValue;
   }

    /**
    * @return the ty
    */
   public double getTy() {
       return ty.getDouble(0.0);
   }

    public double getTv() {
       return tv.getDouble(0.0);
   }

    /**
    * @return the ta
    */
   public double getTa() {
       if(tv.getDouble(0.0)==1) {
           taValue = ta.getDouble(taValue);
       }
      return taValue;
   }

    /**
    * @return the ts
    */
   public double getTs() {
       return ts.getDouble(0.0);
   }

    /**
    * @return the tl
    */
   public double getTl() {
       return tl.getDouble(0.0);
   }

    public double getDistance() {
       return 75.315 * Math.pow(getTa(), -.484);
   }

    /* LED Editing Code */
   public void setLedMode(double ledType) {
       ledMode.setNumber(ledType);
   }

    public void forceLEDOn() {
       setLedMode(LED_ON);
   }

    public void forceLEDOff() {
       setLedMode(LED_OFF);
   }

    public void forceLEDBLink() 
   {
       setLedMode(LED_BLINK);
   }

    public void LEDDefaultMode()
   {
       setLedMode(LED_DEFAULT);
   }

    /* Other Modes */
   public void setCamMode(double CamType) {
      camMode.setNumber(CamType);
   }

    public void setPipeline(double Pipeline) {
       pipeline.setNumber(Pipeline);
   }

    public void setStreamMode(double Stream) {
       stream.setNumber(Stream);
   }

    public void setSnapshot(double Snapshot) {
       snapshot.setNumber(Snapshot);
   }

    @Override
   protected void initDefaultCommand() {

    }

    public void log() {
       SmartDashboard.putNumber("tx", getTx());
       SmartDashboard.putNumber("ty", getTy());
       SmartDashboard.putNumber("ta", getTa());
       SmartDashboard.putNumber("tv" , getTv());
       SmartDashboard.putNumber("Distance", getDistance());
   }



}