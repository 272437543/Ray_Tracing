package computer_graphics_6;

public class GrayPlane extends Material{//���Ǹ����Ը��ݾ�����Ⱦ�Ĵ�ɫ�ذ����
	private float depth;
	public GrayPlane() {
		depth = 0;
		reflectiveness = 0;
	}
	public GrayPlane(float depth, float reflectiveness)
	{
		this.reflectiveness = reflectiveness;
		this.depth = depth;
	}
	public Colors sample(Ray3 ray, Vector3 position, Vector3 normal, LightSample light) {
		// TODO Auto-generated method stub
		float distance = Vector3.distance(ray.oril, position);
		float c = distance / depth >= 1f? 1f:distance / depth;
		return new Colors(1-c,1- c, 1-c);
	}

}
