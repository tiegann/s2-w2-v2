import java.util.ArrayList;

public class Sound {

    private Viewer myViewer;
    private ArrayList<Integer> myData;
    private ArrayList<Integer> originalData;
    private String fileName;
    private ArrayList<Runnable> transformationHistory;
    private boolean isReplaying = false;


    /*
     * Constructor: loads hello.wav by default.
     */
    public Sound() {
        myViewer = new Viewer();
        myViewer.setSound(this);
        myData = myViewer.load("sounds/hello.wav");
        originalData = new ArrayList<Integer>(myData);
        transformationHistory = new ArrayList<Runnable>();
    }


    /*
     * Constructor: creates an empty sound with the specific length of samples, all set 
     * to 0.  Remember, the default sample rate is 22050 samples per second.
     */
    public Sound(int soundLength) {
        myViewer = new Viewer();
        myViewer.setSound(this);
        myData = myViewer.newSound(soundLength);
        originalData = new ArrayList<Integer>(myData);
        transformationHistory = new ArrayList<Runnable>();
    }

    /*
     * Constructor: create a new sound from a given filename
     */
    public Sound(String fileName) {
        myViewer = new Viewer();
        myViewer.setSound(this);
        myData = myViewer.load(fileName);
        originalData = new ArrayList<Integer>(myData);
        transformationHistory = new ArrayList<Runnable>();
    }

    
    /*
     * Call this method to listen to the sound
     */
    public void play() {
        myViewer.play();
    }

    /*
     * Zoom the viewer to a part of the sound
     */
    public void zoomTo(int begin, int end) {
        myViewer.zoomTo(begin, end);
    }

    /*
     * Save the sound back to its file
     */
    public void save() {
        myViewer.writeToFile(fileName);
    }

    /*
     * Save the sound to a new file
     */
    public void saveAs(String anotherfile) {
        myViewer.writeToFile(anotherfile);
        fileName = anotherfile;
    }

    /*
     * Load in sound from a new file, overwriting the old
     */
    public void load(String filename) {
        myData = myViewer.load(filename);
    }

    /*
     * Call this method to refresh the viewer after you've made changes to the sound data
     */
    public void refresh() {
        // Skip refresh during transformation replay to avoid sync issues
        if (isReplaying) {
            return;
        }
        // If the underlying list object was replaced (e.g., reversed by creating a new list),
        // make sure the viewer and helper point to the new reference before refreshing.
        if (myViewer.getData() != myData) {
            myViewer.setData(myData);
        }
        myViewer.refresh(true);
    }

    /*
     * Returns the viewer associated with this sound
     */
    public Viewer getViewer() {
        return myViewer;
    }

    /*
     * Open a new viewer window with a cloned copy of the current sound.
     * Useful for side-by-side comparison without sharing the same data.
     */
    public Viewer openViewerCopy() {
        Viewer v = new Viewer();
        Helper helperCopy = new Helper(myViewer.getHelper());
        v.openWithHelper(helperCopy);
        return v;
    }

    /*
     * Returns the sample rate of the sound.  Note, this should generally be 22050
     * for all your sounds, unless you have had problems with slow computers. 
     */
    private int getSamplingRate() {
        return (myViewer.getSamplingRate());
    }
    
    private int getMaxSampleValue() {
        return myViewer.getMaxSampleValue();
    }
    
    /*
     * Use this method to set a new ArrayList as the sound data.  This will keep the original viewer window.
     * Note: this method will call refresh automatically, so there is no need to do so again.
     */
    public void setMyData(ArrayList<Integer> newData) {
       myData = newData;
       myViewer.setData(newData);
    }
    
    //////////////////////////////////////////////
    /// put your Sound transformation methods here
    //////////////////////////////////////////////
    
    public int size() {
        return myData.size();
    }
    
    
    
    public void setToSingleTone(int hertz) {
        int maxAmplitude = 25000;  // how loud things can get

        double samplesPerCycle = getSamplingRate() / hertz;
        double radiansPerSample = (2 * Math.PI) / samplesPerCycle;

        double currentRadians = 0;
        int currentAmplitude;
        for (int i=0; i < myData.size(); i++) {
            currentRadians += radiansPerSample;
            //radiansPerSample += 0.000001;
            currentAmplitude = (int) (Math.sin(currentRadians ) * maxAmplitude);
            myData.set(i, currentAmplitude);
        }
        refresh();
    }



    /*
     * Restores the sound to its original state when first loaded or created.
     * Undoes all transformations applied since construction.
     */
    public void restoreOriginal() {
        transformationHistory.clear();
        myData = new ArrayList<Integer>(originalData);
        refresh();
    }

    /*
     * Load a new sound file and apply the current transformation history.
     * This allows comparing how different sounds respond to the same transformations.
     */
    public void loadAndApplyTransformations(String filename) {
        myData = myViewer.loadDataOnly(filename);
        originalData = new ArrayList<Integer>(myData);
        replayTransformations();
    }

    /*
     * Replay all transformations in the history on the current sound data.
     */
    private void replayTransformations() {
        isReplaying = true;
        try {
            for (Runnable transformation : transformationHistory) {
                transformation.run();
            }
        } finally {
            isReplaying = false;
            // Now do one final refresh to sync everything
            if (myViewer.getData() != myData) {
                myViewer.setData(myData);
            }
            myViewer.refresh(true);
        }
    }

    /*
     * Track a transformation in the history so it can be replayed on new sounds.
     * Exposed publicly so the viewer can record actions without cluttering student methods.
     */
    public void addTransformationToHistory(Runnable transformation) {
        transformationHistory.add(transformation);
    }

    /*
     * Clear the transformation history.
     */
    public void clearTransformationHistory() {
        transformationHistory.clear();
    }

    // =========================== YOUR METHODS

    /*
     * reverse the sound
     */
    public void reverse() {


    }

    // this throws out half the data
    public void doublePitch() {

    }


  
    //complete this method
    public void amplify (double amt) {

    }

    /*
     * Finds and returns the absolute maximum sample value in the sound data.
     * Used by normalize() to determine the scaling factor.
     */
    private int findAbsoluteMax() {
  
    }

    /*
     * Normalizes the audio by scaling all samples so the loudest sample
     * reaches the maximum amplitude (32767 for 16-bit audio) without clipping.
     * This makes quiet sounds louder while preventing distortion.
     */
    public void normalize() {


    }


    // Fade in over a duration in seconds
    // - get the number of samples you want to fade-in to full volume 
    // - get a small number between 0 and 1 inclusive 
    // - multiply that small number by the current value in the sample
    // - replace the current value with the new value
    // - refresh!
    public void fadeIn(double seconds) {

   
    }


    // Fade out over a duration in seconds
    public void fadeOut(double seconds) {

    }


    /*
     * Generates a square wave at the specified frequency.
     * A square wave alternates between -max and +max.
     */
    public void setSquare(int hertz) {
        int maxAmplitude = 25000;
        // based on hertz: cycles per second
        // cycle - is one complete wave 
        // sampleRate() -- getSamplingRate() - samples per second
        // You need to calculate the samplesPerCycle 

    }



    // Simple echo: single delayed tap mixed with the original
    // What is echo mathically: current value + (decay * past)
    public void echo(double delaySeconds, double decay) {

    }

    private int clampSample(int value) {

        return -1;
    }




} // end Sound class
