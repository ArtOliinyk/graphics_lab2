package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {

    private static final String FILE = "DS3.txt";
    private static Point[] points;

    public static void main(final String[] args) throws IOException {
        try{
            final BufferedReader br = new BufferedReader(new FileReader(new File(FILE)));
            points = new Point[22159];
            int i = 0;
            while(br.ready()){
                final String[] split = br.readLine().split(" ");
                final int x = Integer.parseInt(split[0]);
                final int y = Integer.parseInt(split[1]);
                points[i++] = new Point(x, y);
            }
        } catch (final Exception e){
            e.printStackTrace();
        }
        BufferedImage image = new BufferedImage(540, 960, ColorSpace.TYPE_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setPaint ( new Color (255, 255, 255) );
        for(int i = 0; i < points.length; i++)
        {
            graphics.fillRect(points[i].x, points[i].y, 1, 1);
        }
        File outFile = new File("lab2_image.png");
        ImageIO.write(image, "png", outFile);
    }
}
