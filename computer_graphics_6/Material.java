package computer_graphics_6;

public abstract class Material {
	public float reflectiveness;//����ǿ��
	public abstract Colors sample(Ray3 ray, Vector3 position, Vector3 normal, LightSample light);
	//��������
}
