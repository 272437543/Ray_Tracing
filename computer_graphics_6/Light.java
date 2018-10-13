package computer_graphics_6;

public abstract class Light {//光的父类
	//public Vector3 L;//方向
	//public Colors irradiance;//颜色
	public abstract void init();//初始化方法
	public abstract LightSample sample(Union union, Vector3 position);//采样方法
}
