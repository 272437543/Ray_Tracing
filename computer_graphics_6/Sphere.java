package computer_graphics_6;

public class Sphere extends SceneObject{
	public Vector3 center;
	public float radius;
	public Sphere(Vector3 center, float radius) {
		this.center = center;
		this.radius = radius;
	}
	@Override
	public IntersectResult intersect(Ray3 ray)
	{
		IntersectResult result = new IntersectResult();//����һ���µ���ײ����
		//���������ߺ�С���ཻ�Ĺ�ʽ
		Vector3 v = ray.oril.subtract(this.center);
		float a1 = v.Length() * v.Length() - radius * radius;
		float DdotV = ray.dir.dot(v);
		
		if(DdotV <= 0)
		{
			float discr = DdotV * DdotV - a1;//�ж�������>=0�˾���������
			if(discr >= 0)
			{//������
				result.Object = this;//��ײ����
				result.distance = (float) (-DdotV - Math.sqrt(discr));//����
				result.position = ray.getPoint(result.distance);//��ײλ��
				result.normal = result.position.subtract(this.center).normalize();//������
				
				return result;
			}
		}
		return result.NoHit();//û����
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
