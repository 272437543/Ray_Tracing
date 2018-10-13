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
		IntersectResult result = new IntersectResult();//创建一个新的碰撞对象
		//以下是射线和小球相交的公式
		Vector3 v = ray.oril.subtract(this.center);
		float a1 = v.Length() * v.Length() - radius * radius;
		float DdotV = ray.dir.dot(v);
		
		if(DdotV <= 0)
		{
			float discr = DdotV * DdotV - a1;//判定参数，>=0了就是碰到了
			if(discr >= 0)
			{//碰到了
				result.Object = this;//碰撞物体
				result.distance = (float) (-DdotV - Math.sqrt(discr));//距离
				result.position = ray.getPoint(result.distance);//碰撞位置
				result.normal = result.position.subtract(this.center).normalize();//法向量
				
				return result;
			}
		}
		return result.NoHit();//没碰到
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
