package computer_graphics_6;

public class Panel extends SceneObject{
	float scale;
	Vector3 normal, pos;
	public Panel( Vector3 normal , float scale) {
		this.scale = scale;//大小
		this.normal = normal;//平面方向
	}
	public void init()
	{
		pos = normal.multi(scale);
	}
	
	@Override
	public IntersectResult intersect(Ray3 ray)
	{
		IntersectResult result = new IntersectResult();
		float a = ray.dir.dot(normal);
		if(a>=0f)return result.NoHit();
		else{
			float b = this.normal.dot(ray.oril.subtract(this.pos));
	        result.Object = this;
	        result.distance = -b / a;
	        result.position = ray.getPoint(result.distance);
	        result.normal = this.normal;
			return result;
		}
		
	}
}
