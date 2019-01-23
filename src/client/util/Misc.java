/*
    Miscellanious methods I've written that are
    general useful tools


    Written by Kane Templeton Jan 12, 2019
 */

package client.util;

import java.awt.Rectangle;

public class Misc {

    
    /* inRange(x,y,minX,minY,maxX,maxY):
     * determines if (x,y) is within range of a region bounded by
     * minX <= x <= maxX
     * minY <= y <= maxY
    */
    public static boolean inRange(int x, int y, int minx, int miny, int maxx, int maxy) {
        return (x>=minx&&x<=maxx&&y>=miny&&y<=maxy);
    }
    
    /* inRange(x,y,startX,startY,R):
        determines if (x,y) is inside the bounds 
        of Rectangle R starting at (startX,startY)
    
    */
    public static boolean inRange(int x, int y, int startx, int starty, Rectangle R) {
        return (x>=startx&&y>=starty&&x<=startx+R.width&&y<=starty+R.height);
    }
    
    /* arrayToString(words,fromIndex):
        converts words into a single string starting at words[fromIndex]
    
    ex: arrayToString(["hello","this","is","a","test"],2) => "is a test"
    
        this method is useful on the result of calling split(x) on a string,'
        especially for things like typing commands
    
    */
    public static String arrayToString(String[] words, int fromIndex) {
        String build = "";
        for (int i=fromIndex; i<words.length-1; i++)
            build+=words[i]+" ";
        build+=words[words.length-1];
        return build;
    }


}
