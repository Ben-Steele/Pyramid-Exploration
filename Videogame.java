//DOPE
//added an option to choose a new map when you win
//fixed the problem with the view not centering in the window when you start a new map
//doesnt display the JOptionPane.showMessageDialog(null, "Join us for more adventure soon!") in the Y view (view 2)

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;



public class Videogame extends JComponent {

    private int mapSize;
    private int[][] map;
    private int charX;
    private int charY;
    private int oracleX;
    private int oracleY;
    private int contourHeight;
    private int contourHeight2;
    private int positionZ;
    private int unitSize;
    private int view;
    private int towerHeight = 0;
    private int towerHeight2 = 0;
    private int moves = 0;
    private double miniMapScale = .35;
    public static final int windowWidth = 1000;
    public static final int windowHeight = 800;
    private int offset = 5;
    private BufferedImage img;


    //Color library
    Color teal = new Color(76,176,222);
    Color ivory = new Color(242,234,223);
    Color darkSand = new Color(164, 107, 64);
    Color lightSand = new Color(245, 219, 158);
    Color block = new Color(76,176,222);
    Color brown = new Color(68, 44, 3);
    Color emerald = new Color(13, 96, 39);
    Color lightGreen = new Color(70, 140, 65);


    //Initialize map and character 
    public Videogame(int _incoming){
        mapSize = _incoming;
        //Generate map 
        
        charX = 0;
        charY = 0;
        view = 1;  
    }

    public void moveRight(){

        //move depending on view
        if(view == 1){

            //Check that Character does not leave map
            if(charX+1 > (mapSize-1)){
            }
            else{

                int current = map[charY][charX];
                int nextMove = map[charY][charX+1];

                //Rules - you can't move if the next block height is more than one unit
                if((nextMove-current) > 1){   
                }
                else if((nextMove-current) < -1){ 
                }
                else{
                    //Check if character moved to GOAL (bottom right corner of array)
                    if(charY == oracleY && charX == oracleX-1){
                        charX++;
                        repaint();
                        moves++;
                        String replay = JOptionPane.showInputDialog(null, "You won! Would you like to play again? \n\ty for Yes \n\tn for No");
                        if (replay.equals("y")) {
                            String newMap = JOptionPane.showInputDialog(null, "Please Choose another map:");
                            createBoard(newMap + ".txt");
                            moves = 0;
                            charX = 0;
                            charY = 0;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Join us for more adventure soon!");
                            System.exit(0);
                        }
                    }
                    else{
                    charX++;
                    moves++;
                    }
                }
            }
        }
    

        //move depending on view
        else if(view == 2){

            //Check that Character does not leave map
            if(charY+1 > (mapSize-1)){
            }
            else{

                int current2 = map[charY][charX];
                int nextMove2 = map[charY+1][charX];

                if((nextMove2-current2) > 1){
                }
                else if((nextMove2-current2) < -1){       
                }
                else{
                    //Check if character moved to GOAL (bottom right corner of array)
                    if(charX == oracleX && charY == oracleY-1){
                        charY++;
                        repaint();
                        moves++;
                        String replay = JOptionPane.showInputDialog(null, "You won! Would you like to play again? \n\ty for Yes \n\tn for No");
                        if (replay.equals("y")) {
                            String newMap = JOptionPane.showInputDialog(null, "Please Choose another map:");
                            createBoard(newMap + ".txt");
                            moves = 0;
                            charX = 0;
                            charY = 0;
                        }
                        else if (replay.equals("n")) {
                            JOptionPane.showMessageDialog(null, "Join us for more adventure soon!");
                            System.exit(0);
                        }
                        else {
                        }
                    }
                    else{
                        charY++;
                        moves++;
                    }
                }
            }
        }
    }

