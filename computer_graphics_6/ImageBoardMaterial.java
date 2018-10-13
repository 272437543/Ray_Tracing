package computer_graphics_6;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageBoardMaterial extends Material{
	float scale;
	private float size;
	public ImageBoardMaterial(float scale, float reflectiveness) {
		this.scale = scale;
		this.reflectiveness = reflectiveness;
		size = 1f/scale;
		
	}
	
	private String path1 = "D:\\workplace\\Drake\\src\\computer_graphics_6\\HDFicon.png";
	private String path2 = "D:\\workplace\\Drake\\src\\computer_graphics_6\\QRcode.png";
	private String path3 = "D:\\workplace\\Drake\\src\\computer_graphics_6\\Tobu-Life.png";
	private String path4 = "D:\\workplace\\Drake\\src\\computer_graphics_6\\ybh.png";
	private BufferedImage img, img2;
	public Colors sample(Ray3 ray, Vector3 position, Vector3 normal, LightSample light)
	{
		try {
			if(img == null){
				img = ImageIO.read(new File(path1));
			}
			float x = (position.x % size) * img.getWidth()/size;
			float y = (position.z % size) * img.getHeight()/size;
			
			//System.out.println(x+" "+y);
			return Math.abs((int)(Math.floor(position.x * this.scale) + Math.floor(position.z * this.scale)) % 2) < 1 
					? new Colors(0,0,0).modulate(light.EL) : new Colors(new Color(img.getRGB((int)Math.abs(x), (int)Math.abs(y)))).modulate(light.EL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}