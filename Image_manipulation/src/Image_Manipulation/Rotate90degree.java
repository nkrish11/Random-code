package Image_Manipulation;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
//import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;


import java.io.IOException;

import javax.imageio.ImageIO;

public class Rotate90degree {
	
	public static void main(String[] args) throws IOException{
		File file=new File("C:/Users/nikhil/Desktop/test.jpg");
		BufferedImage img  =ImageIO.read(file);
		Raster raster=img.getData();
		int w =raster.getWidth(), h=raster.getHeight();
		int pixels[][]=new int[w][h];
		//SampleModel sampleModel = raster.getSampleModel();
		for (int x=0;x<w;x++)
		{
			for (int y=0;y<h;y++)
			{
				pixels[x][y]=raster.getSample(x, y, 0);
			}
		}
		
		
		// Rotates counter-clockwise .. check
		int pixelsnew[][] = new int[h][w];
		int c=w,r=0;
		for (int i=0;i<w;i++){
			c--;
			r=0;
			for(int j=0;j<h;j++){
				pixelsnew[r][c]=pixels[i][j];
				r++;
			}
			
			
			
		} 
		
		
		
		
		w=pixelsnew.length;
		h=pixelsnew[0].length;
		BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_BYTE_GRAY);
		//WritableRaster wraster =Raster.createWritableRaster(sampleModel, new Point(0,0));
		WritableRaster wraster= Raster.createWritableRaster(new PixelInterleavedSampleModel(0, w, h, 1, 1920, new int[] {0}), new Point(0,0));
		
		for(int i=0;i<w;i++)
	    {
	        for(int j=0;j<h;j++)
	        {
	            wraster.setSample(i,j,0,pixelsnew[i][j]);
	        }
	    }
		
		image.setData(wraster);
		
		
		ImageIO.write(image,"jpg",(new File("C:/Users/nikhil/Desktop/output.jpg")));
		
		
		
		
		
	}
	

}
