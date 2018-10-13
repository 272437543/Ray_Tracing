package computer_graphics_6;

public abstract class Material {
	public float reflectiveness;//反射强度
	public abstract Colors sample(Ray3 ray, Vector3 position, Vector3 normal, LightSample light);
	//采样函数
}
