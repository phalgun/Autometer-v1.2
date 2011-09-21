/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.location.*;

/**
 * @author admin
 */
public class first extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private Coordinates destination;
    private Coordinates source;
    private Location start_point;
    private LocationProvider lp;
    private float distance;
    private float fare;
    private float Minimum_Fare;
    private float Price_per_km;
    private LocationListener loc_listener;
    private Criteria cr;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form form;
    private StringItem stringItem1;
    private StringItem stringItem;
    private Alert alert;
    private Form form1;
    private TextField per_km;
    private TextField Minimum;
    private Alert alert1;
    private Form form2;
    private StringItem stringItem2;
    private Command Start;
    private Command Stop;
    private Command exitCommand;
    private Command exitCommand1;
    private Command Options;
    private Command backCommand;
    private Command cancelCommand;
    private Command okCommand;
    private Command Help;
    private Command Back;
    private Command Exit;
    private Ticker ticker;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The first constructor.
     */
    public void Update_Distance() {
        try {
            String temp = "" + (distance/1000);
            if(temp.length()>3)
            temp = temp.substring(0, temp.lastIndexOf('.') + 3);
            stringItem1.setText(temp + " kms");
        } catch (Exception e) {
            Alert alert = new Alert(null, ("distance too huge!\n" + e), null, null);
            alert.setTimeout(3000);

            switchDisplayable(alert, form);
        }
    }

    public void Update_Fare() {
        try {
            if (distance <= 2000) {
                fare = Minimum_Fare;
            } else {
                fare = Minimum_Fare + (((distance / 1000) - 2) * Price_per_km);

            }

            String temp = "" + fare;

            temp = temp.substring(0, temp.lastIndexOf('.') + 2);
            stringItem.setText(temp);
        } catch (Exception e) {
            Alert alert = new Alert(null, ("error\n" + e), null, null);
            alert.setTimeout(3000);

            switchDisplayable(alert, form);
        }

    }

    class MyLocationListener implements LocationListener {

        public void locationUpdated(LocationProvider lp, Location present_location) {

            destination = present_location.getQualifiedCoordinates();
            String lat = "" + destination.getLatitude();
            String lon = "" + destination.getLongitude();
            distance = distance + source.distance(destination);
            source = destination;

            Update_Distance();
            Update_Fare();
        }

        public void providerStateChanged(LocationProvider lp, int i) {
            //Utility.getStateString gets the state string such as 1 stands for Available
            String s = "providerStateChanged = ";
            Alert alert = new Alert("providerStateChanged", s, null, null);
            alert.setTimeout(2000);
            switchDisplayable(alert, form1);
        }
    }

    public void Compute_Dist_Fare() {


        try {
            distance = 0;
            fare = 0;
            lp = LocationProvider.getInstance(cr);
            loc_listener = new MyLocationListener();
            start_point = lp.getLocation(30);
            source = start_point.getQualifiedCoordinates();
            lp.setLocationListener(loc_listener, 5, 5, 5);




        } catch (Exception e) {
            Alert alert = new Alert(null, ("error\n" + e), null, null);
            alert.setTimeout(3000);

            switchDisplayable(alert, form);
        }

    }

    public first() {
        cr = new Criteria();
        cr.setHorizontalAccuracy(150);
        //cr.setCostAllowed(false);
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        distance = (float) 0.0;
        fare = (float) 0.0;
        Minimum_Fare = 17;
        Price_per_km = 9;
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction



        switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction

    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == alert) {//GEN-BEGIN:|7-commandAction|1|30-preAction
            if (command == exitCommand1) {//GEN-END:|7-commandAction|1|30-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|2|30-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|3|58-preAction
        } else if (displayable == form) {
            if (command == Exit) {//GEN-END:|7-commandAction|3|58-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|4|58-postAction
                // write post-action user code here
            } else if (command == Help) {//GEN-LINE:|7-commandAction|5|49-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm2());//GEN-LINE:|7-commandAction|6|49-postAction
                // write post-action user code here
            } else if (command == Options) {//GEN-LINE:|7-commandAction|7|33-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|8|33-postAction
                Minimum.setString("" + Minimum_Fare);
                per_km.setString("" + Price_per_km);
            } else if (command == Start) {//GEN-LINE:|7-commandAction|9|17-preAction
                try {

                    Compute_Dist_Fare();

//GEN-LINE:|7-commandAction|10|17-postAction
                } catch (Exception e) {
                }
            } else if (command == Stop) {//GEN-LINE:|7-commandAction|11|21-preAction
                lp.setLocationListener(null, 0, 0, 0);

                switchDisplayable(null, getAlert());//GEN-LINE:|7-commandAction|12|21-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|39-preAction
        } else if (displayable == form1) {
            if (command == backCommand) {//GEN-END:|7-commandAction|13|39-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|14|39-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|15|44-preAction
                Minimum_Fare = Float.valueOf((Minimum.getString()).trim()).floatValue();
                Price_per_km = Float.valueOf((per_km.getString()).trim()).floatValue();

                switchDisplayable(getAlert1(), getForm());//GEN-LINE:|7-commandAction|16|44-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|53-preAction
        } else if (displayable == form2) {
            if (command == Back) {//GEN-END:|7-commandAction|17|53-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|18|53-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|19|7-postCommandAction
        }//GEN-END:|7-commandAction|19|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|20|
    //</editor-fold>//GEN-END:|7-commandAction|20|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            form = new Form("AutoMeter", new Item[] { getStringItem(), getStringItem1() });//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getStart());
            form.addCommand(getStop());
            form.addCommand(getOptions());
            form.addCommand(getHelp());
            form.addCommand(getExit());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            stringItem = new StringItem("fare", "0");//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Start ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initiliazed instance of Start component.
     * @return the initialized component instance
     */
    public Command getStart() {
        if (Start == null) {//GEN-END:|16-getter|0|16-preInit
            // write pre-init user code here
            Start = new Command("Start", Command.OK, 0);//GEN-LINE:|16-getter|1|16-postInit
            // write post-init user code here
        }//GEN-BEGIN:|16-getter|2|
        return Start;
    }
    //</editor-fold>//GEN-END:|16-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|19-getter|0|19-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|19-getter|0|19-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("distance", "0");//GEN-LINE:|19-getter|1|19-postInit
            // write post-init user code here
        }//GEN-BEGIN:|19-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|19-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|22-getter|0|22-preInit
            String finalfare = "Pay Rs." + fare + "\n\n\n6 Bytes more..";

            alert = new Alert("Done!", " A \'6 Bytes more..\' product.", null, AlertType.INFO);//GEN-BEGIN:|22-getter|1|22-postInit
            alert.addCommand(getExitCommand1());
            alert.setCommandListener(this);
            alert.setTimeout(Alert.FOREVER);//GEN-END:|22-getter|1|22-postInit
            alert.setString(finalfare);


        }//GEN-BEGIN:|22-getter|2|
        return alert;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Stop ">//GEN-BEGIN:|20-getter|0|20-preInit
    /**
     * Returns an initiliazed instance of Stop component.
     * @return the initialized component instance
     */
    public Command getStop() {
        if (Stop == null) {//GEN-END:|20-getter|0|20-preInit
            // write pre-init user code here
            Stop = new Command("Stop", Command.STOP, 1);//GEN-LINE:|20-getter|1|20-postInit
            // write post-init user code here
        }//GEN-BEGIN:|20-getter|2|
        return Stop;
    }
    //</editor-fold>//GEN-END:|20-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|25-getter|0|25-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|25-getter|1|25-postInit
            // write post-init user code here
        }//GEN-BEGIN:|25-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|25-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of exitCommand1 component.
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|29-getter|1|29-postInit
            // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return exitCommand1;
    }
    //</editor-fold>//GEN-END:|29-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form1 ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initiliazed instance of form1 component.
     * @return the initialized component instance
     */
    public Form getForm1() {
        if (form1 == null) {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            form1 = new Form("Set Minimum Fare and Price per km", new Item[] { getMinimum(), getPer_km() });//GEN-BEGIN:|34-getter|1|34-postInit
            form1.addCommand(getBackCommand());
            form1.addCommand(getOkCommand());
            form1.setCommandListener(this);//GEN-END:|34-getter|1|34-postInit
            // write post-init user code here
        }//GEN-BEGIN:|34-getter|2|
        return form1;
    }
    //</editor-fold>//GEN-END:|34-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Minimum ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of Minimum component.
     * @return the initialized component instance
     */
    public TextField getMinimum() {
        if (Minimum == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            Minimum = new TextField("Minimum Fare", null, 32, TextField.DECIMAL);//GEN-LINE:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return Minimum;
    }
    //</editor-fold>//GEN-END:|41-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: per_km ">//GEN-BEGIN:|42-getter|0|42-preInit
    /**
     * Returns an initiliazed instance of per_km component.
     * @return the initialized component instance
     */
    public TextField getPer_km() {
        if (per_km == null) {//GEN-END:|42-getter|0|42-preInit
            // write pre-init user code here
            per_km = new TextField("Price per km", null, 32, TextField.DECIMAL);//GEN-LINE:|42-getter|1|42-postInit
            // write post-init user code here
        }//GEN-BEGIN:|42-getter|2|
        return per_km;
    }
    //</editor-fold>//GEN-END:|42-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert1 ">//GEN-BEGIN:|46-getter|0|46-preInit
    /**
     * Returns an initiliazed instance of alert1 component.
     * @return the initialized component instance
     */
    public Alert getAlert1() {
        if (alert1 == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            alert1 = new Alert("Minimum and Price per km fare Changed!", "Your readings will be reset", null, AlertType.WARNING);//GEN-BEGIN:|46-getter|1|46-postInit
            alert1.setTimeout(Alert.FOREVER);//GEN-END:|46-getter|1|46-postInit
            // write post-init user code here
        }//GEN-BEGIN:|46-getter|2|
        return alert1;
    }
    //</editor-fold>//GEN-END:|46-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Options ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of Options component.
     * @return the initialized component instance
     */
    public Command getOptions() {
        if (Options == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            Options = new Command("Options", Command.OK, 3);//GEN-LINE:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return Options;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of cancelCommand component.
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return cancelCommand;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|38-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|43-getter|1|43-postInit
            // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Help ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initiliazed instance of Help component.
     * @return the initialized component instance
     */
    public Command getHelp() {
        if (Help == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
            Help = new Command("Help", Command.HELP, 3);//GEN-LINE:|48-getter|1|48-postInit
            // write post-init user code here
        }//GEN-BEGIN:|48-getter|2|
        return Help;
    }
    //</editor-fold>//GEN-END:|48-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form2 ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of form2 component.
     * @return the initialized component instance
     */
    public Form getForm2() {
        if (form2 == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            form2 = new Form("Help", new Item[] { getStringItem2() });//GEN-BEGIN:|50-getter|1|50-postInit
            form2.setTicker(getTicker());
            form2.addCommand(getBack());
            form2.setCommandListener(this);//GEN-END:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return form2;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of stringItem2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            stringItem2 = new StringItem("Beat the Auto!", "Press start to start calculating distance after you hop onto autorickshaw.\nPress stop to stop the calculation and display the final fare.\nGo to Menu->Options to change the minimum fare and price per kilometre.\n\nYour feedback and donations are highly appreciated! Help freelancers.\nContact Us: 6bytesmore@gmail.com", Item.PLAIN);//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return stringItem2;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Back ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initiliazed instance of Back component.
     * @return the initialized component instance
     */
    public Command getBack() {
        if (Back == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            Back = new Command("Back", Command.BACK, 0);//GEN-LINE:|52-getter|1|52-postInit
            // write post-init user code here
        }//GEN-BEGIN:|52-getter|2|
        return Back;
    }
    //</editor-fold>//GEN-END:|52-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Exit ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of Exit component.
     * @return the initialized component instance
     */
    public Command getExit() {
        if (Exit == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            Exit = new Command("Exit", Command.EXIT, 7);//GEN-LINE:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return Exit;
    }
    //</editor-fold>//GEN-END:|57-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ticker ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of ticker component.
     * @return the initialized component instance
     */
    public Ticker getTicker() {
        if (ticker == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            ticker = new Ticker("A Product of 6 Bytes More..");//GEN-LINE:|60-getter|1|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|2|
        return ticker;
    }
    //</editor-fold>//GEN-END:|60-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