    public void moveLeft(){

        //move depending on view
        if(view == 1){

            //Check that Character does not leave map
            if(charX-1 < 0){
            }
            else{

                int current = map[charY][charX];
                int nextMove = map[charY][charX-1];

                if((nextMove-current) > 1){
                   
                }
                else if((nextMove-current) < -1){ 
                       
                }
                else{
                   //Check if character moved to GOAL (bottom right corner of array)
                    if(charY == oracleY && charX == oracleX+1){
                        charX--;
                        repaint();
                        moves++;
                        String replay = JOptionPane.showInputDialog(null, "You won! Would you like to play again? \n\ty for Yes \n\tn for No");
                        if (replay.equals("y")) {
                            String newMap = JOptionPane.showInputDialog(null, "Please Choose another map:");
                            createBoard(newMap + ".txt");
                            moves = 0;
                            charX = 0;
                            charY = 0;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Join us for more adventure soon!");
                            System.exit(0);
                        }
                    }
                    else{
                        charX--;
                        moves++;
                    }
                }
            }
        }

        //move depending on view
        else if(view == 2){
            //Check that Character does not leave map
            if(charY-1 < 0){

            }
            else{
                int current2 = map[charY][charX];
                int nextMove2 = map[charY-1][charX];

                if((nextMove2-current2) > 1){
                   
                }
                else if((nextMove2-current2) < -1){ 
                       
                }
                else{
                    //Check if character moved to GOAL (bottom right corner of array)
                    if(charX == oracleX && charY == oracleY+1){
                        charY--;
                        repaint();
                        moves++;
                        String replay = JOptionPane.showInputDialog(null, "You won! Would you like to play again? \n\ty for Yes \n\tn for No");
                        if (replay.equals("y")) {
                            String newMap = JOptionPane.showInputDialog(null, "Please Choose another map:");
                            createBoard(newMap + ".txt");
                            moves = 0;
                            charX = 0;
                            charY = 0;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Join us for more adventure soon!");
                            System.exit(0);
                        }
                    }
                    else{
                        charY--;
                        moves++;
                    }
                }
            }
        }
    }

    public void switchView(){
        //from bottom
        if(view == 1){
            view = 2;
        }
        //from left
        else{
            view = 1;
        }
    }

    //load  map .txt file and generate matrix based on integers
    public void createBoard(String fileName){

        try {
            //Load file
            File inputFile = new File(fileName);
            Scanner newMap = new Scanner(inputFile);

            mapSize = newMap.nextInt();
            map = new int[mapSize][mapSize];

            //Set Oracle location coordinates 
            oracleX = newMap.nextInt() -1;
            oracleY = newMap.nextInt() -1;

            //Input file contents intoaa map generator
            for (int i = 0; i < mapSize; i++){
                for (int j = 0; j < mapSize; j++){
                    int dataInput = newMap.nextInt();
                    map[i][j] = dataInput;
                }
            }
        }          
        catch(FileNotFoundException e) {
            System.out.println("ERROR! " + e);      
        }
    }  

    //load in background image from directory
    public void loadImage(String imageName) {
        img = null;
        try {
            img = ImageIO.read(new File(imageName));
            
        } catch (IOException e) {
            System.out.println("Could not read image! " + imageName);
        }
    }

    //draws minimap in top left corner
    public void miniMap(Graphics g){
        
        //checks whether to scale the minimap based on width or height of window
        double miniMapDimensions = 0;
        if(getHeight() <= getWidth()) {
            miniMapDimensions = (getHeight() / mapSize) * miniMapScale;
        }
        else if(getWidth() < getHeight()) {
            miniMapDimensions = (getWidth() / mapSize) * miniMapScale;
        }

        int offsetXmini = (int)((getWidth() - mapSize*miniMapDimensions)/2);
        
        //draw miniboard
        for (int i=0; i < mapSize; i++) {
            for (int j=0; j < mapSize; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(darkSand);
                }
                else {
                    g.setColor(lightSand);
                }

                g.fillRect(i*(int)miniMapDimensions + offset, j*(int)miniMapDimensions + offset, (int)miniMapDimensions, (int)miniMapDimensions);
            }
        }
        //draw player on minimap
        g.setColor(block);
        g.fillRect(offset + charX*(int)miniMapDimensions, offset + charY*(int)miniMapDimensions,(int)miniMapDimensions,(int)miniMapDimensions);

        //Draw oracle location (always bottom right corner, by game design (coul be improved later))
            g.setColor(emerald);
            g.fillOval(offset + (oracleX)*(int)miniMapDimensions, offset + (oracleY)*(int)miniMapDimensions, (int)miniMapDimensions, (int)miniMapDimensions);

