package computer_graphics_6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Main extends JFrame{
	/**
	 * @author Drake
	 * 这个版本优化了视角转化(更加真实，但更卡...)，并加入了鼠标控制
	 * 继续改良视野的转向
	 * 这版本加入光源(已加入直线关，和点光源)
	 * 推荐用C++；
	 * 好用的开源软件：Open Scene Graph
	 */
	private float w=220,h=230;//使用1：1的屏幕，计算上比较方便
	private Colors bg = new Colors(0.08f, 0.05f, 0.22f);
	public Main() {
		setSize((int)w, (int)h);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setVisible(true);
		pos = new Vector3(0, 5, 15);
		view = new Vector3(0, 0, -1);
		addListener();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	public static Vector3 pos, view;
	public float depth = 30;
	private BufferedImage img;
	private Graphics2D gg;
	
	private void addListener()
	{
		addKeyListener(new ControlListener(pos, this));
		addMouseListener(new ControlListener(pos, this));
		addMouseMotionListener(new ControlListener(pos, this));
	}
	private Light[] lights = {new DirectionalLight(new Colors(0.5f, 1, 1).multi(0), new Vector3(-1f, -2.5f, -1.5f), true), new PointLight(new Colors(1, 1, 1).multi(500f), new Vector3(6, 30, -5), true)};
	public void paint(Graphics g)
	{
		w = getWidth();
		h = getHeight();
		img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
		gg = (Graphics2D) img.getGraphics();
		bg = bg.legel() == 1?new Colors(1, 1, 1):bg;
		gg.setColor(new Color((int)(bg.r * 255), (int)(bg.g * 255), (int)(bg.b * 255)));
		gg.fillRect(0, 0, getWidth(), getHeight());
		//创建双缓存图层
		//创建了两个球体和一个平面
		Panel panel = new Panel(new Vector3(0, 1, 0), 2);
		Sphere sphere = new Sphere(new Vector3(-10, 6, -10), 5);
		Sphere sphere2 = new Sphere(new Vector3(2, 6, -10), 5);
		Sphere sphere3 = new Sphere(new Vector3(15, 8, -5), 7);
		
		panel.material = new ImageBoardMaterial(0.2f, 0.25f);//格子贴图
		//panel.material = new CheckBoardMaterial(0.15f, 0.5f);
		sphere.material = new PhongMaterial(new Colors(1, 0, 0), new Colors(0, 0, 0), 16, 0.35f);
		sphere2.material = new PhongMaterial(new Colors(0, 1, 0), new Colors(0, 0, 0), 16, 0.25f);
		sphere3.material = new PhongMaterial(new Colors(0.6f, 0.3f, 0), new Colors(0, 0, 0), 16, 0.3f);
		
		Camera camera = new Camera(pos, view, new Vector3(0, 1, 0).normalize(), 60);
		camera.init();					//   左右 上下 前后
		//初始化摄像机
		for(int k = 0; k<lights.length; k++)
		{
			lights[k].init();
		}
		for(int y = 0; y < h; y++)//开始渲染
		{
			float sy = 1 - ((float)y / h);
			for(int x = 0; x < w; x++)
			{
				float sx = (w/h)*((float)x / w) - (w-h)/(2*h);
				Ray3 ray = camera.generateRay(sx, sy);
				//从眼前投射到场景的射线
				SceneObject[] o = {panel, sphere, sphere2, sphere3};
				//所有物体的集合
				Union union = new Union(o);
				union.init();
				IntersectResult result = union.FinalResult(ray);
				if(result.Object != null)
				{
				Colors color = reflect(new Union(o), ray, 3);
					for(int k=0; k<lights.length; k++)
					{
						LightSample lightSample = lights[k].sample(union, result.position);
						if(!lightSample.equals(new LightSample(new Vector3(), new Colors())))
						{
							float NdotL = result.normal.dot(lightSample.L);
							if(NdotL >= 0)
								color = color.add(lightSample.EL.multi(NdotL));
						}
					}
				
				
				int R = (int)(color.r * 255f)>255?255:(int)(color.r * 255f);
				int G = (int)(color.g * 255f)>255?255:(int)(color.g * 255f);
				int B = (int)(color.b * 255f)>255?255:(int)(color.b * 255f);
				img.setRGB(x, y, new Color(R, G, B).getRGB());
				}
			}
		}
		g.drawImage(img, 0, 0, this);
		
	}
	
	public Colors reflect(Union union, Ray3 ray, int maxReflect)//材质反射
	{
		union.init();
		IntersectResult result = union.FinalResult(ray);
		if (result.Object != null) {
	        float reflectiveness = result.Object.material.reflectiveness;
	        Colors color = new Colors();
	        for(int k=0;k<lights.length;k++)
	        {
	        	color = color.add(result.Object.material.sample(ray, result.position, result.normal, lights[k].sample(union, result.position)));
	        }
	        color = color.multi(1f - reflectiveness);
	        
	        if (reflectiveness > 0 && maxReflect > 0) {
	            Vector3 r = result.normal.multi(-2f * result.normal.dot(ray.dir)).add(ray.dir);
	            ray = new Ray3(result.position, r);
	            Colors reflectedColor = reflect(union, ray, maxReflect - 1);
	            color = color.add(reflectedColor.multi(reflectiveness));
	        }
	        return color;
	    }
	    else
	    {
	    	//System.out.println(ray.getPoint(1));
	        return new Colors();//背景色
	    }
	}
	
}