            int oracleScale = (int)(miniMapDimensions*.2);
            int oracleSize = (int)(miniMapDimensions*.62);

            g.setColor(lightGreen);
            g.fillOval(offset + oracleScale + (oracleX)*(int)miniMapDimensions, offset + oracleScale + (oracleY)*(int)miniMapDimensions, oracleSize, oracleSize);


        //draw towers
        for (int i=0; i < mapSize; i++) {
            for (int j=0; j < mapSize; j++) {
                if (map[i][j] == 21){
                    g.setColor(ivory);
                    g.fillRect(offset + j*(int)miniMapDimensions, offset + i*(int)miniMapDimensions,(int)miniMapDimensions,(int)miniMapDimensions);
                    g.setColor(Color.BLACK);
                    g.drawRect(offset + j*(int)miniMapDimensions, offset + i*(int)miniMapDimensions,(int)miniMapDimensions,(int)miniMapDimensions);

                }
            }
        }
    }

    public void paintComponent(Graphics g){

        //draw background
        g.drawImage(img, 0, 0, null);

        miniMap(g);

        //draw one of two views

        if(view == 1){
            drawViewBottom(g);
        }
        else if(view == 2){
            drawViewLeft(g);
        }    
    }

    public void drawViewBottom(Graphics g){

        int updateHeight = 0;

        if(getHeight() <= getWidth()) {
            unitSize = (getHeight() / mapSize) * 2 / 3;
            updateHeight = getHeight();
        }
        else if(getWidth() < getHeight()) {
            unitSize = (getWidth() / mapSize) * 2 / 3;
            updateHeight = getWidth();
        }
        int offsetX = (getWidth() - (mapSize * unitSize)) / 2;
        
        
        //Loop for drawing view
        for(int i = 0; i <mapSize;i++){

            //Finds value from array to deteremine height (z-value) of the map from sideview
            contourHeight = map[charY][i];
            int inblockScale = (int)(unitSize*.2);

            //Draw towers 
            if(contourHeight == 21){

                int towerHeight = mapSize+2;
                int towerInner = unitSize/8;

                g.setColor(ivory);
                g.fillRect( offsetX + i*unitSize, updateHeight-(towerHeight*unitSize), unitSize, contourHeight*unitSize);

                g.setColor(Color.BLACK);
                g.fillRect( (offsetX + inblockScale) + i*unitSize, updateHeight-(towerHeight*unitSize) + inblockScale, unitSize-(2*inblockScale), towerInner);
                g.fillRect( (offsetX + inblockScale) + i*unitSize, updateHeight-(towerHeight*unitSize) + inblockScale + 2*towerInner, unitSize-(2*inblockScale), towerInner);
                g.drawRect( offsetX + i*unitSize, updateHeight-(towerHeight*unitSize), unitSize, contourHeight*unitSize);
               

            }
            else{

            //Blocks
            g.setColor(brown);
            g.fillRect( offsetX + i*unitSize, updateHeight-(contourHeight*unitSize), unitSize, contourHeight*unitSize);
            //Inner blocks
            g.setColor(lightSand);
            g.fillRect( (offsetX + inblockScale) + i*unitSize, updateHeight-(contourHeight*unitSize) + inblockScale, unitSize-(2*inblockScale), (contourHeight*unitSize) - (2*inblockScale));
            //Block outlines
            g.setColor(Color.BLACK);
            g.drawRect( offsetX + i*unitSize, updateHeight-(contourHeight*unitSize), unitSize, contourHeight*unitSize);
            }
        }

        //Calculate vertical value of height 
        positionZ = map[charY][charX];

        //Draw character
           
            //head
            g.setColor(teal);
            g.fillRect(offsetX + charX*unitSize + unitSize/4,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*5/16,unitSize/2,unitSize*5/16);

            //hat
            g.setColor(brown);
            g.fillRect(offsetX + charX*unitSize + unitSize/4,(updateHeight - unitSize) - (positionZ*unitSize),unitSize/2,unitSize*3/8);
            g.setColor(lightSand);
            g.fillRect(offsetX + charX*unitSize,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize/4,unitSize,unitSize/8);
            g.setColor(brown);
            g.drawRect(offsetX + charX*unitSize,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize/4,unitSize,unitSize/8);
            //eyes
            g.setColor(Color.BLACK);
            //g.fillRect(offsetX + charX*unitSize + unitSize*3/8,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*7/16,unitSize/16,unitSize/16);
            g.fillRect(offsetX + charX*unitSize + unitSize*9/16,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*7/16,unitSize/14,unitSize/14);
            //body
            g.setColor(teal);
            g.fillRect(offsetX + charX*unitSize + unitSize*5/16,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize/2,unitSize*3/8,unitSize*6/16);
            //arms
            g.fillRect(offsetX + charX*unitSize + unitSize*5/8,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*5/8,unitSize*3/8,unitSize/8);
            g.fillRect(offsetX + charX*unitSize,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*5/8,unitSize/2,unitSize/8);
            //feet
            g.setColor(Color.BLACK);
            g.fillRect(offsetX + charX*unitSize + unitSize*9/16,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*7/8,unitSize/4,unitSize/8);
            g.fillRect(offsetX + charX*unitSize + unitSize*3/16,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*7/8,unitSize/4,unitSize/8);
        

        //Draw oracle 
        if(charY == oracleY){
            int jewelHeight = updateHeight - (unitSize + unitSize*map[oracleX][oracleY]);

            g.setColor(emerald);
            g.fillOval(offsetX + (oracleX)*unitSize, jewelHeight, unitSize , unitSize );
        }

        //Draw minimap view indicator (blue rectangle over current "slice")
        
        double miniMapDimensions = 0;
        if(getHeight() <= getWidth()) {
            miniMapDimensions = (getHeight() / mapSize) * miniMapScale;
        }
        else if(getWidth() < getHeight()) {
            miniMapDimensions = (getWidth() / mapSize) * miniMapScale;
        }
        int offsetXmini = (int)((getWidth() - mapSize*miniMapDimensions)/2);
        g.setColor(teal);
        g.drawRect(offset,offset + (int)(charY*miniMapDimensions), (int)(miniMapDimensions*mapSize), (int)(miniMapDimensions));

        //Draw Counter 
            g.drawString("Moves: " + moves, (getWidth()-90), 20);
    }

    public void drawViewLeft(Graphics g){

        
        int updateHeight = 0;

        if(getHeight() <= getWidth()) {
            unitSize = (getHeight() / mapSize) * 2 / 3;
            updateHeight = getHeight();
        }
        else if(getWidth() < getHeight()) {
            unitSize = (getWidth() / mapSize) * 2 / 3;
            updateHeight = getWidth();
        }
        int offsetX = (getWidth() - (mapSize * unitSize)) / 2;

        //Draw map
        for(int i = 0; i <mapSize;i++){

            //Finds value from array to deteremine height (z-value) of the map from sideview
            contourHeight2 = map[i][charX];
            int inblockScale = (int)(unitSize*.2);

            //draw towers
            if(contourHeight2 == 21){

                int towerHeight2 = mapSize+2;
                int towerInner = unitSize/8;

                g.setColor(ivory);
                g.fillRect( offsetX + i*unitSize, updateHeight-(towerHeight2*unitSize), unitSize, contourHeight2*unitSize); 

                g.setColor(Color.BLACK);
                g.fillRect( (offsetX + inblockScale) + i*unitSize, updateHeight-(towerHeight2*unitSize) + inblockScale, unitSize-(2*inblockScale), towerInner);
                g.fillRect( (offsetX + inblockScale) + i*unitSize, updateHeight-(towerHeight2*unitSize) + inblockScale + 2*towerInner, unitSize-(2*inblockScale), towerInner);
                g.drawRect( offsetX + i*unitSize, updateHeight-(towerHeight2*unitSize), unitSize, contourHeight2*unitSize); 

            }
            else{

            //Draws the sideview blocks
            g.setColor(brown);
            g.fillRect( offsetX + i*unitSize, updateHeight-(contourHeight2*unitSize), unitSize, contourHeight2*unitSize); 

            g.setColor(lightSand);
            g.fillRect( (offsetX + inblockScale) + i*unitSize, updateHeight-(contourHeight2*unitSize) + inblockScale, unitSize-(2*inblockScale), (contourHeight2*unitSize) - (2*inblockScale));
            
            g.setColor(Color.BLACK);
            g.drawRect( offsetX + i*unitSize, updateHeight-(contourHeight2*unitSize), unitSize, contourHeight2*unitSize);  
            }
        }

        //Calculate vertical value of height 
        positionZ = map[charY][charX];

        //Draw character
            
            //head
            g.setColor(teal);
            g.fillRect(offsetX + charY*unitSize + unitSize/4,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*5/16,unitSize/2,unitSize*5/16);
            //hat
            g.setColor(brown);
            g.fillRect(offsetX + charY*unitSize + unitSize/4,(updateHeight - unitSize) - (positionZ*unitSize),unitSize/2,unitSize*3/8);
            g.setColor(lightSand);
            g.fillRect(offsetX + charY*unitSize,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize/4,unitSize,unitSize/8);
            g.setColor(brown);
            g.drawRect(offsetX + charY*unitSize,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize/4,unitSize,unitSize/8);
            //eyes
            g.setColor(Color.BLACK);
            //g.fillRect(offsetX + charY*unitSize + unitSize*3/8,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*7/16,unitSize/16,unitSize/16);
            g.fillRect(offsetX + charY*unitSize + unitSize*9/16,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*7/16,unitSize/14,unitSize/14);
            //body
            g.setColor(teal);
            g.fillRect(offsetX + charY*unitSize + unitSize*5/16,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize/2,unitSize*3/8,unitSize*6/16);
            //arms
            g.fillRect(offsetX + charY*unitSize + unitSize*5/8,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*5/8,unitSize*3/8,unitSize/8);
            g.fillRect(offsetX + charY*unitSize,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*5/8,unitSize/2,unitSize/8);
            //feet
            g.setColor(Color.BLACK);
            g.fillRect(offsetX + charY*unitSize + unitSize*9/16,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*7/8,unitSize/4,unitSize/8);
            g.fillRect(offsetX + charY*unitSize + unitSize*3/16,(updateHeight - unitSize) - (positionZ*unitSize) + unitSize*7/8,unitSize/4,unitSize/8);

        //Draw oracle 

        if(charX == oracleX){
            int jewelHeight = updateHeight - (unitSize + unitSize*map[oracleX][oracleY]);

            g.setColor(emerald);
            g.fillOval(offsetX + (oracleY)*unitSize, jewelHeight, unitSize , unitSize );

        
        }

        //Draw minimap view indicator 
        
        double miniMapDimensions = 0;
        if(getHeight() <= getWidth()) {
            miniMapDimensions = (getHeight() / mapSize) * miniMapScale;
        }
        else if(getWidth() < getHeight()) {
            miniMapDimensions = (getWidth() / mapSize) * miniMapScale;
        }
        int offsetXmini = (int)((getWidth() - mapSize*miniMapDimensions)/2);
        g.setColor(teal);
        g.drawRect(offset + (int)(charX*miniMapDimensions), offset, (int)(miniMapDimensions), (int)(miniMapDimensions*mapSize ));

        //Draw Counter 
            g.drawString("Moves: " + moves, (getWidth()-90), 20);
    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();

        //needs to be final because of KeyPanel class needing to use it
        final Videogame start = new Videogame(5);
        start.setFocusable(true);
        frame.setFocusable(true);


        //Inner class for keystroke input
        class KeyPanel implements KeyListener{

            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_D){

                    start.moveRight();
                    start.repaint();
                }
                else if(e.getKeyCode() == KeyEvent.VK_A){

                    start.moveLeft();
                    start.repaint();
                }
                else if(e.getKeyCode() == KeyEvent.VK_S){

                    start.switchView();
                    start.repaint();
                }
            }

            public void keyReleased(KeyEvent e){
                
            }

            public void keyTyped(KeyEvent e){
                
            }
        }
        
        //to make KeyPanel active
        KeyPanel keys = new KeyPanel();

        //Prompt for choosing map
        String mapChoose = JOptionPane.showInputDialog("Please choose your map:");

        //Generate map
        start.createBoard(mapChoose + ".txt");
        start.loadImage("pyramids.jpg");

        //All Frame goodies
        frame.addKeyListener(keys);
        frame.add(start);
        frame.setTitle("PYRAMID EXPLORER");
        frame.setSize(windowWidth, windowHeight);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}














